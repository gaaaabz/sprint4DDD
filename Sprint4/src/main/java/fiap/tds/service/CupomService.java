package fiap.tds.service;

import fiap.tds.entities.Cupom;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CupomService {

    public boolean validateCupom(Cupom cupom){
        if (cupom == null)
            return false;

        Boolean ativo = cupom.isAtivo();
        if (cupom.getData()==null || cupom.getCodigo().isBlank()
                || cupom.getDescricao().isBlank() || cupom.getIdCliente().isBlank() )
            return false;

        return true;
    }
}
