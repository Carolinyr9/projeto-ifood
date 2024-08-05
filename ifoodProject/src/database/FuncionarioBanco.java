package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;

public class FuncionarioBanco {

    protected DBConnection connection;

    public FuncionarioBanco(DBConnection connection) {
        super();
        this.connection = connection;
    }

    // Método para criar um novo funcionário
    public void criarFuncionario(Funcionario funcionario) {
        String sql = "CALL Inserir_Funcionario(?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setLong(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getCodigoFuncional());
            stmt.setString(4, funcionario.getEmail());
            stmt.setString(5, funcionario.getSenha());
            stmt.setInt(6, funcionario.getIdRestaurante());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar funcionário", e);
        }
    }

    // Método para visualizar um funcionário pelo ID
    public Funcionario visualizarFuncionario(int id) {
        String sql = "CALL Selecionar_Funcionario(?)";
        Funcionario funcionario = null;

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getLong("cpf"));
                funcionario.setCodigoFuncional(rs.getString("codigo_funcional"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setIdRestaurante(rs.getInt("id_restaurante"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao visualizar funcionário", e);
        }
        return funcionario;
    }

    // Método para atualizar um funcionário
    public void atualizarFuncionario(Funcionario funcionario, int id) {
        String sql = "CALL Atualizar_Funcionario(?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, funcionario.getNome());
            stmt.setLong(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getCodigoFuncional());
            stmt.setString(5, funcionario.getEmail());
            stmt.setString(6, funcionario.getSenha());
            stmt.setInt(7, funcionario.getIdRestaurante());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar funcionário", e);
        }
    }

    // Método para excluir um funcionário
    public void excluirFuncionario(int id) {
        String sql = "CALL Excluir_Funcionario(?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir funcionário", e);
        }
    }

    // Método para listar todos os funcionários
    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "CALL Listar_Funcionarios()";

        try (Statement stmt = connection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getLong("cpf"));
                funcionario.setCodigoFuncional(rs.getString("codigo_funcional"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setIdRestaurante(rs.getInt("id_restaurante"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar funcionários", e);
        }
        return funcionarios;
    }
}
