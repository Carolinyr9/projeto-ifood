package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import database.DBConnection;
import model.Cardapio;

public class CardapioBanco {

    protected DBConnection connection;

    public CardapioBanco(DBConnection connection) {
        super();
        this.connection = connection;
    }

    // Método para criar um novo cardápio
    public void criarCardapio(Cardapio cardapio) {
        String sql = "CALL Inserir_Cardapio(?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, cardapio.getIdRestaurante());
            stmt.setInt(2, cardapio.getIdPrato());
            stmt.setInt(3, cardapio.getIdProduto());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar cardápio", e);
        }
    }

    // Método para visualizar um cardápio pelo ID
    public Cardapio visualizarCardapio(int id) {
        String sql = "CALL Selecionar_Cardapio(?)";
        Cardapio cardapio = null;

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cardapio = new Cardapio();
                cardapio.setId(rs.getInt("id"));
                cardapio.setIdRestaurante(rs.getInt("id_restaurante"));
                cardapio.setIdPrato(rs.getInt("id_prato"));
                cardapio.setIdProduto(rs.getInt("id_produto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao visualizar cardápio", e);
        }
        return cardapio;
    }

    // Método para atualizar um cardápio
    public void atualizarCardapio(Cardapio cardapio, int id) {
        String sql = "CALL Atualizar_Cardapio(?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setInt(2, cardapio.getIdRestaurante());
            stmt.setInt(3, cardapio.getidPrato(id));
            stmt.setInt(4, cardapio.getIdProduto());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar cardápio", e);
        }
    }

    // Método para excluir um cardápio
    public void excluirCardapio(int id) {
        String sql = "CALL Excluir_Cardapio(?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir cardápio", e);
        }
    }

    // Método para listar todos os cardápios
    public List<Cardapio> listarCardapios() {
        List<Cardapio> cardapios = new ArrayList<>();
        String sql = "CALL Listar_Cardapios()";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cardapio cardapio = new Cardapio();
                cardapio.setId(rs.getInt("id"));
                cardapio.setIdRestaurante(rs.getInt("id_restaurante"));
                cardapio.setIdPrato(rs.getInt("id_prato"));
                cardapio.setIdProduto(rs.getInt("id_produto"));
                cardapios.add(cardapio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar cardápios", e);
        }
        return cardapios;
    }
}
