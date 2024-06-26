/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.Lumina.proyectolumina.gui.vistasClientUser;


import java.awt.Image;
import java.awt.TextArea;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

/**
 *
 * @author USUARIO
 */
public class vistaContrararServicio1 extends javax.swing.JFrame {

    /**
     * Creates new form vistaContrararServicio1
     */
    private String txtInfo = "Por favor especifique el servicio que desea contratar, una breve\n"
            + "descripción de la razón por la cual contratara este servicio\n"
            + "y además debe anexar información sobre si usted es empresario o no, si es\n"
            + "así debe proporcionar datos de la empresa como\n"
            + "por ejemplo: nombre y teléfono de contacto además de sus datos\n"
            + "personales como nombre, correo, direccion, teléfono, tipo y\n"
            + "numero de documento, si usted es un trabajador independiente o persona\n"
            + "natural solo debe suministrar sus datos personales";

    public vistaContrararServicio1() {
        initComponents();


        lblInfoTservicio.setText(formatearTexto(txtInfo));
        // agregando imagenes al banner y la ventana de fondo
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

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    public JMenuItem getJmiCerrarSesion() {
        return jmiCerrarSesion;
    }

    public JMenuItem getJmiEditarPerfil() {
        return jmiEditarPerfil;
    }

    public JLabel getLblNombreUsu() {
        return lblNombreUsu;
    }

    public JButton getBtnPaso2() {
        return btnPaso2;
    }

    public JLabel getLblCategoriaSelec() {
        return lblCategoriaSelec;
    }

    public TextArea getTxtAreaDescripcionServicio() {
        return txtAreaDescripcionServicio;
    }

    public JComboBox<String> getCbSelectServicio() {
        return cbSelectServicio;
    }

    public String formatearTexto(String texto) {
        return "<html><p>" + texto + "</p></html>";
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
        jPanel3 = new javax.swing.JPanel();
        cbSelectServicio = new javax.swing.JComboBox<>();
        txtAreaDescripcionServicio = new java.awt.TextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnPaso2 = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lblInfoTservicio = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblCategoriaSelec = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblPerfilUsu = new javax.swing.JLabel();
        lblNombreUsu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblIconoLumina = new javax.swing.JLabel();
        lblDegradado = new javax.swing.JLabel();
        jPanelFondo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblCategoriaSelec1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jmiEditarPerfil.setFont(new java.awt.Font("Mulish", 0, 12)); // NOI18N
        jmiEditarPerfil.setText("Editar perfil");
        jpmAcionesUsuario.add(jmiEditarPerfil);

        jmiCerrarSesion.setFont(new java.awt.Font("Mulish", 0, 12)); // NOI18N
        jmiCerrarSesion.setText("Cerrar sesion");
        jpmAcionesUsuario.add(jmiCerrarSesion);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbSelectServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));
        jPanel3.add(cbSelectServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 200, 30));
        jPanel3.add(txtAreaDescripcionServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 200, 60));

        jLabel8.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(2, 31, 89));
        jLabel8.setText("Descripcion del servicio");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Mulish SemiBold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 31, 89));
        jLabel3.setText("Nombre del servicio");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        btnPaso2.setBackground(new java.awt.Color(4, 49, 140));
        btnPaso2.setFont(new java.awt.Font("Mulish ExtraBold", 0, 18)); // NOI18N
        btnPaso2.setForeground(new java.awt.Color(255, 255, 255));
        btnPaso2.setText("Siguiente");
        btnPaso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaso2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnPaso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(3, 90, 167));
        btnRegresar.setFont(new java.awt.Font("Mulish ExtraBold", 0, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, -1));

        jLabel11.setFont(new java.awt.Font("Mulish Black", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(2, 31, 89));
        jLabel11.setText("PASO 1/3");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        lblInfoTservicio.setFont(new java.awt.Font("Mulish", 0, 12)); // NOI18N
        lblInfoTservicio.setForeground(new java.awt.Color(34, 52, 64));
        lblInfoTservicio.setText("Informacion importante");
        jPanel3.add(lblInfoTservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 280, 200));

        jLabel10.setFont(new java.awt.Font("Mulish Black", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(2, 31, 89));
        jLabel10.setText("Informacion del servucio que se desea contratar");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        lblCategoriaSelec.setFont(new java.awt.Font("Mulish Light", 0, 12)); // NOI18N
        lblCategoriaSelec.setForeground(new java.awt.Color(34, 52, 64));
        lblCategoriaSelec.setText("[Nombre de la categoria seleccionada]");
        jPanel3.add(lblCategoriaSelec, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Mulish Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(34, 52, 64));
        jLabel2.setText("CATEGORIA SELECCIONADA:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(lblPerfilUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 70, 60));

        lblNombreUsu.setFont(new java.awt.Font("Mulish Light", 0, 14)); // NOI18N
        lblNombreUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsu.setText("Nombre de usuario");
        lblNombreUsu.setComponentPopupMenu(jpmAcionesUsuario);
        lblNombreUsu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(lblNombreUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Mulish Black", 1, 23)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Contratar un servicio");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 290, 40));
        jPanel2.add(lblIconoLumina, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 60));
        jPanel2.add(lblDegradado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 80));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 80));

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -2, 810, 460));

        jLabel12.setFont(new java.awt.Font("Mulish Black", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(2, 31, 89));
        jLabel12.setText("Informacion del servucio que se desea contratar");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        lblCategoriaSelec1.setFont(new java.awt.Font("Mulish Light", 0, 12)); // NOI18N
        lblCategoriaSelec1.setForeground(new java.awt.Color(34, 52, 64));
        lblCategoriaSelec1.setText("[Nombre de la categoria seleccionada]");
        jPanel3.add(lblCategoriaSelec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Mulish Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(34, 52, 64));
        jLabel4.setText("CATEGORIA SELECCIONADA:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPaso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaso2ActionPerformed

    }//GEN-LAST:event_btnPaso2ActionPerformed

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
            java.util.logging.Logger.getLogger(vistaContrararServicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaContrararServicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaContrararServicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaContrararServicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaContrararServicio1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPaso2;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbSelectServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jPanelFondo;
    private javax.swing.JMenuItem jmiCerrarSesion;
    private javax.swing.JMenuItem jmiEditarPerfil;
    private javax.swing.JPopupMenu jpmAcionesUsuario;
    private javax.swing.JLabel lblCategoriaSelec;
    private javax.swing.JLabel lblCategoriaSelec1;
    private javax.swing.JLabel lblDegradado;
    private javax.swing.JLabel lblIconoLumina;
    private javax.swing.JLabel lblInfoTservicio;
    private javax.swing.JLabel lblNombreUsu;
    private javax.swing.JLabel lblPerfilUsu;
    private java.awt.TextArea txtAreaDescripcionServicio;
    // End of variables declaration//GEN-END:variables
}
