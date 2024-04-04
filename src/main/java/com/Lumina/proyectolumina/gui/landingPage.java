/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.Lumina.proyectolumina.gui;

/**
 *
 * @author USUARIO
 */
public class landingPage extends javax.swing.JFrame {

    private String textoTitulo = "Mejore sus ventas y productividad\n "
            + "con Lumina";
    
    private String parrafoDescripcionLumina = "¿Está buscando una manera de mejorar la imagen de su\n" +
    "empresa y destacar en el mercado? ¡Nuestra agencia de\n" +
    "diseño puede ayudarte! Ofrecemos una amplia gama de\n" +
    "servicios de diseño gráfico, desde la creación de logotipos\n" +
    "hasta el diseño de sitios web y materiales de marketing.\n" +
    "Nuestro equipo de diseñadores altamente calificados\n" +
    "trabajará con usted para crear una imagen única y atractiva\n" +
    "para su empresa. ¡No dudes en ponerte en contacto con\n" +
    "nosotros para obtener más información sobre cómo\n" +
    "podemos ayudarte a alcanzar sus objetivos!";
    
    
    public landingPage() {
        initComponents();
        titulo_lp.setText(strTohuml(textoTitulo));
        descripcionLumina.setText(formatearTexto(parrafoDescripcionLumina));
    }

    public String strTohuml (String texto) {
        return "<html><p>" +texto+ "</p></html>";
    }
    
    public String formatearTexto (String texto) {
        return "<html><p>" +texto+ "</p></html>";
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        titulo_lp = new javax.swing.JLabel();
        descripcionLumina = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(4, 49, 140));

        jLabel2.setIcon(new javax.swing.ImageIcon("X:\\PROGRAMACION\\Tecnico SENA 2023\\Proyecto formativo\\ProyectoSENA\\ProyectoLumina\\src\\main\\java\\com\\Lumina\\proyectolumina\\gui\\recursos multimedia\\logo lumina blanco (2).png")); // NOI18N
        jLabel2.setMinimumSize(new java.awt.Dimension(960, 560));
        jLabel2.setName(""); // NOI18N

        jButton1.setBackground(new java.awt.Color(3, 90, 167));
        jButton1.setFont(new java.awt.Font("Mulish ExtraBold", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Iniciar sesion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Mulish ExtraBold", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(4, 49, 140));
        jButton2.setText("Registrarse");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 881, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Mulish ExtraBold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 195, 248, -1));

        jButton3.setBackground(new java.awt.Color(3, 90, 167));
        jButton3.setFont(new java.awt.Font("Mulish ExtraBold", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Empezar ahora");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 389, 167, 40));

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

        jLabel4.setIcon(new javax.swing.ImageIcon("X:\\PROGRAMACION\\Tecnico SENA 2023\\Proyecto formativo\\ProyectoSENA\\ProyectoLumina\\src\\main\\java\\com\\Lumina\\proyectolumina\\gui\\recursos multimedia\\Imagen  descriptiva lumina.png")); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 400, 323));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descripcionLumina;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel titulo_lp;
    // End of variables declaration//GEN-END:variables
}
