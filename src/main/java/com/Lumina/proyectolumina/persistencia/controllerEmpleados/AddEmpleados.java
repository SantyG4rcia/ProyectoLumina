/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerEmpleados;

import com.Lumina.proyectolumina.gui.vistasAdminUser.vistasEmpleados.vistaAgregarEmpleado;
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
public class AddEmpleados {

    public static void addEmpleado(vistaAgregarEmpleado addEmpleado) {
        addEmpleado.getBtnAddEmpleado().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String nomEmpleado = addEmpleado.getTxtNomEmpleado().getText();
                String telEmpleado = addEmpleado.getTxtTelEmpleado().getText();
                String correo = addEmpleado.getTxtCorreoEmpleado().getText();
                String direccion = addEmpleado.getTxtDireccionEmpleados().getText();
                String cargo = addEmpleado.getTxtCargo().getText();
                float salario = Float.parseFloat(addEmpleado.getTxtSalario().getText());

                if (nomEmpleado.equals("") || telEmpleado.equals("") || correo.equals("") || direccion.equals("")
                        || cargo.equals("") || salario == 0) {
                    JOptionPane.showMessageDialog(null, "HAY UNO O VARIOS CAMPOS VACIOS, VERIFIQUE LA INFORMACION E INTENTE DE NUEVO");
                } else {
                    try {
                        URL url = new URL("http://localhost:3001/crearEmpleado/");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("POST");
                        conn.setDoOutput(true);
                        conn.setRequestProperty("Content-Type", "application/json");

                        String requestBody = "{"
                                + "\"nombre\": \"" + nomEmpleado + "\","
                                + "\"direccion\": \"" + direccion + "\","
                                + "\"correo\": \"" + correo + "\","
                                + "\"cargo\": \"" + cargo + "\","
                                + "\"salario\": \"" + salario + "\","
                                + "\"telefono\": \"" + telEmpleado + "\"}";

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
        });
    }
}
