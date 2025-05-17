package fiap.tds.repositories;

import fiap.tds.entities.Metro;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

public class MetroRepository implements _CrudRepository<Metro>{

    List<Metro> metro = new ArrayList<Metro>();


    @Override

    public void add(Metro object) {

        metro.add(object);

    }

    @Override

    public void remove(Metro object) {

    }

    @Override

    public void removeByid(String id) {

    }

    @Override

    public List<Metro> getALL() {

        return List.of();

    }

    @Override
    public Optional<Metro> getById(String id) {
        return Optional.empty();
    }


}

