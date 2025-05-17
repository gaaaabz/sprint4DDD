package fiap.tds.repositories;

import fiap.tds.entities.Estacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EstacaoRepository implements _CrudRepository<Estacao>{
    List<Estacao> estaoes = new ArrayList<Estacao>();

    @Override
    public void add(Estacao object) {
        estaoes.add(object);
    }

    @Override
    public void remove(Estacao object) {
        estaoes.remove(object);

    }

    @Override
    public void removeByid(String id) {

    }

    @Override
    public List<Estacao> getALL() {
        return List.of();
    }

    @Override
    public Optional<Estacao> getById(String id) {
        return Optional.empty();
    }


}