package fiap.tds.repositories;

import fiap.tds.entities.Linha;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LinhaRepository implements _CrudRepository<Linha> {
    List<Linha> linha = new ArrayList<Linha>();


    @Override
    public void add(Linha object) {
        linha.add(object);

    }

    @Override
    public void remove(Linha object) {

    }

    @Override
    public void removeByid(String id) {

    }

    @Override
    public List<Linha> getALL() {
        return List.of();
    }

    @Override
    public Optional<Linha> getById(String id) {
        return Optional.empty();
    }


}