package fiap.tds.Dtos;

import java.time.LocalDate;

public record CupomDto(
        String id,
        String codigo,
        String descricao,
        boolean ativo,
        LocalDate data,
        String id_cliente
) {}
