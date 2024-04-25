/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerLogin;

import com.Lumina.proyectolumina.gui.vistasLogin.vistaRegistroUsuariosParte1;
import com.Lumina.proyectolumina.gui.vistasLogin.vistaRegistroUsuariosParte2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class RegistroUsuarios {

    public static void createUser(vistaRegistroUsuariosParte1 newUser) {
        String nomCliente = newUser.getTxtNombre().getText();
        String tDocuCliente = String.valueOf(newUser.getCbTipoDocumento().getSelectedItem());
        String nDocuCliente = newUser.getTxtNumDocumento().getText();
        String correoCliente = newUser.getTxtCorreo().getText();
        String telCliente = newUser.getTxtTelefono().getText();
        String tPagoCliente = String.valueOf(newUser.getCbMetodoPago().getSelectedItem());

        // verificando que los campos no esten vacios
        if (nomCliente.equals("") || tDocuCliente.equals("SELECCIONE") || nDocuCliente.equals("")
                || correoCliente.equals("") || telCliente.equals("") || tPagoCliente.equals("SELECCIONE")) {

            JOptionPane.showMessageDialog(null, "HAY UNO O VARIOS CAMPOS VACIOS, VERIFIQUE LA INFORMACION E INTENTE DE NUEVO");

        } else {
            newUser.getBtnPaso2().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    newUser.dispose();
                    vistaRegistroUsuariosParte2 newUserP2 = new vistaRegistroUsuariosParte2();
                    newUserP2.setVisible(true);
                    newUserP2.setLocationRelativeTo(null);
                    
                    String nombreUsu = newUserP2.getTxtNomUsuario().getText();
                    String password = newUserP2.getTxPasword().getText();
                    String confirmPassword = newUserP2.getTxtCofirnaPasword().getSelectedText();
                    
                    
                    try {
                        URL url = new URL("http://localhost:3001/crearUsuario/");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("POST");
                        conn.setDoOutput(true);
                        conn.setRequestProperty("Content-Type", "application/json");

                        String requestBody = "{"
                                + "\"nombre\": \"" + nomCliente + "\","
                                + "\"correo\": \"" + correoCliente + "\","
                                + "\"tDocumento\": \"" + tDocuCliente + "\","
                                + "\"nDocumento\": \"" + nDocuCliente + "\","
                                + "\"telefono\": \"" + telCliente + "\","
                                + "\"tPago\": \"" + tPagoCliente + "\"}";

                        OutputStream os = conn.getOutputStream();
                        os.write(requestBody.getBytes());
                        os.flush();
                        os.close();

                        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                        String output;
                        System.out.println("Respuesta de la API:");
                        while ((output = br.readLine()) != null) {
                            System.out.println(output);
                        }

                        conn.disconnect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        }

    }
}
