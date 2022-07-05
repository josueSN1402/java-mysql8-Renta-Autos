package view;

public class frmPrincipal extends javax.swing.JFrame {

    public frmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(this);
        frmLogin login = new frmLogin();
        login.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuRegistro = new javax.swing.JMenu();
        mniClientes = new javax.swing.JMenuItem();
        mniUser = new javax.swing.JMenuItem();
        mnuProcesos = new javax.swing.JMenu();
        mniReserva = new javax.swing.JMenuItem();
        mniAlquilar = new javax.swing.JMenuItem();
        mnuListaFactoras = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mniListaAutos = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenu();
        mniCerrarSesion = new javax.swing.JMenuItem();
        mniSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo-formulario.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 796));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -18, 606, 350));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mnuRegistro.setBackground(new java.awt.Color(255, 255, 255));
        mnuRegistro.setForeground(new java.awt.Color(51, 51, 51));
        mnuRegistro.setText("Registros");
        mnuRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mniClientes.setBackground(new java.awt.Color(255, 255, 255));
        mniClientes.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mniClientes.setForeground(new java.awt.Color(51, 51, 51));
        mniClientes.setText("Clientes");
        mniClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniClientesActionPerformed(evt);
            }
        });
        mnuRegistro.add(mniClientes);

        mniUser.setBackground(new java.awt.Color(255, 255, 255));
        mniUser.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mniUser.setForeground(new java.awt.Color(51, 51, 51));
        mniUser.setText("Usuarios");
        mniUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUserActionPerformed(evt);
            }
        });
        mnuRegistro.add(mniUser);

        jMenuBar1.add(mnuRegistro);

        mnuProcesos.setBackground(new java.awt.Color(255, 255, 255));
        mnuProcesos.setForeground(new java.awt.Color(51, 51, 51));
        mnuProcesos.setText("Procesos");
        mnuProcesos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mniReserva.setBackground(new java.awt.Color(255, 255, 255));
        mniReserva.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mniReserva.setForeground(new java.awt.Color(51, 51, 51));
        mniReserva.setText("Reserva");
        mniReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniReservaActionPerformed(evt);
            }
        });
        mnuProcesos.add(mniReserva);

        mniAlquilar.setBackground(new java.awt.Color(255, 255, 255));
        mniAlquilar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mniAlquilar.setForeground(new java.awt.Color(51, 51, 51));
        mniAlquilar.setText("Alquilar");
        mniAlquilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAlquilarActionPerformed(evt);
            }
        });
        mnuProcesos.add(mniAlquilar);

        mnuListaFactoras.setBackground(new java.awt.Color(255, 255, 255));
        mnuListaFactoras.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mnuListaFactoras.setForeground(new java.awt.Color(51, 51, 51));
        mnuListaFactoras.setText("Facturas");
        mnuListaFactoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListaFactorasActionPerformed(evt);
            }
        });
        mnuProcesos.add(mnuListaFactoras);

        jMenuBar1.add(mnuProcesos);

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setForeground(new java.awt.Color(51, 51, 51));
        jMenu1.setText("Consultas");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mniListaAutos.setBackground(new java.awt.Color(255, 255, 255));
        mniListaAutos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mniListaAutos.setForeground(new java.awt.Color(51, 51, 51));
        mniListaAutos.setText("Lista de Autos");
        mniListaAutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniListaAutosActionPerformed(evt);
            }
        });
        jMenu1.add(mniListaAutos);

        jMenuBar1.add(jMenu1);

        mnuSalir.setBackground(new java.awt.Color(255, 255, 255));
        mnuSalir.setForeground(new java.awt.Color(51, 51, 51));
        mnuSalir.setText("Salir");
        mnuSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mniCerrarSesion.setBackground(new java.awt.Color(255, 255, 255));
        mniCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mniCerrarSesion.setForeground(new java.awt.Color(51, 51, 51));
        mniCerrarSesion.setText("Cerrar sesión");
        mniCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCerrarSesionActionPerformed(evt);
            }
        });
        mnuSalir.add(mniCerrarSesion);

        mniSalir.setBackground(new java.awt.Color(255, 255, 255));
        mniSalir.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mniSalir.setForeground(new java.awt.Color(51, 51, 51));
        mniSalir.setText("Salir");
        mniSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSalirActionPerformed(evt);
            }
        });
        mnuSalir.add(mniSalir);

        jMenuBar1.add(mnuSalir);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mniSalirActionPerformed

    private void mniClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniClientesActionPerformed
        try {
            frmClientes frm = new frmClientes();
            frm.setVisible(true);
            dispose();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_mniClientesActionPerformed

    private void mniReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniReservaActionPerformed
        try {
            frmReserva frm = new frmReserva();
            frm.setVisible(true);
            dispose();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_mniReservaActionPerformed

    private void mniAlquilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAlquilarActionPerformed
        try {
            frmAlquilar frm = new frmAlquilar();
            frm.setVisible(true);
            dispose();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_mniAlquilarActionPerformed

    private void mniListaAutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniListaAutosActionPerformed
        try {
            frmListaAutos frm = new frmListaAutos();
            frm.setVisible(true);
            dispose();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_mniListaAutosActionPerformed

    private void mnuListaFactorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListaFactorasActionPerformed
        try {
            frmFactura frm = new frmFactura();
            frm.setVisible(true);
            dispose();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_mnuListaFactorasActionPerformed

    private void mniCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCerrarSesionActionPerformed
        try {
            frmLogin frm = new frmLogin();
            frm.setVisible(true);
            dispose();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_mniCerrarSesionActionPerformed

    private void mniUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUserActionPerformed
        try {
            frmUsuario frm = new frmUsuario();
            frm.setVisible(true);
            dispose();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_mniUserActionPerformed

    /*public static void main(String args[]) {
    try {
    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    if ("Windows".equals(info.getName())) {
    javax.swing.UIManager.setLookAndFeel(info.getClassName());
    break;
    }
    }
    } catch (ClassNotFoundException ex) {
    java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
    java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
    java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
    try {
    new frmPrincipal().setVisible(true);
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
    Logger.getLogger(frmLogi.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem mniAlquilar;
    private javax.swing.JMenuItem mniCerrarSesion;
    private javax.swing.JMenuItem mniClientes;
    private javax.swing.JMenuItem mniListaAutos;
    private javax.swing.JMenuItem mniReserva;
    private javax.swing.JMenuItem mniSalir;
    private javax.swing.JMenuItem mniUser;
    private javax.swing.JMenuItem mnuListaFactoras;
    private javax.swing.JMenu mnuProcesos;
    private javax.swing.JMenu mnuRegistro;
    private javax.swing.JMenu mnuSalir;
    // End of variables declaration//GEN-END:variables
}
