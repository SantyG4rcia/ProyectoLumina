/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerLogin.contollerNewUsers;

import com.Lumina.proyectolumina.gui.vistasLogin.vistaRegistroUsuariosParte1;
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
public class AddNewUser {
    public static void addUser(vistaRegistroUsuariosParte1 newUser){
        String nomCliente = newUser.getTxtNombre().getText();
        String tDocuCliente = String.valueOf(newUser.getCbTipoDocumento().getSelectedItem());
        String nDocuCliente = newUser.getTxtNumDocumento().getText();
        String correoCliente = newUser.getTxtCorreo().getText();
        String direccionCliente = newUser.getTxtDireccion().getText();
        String telCliente = newUser.getTxtTelefono().getText();
        String tPagoCliente = String.valueOf(newUser.getCbMetodoPago().getSelectedItem());

        // verificando que los campos no esten vacios
        if (nomCliente.equals("") || tDocuCliente.equals("SELECCIONE") || nDocuCliente.equals("")
                || correoCliente.equals("") || direccionCliente.equals("") || telCliente.equals("") || tPagoCliente.equals("SELECCIONE")) {

            JOptionPane.showMessageDialog(null, "HAY UNO O VARIOS CAMPOS VACIOS, VERIFIQUE LA INFORMACION E INTENTE DE NUEVO");

        } else {
            try {
                URL url = new URL("http://localhost:3001/crearCliente/");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setRequestProperty("Content-Type", "application/json");

                String requestBody = "{"
                        + "\"nombre\": \"" + nomCliente + "\","
                        + "\"direccion\": \"" + direccionCliente + "\","
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
    }
}
