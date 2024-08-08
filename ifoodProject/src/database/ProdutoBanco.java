package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoBanco {

    protected DBConnection connection;

    public ProdutoBanco(DBConnection connection) {
        this.connection = connection;
    }

    // Método para criar um novo produto
    public boolean criarProduto(Produto produto) {
        String sql = "CALL Inserir_Produto(?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
        	stmt.setInt(1, produto.getIdProduto());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getIdRestaurante());

            stmt.execute();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar produto", e);
        }
    }

    // Método para visualizar um produto pelo ID
    public Produto visualizarProduto(int id) {
        String sql = "CALL Selecionar_Produto(?)";
        Produto produto = null;

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                produto.setIdProduto(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setIdRestaurante(rs.getInt("id_restaurante"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao visualizar produto", e);
        }
        return produto;
    }

    // Método para atualizar um produto
    public void atualizarProduto(Produto produto, int id) {
        String sql = "CALL Atualizar_Produto(?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getIdRestaurante());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar produto", e);
        }
    }

    // Método para excluir um produto
    public void excluirProduto(int id) {
        String sql = "CALL Excluir_Produto(?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir produto", e);
        }
    }

    // Método para listar todos os produtos de um restaurante específico
    public List<Produto> listarProdutos(int idRestaurante) {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE id_restaurante = ?";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, idRestaurante);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setIdRestaurante(rs.getInt("id_restaurante"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar produtos", e);
        }
        return produtos;
    }
}
