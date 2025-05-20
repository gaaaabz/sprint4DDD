package fiap.tds.resource;

import fiap.tds.Dtos.CupomDto;
import fiap.tds.entities.Cupom;
import fiap.tds.repositories.CupomRepository;
import fiap.tds.service.CupomService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;


import java.util.List;
import java.util.stream.Collectors;

@Path("/cupons")


public class CupomResource {

    @Inject
    CupomRepository cupomRepository;

    @Inject
    CupomService cupomService;

    @GET
    @Transactional
    @Path("/{id_passageiro}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CupomDto> listarPorusuario(@PathParam("id_passageiro") String id_passageiro) {
        return cupomRepository.getAllByClient(id_passageiro).stream()
                .map(cupom -> new CupomDto(
                        cupom.getId(),
                        cupom.getCodigo(),
                        cupom.getDescricao(),
                        cupom.isAtivo(),
                        cupom.getData(),
                        cupom.getIdCliente()
                ))
                .collect(Collectors.toList());
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criar(Cupom cupom){
        if(cupom == null || !cupomService.validateCupom(cupom))
            return Response.status(Response.Status.BAD_REQUEST).build();

        cupomRepository.add(cupom);
        return Response.status(Response.Status.CREATED).build();
    }


}
