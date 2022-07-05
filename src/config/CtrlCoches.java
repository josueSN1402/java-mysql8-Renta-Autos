package config;

import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import tables.Coches;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;

public class CtrlCoches extends conexion {

    public void datos(String valor, JTable table) {
        try {
            Connection con = establecerConexion();
            String[] titulos = {"N° Matricula", "Color", "Kilometros", "Modelo"};

            DefaultTableModel modelo = new DefaultTableModel(null, titulos);
            table.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "SELECT numero_Matricula, color, km, modelo FROM coches WHERE numero_Matricula LIKE '%" + valor + "%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int rowsCount = rsMd.getColumnCount();

            int[] columnWith = {150, 150, 150, 150};

            for (int x = 0; x < rowsCount; x++) {
                table.getColumnModel().getColumn(x).setPreferredWidth(columnWith[x]);
            }

            while (rs.next()) {
                Object[] rows = new Object[rowsCount];

                for (int i = 0; i < rowsCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }

                modelo.addRow(rows);
            }
            rs.close();
            table.setModel(modelo);
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public boolean buscar(Coches coche) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        String sql = "SELECT numero_Matricula, color, km, modelo FROM coches WHERE numero_Matricula = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, coche.getNumero_Matricula());
            rs = ps.executeQuery();
            if (rs.next()) {
                coche.setNumero_Matricula(rs.getString("numero_Matricula"));
                coche.setColor(rs.getString("color"));
                coche.setKm(rs.getInt("km"));
                coche.setModelo(rs.getString("modelo"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlCoches.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public void cargarModelos(JComboBox cbo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        String sql = "SELECT cod_Modelo FROM modelos ORDER BY cod_Modelo ASC";
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbo.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlAlquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void cargarColores(JComboBox cbo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        String sql = "SELECT DISTINCT color FROM coches ORDER BY color ASC";
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbo.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlAlquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int insertar(Coches coche) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "INSERT INTO coches (numero_Matricula, color, km, modelo) VALUES (?, ?, ?, ?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, coche.getNumero_Matricula());
            ps.setString(2, coche.getColor());
            ps.setInt(3, coche.getKm());
            ps.setString(4, coche.getModelo());
            res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlCoches.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Coches coche, String matri) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "UPDATE coches SET color = ?, km = ?, modelo = ? WHERE numero_Matricula = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, coche.getColor());
            ps.setInt(2, coche.getKm());
            ps.setString(3, coche.getModelo());
            ps.setString(4, coche.getNumero_Matricula());
            res = ps.executeUpdate();
            return res > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlCoches.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int eliminar(String matri) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "DELETE FROM coches WHERE numero_Matricula = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, matri);
            res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlCoches.class.getName()).log(Level.SEVERE, null, ex);
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
