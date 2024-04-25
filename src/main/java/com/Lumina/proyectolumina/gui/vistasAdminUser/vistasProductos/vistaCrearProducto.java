/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.Lumina.proyectolumina.gui.vistasAdminUser.vistasProductos;

import com.Lumina.proyectolumina.persistencia.controllerServicios.GetServiosLuminApi;
import java.awt.Image;
import java.awt.TextArea;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author USUARIO
 */
public class vistaCrearProducto extends javax.swing.JFrame {

    /**
     * Creates new form vistaCrearProducto
     */
    public vistaCrearProducto() {
        initComponents();
         ImageIcon iconLumina = new ImageIcon("src/main/java/com/Lumina/proyectolumina/gui/recursos multimedia/logo lumina blanco (2).png");
        Icon icon2 = new ImageIcon(iconLumina.getImage().getScaledInstance(lblIconoLumina.getWidth(), lblIconoLumina.getHeight(), Image.SCALE_SMOOTH));
        lblIconoLumina.setIcon(icon2);
    }

    public JButton getBtnAddServicio() {
        return btnAddServicio;
    }

    public JComboBox<String> getCbTipoServicio() {
        return cbTipoServicio;
    }

    public JCheckBox getCheckActivo() {
        return checkActivo;
    }

    public JCheckBox getCheckInactivo() {
        return checkInactivo;
    }

    public TextArea getTxtAreaDescripcionServicio() {
        return txtAreaDescripcionServicio;
    }

    public JTextField getTxtNomServicio() {
        return txtNomServicio;
    }

    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblIconoLumina = new javax.swing.JLabel();
        txtNomServicio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbTipoServicio = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtAreaDescripcionServicio = new java.awt.TextArea();
        jLabel5 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        checkActivo = new javax.swing.JCheckBox();
        checkInactivo = new javax.swing.JCheckBox();
        btnAddServicio = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(4, 49, 140));

        jLabel1.setFont(new java.awt.Font("Mulish ExtraBold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agregar servicio a Lumina");

        lblIconoLumina.setMinimumSize(new java.awt.Dimension(960, 560));
        lblIconoLumina.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIconoLumina, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jLabel1)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIconoLumina, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        txtNomServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomServicioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 31, 89));
        jLabel3.setText("Nombre del servicio");

        cbTipoServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "Identidad corporativa", "Contenido para redes sociales", "Piezas graficas de impresion", "Diseño web", "Impresion de documentos" }));

        jLabel7.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(2, 31, 89));
        jLabel7.setText("Tipo de servicio");

        jLabel8.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(2, 31, 89));
        jLabel8.setText("Descripcion del servicio");

        jLabel5.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(2, 31, 89));
        jLabel5.setText("Estado del servicio");

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(2, 31, 89));
        jLabel6.setText("Precio del servicio");

        checkActivo.setFont(new java.awt.Font("Mulish", 2, 14)); // NOI18N
        checkActivo.setForeground(new java.awt.Color(0, 0, 0));
        checkActivo.setText("Activo");

        checkInactivo.setFont(new java.awt.Font("Mulish", 2, 14)); // NOI18N
        checkInactivo.setForeground(new java.awt.Color(0, 0, 0));
        checkInactivo.setText("Inactivo");
        checkInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInactivoActionPerformed(evt);
            }
        });

        btnAddServicio.setBackground(new java.awt.Color(4, 49, 140));
        btnAddServicio.setFont(new java.awt.Font("Mulish ExtraBold", 0, 18)); // NOI18N
        btnAddServicio.setForeground(new java.awt.Color(255, 255, 255));
        btnAddServicio.setText("Agregar servicio");
        btnAddServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServicioActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(3, 90, 167));
        btnRegresar.setFont(new java.awt.Font("Mulish ExtraBold", 0, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtAreaDescripcionServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtNomServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7)
                        .addComponent(cbTipoServicio, 0, 211, Short.MAX_VALUE)
                        .addComponent(txtPrecio))
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(checkActivo)
                        .addGap(18, 18, 18)
                        .addComponent(checkInactivo)))
                .addGap(67, 67, 67))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(btnRegresar)
                .addGap(18, 18, 18)
                .addComponent(btnAddServicio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipoServicio)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAreaDescripcionServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkActivo)
                            .addComponent(checkInactivo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnAddServicio))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomServicioActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void checkInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInactivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkInactivoActionPerformed

    private void btnAddServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddServicioActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        vistaListaServicios servicios = new vistaListaServicios();
        GetServiosLuminApi.getServicios(servicios);
        servicios.setVisible(true);
        servicios.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegresarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddServicio;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbTipoServicio;
    private javax.swing.JCheckBox checkActivo;
    private javax.swing.JCheckBox checkInactivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblIconoLumina;
    private java.awt.TextArea txtAreaDescripcionServicio;
    private javax.swing.JTextField txtNomServicio;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}