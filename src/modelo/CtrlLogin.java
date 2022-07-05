package modelo;

import config.conexion;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class CtrlLogin extends conexion {

    public boolean conexion() {
        Connection cn = establecerConexion();
        if (cn == null) {
            JOptionPane.showMessageDialog(null, "Error al conectar", "Error", 0);
            return false;
        } else {
            return true;
        }
    }
}
