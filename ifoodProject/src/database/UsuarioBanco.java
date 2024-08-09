package database;

import java.sql.*;
import java.time.LocalDate;

import model.Cliente;
import model.Entregador;
import model.Funcionario;
import model.Usuario;

public class UsuarioBanco {
    
    protected DBConnection connection;

    public UsuarioBanco(DBConnection connection) {
        super();
        this.connection = connection;
    }
    
    public Cliente logarCliente(Usuario usuario) {
        Cliente cliente = new Cliente();
        String sql = "CALL Logar_Cliente(?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());

            ResultSet rs = stmt.executeQuery();
            System.out.println("Logado");
            
            if (rs.next()) {
                System.out.println("Logado");
                cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                cliente.setTelefone(Long.parseLong(rs.getString("telefone")));
                cliente.setCpf(Long.parseLong(rs.getString("cpf")));
                cliente.setEndereco(rs.getString("rua") + " " + rs.getString("numero_residencial"));
                
            } else {
                System.out.println("Usuário não encontrado");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao logar usuário", e);
        }

        return cliente;
    }
    
    public Funcionario logarFuncionario(Usuario usuario) {
        Funcionario funcionario = new Funcionario();
        String sql = "CALL Logar_Funcionario(?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());

            ResultSet rs = stmt.executeQuery();
            System.out.println("Logado");
            
            if (rs.next()) {
                System.out.println("Logado");
                funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setCpf(Long.parseLong(rs.getString("cpf")));
                funcionario.setCodFuncional(rs.getString("codigo_funcional"));
                funcionario.setIdRestaurante(rs.getInt("id_restaurante"));
                
            } else {
                System.out.println("Usuário não encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao logar usuário", e);
        }

        return funcionario; 
    }
    
    public Entregador logarEntregador(Usuario usuario) {
        Entregador entregador = new Entregador();
        String sql = "CALL Logar_Entregador(?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());

            ResultSet rs = stmt.executeQuery();
            System.out.println("Logado");
            
            if (rs.next()) {
                System.out.println("Logado");
                entregador = new Entregador();
                entregador.setNome(rs.getString("nome"));
                entregador.setEmail(rs.getString("email"));
                entregador.setSenha(rs.getString("senha"));
                entregador.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                entregador.setCpf(Long.parseLong(rs.getString("cpf")));
                entregador.setCnh(Long.parseLong(rs.getString("cnh")));
                entregador.setEndereco(rs.getString("rua") + " " + rs.getString("numero_residencial"));
                    
            } else {
                System.out.println("Usuário não encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao logar usuário", e);
        }

        return entregador; 
    }
}