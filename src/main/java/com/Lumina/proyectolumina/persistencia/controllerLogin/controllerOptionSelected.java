/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerLogin;

import com.Lumina.proyectolumina.gui.vistasLogin.vistaActualizarPerfilUsuario;
import com.Lumina.proyectolumina.persistencia.controllerLogin.controllerUserActions.ActualizarPerfilUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author USUARIO
 */
public class controllerOptionSelected implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem) e.getSource();
        String textoMenuItem = menuItem.getText();

        switch (textoMenuItem) {
            case "Editar perfil":
                vistaActualizarPerfilUsuario updateClient = new vistaActualizarPerfilUsuario();
                updateClient.setVisible(true);
                updateClient.setLocationRelativeTo(null);
                ActualizarPerfilUsuario.actualizarCliente(updateClient);
                break;

            case "Cerrar sesion":
                // ACA SE LLAMA A LA VISTA DE CIERRE DE SESION Y A LA CLASE QUE CONTIENE LA LOGICA
                break;

        }
    }

}
