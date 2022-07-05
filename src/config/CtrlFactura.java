package config;

import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import tables.Factura;
import java.sql.Date;
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

public class CtrlFactura extends conexion {

    public void datos(String valor, String dni, JTable table) {
        try {
            Connection con = establecerConexion();
            String[] titulos = {"N° Factura", "Fecha", "Precio", "IGV", "Total", "DNI", "Apellidos", "Nombre", "telefono", "Fech. entrega", "Ofi. Recojo", "Ofi. Entrega"};

            DefaultTableModel modelo = new DefaultTableModel(null, titulos);
            table.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "SELECT F.num_Factura, F.fecha, F.precio, F.igv, F.total, C.dni, concat(C.apellido_paterno, ' ', C.apellido_materno) AS Apellidos, "
                    + "C.nombre, C.telefono AS 'telefono', A.fecha_final_al AS 'Entrega', O1.nom_Oficina AS 'Ofi recojer', O2.nom_Oficina AS 'Ofi entrega' "
                    + "FROM factura AS F "
                    + "inner join clientes AS C "
                    + "ON F.dni = C.dni "
                    + "inner join alquiler AS A "
                    + "ON C.dni = A.dni "
                    + "inner join oficina AS O1 "
                    + "ON A.cod_Ofi_1_a = O1.cod_Oficina "
                    + "inner join oficina AS O2 "
                    + "ON A.cod_Ofi_2_a = O2.cod_Oficina "
                    + "WHERE F.num_Factura LIKE '%" + valor + "%' and C.dni LIKE '%" + dni + "%' and F.fecha = A.fecha_inicio_al "
                    + "ORDER BY F.num_Factura ASC";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int rowsCount = rsMd.getColumnCount();

            int[] columnWith = {60, 60, 80, 80, 80, 80, 80, 80, 80, 60, 60, 60};

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
            System.err.println(ex);
        }
    }

    public boolean buscar(Factura fac) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        String sql = "F.num_Factura, F.fecha, F.precio, F.igv, F.total, C.dni, concat(C.apellido_paterno, ' ', C.apellido_materno) AS Apellidos, "
                + "C.nombre, C.telefono, A.fecha_final_al, O1.nom_Oficina, O2.nom_Oficina "
                + "FROM factura AS F "
                + "inner join clientes AS C "
                + "ON F.dni = C.dni "
                + "inner join alquiler AS A "
                + "ON C.dni = A.dni "
                + "inner join oficina AS O1 "
                + "ON A.cod_Ofi_1_a = O1.cod_Oficina "
                + "inner join oficina AS O2 "
                + "ON A.cod_Ofi_2_a = O2.cod_Oficina ";
//                + "WHERE F.num_Factura = '" + valor + "'' and C.dni = '" + dni + "' and F.fecha = A.fecha_inicio_al";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, fac.getDni());
            rs = ps.executeQuery();
            if (rs.next()) {
                fac.setNum_Factura(rs.getInt("num_Factura"));
                fac.setFecha(rs.getDate("fecha"));
                fac.setTotal(rs.getInt("total"));
                fac.setPrecio(rs.getInt("precio"));
                fac.setIgv(rs.getInt("igv"));
                fac.setDni(rs.getString("dni"));
                fac.setCod_Alquiler(rs.getInt("cod_Alquiler"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlFactura.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int insertar(Factura fac) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "INSERT INTO factura (fecha, precio, igv, total, dni, cod_Alquiler) VALUES ("
                    + "(SELECT A.fecha_inicio_al FROM  alquiler AS A WHERE A.dni = ? AND A.cod_Alquiler = ?),"
                    +"?, ?, ?, ?, ?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, fac.getNum_Factura());
            ps.setDate(2, (Date) fac.getFecha());
            ps.setDouble(3, fac.getTotal());
            ps.setDouble(4, fac.getPrecio());
            ps.setDouble(5, fac.getIgv());
            ps.setString(6, fac.getDni());
            ps.setDouble(7, fac.getCod_Alquiler());
            res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlFactura.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Factura fac, int nFac) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "UPDATE factura SET precio = ?, igv = ?, total = ?, dni = ?, cod_Alquiler = ?, fecha = "
                    + "(SELECT A.fecha_inicio_al FROM  alquiler AS A WHERE A.dni = ? AND A.cod_Alquiler = ?) WHERE num_Factura = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, fac.getNum_Factura());
            ps.setDate(2, (Date) fac.getFecha());
            ps.setDouble(3, fac.getTotal());
            ps.setDouble(4, fac.getPrecio());
            ps.setDouble(5, fac.getIgv());
            ps.setString(6, fac.getDni());
            ps.setDouble(7, fac.getCod_Alquiler());
            ps.setInt(8, nFac);
            res = ps.executeUpdate();
            if (res > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlFactura.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int eliminar(int nFac) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = establecerConexion();
        int res = 0;
        String sql = "DELETE FROM factura WHERE num_Factura = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, nFac);
            res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlFactura.class.getName()).log(Level.SEVERE, null, ex);
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
