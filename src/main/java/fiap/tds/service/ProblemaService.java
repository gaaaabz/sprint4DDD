package fiap.tds.service;

import fiap.tds.entities.Problema;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProblemaService {

    public boolean validateProblema(Problema problema) {
        if (problema == null)
            return false;

        if (problema.getData()==null || problema.getDescricao().isBlank()
                || problema.getId_passageiro().isBlank())
            return false;

        return true;
    }
}
