package fiap.tds.repositories;

import fiap.tds.entities.Problema;
import fiap.tds.infrastructure.DataBaseConfig;
import jakarta.enterprise.context.ApplicationScoped;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProblemaRepository implements _CrudRepository<Problema>{
    List<Problema> problema = new ArrayList<Problema>();


    @Override
    public void add(Problema problema) {
        var query = "INSERT INTO T_CNCT_PROBLEMA_RELATADO (dt, ds, id_cliente) VALUES (?, ?, ?)";
        try (var connection = DataBaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDate(1, java.sql.Date.valueOf(problema.getData()));
            stmt.setString(2, problema.getDescricao());
            stmt.setString(3, problema.getId_passageiro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Problema> listarProblemasPorCliente(String idCliente) {
        List<Problema> problemas = new ArrayList<>();
        var query = "SELECT id_relato, dt, ds FROM T_CNCT_PROBLEMA_RELATADO WHERE id_cliente = ?";
        try (var connection = DataBaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, idCliente);
            var resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Problema problema = new Problema();
                problema.setId(resultSet.getString("id_relato"));

                problema.setData(resultSet.getDate("dt").toLocalDate());
                problema.setDescricao(resultSet.getString("ds"));
                System.out.println(problema.getId());
                System.out.println(problema.getId());
                problemas.add(problema);
            }
            System.out.println(problemas);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return problemas;
    }


    @Override
    public void remove(Problema object) {

    }

    @Override
    public void removeByid(String id) {

    }

    @Override
    public List<Problema> getALL() {
        return List.of();
    }

    @Override
    public Optional<Problema> getById(String id) {
        return Optional.empty();
    }
}