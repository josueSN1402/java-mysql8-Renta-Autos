package config;

import java.util.logging.Level;
import java.util.logging.Logger;
import tables.Alquiler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CtrlAlquiler extends conexion {

    public void datos(String valor, JTable table) {
        try {
            Connection con = establecerConexion();
            String[] titulos = {"Código", "Fecha inicial", "Fecha final", "DNI", "Matricula", "Ofi. Recojo", "Ofi. Entrega", "Reserva"};

            DefaultTableModel modelo = new DefaultTableModel(null, titulos);
            table.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "SELECT A.cod_Alquiler, A.fecha_inicio_al, A.fecha_final_al, A.dni, A.num_matricula, O1.nom_Oficina, O2.nom_Oficina, A.cod_reserva "
                    + "FROM alquiler AS A "
                    + "INNER JOIN oficina AS O1 "
                    + "ON A.cod_Ofi_1_a = O1.cod_Oficina "
                    + "INNER JOIN oficina AS O2 "
                    + "ON A.cod_Ofi_2_a = O2.cod_Oficina "
                    + "WHERE dni LIKE '%" + valor + "%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int rowsCount = rsMd.getColumnCount();

            int[] columnWith = {60, 100, 100, 75, 80, 80, 80, 50};

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

    public boolean buscar(Alquiler alq) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        String sql = "SELECT A.cod_Alquiler, A.fecha_inicio_al, A.fecha_final_al, A.dni, A.cod_Ofi_1_a, A.cod_Ofi_2_a, A.num_matricula, A.cod_reserva "
                + "FROM alquiler AS A "
                + "WHERE A.cod_Alquiler = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, alq.getCod_Alquiler());
            rs = ps.executeQuery();
            if (rs.next()) {
                alq.setCod_Alquiler(rs.getInt("cod_Alquiler"));
                alq.setFecha_inicio_al(rs.getDate("fecha_inicio_al"));
                alq.setFecha_final_al(rs.getDate("fecha_final_al"));
                alq.setDni(rs.getString("dni"));
                alq.setCod_Ofi_1_a(rs.getInt("cod_Ofi_1_a"));
                alq.setCod_Ofi_2_a(rs.getInt("cod_Ofi_2_a"));
                alq.setNum_matricula(rs.getString("num_matricula"));
                alq.setCod_reserva(rs.getInt("cod_reserva"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlAlquiler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public void cargarOficionas(JComboBox cbo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        String sql = "SELECT nom_Oficina FROM oficina ORDER BY nom_Oficina ASC";
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

    public int codOficiona(String nom) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int codOfi = 0;
        String sql = "SELECT cod_Oficina FROM oficina WHERE nom_Oficina = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();
            if (rs.next()) {
                codOfi = rs.getInt(1);
            }
            return codOfi;
        } catch (SQLException ex) {
            System.err.println(ex);
            return 0;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlAlquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String nomOficina(int ofi) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        String codOfi = "";
        String sql = "SELECT nom_Oficina FROM oficina WHERE cod_Oficina = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, ofi);
            rs = ps.executeQuery();
            if (rs.next()) {
                codOfi = rs.getString(1);
            }
            return codOfi;
        } catch (SQLException ex) {
            System.err.println(ex);
            return "";
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlAlquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean insertar(int codRes) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        /* String sql = "INSERT INTO alquiler (fecha_inicio_al, fecha_final_al, dni, cod_Ofi_1_a, cod_Ofi_2_a, num_matricula, cod_reserva) VALUES ("
                + "(SELECT fecha_inicio_res FROM reservas where cod_Reserva = ?), (SELECT fecha_final_res FROM reservas where cod_Reserva = ?), "
                + "?, ?, ?, ?, ?)"; */
        String sql = "INSERT INTO alquiler (fecha_inicio_al, fecha_final_al, dni, cod_Ofi_1_a, cod_Ofi_2_a, num_matricula, cod_reserva) VALUES ("
                + " (SELECT fecha_inicio_res FROM reservas where cod_Reserva = ?), (SELECT fecha_final_res FROM reservas where cod_Reserva = ?), "
                + " (SELECT dni FROM reservas where cod_Reserva = ?), (SELECT cod_Ofi_1_r FROM reservas where cod_Reserva = ?), "
                + " (SELECT cod_Ofi_2_r FROM reservas where cod_Reserva = ?), "
                + " (SELECT numero_Matricula FROM coches where modelo = (SELECT modelo FROM reservas where cod_Reserva = ?)), ?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, codRes);
            ps.setInt(2, codRes);
            ps.setInt(3, codRes);
            ps.setInt(4, codRes);
            ps.setInt(5, codRes);
            ps.setInt(6, codRes);
            ps.setInt(7, codRes);
            res = ps.executeUpdate();
            return res > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlAlquiler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(int codRes, int codAl) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        /* String sql = "UPDATE alquiler SET dni = ?, cod_Ofi_1_a = ?, cod_Ofi_2_a = ?, "
                + "fecha_inicio_al = (SELECT fecha_inicio_res FROM reservas where cod_Reserva = ?), "
                + "fecha_final_al = (SELECT fecha_final_res FROM reservas where cod_Reserva = ?), "
                + "num_matricula = ?, cod_reserva = ? "
                + "WHERE cod_Alquiler = ?"; */
        String sql = "UPDATE alquiler SET dni = (SELECT dni FROM reservas where cod_Reserva = ?), "
                + "cod_Ofi_1_a = (SELECT cod_Ofi_1_r FROM reservas where cod_Reserva = ?), "
                + "cod_Ofi_2_a = (SELECT cod_Ofi_2_r FROM reservas where cod_Reserva = ?), "
                + "fecha_inicio_al = (SELECT fecha_inicio_res FROM reservas where cod_Reserva = ?), "
                + "fecha_final_al = (SELECT fecha_final_res FROM reservas where cod_Reserva = ?), "
                + "num_matricula = (SELECT numero_Matricula FROM coches where modelo = (SELECT modelo FROM reservas where cod_Reserva = ?)), "
                + "cod_reserva = ? WHERE cod_Alquiler = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, codRes);
            ps.setInt(2, codRes);
            ps.setInt(3, codRes);
            ps.setInt(4, codRes);
            ps.setInt(5, codRes);
            ps.setInt(6, codRes);
            ps.setInt(7, codRes);
            ps.setInt(8, codAl);
            res = ps.executeUpdate();
            return res > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlAlquiler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(int cod) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res;
        String sql = "DELETE FROM alquiler WHERE cod_Alquiler = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cod);
            res = ps.executeUpdate();
            return res > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlAlquiler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
