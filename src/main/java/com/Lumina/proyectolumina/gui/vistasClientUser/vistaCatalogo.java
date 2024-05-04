/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.Lumina.proyectolumina.gui.vistasClientUser;

import com.Lumina.proyectolumina.gui.landingPage;
import com.Lumina.proyectolumina.persistencia.controllerCatalogo.ContratarServicio;
import com.Lumina.proyectolumina.persistencia.controllerLogin.controllerOptionSelected;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author USUARIO
 */
public class vistaCatalogo extends javax.swing.JFrame implements ActionListener {

    private vistaContrararServicio1 hireService = new vistaContrararServicio1();
    

    private String parrafo1 = "Para Lumina, lo más importante es la calidad de nuestros servicios, por tal motivo contratamos a los mejores en su área de\n"
            + "desempeño, creando los diseños mas llamativos, creativos e innovadores teniendo como principal objetivo satisfacer las necesidades\n"
            + "del cliente, y además se encuentran organizados por categorías para facilitar su búsqueda y contratacion.";

    private String parrafo2P1 = "Aspiramos al máximo posible en nuestra forma de trabajar para ofrecer el mejor servicio a nuestros clientes.\n";
    private String parrafo2P2 = "Da clic en uno de nuestros servicios para realizar el proceso de contratación.";

    //DESCRIPCIONES DE SERVICIOS
    //servicio1
    private String txtDescripS1 = "Ofrecemos la mejor calidad en\n"
            + "el desarrollo de las identidades\n"
            + "corporativas analizando el publico\n"
            + "objetivo los productos o servicios que\n"
            + "brinda la empresa que adquiere nuestros\n"
            + "servicios.";
    // servicio 2
    private String txtServicio2 = "¿Redes sociales sin ideas? Lumina\n"
            + "te ayuda: crea contenido que la gente\n"
            + "quiere ver, maneja tus redes y publica en\n"
            + "el mejor momento. ¡Más seguidores y mejor\n"
            + "imagen para tu marca! ¡Te asesoramos gratis!";
    // servicio 3
    private String txtServicio3 = "Creamos diseños personalizados para tus redes\n"
            + "sociales, impresión e infografías.\n"
            + "¡Contáctanos para que tu marca triunfe!\n"
            + "Pide una cotización gratis sin compromiso.";
    //servicio 4
    private String txtServicio4 = "Diseño web para redes sociales:\n"
            + "¡Destaca y gana más! Creamos páginas atractivas y\n"
            + "funcionales para redes sociales.\n"
            + "Diseño acorde a tu marca, optimización para\n"
            + "móviles, Integración de herramientas sociales.\n"
            + "Estrategia de contenido, logra mayor reconocimiento,\n"
            + "leads, clientes y ventas. ¡Contáctanos!";
    //servicio 5
    private String txtServicio5 = "Imprimimos tus documentos desde el archivo digital hasta el papel final.\n"
            + "Equipos modernos y expertos en impresión para resultados de alta\n"
            + "calidad en todo tipo de tamaños y estilos. Diseño, encuadernación\n"
            + "y plegado para que tus documentos sean profesionales.Impresiones simples,\n"
            + "proyectos grandes o material publicitario, ¡somos tu solución!";

    /**
     * Creates new form vistaCatalogo
     */
    public vistaCatalogo() {
        initComponents();
        controllerOptionSelected controllerActioUser = new controllerOptionSelected();
        jmiEditarPerfil.addActionListener(controllerActioUser);

        btnServicio1.addActionListener(this);
        btnServicio2.addActionListener(this);
        btnServicio3.addActionListener(this);
        btnServicio4.addActionListener(this);
        btnServicio5.addActionListener(this);

        lblParrafo1.setText(formatearTexto(parrafo1));
        lblParrafo2.setText(formatearTexto2(parrafo2P1, parrafo2P2));

        //setteando los textos a cada label
        //servicio1
        lblDescripcionsServicio1.setText(formatearTexto(txtDescripS1));
        //servicio2
        lblDescripcionsServicio2.setText(formatearTexto(txtServicio2));
        //servicio3
        lblDescripcionsServicio3.setText(formatearTexto(txtServicio3));
        //servicio4
        lblDescripcionsServicio4.setText(formatearTexto(txtServicio4));
        //servicio5
        lblDescripcionsServicio5.setText(formatearTexto(txtServicio5));

        // PONER ICONOS
        //servicio 1
        ImageIcon iconoServicio1 = new ImageIcon("src/main/java/com/Lumina/proyectolumina/gui/recursos multimedia/Iconos vistas clientes/iconos vistas clientes-03.png");
        Icon iconService1 = new ImageIcon(iconoServicio1.getImage().getScaledInstance(lblIconoServicio1.getWidth(), lblIconoServicio1.getHeight(), Image.SCALE_SMOOTH));
        lblIconoServicio1.setIcon(iconService1);

        //servicio 2
        ImageIcon iconoServicio2 = new ImageIcon("src/main/java/com/Lumina/proyectolumina/gui/recursos multimedia/Iconos vistas clientes/iconos vistas clientes-05.png");
        Icon iconService2 = new ImageIcon(iconoServicio2.getImage().getScaledInstance(lblIconoServicio2.getWidth(), lblIconoServicio2.getHeight(), Image.SCALE_SMOOTH));
        lblIconoServicio2.setIcon(iconService2);

        //servicio 3
        ImageIcon iconoServicio3 = new ImageIcon("src/main/java/com/Lumina/proyectolumina/gui/recursos multimedia/Iconos vistas clientes/iconos vistas clientes-02.png");
        Icon iconService3 = new ImageIcon(iconoServicio3.getImage().getScaledInstance(lblIconoServicio3.getWidth(), lblIconoServicio3.getHeight(), Image.SCALE_SMOOTH));
        lblIconoServicio3.setIcon(iconService3);

        // servico 4
        ImageIcon iconoServicio4 = new ImageIcon("src/main/java/com/Lumina/proyectolumina/gui/recursos multimedia/Iconos vistas clientes/iconos vistas clientes-01.png");
        Icon iconService4 = new ImageIcon(iconoServicio4.getImage().getScaledInstance(lblIconoServicio4.getWidth(), lblIconoServicio4.getHeight(), Image.SCALE_SMOOTH));
        lblIconoServicio4.setIcon(iconService4);

        // servicio 5
        ImageIcon iconoServicio5 = new ImageIcon("src/main/java/com/Lumina/proyectolumina/gui/recursos multimedia/Iconos vistas clientes/iconos vistas clientes-04.png");
        Icon iconService5 = new ImageIcon(iconoServicio5.getImage().getScaledInstance(lblIconoServicio5.getWidth(), lblIconoServicio5.getHeight(), Image.SCALE_SMOOTH));
        lblIconoServicio5.setIcon(iconService5);

        //transparencia de botones
        // boton servicio 1
        btnServicio1.setOpaque(false);
        btnServicio1.setContentAreaFilled(false);
        btnServicio1.setBorderPainted(false);
        btnServicio1.setBorder(null);

        // boton servicio 1
        btnServicio2.setOpaque(false);
        btnServicio2.setContentAreaFilled(false);
        btnServicio2.setBorderPainted(false);
        btnServicio2.setBorder(null);

        // boton servicio 1
        btnServicio3.setOpaque(false);
        btnServicio3.setContentAreaFilled(false);
        btnServicio3.setBorderPainted(false);
        btnServicio3.setBorder(null);

        // boton servicio 1
        btnServicio4.setOpaque(false);
        btnServicio4.setContentAreaFilled(false);
        btnServicio4.setBorderPainted(false);
        btnServicio4.setBorder(null);

        // boton servicio 1
        btnServicio5.setOpaque(false);
        btnServicio5.setContentAreaFilled(false);
        btnServicio5.setBorderPainted(false);
        btnServicio5.setBorder(null);

        // agregando imagenes al banner y la ventana de fondo
        ImageIcon iconLumina = new ImageIcon("src/main/java/com/Lumina/proyectolumina/gui/recursos multimedia/logo lumina blanco (2).png");
        Icon icon1 = new ImageIcon(iconLumina.getImage().getScaledInstance(lblIconoLumina.getWidth(), lblIconoLumina.getHeight(), Image.SCALE_SMOOTH));
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

    public JButton getBtnServicio1() {
        return btnServicio1;
    }

    public JButton getBtnServicio2() {
        return btnServicio2;
    }

    public JButton getBtnServicio3() {
        return btnServicio3;
    }

    public JButton getBtnServicio4() {
        return btnServicio4;
    }

    public JButton getBtnServicio5() {
        return btnServicio5;
    }

    public String formatearTexto(String texto) {
        return "<html><p>" + texto + "</p></html>";
    }

    public String formatearTexto2(String texto1, String texto2) {
        return "<html><p style='text-align: center;'>" + texto1 + "<br>" + texto2 + "</p></html>";
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
        lblNombreUsu = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnServicio5 = new javax.swing.JButton();
        lblIconoServicio5 = new javax.swing.JLabel();
        lblDescripcionsServicio5 = new javax.swing.JLabel();
        btnServicio4 = new javax.swing.JButton();
        lblIconoServicio4 = new javax.swing.JLabel();
        lblDescripcionsServicio4 = new javax.swing.JLabel();
        lblDescripcionsServicio3 = new javax.swing.JLabel();
        btnServicio3 = new javax.swing.JButton();
        lblIconoServicio3 = new javax.swing.JLabel();
        lblDescripcionsServicio2 = new javax.swing.JLabel();
        btnServicio2 = new javax.swing.JButton();
        lblIconoServicio2 = new javax.swing.JLabel();
        lblDescripcionsServicio1 = new javax.swing.JLabel();
        btnServicio1 = new javax.swing.JButton();
        lblIconoServicio1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblParrafo2 = new javax.swing.JLabel();
        lblParrafo1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblPerfilUsu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblIconoLumina = new javax.swing.JLabel();
        lblDegradado = new javax.swing.JLabel();
        jPanelFondo = new javax.swing.JLabel();

        jmiEditarPerfil.setFont(new java.awt.Font("Mulish", 0, 12)); // NOI18N
        jmiEditarPerfil.setText("Editar perfil");
        jpmAcionesUsuario.add(jmiEditarPerfil);

        jmiCerrarSesion.setFont(new java.awt.Font("Mulish", 0, 12)); // NOI18N
        jmiCerrarSesion.setText("Cerrar sesion");
        jpmAcionesUsuario.add(jmiCerrarSesion);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreUsu.setFont(new java.awt.Font("Mulish Light", 0, 14)); // NOI18N
        lblNombreUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsu.setText("Nombre de usuario");
        lblNombreUsu.setComponentPopupMenu(jpmAcionesUsuario);
        jPanel1.add(lblNombreUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(3, 90, 167));
        btnRegresar.setFont(new java.awt.Font("Mulish ExtraBold", 0, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 670, -1, -1));

        btnServicio5.setFont(new java.awt.Font("Mulish", 1, 12)); // NOI18N
        btnServicio5.setForeground(new java.awt.Color(34, 52, 64));
        btnServicio5.setText("Impresion de documentos");
        btnServicio5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServicio5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicio5ActionPerformed(evt);
            }
        });
        jPanel1.add(btnServicio5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 570, -1, -1));
        jPanel1.add(lblIconoServicio5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, 70, 60));

        lblDescripcionsServicio5.setFont(new java.awt.Font("Mulish ExtraLight", 0, 12)); // NOI18N
        lblDescripcionsServicio5.setForeground(new java.awt.Color(34, 52, 64));
        lblDescripcionsServicio5.setText("Descripcion servicio 5");
        jPanel1.add(lblDescripcionsServicio5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 590, 210, 100));

        btnServicio4.setFont(new java.awt.Font("Mulish", 1, 12)); // NOI18N
        btnServicio4.setForeground(new java.awt.Color(34, 52, 64));
        btnServicio4.setText("Diseño web");
        btnServicio4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServicio4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicio4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnServicio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, -1, -1));
        jPanel1.add(lblIconoServicio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, 70, 60));

        lblDescripcionsServicio4.setFont(new java.awt.Font("Mulish ExtraLight", 0, 12)); // NOI18N
        lblDescripcionsServicio4.setForeground(new java.awt.Color(34, 52, 64));
        lblDescripcionsServicio4.setText("Descripcion servicio 4");
        jPanel1.add(lblDescripcionsServicio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 210, 140));

        lblDescripcionsServicio3.setFont(new java.awt.Font("Mulish ExtraLight", 0, 12)); // NOI18N
        lblDescripcionsServicio3.setForeground(new java.awt.Color(34, 52, 64));
        lblDescripcionsServicio3.setText("Descripcion servicio 3");
        jPanel1.add(lblDescripcionsServicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 210, 100));

        btnServicio3.setFont(new java.awt.Font("Mulish", 1, 12)); // NOI18N
        btnServicio3.setForeground(new java.awt.Color(34, 52, 64));
        btnServicio3.setText("Piezas graficas de impresion");
        btnServicio3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServicio3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicio3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnServicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, -1));
        jPanel1.add(lblIconoServicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 70, 60));

        lblDescripcionsServicio2.setFont(new java.awt.Font("Mulish ExtraLight", 0, 12)); // NOI18N
        lblDescripcionsServicio2.setForeground(new java.awt.Color(34, 52, 64));
        lblDescripcionsServicio2.setText("Descripcion servicio 2");
        jPanel1.add(lblDescripcionsServicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 210, 100));

        btnServicio2.setFont(new java.awt.Font("Mulish", 1, 12)); // NOI18N
        btnServicio2.setForeground(new java.awt.Color(34, 52, 64));
        btnServicio2.setText("Contenido para redes sociales");
        btnServicio2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServicio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicio2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnServicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, -1, -1));
        jPanel1.add(lblIconoServicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 70, 60));

        lblDescripcionsServicio1.setFont(new java.awt.Font("Mulish ExtraLight", 0, 12)); // NOI18N
        lblDescripcionsServicio1.setForeground(new java.awt.Color(34, 52, 64));
        lblDescripcionsServicio1.setText("Descripcion servicio 1");
        jPanel1.add(lblDescripcionsServicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 210, 100));

        btnServicio1.setFont(new java.awt.Font("Mulish", 1, 12)); // NOI18N
        btnServicio1.setForeground(new java.awt.Color(34, 52, 64));
        btnServicio1.setText("Identidad corporativa");
        btnServicio1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicio1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnServicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));
        jPanel1.add(lblIconoServicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 70, 60));

        jLabel2.setFont(new java.awt.Font("Mulish SemiBold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(34, 52, 64));
        jLabel2.setText("SERVICIOS QUE OFRECEMOS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        jPanel3.setBackground(new java.awt.Color(6, 199, 242));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblParrafo2.setBackground(new java.awt.Color(51, 255, 204));
        lblParrafo2.setFont(new java.awt.Font("Mulish", 0, 12)); // NOI18N
        lblParrafo2.setForeground(new java.awt.Color(3, 90, 167));
        lblParrafo2.setText("Parrafo 2");
        jPanel3.add(lblParrafo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 740, 50));

        lblParrafo1.setFont(new java.awt.Font("Mulish", 0, 12)); // NOI18N
        lblParrafo1.setForeground(new java.awt.Color(34, 52, 64));
        lblParrafo1.setText("Parrafo ");
        jPanel1.add(lblParrafo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 740, 60));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(lblPerfilUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 70, 60));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Mulish Black", 1, 23)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido a Lumina");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 290, 40));
        jPanel2.add(lblIconoLumina, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 60));
        jPanel2.add(lblDegradado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 80));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 80));

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -2, 810, 730));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnServicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnServicio1ActionPerformed

    private void btnServicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicio2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnServicio2ActionPerformed

    private void btnServicio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicio3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnServicio3ActionPerformed

    private void btnServicio4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicio4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnServicio4ActionPerformed

    private void btnServicio5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicio5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnServicio5ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        landingPage lp = new landingPage();
        lp.setVisible(true);
        lp.setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(vistaCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaCatalogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnServicio1;
    private javax.swing.JButton btnServicio2;
    private javax.swing.JButton btnServicio3;
    private javax.swing.JButton btnServicio4;
    private javax.swing.JButton btnServicio5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jPanelFondo;
    private javax.swing.JMenuItem jmiCerrarSesion;
    private javax.swing.JMenuItem jmiEditarPerfil;
    private javax.swing.JPopupMenu jpmAcionesUsuario;
    private javax.swing.JLabel lblDegradado;
    private javax.swing.JLabel lblDescripcionsServicio1;
    private javax.swing.JLabel lblDescripcionsServicio2;
    private javax.swing.JLabel lblDescripcionsServicio3;
    private javax.swing.JLabel lblDescripcionsServicio4;
    private javax.swing.JLabel lblDescripcionsServicio5;
    private javax.swing.JLabel lblIconoLumina;
    private javax.swing.JLabel lblIconoServicio1;
    private javax.swing.JLabel lblIconoServicio2;
    private javax.swing.JLabel lblIconoServicio3;
    private javax.swing.JLabel lblIconoServicio4;
    private javax.swing.JLabel lblIconoServicio5;
    private javax.swing.JLabel lblNombreUsu;
    private javax.swing.JLabel lblParrafo1;
    private javax.swing.JLabel lblParrafo2;
    private javax.swing.JLabel lblPerfilUsu;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnServicio1)) {
            this.dispose();
            hireService.setVisible(true);
            hireService.setLocationRelativeTo(null);
            ContratarServicio.selectService(hireService, btnServicio1.getText());
        } else if (e.getSource().equals(btnServicio2)) {
            this.dispose();
            hireService.setVisible(true);
            hireService.setLocationRelativeTo(null);
            ContratarServicio.selectService(hireService, btnServicio2.getText());

        } else if (e.getSource().equals(btnServicio3)) {
            this.dispose();
            hireService.setVisible(true);
            hireService.setLocationRelativeTo(null);
            ContratarServicio.selectService(hireService, btnServicio3.getText());

        } else if (e.getSource().equals(btnServicio4)) {
            this.dispose();
            hireService.setVisible(true);
            hireService.setLocationRelativeTo(null);
            ContratarServicio.selectService(hireService, btnServicio4.getText());

        } else if (e.getSource().equals(btnServicio5)) {
            this.dispose();
            hireService.setVisible(true);
            hireService.setLocationRelativeTo(null);
            ContratarServicio.selectService(hireService, btnServicio5.getText());
        }
    }

}
