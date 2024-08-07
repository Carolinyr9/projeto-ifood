package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Prato;

public class PratoBanco {

    protected DBConnection connection;

    public PratoBanco(DBConnection dbconnection) {
        super();
        this.connection = dbconnection;
    }

    // Método para criar um novo prato
    public boolean criarPrato(Prato prato) {
        String sql = "CALL Inserir_Prato(?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
        	stmt.setInt(1, prato.getId());
            stmt.setString(2, prato.getNome());
            stmt.setString(3, prato.getDescricao());
            stmt.setString(4, prato.getIngredientes());
            stmt.setDouble(5, prato.getPreco());
            stmt.setInt(6, prato.getIdRestaurante());

            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar prato", e);
        }
    }

    // Método para visualizar um prato pelo ID
    public Prato visualizarPrato(int id) {
        String sql = "CALL Selecionar_Prato(?)";
        Prato prato = null;

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                prato = new Prato();
                prato.setId(rs.getInt("id"));
                prato.setNome(rs.getString("nome"));
                prato.setDescricao(rs.getString("descricao"));
                prato.setIngredientes(rs.getString("ingredientes"));
                prato.setPreco(rs.getDouble("preco"));
                prato.setIdRestaurante(rs.getInt("id_restaurante"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao visualizar prato", e);
        }
        return prato;
    }

    // Método para atualizar um prato
    public void atualizarPrato(Prato prato, int id) {
        String sql = "CALL Atualizar_Prato(?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, prato.getNome());
            stmt.setString(3, prato.getDescricao());
            stmt.setString(4, prato.getIngredientes());
            stmt.setDouble(5, prato.getPreco());
            stmt.setInt(6, prato.getIdRestaurante());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar prato", e);
        }
    }

    // Método para excluir um prato
    public void excluirPrato(int id) {
        String sql = "CALL Excluir_Prato(?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir prato", e);
        }
    }

    // Método para listar todos os pratos
    public List<Prato> listarPratos() {
        List<Prato> pratos = new ArrayList<>();
        String sql = "SELECT * FROM prato";

        try (Statement stmt = connection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Prato prato = new Prato();
                prato.setId(rs.getInt("id"));
                prato.setNome(rs.getString("nome"));
                prato.setDescricao(rs.getString("descricao"));
                prato.setIngredientes(rs.getString("ingredientes"));
                prato.setPreco(rs.getDouble("preco"));
                prato.setIdRestaurante(rs.getInt("id_restaurante"));
                pratos.add(prato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar pratos", e);
        }
        return pratos;
    }
}
