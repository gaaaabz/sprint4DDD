package fiap.tds.repositories;

import fiap.tds.entities.Cupom;
import fiap.tds.infrastructure.DataBaseConfig;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CupomRepository implements _CrudRepository<Cupom> {
    List<Cupom> cupons = new ArrayList<Cupom>();

    @Override
    public void add(Cupom cupom) {
        var query = "INSERT INTO T_CNCT_CUPOM ( dt_validade, ds, cd_cupom, ativo,id_cliente) VALUES ( ?, ?, ?, ?,?)";
        try (var connection = DataBaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setDate(1, java.sql.Date.valueOf(cupom.getData()));
            stmt.setString(2, cupom.getDescricao());
            stmt.setString(3, cupom.getCodigo());
            String ativo = "";
            if (cupom.isAtivo()){
                ativo = "S";
            } else{
                ativo = "N";
            }
            stmt.setString(4, ativo);
            stmt.setString(5,cupom.getIdCliente());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Cupom object) {
        cupons.remove(object);

    }

    @Override
    public void removeByid(String id) {

    }

    @Override
    public List<Cupom> getALL() {
        List<Cupom> cupoms = new ArrayList<>();
        String query = "SELECT * FROM  WHERE id_cliente = id";

        try (var connection = DataBaseConfig.getConnection();
             var stmt = connection.prepareStatement(query);
             var result = stmt.executeQuery()) {

            while (result.next()) {
                Cupom cupom = new Cupom();
                cupom.setId(result.getString("id_cupom"));
                cupom.setData(result.getDate("dt_validade").toLocalDate());
                cupom.setCodigo(result.getString("cd_cupom"));
                cupom.setDescricao(result.getString("ds"));
                if (result.getString("ativo") == "N"){
                    cupom.setAtivo(false);
                } else{
                cupom.setAtivo(true);
                }
                cupom.setIdCliente(result.getString("id_cliente"));
                cupoms.add(cupom);
            }


        } catch (SQLException e) {
            System.out.println("Erro ao buscar cupons");
        }
        return cupoms;

    }

    @Override
    public Optional<Cupom> getById(String id) {
        return Optional.empty();
    }

    public List<Cupom> getAllByClient(String idCliente) {
        List<Cupom> cupons = new ArrayList<>();

        String queryComCliente = "SELECT * FROM T_CNCT_CUPOM WHERE id_cliente = ?";
        String querySemCliente = "SELECT * FROM T_CNCT_CUPOM WHERE id_cliente IS NULL";

        try (var connection = DataBaseConfig.getConnection()) {

            try (var stmt = connection.prepareStatement(queryComCliente)) {
                stmt.setString(1, idCliente);
                try (var result = stmt.executeQuery()) {
                    while (result.next()) {
                        cupons.add(mapToCupom(result));
                    }
                }
            }

            try (var stmt = connection.prepareStatement(querySemCliente);
                 var result = stmt.executeQuery()) {
                while (result.next()) {
                    cupons.add(mapToCupom(result));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar cupons");
        }

        return cupons;
    }

    private Cupom mapToCupom(ResultSet result) throws SQLException {
        Cupom cupom = new Cupom();
        cupom.setId(result.getString("id_cupom"));
        cupom.setData(result.getDate("dt_validade").toLocalDate());
        cupom.setCodigo(result.getString("cd_cupom"));
        cupom.setDescricao(result.getString("ds"));
        cupom.setAtivo(!"N".equals(result.getString("ativo")));
        cupom.setIdCliente(result.getString("id_cliente"));
        return cupom;
    }

}