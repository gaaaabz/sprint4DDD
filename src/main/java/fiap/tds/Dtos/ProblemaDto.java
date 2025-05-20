package fiap.tds.Dtos;

import java.time.LocalDate;

public record ProblemaDto(
        String id,
        String descricao,
        LocalDate data,
        String id_passageiro
){}
