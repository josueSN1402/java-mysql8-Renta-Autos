package config;

import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import tables.Clientes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;

public class CtrlClientes extends conexion {

    public void datos(String valor, JTable table) {
        try {
            Connection con = establecerConexion();
            String[] titulos = {"DNI", "A. Paterno", "A. Materno", "Nombre", "Dirección", "Teléfono"};

            DefaultTableModel modelo = new DefaultTableModel(null, titulos);
            table.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "SELECT dni, apellido_paterno, apellido_materno, nombre, direccion, telefono FROM clientes WHERE dni LIKE '%" + valor + "%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int rowsCount = rsMd.getColumnCount();

            int[] columnWith = {80, 100, 100, 100, 140, 80};

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

    public boolean buscar(Clientes cli) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        String sql = "SELECT dni, apellido_paterno, apellido_materno, nombre, direccion, telefono FROM clientes WHERE dni = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            rs = ps.executeQuery();
            if (rs.next()) {
                cli.setDni(rs.getString("dni"));
                cli.setApellido_paterno(rs.getString("apellido_paterno"));
                cli.setApellido_materno(rs.getString("apellido_materno"));
                cli.setNombre(rs.getString("nombre"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setTelefono(rs.getInt("telefono"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlClientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int insertar(Clientes cli) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "INSERT INTO clientes (dni, apellido_paterno, apellido_materno, nombre, direccion, telefono) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getApellido_paterno());
            ps.setString(3, cli.getApellido_materno());
            ps.setString(4, cli.getNombre());
            ps.setString(5, cli.getDireccion());
            ps.setInt(6, cli.getTelefono());
            res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlClientes.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Clientes cli, String dni) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "UPDATE clientes SET dni = ?, apellido_paterno = ?, apellido_materno = ?, nombre = ?, direccion = ?, telefono = ? WHERE dni = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getApellido_paterno());
            ps.setString(3, cli.getApellido_materno());
            ps.setString(4, cli.getNombre());
            ps.setString(5, cli.getDireccion());
            ps.setInt(6, cli.getTelefono());
            ps.setString(7, dni);
            res = ps.executeUpdate();
            return res > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlClientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int eliminar(String dni) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "DELETE FROM clientes WHERE dni = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, dni);
            res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlClientes.class.getName()).log(Level.SEVERE, null, ex);
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
