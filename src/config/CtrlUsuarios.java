package config;

import java.util.logging.Level;
import java.util.logging.Logger;
import tables.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CtrlUsuarios extends conexion {

    public boolean login(Usuario usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        String sql = "SELECT username, contra FROM usuario WHERE username = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, usr.getUsername());
            rs = ps.executeQuery();
            if (rs.next()) {
                return usr.getContra().equals(rs.getString(2));
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int verificar(String usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        String sql = "SELECT count(username) FROM usuario WHERE username = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, usr);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            System.err.println(ex);
            return 1;
        }
    }

    public boolean insertar(Usuario usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        String sql = "INSERT INTO usuario (username, contra) VALUES (?, ?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, usr.getUsername());
            ps.setString(2, usr.getContra());
            int res = ps.executeUpdate();
            return res == 1;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
