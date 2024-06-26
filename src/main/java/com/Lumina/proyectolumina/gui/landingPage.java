/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.Lumina.proyectolumina.gui;

import com.Lumina.proyectolumina.gui.vistasClientUser.vistaCatalogo;
import com.Lumina.proyectolumina.gui.vistasLogin.vistaInicioSesion;
import com.Lumina.proyectolumina.gui.vistasLogin.vistaRegistroUsuariosParte1;
import com.Lumina.proyectolumina.persistencia.controllerLogin.contollerUsers.RegistroClientes;
import com.Lumina.proyectolumina.persistencia.controllerLogin.controllerUserActions.IniciarSesion;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author USUARIO
 */
public class landingPage extends javax.swing.JFrame {

    private String textoTitulo = "Mejore sus ventas y productividad\n "
            + "con Lumina";

    private String parrafoDescripcionLumina = "¿Está buscando una manera de mejorar la imagen de su\n"
            + "empresa y destacar en el mercado? ¡Nuestra agencia de\n"
            + "diseño puede ayudarte! Ofrecemos una amplia gama de\n"
            + "servicios de diseño gráfico, desde la creación de logotipos\n"
            + "hasta el diseño de sitios web y materiales de marketing.\n"
            + "Nuestro equipo de diseñadores altamente calificados\n"
            + "trabajará con usted para crear una imagen única y atractiva\n"
            + "para su empresa. ¡No dudes en ponerte en contacto con\n"
            + "nosotros para obtener más información sobre cómo\n"
            + "podemos ayudarte a alcanzar sus objetivos!";

    public landingPage() {
        initComponents();
        titulo_lp.setText(strTohuml(textoTitulo));
        descripcionLumina.setText(formatearTexto(parrafoDescripcionLumina));

        ImageIcon imageicon = new ImageIcon("src/main/java/com/Lumina/proyectolumina/gui/recursos multimedia/Imagen  descriptiva lumina.png");
        Icon icon = new ImageIcon(imageicon.getImage().getScaledInstance(lblDescripcion.getWidth(), lblDescripcion.getHeight(), Image.SCALE_SMOOTH));
        lblDescripcion.setIcon(icon);

        ImageIcon iconLumina = new ImageIcon("src/main/java/com/Lumina/proyectolumina/gui/recursos multimedia/logo lumina blanco (2).png");
        Icon icon2 = new ImageIcon(iconLumina.getImage().getScaledInstance(lblIconoLumina.getWidth(), lblIconoLumina.getHeight(), Image.SCALE_SMOOTH));
        lblIconoLumina.setIcon(icon2);
    }

    public String strTohuml(String texto) {
        return "<html><p>" + texto + "</p></html>";
    }

    public String formatearTexto(String texto) {
        return "<html><p>" + texto + "</p></html>";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblIconoLumina = new javax.swing.JLabel();
        btnInicioSesion = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnHomeClients = new javax.swing.JButton();
        titulo_lp = new javax.swing.JLabel();
        descripcionLumina = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(4, 49, 140));

        lblIconoLumina.setMinimumSize(new java.awt.Dimension(960, 560));
        lblIconoLumina.setName(""); // NOI18N

        btnInicioSesion.setBackground(new java.awt.Color(3, 90, 167));
        btnInicioSesion.setFont(new java.awt.Font("Mulish ExtraBold", 0, 12)); // NOI18N
        btnInicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnInicioSesion.setText("Iniciar sesion");
        btnInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioSesionActionPerformed(evt);
            }
        });

        btnRegistrarse.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarse.setFont(new java.awt.Font("Mulish ExtraBold", 1, 12)); // NOI18N
        btnRegistrarse.setForeground(new java.awt.Color(4, 49, 140));
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIconoLumina, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrarse)
                .addGap(18, 18, 18)
                .addComponent(btnInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIconoLumina, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInicioSesion)
                            .addComponent(btnRegistrarse))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 881, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Mulish ExtraBold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 195, 248, -1));

        btnHomeClients.setBackground(new java.awt.Color(3, 90, 167));
        btnHomeClients.setFont(new java.awt.Font("Mulish ExtraBold", 0, 18)); // NOI18N
        btnHomeClients.setForeground(new java.awt.Color(255, 255, 255));
        btnHomeClients.setText("Empezar ahora");
        btnHomeClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeClientsActionPerformed(evt);
            }
        });
        jPanel1.add(btnHomeClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 389, 167, 40));

        titulo_lp.setFont(new java.awt.Font("Mulish ExtraBold", 1, 18)); // NOI18N
        titulo_lp.setForeground(new java.awt.Color(0, 0, 0));
        titulo_lp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_lp.setText("titulo");
        titulo_lp.setFocusable(false);
        jPanel1.add(titulo_lp, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 87, 269, 70));

        descripcionLumina.setFont(new java.awt.Font("Mulish", 0, 12)); // NOI18N
        descripcionLumina.setForeground(new java.awt.Color(0, 0, 0));
        descripcionLumina.setText("Parrafo");
        jPanel1.add(descripcionLumina, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 290, 210));
        jPanel1.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 400, 323));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioSesionActionPerformed
        this.dispose();
        vistaCatalogo catalogo = new vistaCatalogo();
        vistaInicioSesion login = new vistaInicioSesion();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        IniciarSesion.login(login, catalogo);
    }//GEN-LAST:event_btnInicioSesionActionPerformed

    private void btnHomeClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeClientsActionPerformed
        this.dispose();
        vistaCatalogo catalogo = new vistaCatalogo();
        vistaInicioSesion login = new vistaInicioSesion();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        IniciarSesion.login(login, catalogo);
    }//GEN-LAST:event_btnHomeClientsActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        this.dispose();
        vistaRegistroUsuariosParte1 newUser = new vistaRegistroUsuariosParte1();
        newUser.setVisible(true);
        newUser.setLocationRelativeTo(null);
        RegistroClientes.createUser(newUser);
    }//GEN-LAST:event_btnRegistrarseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHomeClients;
    private javax.swing.JButton btnInicioSesion;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JLabel descripcionLumina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblIconoLumina;
    private javax.swing.JLabel titulo_lp;
    // End of variables declaration//GEN-END:variables
}
