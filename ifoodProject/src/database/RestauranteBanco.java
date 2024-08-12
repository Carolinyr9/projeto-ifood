package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Restaurante;

public class RestauranteBanco {

    protected DBConnection connection;

    public RestauranteBanco(DBConnection connection) {
        this.connection = connection;
    }

    // Método para criar um novo restaurante
    public void criarRestaurante(Restaurante restaurante) {
        String sql = "CALL Inserir_Restaurante(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, restaurante.getNome());
            stmt.setString(2, restaurante.getCnpj());
            stmt.setString(3, restaurante.getCep());
            stmt.setString(4, restaurante.getRua());
            stmt.setString(5, restaurante.getCidade());
            stmt.setString(6, restaurante.getEstado());
            stmt.setString(7, restaurante.getNumeroResidencial());
            stmt.setString(8, restaurante.getTelefone());
            stmt.setString(9, restaurante.getSegmento());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar restaurante", e);
        }
    }

    // Método para visualizar um restaurante pelo ID
    public Restaurante visualizarRestaurante(int id) {
        String sql = "CALL Selecionar_Restaurante(?)";
        Restaurante restaurante = null;

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                restaurante = new Restaurante();
                restaurante.setId(rs.getInt("id"));
                restaurante.setNome(rs.getString("nome"));
                restaurante.setCnpj(rs.getString("cnpj"));
                restaurante.setEndereco(new Endereco(rs.getString("cep"), rs.getString("rua"), rs.getString("cidade"), rs.getString("estado"), rs.getString("numero_residencial"), rs.getString("segmento")));
                restaurante.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao visualizar restaurante", e);
        }
        return restaurante;
    }

    // Método para atualizar um restaurante
    public void atualizarRestaurante(Restaurante restaurante, int id) {
        String sql = "CALL Atualizar_Restaurante(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, restaurante.getNome());
            stmt.setString(3, restaurante.getCnpj());
            stmt.setString(4, restaurante.getCep());
            stmt.setString(5, restaurante.getRua());
            stmt.setString(6, restaurante.getCidade());
            stmt.setString(7, restaurante.getEstado());
            stmt.setString(8, restaurante.getNumeroResidencial());
            stmt.setString(9, restaurante.getTelefone());
            stmt.setString(10, restaurante.getSegmento());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar restaurante", e);
        }
    }

    // Método para excluir um restaurante
    public void excluirRestaurante(int id) {
        String sql = "CALL Excluir_Restaurante(?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir restaurante", e);
        }
    }

    // Método para listar todos os restaurantes
    public List<Restaurante> listarRestaurantes() {
        List<Restaurante> restaurantes = new ArrayList<>();
        String sql = "SELECT * FROM restaurante";

        try (Statement stmt = connection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Restaurante restaurante = new Restaurante();
                restaurante.setId(rs.getInt("id"));
                restaurante.setNome(rs.getString("nome"));
                restaurante.setCnpj(rs.getString("cnpj"));
                restaurante.setCep(rs.getString("cep"));
                restaurante.setRua(rs.getString("rua"));
                restaurante.setCidade(rs.getString("cidade"));
                restaurante.setEstado(rs.getString("estado"));
                restaurante.setNumeroResidencial(rs.getString("numero_residencial"));
                restaurante.setTelefone(rs.getString("telefone"));
                restaurante.setSegmento(rs.getString("segmento"));
                restaurantes.add(restaurante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar restaurantes", e);
        }
        return restaurantes;
    }
}