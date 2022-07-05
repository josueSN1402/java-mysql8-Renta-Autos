package config;

import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import tables.Historial;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CtrlHistorial extends conexion {

    public boolean buscar(Historial his) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        String sql = "SELECT cod_Historial, descripcion, num_matricula, cod_alquiler FROM Historial WHERE cod_Historial = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, his.getCod_Historial());
            rs = ps.executeQuery();
            if (rs.next()) {
                his.setDescripcion(rs.getString("descripcion"));
                his.setNum_matricula(rs.getString("num_matricula"));
                his.setCod_alquiler(rs.getInt("cod_alquiler"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlHistorial.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int insertar(Historial his) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "INSERT INTO Historial (cod_Historial, descripcion, num_matricula, cod_alquiler) VALUES (?, ?, ?, ?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, his.getCod_Historial());
            ps.setString(2, his.getDescripcion());
            ps.setString(3, his.getNum_matricula());
            ps.setInt(4, his.getCod_alquiler());
            res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlHistorial.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Historial his, int cHis) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "UPDATE historial SET cod_Historial = ?, descripcion = ?, num_matricula = ?, cod_alquiler = ? WHERE cod_Historial = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, his.getCod_Historial());
            ps.setString(2, his.getDescripcion());
            ps.setString(3, his.getNum_matricula());
            ps.setInt(4, his.getCod_alquiler());
            ps.setInt(5, cHis);
            res = ps.executeUpdate();
            if (res > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlHistorial.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int eliminar(int cHis) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "DELETE FROM historial WHERE cod_Historial = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cHis);
            res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlHistorial.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
