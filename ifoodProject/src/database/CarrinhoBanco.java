package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Carrinho;

public class CarrinhoBanco {

    protected DBConnection connection;

    public CarrinhoBanco(DBConnection connection) {
        super();
        this.connection = connection;
    }

    // Método para criar um novo item no carrinho
    public void criarCarrinho(Carrinho carrinho) {
        String sql = "CALL Inserir_Carrinho(?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, carrinho.getIdPrato());
            stmt.setInt(2, carrinho.getIdProduto());
            stmt.setInt(3, carrinho.getIdRestaurante());
            stmt.setDouble(4, carrinho.getPreco());
            stmt.setString(5, carrinho.getEnderecoEntrega());
            stmt.setInt(6, carrinho.getQuantidade());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar item no carrinho", e);
        }
    }

    // Método para visualizar um item do carrinho pelo ID
    public List<Carrinho> visualizarCarrinho(int id) {
        String sql = "CALL Selecionar_Carrinho(?)";
        List<Carrinho> listaCarrinhos = null;
        //Carrinho carrinho = null;

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            listaCarrinhos = new ArrayList<Carrinho>();
            int i = 0;
            while(rs.next()) {
            	listaCarrinhos.get(i).setId(rs.getInt("id"));
            	listaCarrinhos.get(i).setIdPrato(rs.getInt("id_prato"));
            	listaCarrinhos.get(i).setIdProduto(rs.getInt("id_produto"));
            	listaCarrinhos.get(i).setIdRestaurante(rs.getInt("id_restaurante"));
            	listaCarrinhos.get(i).setPreco(rs.getDouble("preco"));
            	listaCarrinhos.get(i).setEnderecoEntrega(rs.getString("endereco_entrega"));
            	listaCarrinhos.get(i).setQuantidade(rs.getInt("quantidade"));
            	i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao visualizar item do carrinho", e);
        }
        return listaCarrinhos;
    }

    // Método para excluir um item do carrinho
    public void excluirCarrinho(int id) {
        String sql = "CALL Excluir_Carrinho(?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir item do carrinho", e);
        }
    }
}
