package fiap.tds.service;

import fiap.tds.entities.Cupom;
import fiap.tds.entities.Passageiro;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PassageiroService {
    public boolean validatePassageiro(Passageiro passageiro) {
        if (passageiro == null)
            return false;

        if (passageiro.getNascimento()== null || passageiro.getTelefone().isBlank()
                || passageiro.getCpf().isBlank() || passageiro.getSenha().isBlank()
                || passageiro.getNome().isBlank() || passageiro.getEmail().isBlank()
                || passageiro.getGenero().isBlank())
            return false;

        return true;
    }
}
