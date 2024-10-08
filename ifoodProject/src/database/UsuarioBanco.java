package database;

import java.sql.*;
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
    
    public Cliente logarCliente(String email,String senha) {
        Cliente cliente = new Cliente();
        String sql = "CALL Logar_Cliente(?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                cliente.setTelefone(Long.parseLong(rs.getString("telefone")));
                cliente.setCpf(Long.parseLong(rs.getString("cpf")));
                cliente.setEndereco(rs.getString("rua") + " " + rs.getString("numero_residencial"));
                cliente.setId(rs.getInt("id"));
                
            } else {
                System.out.println("Usuário não encontrado");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao logar usuário", e);
        }

        return cliente;
    }
    
    public Funcionario logarFuncionario(String email,String senha)  {
        Funcionario funcionario = new Funcionario();
        String sql = "CALL Logar_Funcionario(?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
        	stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
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
    
    public Entregador logarEntregador(String email,String senha)  {
        Entregador entregador = new Entregador();
        String sql = "CALL Logar_Entregador(?, ?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
        	stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
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
    
 // Método para obter um cliente pelo ID
    public Cliente obterClientePorId(int idCliente) {
        Cliente cliente = null;
        String sql = "CALL Obter_Cliente_Por_ID(?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
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
            throw new RuntimeException("Erro ao obter cliente por ID", e);
        }

        return cliente;
    }
}
