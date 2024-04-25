/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerCatalogo;

import com.Lumina.proyectolumina.gui.vistasClientUser.vistaContratarServicio2;
import com.Lumina.proyectolumina.gui.vistasClientUser.vistaContratarServicio3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class GetInfoCliente {

   
     private static String[] prueba = {""};

    public static void getInfoCliente(vistaContratarServicio2 hireService, String descripServicio, String nomServicio, String categoriaSelec) {
        hireService.getTxtNombreEmpresa().setEditable(false);
        hireService.getTxtTelefonoEmpresa().setEditable(false);
        hireService.getLblCategoriaSelec().setText(categoriaSelec);
        hireService.getLblServicioSelec().setText(nomServicio);
        hireService.getTxtAreaDescripcionServicio().setText(descripServicio);
        // Variable de tipo array para almacenar el tipo de usuario
      
        selectTipoUsuario(hireService, prueba);
        //prueba = pruebaExtreaeInfo(prueba);
        System.out.println("Tipo de usuario fuera del museListener: "+prueba[0]);
        
        hireService.getBtnPaso3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hireService.dispose();
                vistaContratarServicio3 hireService = new vistaContratarServicio3();
                hireService.setVisible(true);
                hireService.setLocationRelativeTo(null);
                ContactarEmpleado.comtactarEmpleado(hireService);
            }
        });
       

    }

    private static void selectTipoUsuario(vistaContratarServicio2 hireService, String[] x) {
        
        hireService.getCheckTrabajador().setSelected(true);
        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String p;
                if (hireService.getCheckEmpresario().isSelected() || hireService.getCheckTrabajador().isSelected()) {
                    if (hireService.getCheckEmpresario().isSelected() && hireService.getCheckTrabajador().isSelected()) {
                        JOptionPane.showMessageDialog(null, "SOLO DEBE SELECCIONAR UNA OPCION");
                    } else if (hireService.getCheckEmpresario().isSelected()) {
                        hireService.getTxtNombreEmpresa().setEditable(true);
                        hireService.getTxtTelefonoEmpresa().setEditable(true);
                        p = hireService.getCheckEmpresario().getText();
                        
                        x[0] = p;
                        System.out.println("Tipo de usuario mouseListener: " + x[0]);
                    } else if (hireService.getCheckTrabajador().isSelected()) {
                        hireService.getTxtNombreEmpresa().setEditable(false);
                        hireService.getTxtTelefonoEmpresa().setEditable(false);
                         p = hireService.getCheckTrabajador().getText();
                         x[0] = p;
                        System.out.println("Tipo de usuario mouseListener: " + x[0]);
                    }
                }

            }         

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };

        hireService.getCheckTrabajador().addMouseListener(mouseListener);
        hireService.getCheckEmpresario().addMouseListener(mouseListener);

    }
    
 
}
