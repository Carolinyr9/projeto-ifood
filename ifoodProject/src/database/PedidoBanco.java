package database;

import java.sql.*;
import java.time.LocalDateTime;
import model.Pedido;

public class PedidoBanco {

    protected DBConnection connection;

    public PedidoBanco(DBConnection connection) {
        super();
        this.connection = connection;
    }

    // Método para criar um novo pedido
    public void criarPedido(Pedido pedido) {
        String sql = "CALL Inserir_Pedido(?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, pedido.getStatus());
            stmt.setInt(3, pedido.getIdCliente());
            stmt.setInt(4, pedido.getIdEntregador());
            stmt.setTimestamp(5, Timestamp.valueOf(pedido.getDataPedido()));
            stmt.setTimestamp(6, Timestamp.valueOf(pedido.getDataAtualizacao()));

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar pedido", e);
        }
    }

    // Método para visualizar um pedido pelo ID
    public Pedido visualizarPedido(int id) {
        String sql = "CALL Selecionar_Pedido(?)";
        Pedido pedido = null;

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setStatus(rs.getString("status"));
                pedido.setIdCarrinho(rs.getInt("id_carrinho"));
                pedido.setIdCliente(rs.getInt("id_cliente"));
                pedido.setIdEntregador(rs.getInt("id_entregador"));
                pedido.setDataPedido(rs.getTimestamp("data_pedido").toLocalDateTime());
                pedido.setDataAtualizacao(rs.getTimestamp("data_atualizacao").toLocalDateTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao visualizar pedido", e);
        }
        return pedido;
    }

    // Método para excluir um pedido pelo ID
    public void excluirPedido(int id) {
        String sql = "CALL Excluir_Pedido(?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir pedido", e);
        }
    }
}
