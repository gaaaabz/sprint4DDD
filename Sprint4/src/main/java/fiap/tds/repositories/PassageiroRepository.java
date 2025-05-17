package fiap.tds.repositories;

import fiap.tds.Dtos.PassageiroDto;
import fiap.tds.entities.Passageiro;
import fiap.tds.infrastructure.DataBaseConfig;
import jakarta.enterprise.context.ApplicationScoped;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PassageiroRepository implements _CrudRepository<Passageiro> {
    List<Passageiro> passageiros = new ArrayList<Passageiro>();


    @Override
    public void add(Passageiro passageiro) {
        var query = "INSERT INTO T_CNCT_CLIENTE (NM, EMAIL, CPF, SENHA, DT_NASCIMENTO, TELEFONE, GENERO) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (var connection = DataBaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, passageiro.getNome());
            stmt.setString(2, passageiro.getEmail());
            stmt.setString(3, passageiro.getCpf());
            stmt.setString(4, passageiro.getSenha());
            stmt.setDate(5, java.sql.Date.valueOf(passageiro.getNascimento()));
            stmt.setString(6, passageiro.getTelefone());
            stmt.setString(7, passageiro.getGenero());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Passageiro object) {

    }


    @Override
    public void removeByid(String id) {
        String query = "DELETE FROM T_CNCT_CLIENTE WHERE ID_CLIENTE = ?";

        try (var connection = DataBaseConfig.getConnection();
             var stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, Integer.parseInt(id));
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List getALL() {
        List<Passageiro> passageiros = new ArrayList<>();
        String query = "SELECT * FROM T_CNCT_CLIENTE";

        try (var connection = DataBaseConfig.getConnection();
             var stmt = connection.prepareStatement(query);
             var result = stmt.executeQuery()) {

            while (result.next()) {
                Passageiro passageiro = new Passageiro();
                passageiro.setId(result.getString("id_cliente"));
                passageiro.setNome(result.getString("nome"));
                passageiro.setEmail(result.getString("email"));
                passageiro.setCpf(result.getString("cpf"));
                passageiro.setSenha(result.getString("senha"));
                passageiro.setGenero(result.getString("genero"));
                passageiro.setTelefone(result.getString("telefone"));
                passageiro.setNascimento(result.getDate("nascimento").toLocalDate());

                passageiros.add(passageiro);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar passageiros");
            e.printStackTrace();
        }
        return passageiros;
    }

    @Override
    public Optional<Passageiro> getById(String id) {

        return null;
    }


    public Passageiro pegarPorId(String id) {
        var passageiro = new Passageiro();
        var query = "SELECT * FROM T_CNCT_CLIENTE WHERE id_cliente = ?";
        try (var connection = DataBaseConfig.getConnection();
             var stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            var result = stmt.executeQuery();
            if (result.next()) {
                passageiro.setId(result.getString("id_cliente"));
                passageiro.setNome(result.getString("nome"));
                passageiro.setEmail(result.getString("email"));
                passageiro.setCpf(result.getString("cpf"));
                passageiro.setGenero(result.getString("genero"));
                passageiro.setTelefone(result.getString("telefone"));
                passageiro.setSenha(result.getString("senha"));
                passageiro.setNascimento(result.getDate("nascimento").toLocalDate());

                return passageiro;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar passageiro com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }


    public PassageiroDto login(String email, String senha) {
        var query = "SELECT * FROM T_CNCT_CLIENTE WHERE email = ? AND senha = ?";
        try (var connection = DataBaseConfig.getConnection();
             var stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            var resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new PassageiroDto( resultSet.getString("id_cliente"),
                        resultSet.getString( "nm"),
                        resultSet.getString( "email"),
                        resultSet.getString( "cpf"),
                        resultSet.getString( "senha"),
                        resultSet.getDate("dt_nascimento").toLocalDate(),
                        resultSet.getString( "genero"),
                        resultSet.getString( "telefone"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Passageiro usuario) {
        String query = """
        UPDATE T_CNCT_CLIENTE 
        SET nm = ?, email = ?, senha = ?, telefone = ?, dt_nascimento = ?, cpf =?, genero=?
        WHERE id_cliente = ?
    """;

        try (var connection = DataBaseConfig.getConnection();
             var stmt = connection.prepareStatement(query)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getTelefone());
            stmt.setDate(5, java.sql.Date.valueOf(usuario.getNascimento()));
            stmt.setString(6, usuario.getCpf());
            stmt.setString(7, usuario.getGenero());
            stmt.setString(8, usuario.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}