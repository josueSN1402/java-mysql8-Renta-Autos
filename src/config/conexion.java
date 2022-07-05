package config;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

    Connection cn = null;
    String user = "root";
    String pass = "mysql2022";
    String bd = "bdrentaauto";
    String ip = "localhost";
    String puerto = "3306";
    String driver = "com.mysql.cj.jdbc.Driver";
    String sql = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;

    public Connection establecerConexion() {
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(sql, user, pass);
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.err.println("No se puedo conectar: \n" + e);
        }
        return cn;
    }
}
