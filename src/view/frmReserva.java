package view;

import config.CtrlReservas;
import tables.Reservas;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Comprobacion;

public class frmReserva extends javax.swing.JFrame {

    CtrlReservas modRes = new CtrlReservas();

    public frmReserva() {
        initComponents();
        this.setLocationRelativeTo(null);
        cboOfiR.addItem("- Selecionar -");
        cboOfiE.addItem("- Selecionar -");
        conexion();
        jPanel1.setOpaque(false);

        //default time zone
        ZoneId defaultZoneId = ZoneId.systemDefault();

        //creating the instance of LocalDate using the day, month, year info
        LocalDate localDate = LocalDate.of(2016, 8, 19);

        //local date + atStartOfDay() + default time zone + toInstant() = Date
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        //Displaying LocalDate and Date
        System.out.println("LocalDate is: " + localDate);
        System.out.println("Date is: " + date);
    }

    private void conexion() {
        Connection cn = modRes.establecerConexion();
        if (cn == null) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        } else {
            modRes.cargarModelos(cboModelo);
            modRes.cargarOficionas(cboOfiR);
            modRes.cargarOficionas(cboOfiE);
            modRes.datos("", tbRegis);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        dcFeIni = new com.toedter.calendar.JDateChooser();
        dcFeFin = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboModelo = new javax.swing.JComboBox<>();
        txtPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboOfiR = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cboOfiE = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbRegis = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 108, 131));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("FORMULARIO DE RESERVAS");

        btnVolver.setBackground(new java.awt.Color(255, 255, 255));
        btnVolver.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(51, 51, 51));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bracket-2.png"))); // NOI18N
        btnVolver.setText(" VOLVER");
        btnVolver.setBorder(null);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user-frm.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel13)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(jLabel3)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 100));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Datos de Reserva", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        dcFeIni.setDateFormatString("yyyy-MM-dd\n");

        dcFeFin.setDateFormatString("yyyy-MM-dd\n");

        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Fecha Inicio");

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Código");

        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Fecha Final");

        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Modelo del Auto");

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Precio Acordado");

        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Oficina de recojo");

        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Oficina de entrega");

        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("DNI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dcFeIni, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(dcFeFin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 66, Short.MAX_VALUE))
                            .addComponent(cboModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(cboOfiR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(cboOfiE, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcFeFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcFeIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cboOfiE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboOfiR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        btnNuevo.setBackground(new java.awt.Color(51, 108, 131));
        btnNuevo.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(51, 108, 131));
        btnBuscar.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(51, 108, 131));
        btnGuardar.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(null);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(51, 108, 131));
        btnEditar.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.setBorder(null);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(51, 108, 131));
        btnEliminar.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(51, 108, 131));
        btnSalir.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("SALIR");
        btnSalir.setBorder(null);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        tbRegis.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbRegis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbRegis);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 738, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Reservas reser = new Reservas();
        Comprobacion cv = new Comprobacion();
        String cod = txtCod.getText();

        if (cv.esNumerico(cod)) {
            reser.setCod_Reserva(Integer.parseInt(cod));
            if (modRes.buscar(reser)) {
                txtDNI.setText(reser.getDni());
                cboModelo.setSelectedIndex(cboModelo(cboModelo, reser.getModelo()));
                cboOfiR.setSelectedIndex(cboIndex(cboOfiR, reser.getCod_Ofi_1_r()));
                cboOfiE.setSelectedIndex(cboIndex(cboOfiE, reser.getCod_Ofi_2_r()));
                txtPrecio.setText(String.valueOf(reser.getPrecio_acordado()));
                try {
                    java.util.Date fechaInicio = new SimpleDateFormat("yyyy-MM-dd").parse(reser.getFecha_inicio_res().toString());
                    dcFeIni.setDate(fechaInicio);
                    java.util.Date fechaFinal = new SimpleDateFormat("yyyy-MM-dd").parse(reser.getFecha_final_res().toString());
                    dcFeFin.setDate(fechaFinal);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "No se pudieron consultar todos los datos");
                }
                modRes.datos(reser.getDni(), tbRegis);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo encontrar");
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "El código no fue ingresado correctamente");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Reservas reser = new Reservas();
        Comprobacion cv = new Comprobacion();

        String cod = txtCod.getText();
        String dni = txtDNI.getText();
        String ofi1 = (String) cboOfiR.getSelectedItem();
        String ofi2 = (String) cboOfiE.getSelectedItem();
        String prec = txtPrecio.getText();

        if (!dni.equals("") && cv.esNumerico(dni) && cv.esNumerico(prec)) {
            int codRe = Integer.parseInt(cod);
            int precio = Integer.parseInt(prec);

            reser.setCod_Reserva(codRe);
            reser.setDni(dni);
            reser.setModelo(cboModelo.getSelectedItem().toString());
            reser.setCod_Ofi_1_r(modRes.codOficiona(ofi1));
            reser.setCod_Ofi_2_r(modRes.codOficiona(ofi2));
            reser.setPrecio_acordado(precio);

            ZoneId defaultZoneId = ZoneId.systemDefault();
            String recojo = ((JTextField) dcFeIni.getDateEditor().getUiComponent()).getText();
            String entrega = ((JTextField) dcFeIni.getDateEditor().getUiComponent()).getText();

            LocalDate fecIniLD = LocalDate.parse(recojo);
            LocalDate fecFinLD = LocalDate.parse(entrega);

            Date fecIni = Date.from(fecIniLD.atStartOfDay(defaultZoneId).toInstant());
            Date fecFin = Date.from(fecFinLD.atStartOfDay(defaultZoneId).toInstant());
            reser.setFecha_inicio_res(fecIni);
            reser.setFecha_final_res(fecFin);

            if (modRes.modificar(reser, cod)) {
                JOptionPane.showMessageDialog(null, "Registro editado correctamente");
//                modAl.datos("", tbAlquiler);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se puedo editar el registro");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingresar datos");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Reservas reser = new Reservas();
        Comprobacion cv = new Comprobacion();

        String dni = txtDNI.getText();
        String ofi1 = (String) cboOfiR.getSelectedItem();
        String ofi2 = (String) cboOfiE.getSelectedItem();
        String prec = txtPrecio.getText();

        if (!dni.equals("") && cv.esNumerico(dni) && cv.esNumerico(prec)) {
            int precio = Integer.parseInt(prec);

            reser.setDni(dni);
            reser.setModelo(cboModelo.getSelectedItem().toString());
            reser.setCod_Ofi_1_r(modRes.codOficiona(ofi1));
            reser.setCod_Ofi_2_r(modRes.codOficiona(ofi2));
            reser.setPrecio_acordado(precio);

            ZoneId defaultZoneId = ZoneId.systemDefault();
            String recojo = ((JTextField) dcFeIni.getDateEditor().getUiComponent()).getText();
            String entrega = ((JTextField) dcFeIni.getDateEditor().getUiComponent()).getText();

            LocalDate fecIniLD = LocalDate.parse(recojo);
            LocalDate fecFinLD = LocalDate.parse(entrega);

            Date fecIni = Date.from(fecIniLD.atStartOfDay(defaultZoneId).toInstant());
            Date fecFin = Date.from(fecFinLD.atStartOfDay(defaultZoneId).toInstant());
            reser.setFecha_inicio_res(fecIni);
            reser.setFecha_final_res(fecFin);
            
            if (modRes.insertar(reser) > 0) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingresar datos");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String codR = txtCod.getText();
        Comprobacion cv = new Comprobacion();

        if (cv.esNumerico(codR)) {
            if (modRes.eliminar(codR) > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
                modRes.datos("", tbRegis);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingresar Codigo correctamente");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        frmPrincipal frm = new frmPrincipal();
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    /* public static void main(String args[]) {
    try {
    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    if ("Windows".equals(info.getName())) {
    javax.swing.UIManager.setLookAndFeel(info.getClassName());
    break;
    }
    }
    } catch (ClassNotFoundException ex) {
    java.util.logging.Logger.getLogger(frmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
    java.util.logging.Logger.getLogger(frmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
    java.util.logging.Logger.getLogger(frmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    java.util.logging.Logger.getLogger(frmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
    new frmReserva().setVisible(true);
    }
    });
    }*/
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cboModelo;
    private javax.swing.JComboBox<String> cboOfiE;
    private javax.swing.JComboBox<String> cboOfiR;
    private com.toedter.calendar.JDateChooser dcFeFin;
    private com.toedter.calendar.JDateChooser dcFeIni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbRegis;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        txtCod.setText(null);
        txtPrecio.setText(null);
        txtCod.requestFocus();
    }

    private int cboIndex(JComboBox cbo, int cod) {
        String nomOfi = modRes.nomOficina(cod);
        for (int i = 0; i < cbo.getItemCount(); i++) {
            cbo.setSelectedIndex(i);
            if (cbo.getSelectedItem().toString().equals(nomOfi)) {
                return i;
            }
        }
        return 0;
    }

    private int cboModelo(JComboBox cbo, String model) {
        for (int i = 0; i < cbo.getItemCount(); i++) {
            cbo.setSelectedIndex(i);
            if (cbo.getSelectedItem().toString().equals(model)) {
                return i;
            }
        }
        return 0;
    }
}
