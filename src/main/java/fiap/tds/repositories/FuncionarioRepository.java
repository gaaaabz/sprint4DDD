package fiap.tds.repositories;

import fiap.tds.entities.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FuncionarioRepository implements _CrudRepository<Funcionario>{
    List<FuncionarioRepository> funcionarios = new ArrayList<FuncionarioRepository>();


    @Override
    public void add(Funcionario object) {
    }

    @Override
    public void remove(Funcionario object) {

    }

    @Override
    public void removeByid(String id) {
    }

    @Override
    public List<Funcionario> getALL() {
        return List.of();
    }

    @Override
    public Optional<Funcionario> getById(String id) {
        return Optional.empty();
    }

}