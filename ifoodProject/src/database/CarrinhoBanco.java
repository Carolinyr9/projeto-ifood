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
        String sql = "CALL Inserir_Carrinho(?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
        	stmt.setInt(1, carrinho.getIdCliente());
            stmt.setInt(2, carrinho.getIdPrato());
            stmt.setInt(3, carrinho.getIdProduto());
            stmt.setInt(4, carrinho.getIdRestaurante());
            stmt.setDouble(5, carrinho.getPreco());
            stmt.setString(6, carrinho.getEnderecoEntrega());
            stmt.setInt(7, carrinho.getQuantidade());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar item no carrinho", e);
        }
    }

    // Método para visualizar um item do carrinho pelo ID
    public List<Carrinho> visualizarCarrinho(int id) {
        String sql = "CALL Selecionar_Carrinho(?)";
        List<Carrinho> listaCarrinhos = new ArrayList<Carrinho>();

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Carrinho carrinho = new Carrinho();
                carrinho.setId(rs.getInt("id"));
                carrinho.setIdCliente(rs.getInt("id_cliente"));
                carrinho.setIdPrato(rs.getInt("id_prato"));
                carrinho.setIdProduto(rs.getInt("id_produto"));
                carrinho.setIdRestaurante(rs.getInt("id_restaurante"));
                carrinho.setPreco(rs.getDouble("preco"));
                carrinho.setEnderecoEntrega(rs.getString("endereco_entrega"));
                carrinho.setQuantidade(rs.getInt("quantidade"));
                
                listaCarrinhos.add(carrinho);
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
