/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.Lumina.proyectolumina.gui.vistasClientUser;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class vistaContratarServicio3 extends javax.swing.JFrame {

    /**
     * Creates new form vistaContratarServicio3
     */
    public vistaContratarServicio3() {
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

    public JButton getBtnContactarEmpleado() {
        return btnContactarEmpleado;
    }

    public JLabel getLblCategoriaSelec() {
        return lblCategoriaSelec;
    }

    public JLabel getLblServicioSelec() {
        return lblServicioSelec;
    }

    public JTable getTbContratarEmpleado() {
        return tbContratarEmpleado;
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
        jLabel11 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnContactarEmpleado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbContratarEmpleado = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblCategoriaSelec = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblServicioSelec = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblPerfilUsu = new javax.swing.JLabel();
        lblNombreUsu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblIconoLumina = new javax.swing.JLabel();
        lblDegradado = new javax.swing.JLabel();
        jPanelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Mulish Black", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(2, 31, 89));
        jLabel11.setText("PASO 3/3");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(3, 90, 167));
        btnRegresar.setFont(new java.awt.Font("Mulish ExtraBold", 0, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, -1, -1));

        btnContactarEmpleado.setBackground(new java.awt.Color(4, 49, 140));
        btnContactarEmpleado.setFont(new java.awt.Font("Mulish ExtraBold", 0, 18)); // NOI18N
        btnContactarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnContactarEmpleado.setText("Contactar empleado");
        btnContactarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactarEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnContactarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, -1, -1));

        tbContratarEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No. Empleado", "Nombre", "Cargo", "Calificaciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbContratarEmpleado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 610, 200));

        jLabel3.setFont(new java.awt.Font("Mulish Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(34, 52, 64));
        jLabel3.setText("CATEGORIA SELECCIONADA:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        lblCategoriaSelec.setFont(new java.awt.Font("Mulish Light", 0, 12)); // NOI18N
        lblCategoriaSelec.setForeground(new java.awt.Color(34, 52, 64));
        lblCategoriaSelec.setText("[Nombre de la categoria seleccionada]");
        jPanel1.add(lblCategoriaSelec, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Mulish Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(34, 52, 64));
        jLabel2.setText("SERVICIO SELECCIONADO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        lblServicioSelec.setFont(new java.awt.Font("Mulish Light", 0, 12)); // NOI18N
        lblServicioSelec.setForeground(new java.awt.Color(34, 52, 64));
        lblServicioSelec.setText("[Nombre del servicio seleccionado]");
        jPanel1.add(lblServicioSelec, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jLabel10.setFont(new java.awt.Font("Mulish Black", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(2, 31, 89));
        jLabel10.setText("Elije a la persona indicada para este servicio");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(lblPerfilUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 70, 60));

        lblNombreUsu.setFont(new java.awt.Font("Mulish Light", 0, 14)); // NOI18N
        lblNombreUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsu.setText("Nombre de usuario");
        jPanel2.add(lblNombreUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Mulish Black", 1, 23)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Contratar un servicio");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 290, 40));
        jPanel2.add(lblIconoLumina, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 60));
        jPanel2.add(lblDegradado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 80));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 80));

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -2, 810, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        vistaCatalogo catalogo = new vistaCatalogo();
        catalogo.setVisible(true);
        catalogo.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnContactarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactarEmpleadoActionPerformed

    }//GEN-LAST:event_btnContactarEmpleadoActionPerformed

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
            java.util.logging.Logger.getLogger(vistaContratarServicio3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaContratarServicio3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaContratarServicio3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaContratarServicio3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaContratarServicio3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContactarEmpleado;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jPanelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoriaSelec;
    private javax.swing.JLabel lblDegradado;
    private javax.swing.JLabel lblIconoLumina;
    private javax.swing.JLabel lblNombreUsu;
    private javax.swing.JLabel lblPerfilUsu;
    private javax.swing.JLabel lblServicioSelec;
    private javax.swing.JTable tbContratarEmpleado;
    // End of variables declaration//GEN-END:variables
}
