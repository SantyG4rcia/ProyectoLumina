/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerCatalogo;

import com.Lumina.proyectolumina.gui.vistasClientUser.vistaContratarServicio3;
import com.Lumina.proyectolumina.gui.vistasClientUser.vistaVerInfoEmpleado;
import com.Lumina.proyectolumina.persistencia.controllerEmpleados.GetEmpleadosLuminApi;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author USUARIO
 */
public class GetInfoEmpleado {
    public static void getInfoEmpleado(vistaVerInfoEmpleado getInfoEmpleado, vistaContratarServicio3 listaEmpleados, String categoriaSelect, String servicioSelect, int seleccion){
        getInfoEmpleado.getLblCategoriaSelec().setText(categoriaSelect);
        getInfoEmpleado.getLblServicioSelec().setText(servicioSelect);
        
       final DefaultTableModel tablaEmpleados = (DefaultTableModel) listaEmpleados.getTbContratarEmpleado().getModel();
        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {                
                getInfoEmpleado.getTxtNombre().setText(String.valueOf(tablaEmpleados.getValueAt(seleccion, 1)));
                getInfoEmpleado.getTxtCargo().setText(String.valueOf(tablaEmpleados.getValueAt(seleccion, 2)));
                String nomEmpleado = String.valueOf(tablaEmpleados.getValueAt(seleccion, 1));
                GetEmpleadosLuminApi.getEmpleado(getInfoEmpleado, nomEmpleado);
                
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
        listaEmpleados.getTbContratarEmpleado().addMouseListener(mouseListener);
    }
}
