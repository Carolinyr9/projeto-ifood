package database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteBanco {

    protected DBConnection connection;

    public ClienteBanco(DBConnection connection) {
        super();
        this.connection = connection;
    }

    // Método para criar um novo cliente
    public void criarCliente(Cliente cliente) {
        String sql = "CALL Inserir_Cliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setDate(2, Date.valueOf(cliente.getDataNascimento()));
            stmt.setLong(3, cliente.getTelefone());

            String[] enderecoComponents = cliente.getEndereco().split(",");
            stmt.setString(4, enderecoComponents[0].trim());
            stmt.setString(5, enderecoComponents[1].trim());
            stmt.setString(6, enderecoComponents[2].trim());
            stmt.setString(7, enderecoComponents[3].trim());
            stmt.setString(8, enderecoComponents[4].trim());

            stmt.setLong(9, cliente.getCpf());
            stmt.setString(10, cliente.getEmail());
            stmt.setString(11, cliente.getSenha());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar cliente", e);
        }
    }

    // Método para visualizar um cliente pelo ID
    public Cliente visualizarCliente(int id) {
        String sql = "CALL Selecionar_Cliente(?)";
        Cliente cliente = null;

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                cliente.setTelefone(rs.getLong("telefone"));
                cliente.setEndereco(rs.getString("rua") + ", " + rs.getString("cidade") + ", " + rs.getString("estado") + ", " + rs.getString("cep") + ", " + rs.getString("numero_residencial"));
                cliente.setCpf(rs.getLong("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao visualizar cliente", e);
        }
        return cliente;
    }

    // Método para atualizar um cliente
    public void atualizarCliente(Cliente cliente, int id) {
        String sql = "CALL Atualizar_Cliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, cliente.getNome());
            stmt.setDate(3, Date.valueOf(cliente.getDataNascimento()));
            stmt.setLong(4, cliente.getTelefone());

            String[] enderecoComponents = cliente.getEndereco().split(",");
            stmt.setString(5, enderecoComponents[0].trim());
            stmt.setString(6, enderecoComponents[1].trim());
            stmt.setString(7, enderecoComponents[2].trim());
            stmt.setString(8, enderecoComponents[3].trim());
            stmt.setString(9, enderecoComponents[4].trim());

            stmt.setLong(10, cliente.getCpf());
            stmt.setString(11, cliente.getEmail());
            stmt.setString(12, cliente.getSenha());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar cliente", e);
        }
    }

    // Método para excluir um cliente
    public void excluirCliente(int id) {
        String sql = "CALL Excluir_Cliente(?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir cliente", e);
        }
    }

    // Método para listar todos os clientes
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "CALL Listar_Clientes()";

        try (Statement stmt = connection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                cliente.setTelefone(rs.getLong("telefone"));
                cliente.setEndereco(rs.getString("rua") + ", " + rs.getString("cidade") + ", " + rs.getString("estado") + ", " + rs.getString("cep") + ", " + rs.getString("numero_residencial"));
                cliente.setCpf(rs.getLong("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar clientes", e);
        }
        return clientes;
    }
}
