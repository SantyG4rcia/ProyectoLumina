/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerCatalogo;

import com.Lumina.proyectolumina.gui.vistasClientUser.vistaContratarServicio2;
import com.Lumina.proyectolumina.gui.vistasClientUser.vistaContratarServicio3;
import com.Lumina.proyectolumina.persistencia.controllerLogin.controllerOptionSelected;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class GetInfoCliente {

    private static String tipoUsuario[] = {""};
    private static String nomEmpresa = "";
    private static String telEmpresa = "";
    private static String nombre = "";
    private static String correo = "";
    private static String telefono = "";
    private static String direccion = "";
    private static String tDocumento = "";
    private static String nDocumento = "";
    private static String tPago = "";

    public static void getInfoCliente(vistaContratarServicio2 hireService, String descripServicio, String nomServicio, String categoriaSelec, String nomUsuario) {
        hireService.getLblNombreUsu().setText(nomUsuario);
        hireService.getLblCategoriaSelec().setText(categoriaSelec);
        hireService.getLblServicioSelec().setText(nomServicio);
        hireService.getTxtAreaDescripcionServicio().setText(descripServicio);
        controllerOptionSelected.seleccionerVista(hireService);

        hireService.getCbTipoUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tipoUsuario[0] = setTipoUsuario(hireService, tipoUsuario);
                if ("Empresario".equals(tipoUsuario[0])) {
                    nomEmpresa = hireService.getTxtNombreEmpresa().getText();
                    telEmpresa = hireService.getTxtTelefonoEmpresa().getText();
                    if (!nomEmpresa.equals("") && !telEmpresa.equals("")) {
                        System.out.println("Nombre empresa: " + nomEmpresa);
                        System.out.println("Telefono de la empesa: " + telEmpresa);
                    } else {
                        JOptionPane.showMessageDialog(null, "NO DEBE HABER CAMPOS VACIOS");
                    }
                }

            }
        });

        hireService.getBtnPaso3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre = hireService.getTxtNombre().getText();
                correo = hireService.getTxtCorreo().getText();
                telefono = hireService.getTxtTelefono().getText();
                direccion = hireService.getTxtDireccion().getText();
                tDocumento = hireService.getCbTdocumento().getSelectedItem().toString();
                nDocumento = hireService.getTxtNumDocumento().getText();
                tPago = hireService.getCb_tPago().getSelectedItem().toString();

                if (nombre.equals("") || tDocumento.equals("SELECCIONE") || nDocumento.equals("")
                        || correo.equals("") || direccion.equals("") || telefono.equals("") || tPago.equals("SELECCIONE")) {

                    JOptionPane.showMessageDialog(null, "HAY UNO O VARIOS CAMPOS VACIOS, VERIFIQUE LA INFORMACION E INTENTE DE NUEVO");

                } else {
                    hireService.dispose();
                    vistaContratarServicio3 hireService = new vistaContratarServicio3();
                    hireService.setVisible(true);
                    hireService.setLocationRelativeTo(null);
                    ContactarEmpleado.comtactarEmpleado(hireService, nomServicio, categoriaSelec, nomUsuario);
                }
            }
        });
    }

    private static String setTipoUsuario(vistaContratarServicio2 hireService, String[] tipoUsuario) {
        if (hireService.getCbTipoUsuario().getSelectedItem().equals("Empresario")) {
            hireService.getTxtNombreEmpresa().setEditable(true);
            hireService.getTxtTelefonoEmpresa().setEditable(true);
            tipoUsuario[0] = hireService.getCbTipoUsuario().getSelectedItem().toString();
        } else if (hireService.getCbTipoUsuario().getSelectedItem().equals("Trabajador Independiente")) {
            hireService.getTxtNombreEmpresa().setEditable(false);
            hireService.getTxtTelefonoEmpresa().setEditable(false);
            tipoUsuario[0] = hireService.getCbTipoUsuario().getSelectedItem().toString();
        }
        return tipoUsuario[0];
    }
}
