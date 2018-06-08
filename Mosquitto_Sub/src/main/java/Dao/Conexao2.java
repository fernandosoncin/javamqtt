package Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao2 implements Serializable {

    private static Conexao2 conexao2 = null;
    private static Connection connection;
    private String usuario;
    private String senha;
    private String url;

    private Conexao2() {
        // Altere o usuário e senha de acordo com o banco de dados instalado
        usuario = "root";
        senha = "32799097";
        
        // Defina aqui o nome do seu banco de dados
        url = "jdbc:mysql://localhost:3306/sistema_distribuido_2";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        }
    }

    public static Connection getInstance() {
        if (conexao2 == null) {
            synchronized (Conexao.class) {
                conexao2 = new Conexao2();
            }
        }
        return connection;
    }

    public static void closeInstance() throws SQLException {
        if (conexao2 != null) {
            connection.close();
        }
    }

    public static void setAutoCommit(boolean vlr) throws SQLException {
        connection.setAutoCommit(vlr);
    }

    public static void commit() throws SQLException {
        connection.commit();
    }

    public static void rollback() throws SQLException {
        connection.rollback();
    }
}

