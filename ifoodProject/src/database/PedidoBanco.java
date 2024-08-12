package database;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;
import model.Status;
import model.StatusPedido;

public class PedidoBanco {

    protected DBConnection connection;

    public PedidoBanco(DBConnection connection) {
        super();
        this.connection = connection;
    }

 // Método para criar um novo pedido
    public void criarPedido(Pedido pedido) {
        String sql = "CALL inserir_pedido(?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, pedido.getIdsProdutos().toString()); // Convertendo lista para string JSON
            stmt.setString(2, pedido.getIdsPratos().toString()); // Convertendo lista para string JSON
            stmt.setString(3, pedido.getStatus().getStatus().toString());
            stmt.setInt(4, pedido.getIdCarrinho());
            stmt.setInt(5, pedido.getIdCliente());
            stmt.setInt(6, pedido.getIdEntregador());
            stmt.setInt(7, pedido.getIdRestaurante());
            stmt.setDouble(8, pedido.getPrecoTotal()); // Adicionando precoTotal

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar pedido", e);
        }
    }

    // Método para visualizar um pedido pelo ID
    public Pedido visualizarPedido(int id) {
        String sql = "CALL selecionar_pedido(?)";
        Pedido pedido = null;

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setIdsProdutos(convertJsonToList(rs.getString("ids_produtos")));
                pedido.setIdsPratos(convertJsonToList(rs.getString("ids_pratos")));
                Status status = Status.valueOf(rs.getString("status"));
                LocalDateTime horarioStatus = rs.getTimestamp("data_atualizacao").toLocalDateTime();
                pedido.setStatus(new StatusPedido(status, horarioStatus));
                pedido.setIdCarrinho(rs.getInt("id_carrinho"));
                pedido.setIdCliente(rs.getInt("id_cliente"));
                pedido.setIdEntregador(rs.getInt("id_entregador"));
                pedido.setIdRestaurante(rs.getInt("id_restaurante"));
                pedido.setDataPedido(rs.getTimestamp("data_pedido").toLocalDateTime());
                pedido.setEstimativaTempo(rs.getTimestamp("data_pedido").toLocalDateTime().plusMinutes(30));
                pedido.setPrecoTotal(rs.getDouble("precoTotal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao visualizar pedido", e);
        }
        return pedido;
    }

    // Método para excluir um pedido pelo ID
    public void excluirPedido(int id) {
        String sql = "CALL excluir_pedido(?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir pedido", e);
        }
    }

 // Método para listar pratos e produtos por restaurante
    public List<Pedido> listarPedidosPorRestaurante(int idRestaurante) {
        String sql = "CALL listar_pratos_produtos_por_restaurante(?)";
        List<Pedido> pedidos = new ArrayList<>();

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, idRestaurante);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                
                // Extrair e definir o ID do pedido
                pedido.setId(rs.getInt("id"));

                // Extrair e definir o status do pedido
                String statusStr = rs.getString("status");
                if (statusStr != null) {
                    Status status = Status.valueOf(statusStr.toUpperCase());
                    LocalDateTime horarioStatus = rs.getTimestamp("data_atualizacao").toLocalDateTime();
                    pedido.setStatus(new StatusPedido(status, horarioStatus));
                }

                // Configurar outros campos do pedido
                pedido.setIdCarrinho(rs.getInt("id_carrinho"));
                pedido.setIdCliente(rs.getInt("id_cliente"));
                pedido.setIdEntregador(rs.getInt("id_entregador"));
                pedido.setIdRestaurante(rs.getInt("id_restaurante"));
                pedido.setDataPedido(rs.getTimestamp("data_pedido").toLocalDateTime());
                pedido.setEstimativaTempo(rs.getTimestamp("data_pedido").toLocalDateTime().plusMinutes(30));

                // Extrair e definir o campo precoTotal
                pedido.setPrecoTotal(rs.getDouble("precoTotal"));

                // Converter JSON para lista de IDs
                String idsProdutosJson = rs.getString("ids_produtos");
                if (idsProdutosJson != null) {
                    pedido.setIdsProdutos(convertJsonToList(idsProdutosJson));
                }

                String idsPratosJson = rs.getString("ids_pratos");
                if (idsPratosJson != null) {
                    pedido.setIdsPratos(convertJsonToList(idsPratosJson));
                }

                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar pratos e produtos por restaurante", e);
        }
        return pedidos;
    }


    // Método para listar todos os pedidos
    public List<Pedido> listarTodosPedidos() {
        String sql = "CALL listar_todos_pedidos()";
        List<Pedido> pedidos = new ArrayList<>();

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setIdsProdutos(convertJsonToList(rs.getString("ids_produtos")));
                pedido.setIdsPratos(convertJsonToList(rs.getString("ids_pratos")));
                String statusStr = rs.getString("status");
                if (statusStr != null) {
                    Status status = Status.valueOf(statusStr.toUpperCase());
                    LocalDateTime horarioStatus = rs.getTimestamp("data_atualizacao").toLocalDateTime();
                    pedido.setStatus(new StatusPedido(status, horarioStatus));
                }
                pedido.setIdCarrinho(rs.getInt("id_carrinho"));
                pedido.setIdCliente(rs.getInt("id_cliente"));
                pedido.setIdEntregador(rs.getInt("id_entregador"));
                pedido.setIdRestaurante(rs.getInt("id_restaurante"));
                pedido.setDataPedido(rs.getTimestamp("data_pedido").toLocalDateTime());
                pedido.setEstimativaTempo(rs.getTimestamp("data_pedido").toLocalDateTime().plusMinutes(30));
                pedido.setPrecoTotal(rs.getDouble("precoTotal"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar todos os pedidos", e);
        }
        return pedidos;
    }

    // Método para listar pedidos por cliente
    public List<Pedido> listarPedidosPorCliente(int idCliente) {
        String sql = "CALL listar_pedidos_por_cliente(?)";
        List<Pedido> pedidos = new ArrayList<>();

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, idCliente);  
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                
                // Extrair e definir o ID do pedido
                pedido.setId(rs.getInt("id"));

                // Extrair e definir o status do pedido
                String statusStr = rs.getString("status");
                if (statusStr != null) {
                    Status status = Status.valueOf(statusStr.toUpperCase());
                    LocalDateTime horarioStatus = rs.getTimestamp("data_atualizacao").toLocalDateTime();
                    pedido.setStatus(new StatusPedido(status, horarioStatus));
                }

                // Configurar outros campos do pedido
                pedido.setIdCarrinho(rs.getInt("id_carrinho"));
                pedido.setIdCliente(rs.getInt("id_cliente"));
                pedido.setIdEntregador(rs.getInt("id_entregador"));
                pedido.setIdRestaurante(rs.getInt("id_restaurante"));
                pedido.setDataPedido(rs.getTimestamp("data_pedido").toLocalDateTime());
                pedido.setEstimativaTempo(rs.getTimestamp("data_pedido").toLocalDateTime().plusMinutes(30));

                // Extrair e definir o campo precoTotal
                pedido.setPrecoTotal(rs.getDouble("precoTotal"));

                // Converter JSON para lista de IDs
                String idsProdutosJson = rs.getString("ids_produtos");
                if (idsProdutosJson != null) {
                    pedido.setIdsProdutos(convertJsonToList(idsProdutosJson));
                }

                String idsPratosJson = rs.getString("ids_pratos");
                if (idsPratosJson != null) {
                    pedido.setIdsPratos(convertJsonToList(idsPratosJson));
                }

                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar pratos e produtos por restaurante", e);
        }
        return pedidos;
    }

    // Método auxiliar para converter JSON string para List<Integer>
    private List<Integer> convertJsonToList(String json) {
        List<Integer> list = new ArrayList<>();
        json = json.replace("[", "").replace("]", ""); // Remove colchetes
        String[] items = json.split(",");
        for (String item : items) {
        	if(item.equals(null)) {
        		list.add(Integer.parseInt(item.trim()));
        	}
        }
        return list;
    }
}
