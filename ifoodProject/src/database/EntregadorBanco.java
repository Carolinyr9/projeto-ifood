package database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Entregador;

public class EntregadorBanco {

    protected DBConnection connection;

    public EntregadorBanco(DBConnection connection) {
        super();
        this.connection = connection;
    }

    // Método para criar um novo entregador
    public void criarEntregador(Entregador entregador) {
        String sql = "CALL Inserir_Entregador(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, entregador.getNome());
            stmt.setDate(2, Date.valueOf(entregador.getDataNascimento()));
            stmt.setLong(3, entregador.getTelefone());

            String[] enderecoComponents = entregador.getEndereco().split(",");
            stmt.setString(4, enderecoComponents[0].trim());
            stmt.setString(5, enderecoComponents[1].trim());
            stmt.setString(6, enderecoComponents[2].trim());
            stmt.setString(7, enderecoComponents[3].trim());
            stmt.setString(8, enderecoComponents[4].trim());

            stmt.setLong(9, entregador.getCpf());
            stmt.setLong(10, entregador.getCnh());
            stmt.setString(11, entregador.getEmail());
            stmt.setString(12, entregador.getSenha());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar entregador", e);
        }
    }

    // Método para visualizar um entregador pelo ID
    public Entregador visualizarEntregador(int id) {
        String sql = "CALL Selecionar_Entregador(?)";
        Entregador entregador = null;

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                entregador = new Entregador();
                entregador.setNome(rs.getString("nome"));
                entregador.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                entregador.setTelefone(rs.getLong("telefone"));
                entregador.setEndereco(rs.getString("rua") + ", " + rs.getString("cidade") + ", " + rs.getString("estado") + ", " + rs.getString("cep") + ", " + rs.getString("numero_residencial"));
                entregador.setCpf(rs.getLong("cpf"));
                entregador.setCnh(rs.getLong("cnh"));
                entregador.setEmail(rs.getString("email"));
                entregador.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao visualizar entregador", e);
        }
        return entregador;
    }

    // Método para atualizar um entregador
    public void atualizarEntregador(Entregador entregador, int id) {
        String sql = "CALL Atualizar_Entregador(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, entregador.getNome());
            stmt.setDate(3, Date.valueOf(entregador.getDataNascimento()));
            stmt.setLong(4, entregador.getTelefone());

            String[] enderecoComponents = entregador.getEndereco().split(",");
            stmt.setString(5, enderecoComponents[0].trim());
            stmt.setString(6, enderecoComponents[1].trim());
            stmt.setString(7, enderecoComponents[2].trim());
            stmt.setString(8, enderecoComponents[3].trim());
            stmt.setString(9, enderecoComponents[4].trim());

            stmt.setLong(10, entregador.getCpf());
            stmt.setLong(11, entregador.getCnh());
            stmt.setString(12, entregador.getEmail());
            stmt.setString(13, entregador.getSenha());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar entregador", e);
        }
    }

    // Método para excluir um entregador
    public void excluirEntregador(int id) {
        String sql = "CALL Excluir_Entregador(?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir entregador", e);
        }
    }

    // Método para listar todos os entregadores
    public List<Entregador> listarEntregadores() {
        List<Entregador> entregadores = new ArrayList<>();
        String sql = "CALL Listar_Entregadores()";

        try (Statement stmt = connection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Entregador entregador = new Entregador();
                entregador.setNome(rs.getString("nome"));
                entregador.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                entregador.setTelefone(rs.getLong("telefone"));
                entregador.setEndereco(rs.getString("rua") + ", " + rs.getString("cidade") + ", " + rs.getString("estado") + ", " + rs.getString("cep") + ", " + rs.getString("numero_residencial"));
                entregador.setCpf(rs.getLong("cpf"));
                entregador.setCnh(rs.getLong("cnh"));
                entregador.setEmail(rs.getString("email"));
                entregador.setSenha(rs.getString("senha"));
                entregadores.add(entregador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar entregadores", e);
        }
        return entregadores;
    }
}
