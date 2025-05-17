package fiap.tds.repositories;

import java.util.List;
import java.util.Optional;

public interface _CrudRepository <T>{ //esse T serve para colocar que é um tipo não indentificado(varios tipos), só será indentificado quando for instanciar o seu objeto e função
    void add(T object);
    void remove(T object);
    void removeByid(String id);
    List<T> getALL();
    Optional<T> getById(String id);

}