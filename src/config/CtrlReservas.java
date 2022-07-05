package config;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import tables.Reservas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CtrlReservas extends conexion {

    public void datos(String valor, JTable table) {
        try {
            Connection con = establecerConexion();
            String[] titulos = {"Código", "Fecha inicial", "Fecha final", "Precio", "DNI", "Modelo"};

            DefaultTableModel modelo = new DefaultTableModel(null, titulos);
            table.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "SELECT cod_Reserva, fecha_inicio_res, fecha_final_res, precio_acordado, dni, modelo FROM Reservas WHERE dni LIKE '%" + valor + "%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int rowsCount = rsMd.getColumnCount();

            int[] columnWith = {80, 80, 80, 100, 100, 80, 120};

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

    public boolean buscar(Reservas reser) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        String sql = "SELECT cod_Reserva, fecha_inicio_res, fecha_final_res, precio_acordado, dni, cod_Ofi_1_r, cod_Ofi_2_r, modelo FROM Reservas WHERE cod_Reserva = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, reser.getCod_Reserva());
            rs = ps.executeQuery();
            if (rs.next()) {
                reser.setCod_Reserva(rs.getInt("cod_Reserva"));
                reser.setFecha_inicio_res(rs.getDate("fecha_inicio_res"));
                reser.setFecha_final_res(rs.getDate("fecha_final_res"));
                reser.setPrecio_acordado(rs.getInt("precio_acordado"));
                reser.setDni(rs.getString("dni"));
                reser.setCod_Ofi_1_r(rs.getInt("cod_Ofi_1_r"));
                reser.setCod_Ofi_2_r(rs.getInt("cod_Ofi_2_r"));
                reser.setModelo(rs.getString("modelo"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlReservas.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int insertar(Reservas reser) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "INSERT INTO reservas (cod_Reserva, fecha_inicio_res, fecha_final_res, precio_acordado, dni, cod_Ofi_1_r, cod_Ofi_2_r, modelo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, reser.getCod_Reserva());
            ps.setDate(2, (Date) reser.getFecha_inicio_res());
            ps.setDate(3, (Date) reser.getFecha_final_res());
            ps.setDouble(4, reser.getPrecio_acordado());
            ps.setString(5, reser.getDni());
            ps.setInt(6, reser.getCod_Ofi_1_r());
            ps.setInt(7, reser.getCod_Ofi_2_r());
            ps.setString(8, reser.getModelo());
            res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlReservas.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Reservas reser, String cod) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "UPDATE reservas SET cod_Reserva = ?, fecha_inicio_res = ?, fecha_final_res = ?, precio_acordado = ?, dni = ?, cod_Ofi_1_r = ?, cod_Ofi_2_r = ?, modelo = ? WHERE cod_Reserva = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, reser.getCod_Reserva());
            ps.setDate(2, (Date) reser.getFecha_inicio_res());
            ps.setDate(3, (Date) reser.getFecha_final_res());
            ps.setDouble(4, reser.getPrecio_acordado());
            ps.setString(5, reser.getDni());
            ps.setInt(6, reser.getCod_Ofi_1_r());
            ps.setInt(7, reser.getCod_Ofi_2_r());
            ps.setString(8, reser.getModelo());
            ps.setString(9, cod);
            res = ps.executeUpdate();
            if (res > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlReservas.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int eliminar(String cod) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "DELETE FROM reservas WHERE cod_Reserva = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cod);
            res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlReservas.class.getName()).log(Level.SEVERE, null, ex);
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
