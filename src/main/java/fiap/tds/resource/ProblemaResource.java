package fiap.tds.resource;


import fiap.tds.Dtos.ProblemaDto;
import fiap.tds.entities.Problema;
import fiap.tds.repositories.ProblemaRepository;
import fiap.tds.service.ProblemaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("/problema")
public class ProblemaResource {

    @Inject
    ProblemaService problemaService;

    @Inject
    ProblemaRepository problemaRepository;

    @GET
    @Path("/{id_passageiro}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProblemaDto> listarPorUsuario(@PathParam("id_passageiro") String id_passageiro) {
        return problemaRepository.listarProblemasPorCliente(id_passageiro).stream()
                .map(problema -> new ProblemaDto(
                        problema.getId(),
                        problema.getDescricao(),
                        problema.getData(),
                        id_passageiro
                ))
                .collect(Collectors.toList());
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criar(Problema problema) {
        System.out.println("teste");
        System.out.println(problema.getId_passageiro());
        if(problema == null || !problemaService.validateProblema(problema))
            return Response.status(Response.Status.BAD_REQUEST).build();

        problemaRepository.add(problema);
        return Response.status(Response.Status.CREATED).build();
    }
}
