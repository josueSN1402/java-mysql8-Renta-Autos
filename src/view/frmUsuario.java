package view;

import config.CtrlUsuarios;
import config.hash;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import tables.Usuario;

public class frmUsuario extends javax.swing.JFrame {

    public frmUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtUser.setOpaque(false);
        txtPass.setOpaque(false);
        txtPassConfir.setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPassConfir = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblBacked = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 108, 131));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRAR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("USUARIO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        txtUser.setBackground(new java.awt.Color(255, 255, 255));
        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.setBorder(null);
        txtUser.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 105, 240, 24));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("__________________________________");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 105, 240, 33));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CONTRASEÑA");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/view-show.png"))); // NOI18N
        jLabel7.setToolTipText("");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(51, 51, 51));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setBorder(null);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 225, 35));

        txtPass.setBackground(new java.awt.Color(255, 255, 255));
        txtPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setBorder(null);
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 175, 210, 24));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("__________________________________");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 175, 240, 36));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("__________________________________");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 247, 240, 36));

        txtPassConfir.setBackground(new java.awt.Color(255, 255, 255));
        txtPassConfir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassConfir.setForeground(new java.awt.Color(255, 255, 255));
        txtPassConfir.setBorder(null);
        jPanel1.add(txtPassConfir, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 247, 210, 24));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CONFIRMAR CONTRASEÑA");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 222, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/view-show.png"))); // NOI18N
        jLabel11.setToolTipText("");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 222, -1, -1));

        lblBacked.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBacked.setForeground(new java.awt.Color(255, 255, 255));
        lblBacked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bracket.png"))); // NOI18N
        lblBacked.setText(" VOLVER");
        lblBacked.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBacked.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackedMouseClicked(evt);
            }
        });
        jPanel1.add(lblBacked, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        jPanel1.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 380));

        setSize(new java.awt.Dimension(380, 380));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!"".equals(txtUser.getText()) && !"".equals(String.valueOf(txtPass.getPassword())) && !"".equals(String.valueOf(txtPassConfir.getPassword()))) {
            Usuario modUser = new Usuario();
            CtrlUsuarios ctrlUser = new CtrlUsuarios();
            String user = txtUser.getText();
            String pass = String.valueOf(txtPass.getPassword());
            String passC = String.valueOf(txtPassConfir.getPassword());
            if (pass.equals(passC)) {
                String passNew = hash.sha1(pass);
                modUser.setUsername(user);
                modUser.setContra(passNew);
                if (ctrlUser.verificar(user) == 0) {
                    if (ctrlUser.insertar(modUser)) {
                        JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar el usuario");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Este usuario ya existe");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas ingresadas tienen que ser iguales");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingresar todos los datos");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void lblBackedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackedMouseClicked
        try {
            frmPrincipal frm = new frmPrincipal();
            frm.setVisible(true);
            dispose();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_lblBackedMouseClicked

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    /*public static void main(String args[]) {
    try {
    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    if ("Windows".equals(info.getName())) {
    javax.swing.UIManager.setLookAndFeel(info.getClassName());
    break;
    }
    }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
    java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    
    java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
    try {
    new frmUsuario().setVisible(true);
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
    Logger.getLogger(frmUsuario.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBacked;
    private javax.swing.JLabel lblClose;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPassConfir;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        txtUser.setText(null);
        txtPass.setText(null);
        txtPassConfir.setText(null);
        txtUser.requestFocus();
    }
}
