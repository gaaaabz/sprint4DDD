package fiap.tds.repositories;

import fiap.tds.entities.Vagao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VagaoRepository implements _CrudRepository<Vagao>{
    List<Vagao> vagao = new ArrayList<Vagao>();



    @Override
    public void add(Vagao object) {
        vagao.add(object);
    }

    @Override
    public void remove(Vagao object) {

    }

    @Override
    public void removeByid(String id) {

    }

    @Override
    public List<Vagao> getALL() {
        return List.of();
    }

    @Override
    public Optional<Vagao> getById(String id) {
        return Optional.empty();
    }


}