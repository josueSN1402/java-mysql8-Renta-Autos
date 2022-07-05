package config;

import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import tables.Empleados;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CtrlEmpleados extends conexion {

    public void datos(String valor, JTable table) {
        try {
            Connection con = establecerConexion();
            String[] titulos = {"N° Matricula", "Color", "Kilometros", "Modelo"};

            DefaultTableModel modelo = new DefaultTableModel(null, titulos);
            table.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "SELECT dni, apellido_paterno, apellido_materno, nombre, cargo, telefono, edad, sexo, username, lugar_trabajo FROM empleados WHERE dni LIKE '%" + valor + "%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int rowsCount = rsMd.getColumnCount();

            int[] columnWith = {30, 30, 30, 30, 30, 30, 30, 30, 30, 30};

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

    public boolean buscar(Empleados emple) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        String sql = "SELECT dni, apellido_paterno, apellido_materno, nombre, cargo, telefono, edad, sexo, username, lugar_trabajo FROM empleados WHERE dni = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, emple.getDni());
            rs = ps.executeQuery();
            if (rs.next()) {
                emple.setDni(rs.getString("dni"));
                emple.setApellido_paterno(rs.getString("apellido_paterno"));
                emple.setApellido_materno(rs.getString("apellido_materno"));
                emple.setNombre(rs.getString("nombre"));
                emple.setCargo(rs.getString("direccion"));
                emple.setTelefono(rs.getInt("telefono"));
                emple.setEdad(rs.getInt("edad"));
                emple.setSexo(rs.getString("sexo"));
                emple.setSexo(rs.getString("username"));
                emple.setLugar_trabajo(rs.getInt("lugar_trabajo"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int insertar(Empleados emple) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "INSERT INTO empleados (dni, apellido_paterno, apellido_materno, nombre, cargo, telefono, edad, sexo, username, lugar_trabajo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, emple.getDni());
            ps.setString(2, emple.getApellido_paterno());
            ps.setString(3, emple.getApellido_materno());
            ps.setString(4, emple.getNombre());
            ps.setString(5, emple.getCargo());
            ps.setInt(6, emple.getTelefono());
            ps.setInt(7, emple.getEdad());
            ps.setString(8, emple.getSexo());
            ps.setString(9, emple.getUsername());
            ps.setInt(10, emple.getLugar_trabajo());
            res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Empleados emple, String dni) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "UPDATE empleados SET dni = ?, apellido_paterno = ?, apellido_materno = ?, nombre = ?, cargo = ?, telefono = ?, edad = ?, sexo = ?, username = ?, lugar_trabajo = ? WHERE dni = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, emple.getDni());
            ps.setString(2, emple.getApellido_paterno());
            ps.setString(3, emple.getApellido_materno());
            ps.setString(4, emple.getNombre());
            ps.setString(5, emple.getCargo());
            ps.setInt(6, emple.getTelefono());
            ps.setInt(7, emple.getEdad());
            ps.setString(8, emple.getSexo());
            ps.setString(9, emple.getUsername());
            ps.setInt(10, emple.getLugar_trabajo());
            ps.setString(11, dni);
            res = ps.executeUpdate();
            if (res > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlEmpleados.class.getName()).log(Level.SEVERE, null, ex);
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
        String sql = "DELETE FROM empleados WHERE dni = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, dni);
            res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlEmpleados.class.getName()).log(Level.SEVERE, null, ex);
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
