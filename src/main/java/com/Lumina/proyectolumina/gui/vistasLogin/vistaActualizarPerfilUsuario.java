/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.Lumina.proyectolumina.gui.vistasLogin;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author USUARIO
 */
public class vistaActualizarPerfilUsuario extends javax.swing.JFrame {

    /**
     * Creates new form vistaActualizarPerfilUsuario
     */
    public vistaActualizarPerfilUsuario() {
        initComponents();


        ImageIcon iconLumina1 = new ImageIcon("src/main/java/com/Lumina/proyectolumina/gui/recursos multimedia/logo lumina blanco (2).png");
        Icon icon1 = new ImageIcon(iconLumina1.getImage().getScaledInstance(lblIconoLumina.getWidth(), lblIconoLumina.getHeight(), Image.SCALE_SMOOTH));
        lblIconoLumina.setIcon(icon1);

        ImageIcon imagenFondo = new ImageIcon("src/main/java/com/Lumina/proyectolumina/gui/recursos multimedia/fondo.jpg");
        Icon icon2 = new ImageIcon(imagenFondo.getImage().getScaledInstance(jPanelFondo.getWidth(), jPanelFondo.getHeight(), Image.SCALE_SMOOTH));
        jPanelFondo.setIcon(icon2);

        ImageIcon degradadoFondo = new ImageIcon("src/main/java/com/Lumina/proyectolumina/gui/recursos multimedia/textura banner.png");
        Icon icon3 = new ImageIcon(degradadoFondo.getImage().getScaledInstance(lblDegradado.getWidth(), lblDegradado.getHeight(), Image.SCALE_SMOOTH));
        lblDegradado.setIcon(icon3);

        ImageIcon iconoPerfil = new ImageIcon("src/main/java/com/Lumina/proyectolumina/gui/recursos multimedia/icono perfil.png");
        Icon icon4 = new ImageIcon(iconoPerfil.getImage().getScaledInstance(lblPerfilUsu.getWidth(), lblPerfilUsu.getHeight(), Image.SCALE_SMOOTH));
        lblPerfilUsu.setIcon(icon4);
    }

    public JLabel getLblNombreUsu() {
        return lblNombreUsu;
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    public JButton getBtnEditarPerfil() {
        return btnEditarPerfil;
    }

    public JComboBox<String> getCbMetodoPago() {
        return cbMetodoPago;
    }

    public JComboBox<String> getCb_TipoDocumento() {
        return cb_TipoDocumento;
    }

    public JCheckBox getCheckShowPassword() {
        return checkShowPassword;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public JTextField getTxtNomDocumento() {
        return txtNomDocumento;
    }

    public JTextField getTxtNomUsuario() {
        return txtNomUsuario;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpmAcionesUsuario = new javax.swing.JPopupMenu();
        jmiEditarPerfil = new javax.swing.JMenuItem();
        jmiCerrarSesion = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnEditarPerfil = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        checkShowPassword = new javax.swing.JCheckBox();
        txtPassword = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        txtNomUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbMetodoPago = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cb_TipoDocumento = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtNomDocumento = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblPerfilUsu = new javax.swing.JLabel();
        lblNombreUsu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblIconoLumina = new javax.swing.JLabel();
        lblDegradado = new javax.swing.JLabel();
        jPanelFondo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jmiEditarPerfil.setFont(new java.awt.Font("Mulish", 0, 12)); // NOI18N
        jmiEditarPerfil.setText("Editar perfil");
        jpmAcionesUsuario.add(jmiEditarPerfil);

        jmiCerrarSesion.setFont(new java.awt.Font("Mulish", 0, 12)); // NOI18N
        jmiCerrarSesion.setText("Cerrar sesion");
        jpmAcionesUsuario.add(jmiCerrarSesion);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditarPerfil.setBackground(new java.awt.Color(4, 49, 140));
        btnEditarPerfil.setFont(new java.awt.Font("Mulish ExtraBold", 0, 18)); // NOI18N
        btnEditarPerfil.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarPerfil.setText("Editar perfil");
        btnEditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPerfilActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(3, 90, 167));
        btnRegresar.setFont(new java.awt.Font("Mulish ExtraBold", 0, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, -1, -1));

        checkShowPassword.setFont(new java.awt.Font("Mulish", 2, 14)); // NOI18N
        checkShowPassword.setForeground(new java.awt.Color(0, 0, 0));
        checkShowPassword.setText("Mostrar contraseña");
        checkShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkShowPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(checkShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, -1, -1));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 190, -1));

        jLabel11.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(2, 31, 89));
        jLabel11.setText("Contraseña");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, -1));

        txtNomUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtNomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 190, -1));

        jLabel5.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(2, 31, 89));
        jLabel5.setText("Correo electronico");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        cbMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "Tarjeta de debito / credito", "Transferencia bancaria", "Pago en efectivo" }));
        jPanel1.add(cbMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 190, -1));

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 190, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 190, -1));

        jLabel3.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 31, 89));
        jLabel3.setText("Nombre completo ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 190, -1));

        jLabel6.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(2, 31, 89));
        jLabel6.setText("Telefono");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(2, 31, 89));
        jLabel8.setText("Numero de documento");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        cb_TipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "Cedula de ciudadania", "Cedula de extranjeria", "Pasaporte" }));
        jPanel1.add(cb_TipoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 190, -1));

        jLabel9.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(2, 31, 89));
        jLabel9.setText("Metodo de pago");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, -1, -1));

        txtNomDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomDocumentoActionPerformed(evt);
            }
        });
        jPanel1.add(txtNomDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 190, -1));

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 190, -1));

        jLabel10.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(2, 31, 89));
        jLabel10.setText("Direccion");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(2, 31, 89));
        jLabel7.setText("Tipo de documento");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(lblPerfilUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 70, 60));

        lblNombreUsu.setFont(new java.awt.Font("Mulish Light", 0, 14)); // NOI18N
        lblNombreUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsu.setText("Nombre de usuario");
        lblNombreUsu.setComponentPopupMenu(jpmAcionesUsuario);
        jPanel2.add(lblNombreUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Mulish Black", 1, 23)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Actualizar perfil de usuario");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 350, 40));
        jPanel2.add(lblIconoLumina, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 60));
        jPanel2.add(lblDegradado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 80));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 80));

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -2, 820, 460));

        jLabel12.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(2, 31, 89));
        jLabel12.setText("Nombre de usuario");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtNomDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomDocumentoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtNomUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomUsuarioActionPerformed

    private void checkShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkShowPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkShowPasswordActionPerformed

    private void btnEditarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarPerfilActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaActualizarPerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaActualizarPerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaActualizarPerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaActualizarPerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaActualizarPerfilUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarPerfil;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbMetodoPago;
    private javax.swing.JComboBox<String> cb_TipoDocumento;
    private javax.swing.JCheckBox checkShowPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jPanelFondo;
    private javax.swing.JMenuItem jmiCerrarSesion;
    private javax.swing.JMenuItem jmiEditarPerfil;
    private javax.swing.JPopupMenu jpmAcionesUsuario;
    private javax.swing.JLabel lblDegradado;
    private javax.swing.JLabel lblIconoLumina;
    private javax.swing.JLabel lblNombreUsu;
    private javax.swing.JLabel lblPerfilUsu;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNomDocumento;
    private javax.swing.JTextField txtNomUsuario;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
