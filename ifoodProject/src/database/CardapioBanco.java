package database;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Cardapio;
import model.ItemCardapio;
import model.Prato;
import model.Produto;

public class CardapioBanco {

    protected DBConnection connection;

    public CardapioBanco(DBConnection connection) {
        super();
        this.connection = connection;
    }

    // Método para criar um novo cardápio
    public void criarCardapio(Cardapio cardapio) {
        String sql = "CALL Inserir_Cardapio(?, ?, ?, ?)";

        for (ItemCardapio item : cardapio.getItensCardapio()) {
            try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
                stmt.setInt(1, cardapio.getId());
                stmt.setInt(2, item.getIdRestaurante());

                if (item instanceof Prato) {
                    stmt.setInt(3, item.getIdPrato());
                    stmt.setNull(4, java.sql.Types.INTEGER);
                } else if (item instanceof Produto) {
                    stmt.setNull(3, java.sql.Types.INTEGER);
                    stmt.setInt(4, item.getIdProduto());
                } else {
                    throw new RuntimeException("Tipo desconhecido de ItemCardapio");
                }

                stmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao criar cardápio", e);
            }
        }
    }

    // Método para visualizar um cardápio pelo ID
    public Cardapio visualizarCardapio(int id) {
        String sql = "CALL Selecionar_Cardapio(?)";
        List<ItemCardapio> itensCardapio = new ArrayList<>();

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ItemCardapio item = new ItemCardapio();
                item.setIdRestaurante(rs.getInt("id_restaurante"));
                item.setIdPrato(rs.getInt("id_prato"));
                item.setIdProduto(rs.getInt("id_produto"));
                item.setPreco(rs.getDouble("preco"));
                itensCardapio.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao visualizar cardápio", e);
        }
        return new Cardapio(itensCardapio);
    }

    // Método para atualizar um cardápio
    public void atualizarCardapio(Cardapio cardapio, int id) {
        String sql = "CALL Atualizar_Cardapio(?, ?, ?, ?)";

        for (ItemCardapio item : cardapio.getItensCardapio()) {
            try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.setInt(2, item.getIdRestaurante());
                stmt.setInt(3, item.getIdPrato());
                stmt.setInt(4, item.getIdProduto());

                stmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao atualizar cardápio", e);
            }
        }
    }

    // Método para excluir um cardápio
    public void excluirCardapio(int id) {
        String sql = "CALL Excluir_Cardapio(?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir cardápio", e);
        }
    }

    // Método para listar todos os cardápios
    public List<Cardapio> listarCardapios() {
        List<Cardapio> cardapios = new ArrayList<>();
        String sql = "CALL Listar_Cardapios()";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                List<ItemCardapio> itensCardapio = new ArrayList<>();
                int idCardapio = rs.getInt("id");

                do {
                    ItemCardapio item = new ItemCardapio();
                    item.setIdRestaurante(rs.getInt("id_restaurante"));
                    item.setIdPrato(rs.getInt("id_prato"));
                    item.setIdProduto(rs.getInt("id_produto"));
                    item.setPreco(rs.getDouble("preco"));
                    itensCardapio.add(item);
                } while (rs.next() && rs.getInt("id") == idCardapio);

                cardapios.add(new Cardapio(itensCardapio));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar cardápios", e);
        }
        return cardapios;
    }
    
    public List<ItemCardapio> listarCardapioPorRestaurante(int idRestaurante) {
        List<ItemCardapio> itensCardapio = new ArrayList<>();
        String sql = "CALL listar_cardapio_produto_prato(?)";

        try (PreparedStatement stmt = connection.getConnection().prepareStatement(sql)) {
            // Define o parâmetro id_restaurante
            stmt.setInt(1, idRestaurante);

            // Executa a procedure e obtém os resultados
            boolean isResultSet = stmt.execute();
            while (isResultSet) {
                try (ResultSet rs = stmt.getResultSet()) {
                    // Processa o ResultSet para Pratos
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        Double preco = rs.getDouble("preco");
                        String descricao = rs.getString("descricao");

                        if (rs.findColumn("ngredientes") > 0) {
                            String ingredientes = rs.getString("ngredientes");
                            Prato prato = new Prato();
                            prato.setIdPrato(id);
                            prato.setNome(nome);
                            prato.setPreco(preco);
                            prato.setDescricao(descricao);
                            prato.setIngredientes(ingredientes);
                            itensCardapio.add(prato);
                        } else {
                            Produto produto = new Produto();
                            produto.setIdProduto(id);
                            produto.setNome(nome);
                            produto.setPreco(preco);
                            produto.setDescricao(descricao);
                            itensCardapio.add(produto);
                        }
                    }
                }
                // Verifica se há mais resultados (produtos) e processa
                isResultSet = stmt.getMoreResults();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar cardápio por restaurante", e);
        }

        return itensCardapio;
    }


}
