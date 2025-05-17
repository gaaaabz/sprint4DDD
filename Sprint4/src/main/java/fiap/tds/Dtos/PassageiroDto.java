package fiap.tds.Dtos;

import java.time.LocalDate;

public record PassageiroDto(
        String id,
        String nome,
        String email,
        String cpf,
        String senha,
        LocalDate nascimento,
        String genero,
        String telefone
) {
}
