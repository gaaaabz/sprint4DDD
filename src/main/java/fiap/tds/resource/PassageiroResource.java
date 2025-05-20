package fiap.tds.resource;

import fiap.tds.Dtos.LoginDto;
import fiap.tds.Dtos.PassageiroDto;
import fiap.tds.Dtos.ProblemaDto;
import fiap.tds.entities.Passageiro;
import fiap.tds.entities.Problema;
import fiap.tds.repositories.PassageiroRepository;
import fiap.tds.service.PassageiroService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/passageiro")

public class PassageiroResource {
    @Inject
    PassageiroRepository passageiroRepository;

    @Inject
    PassageiroService passageiroservice;


    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criar(Passageiro passageiro) {
        if(passageiro == null || !passageiroservice.validatePassageiro(passageiro))
            return Response.status(Response.Status.BAD_REQUEST).build();

        passageiroRepository.add(passageiro);
        return Response.status(Response.Status.CREATED).build();
    }


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginDto loginDTO) {
        System.out.println("Tentando login com:");
        System.out.println("Email: " + loginDTO.email());
        System.out.println("Senha: " + loginDTO.senha());
        PassageiroDto usuario = passageiroRepository.login(loginDTO.email(), loginDTO.senha());

        if (usuario != null) {
            return Response.ok(usuario).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity("Email ou senha inválidos").build();
    }

    @DELETE
    @Path("/deletar/{id}")
    @Transactional
    public Response deletar(@PathParam("id") String id) {
        passageiroRepository.removeByid(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/atualizar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("id") String id, Passageiro novo) {
        if (novo == null) {
            System.out.println("DEBUG conta: " + novo.toString());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Usuário não encontrado")
                    .build();
        }
        if (!passageiroservice.validatePassageiro(novo)) {
            Response.status(Response.Status.UNAUTHORIZED).build();
        }

        passageiroRepository.update(novo); // implementado no seu repository

        return Response.ok().entity("Usuário atualizado com sucesso").build();
    }

    @GET
    @Path("/login/teste")
    @Produces(MediaType.TEXT_PLAIN)
    public String teste() {
        return "Funcionando!";
    }

}
