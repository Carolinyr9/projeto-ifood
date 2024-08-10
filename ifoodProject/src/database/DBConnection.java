package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private String host;
    private String port;
    private String schema;
    private String user;
    private String password;

    private Connection connection = null;

    public DBConnection(String host, String port, String schema, String user, String password) {
        this.host = host.isEmpty() ? "localhost" : host;
        this.port = port.isEmpty() ? "3306" : port;
        this.schema = schema;
        this.user = user;
        this.password = password;
        this.doConnection();
    }

    public DBConnection() {
        this("localhost", "3306", "bdelivery", "root", "Amo-voce28");
    }

    private void doConnection() {
        String timezone = "&useTimezone=true&serverTimezone=UTC";
        String url = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.schema + "?user=" + this.user + "&password=" + this.password + timezone;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Tratamento adequado da exceção ou relançamento como RuntimeException
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host.isEmpty() ? "localhost" : host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port.isEmpty() ? "3306" : port;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
