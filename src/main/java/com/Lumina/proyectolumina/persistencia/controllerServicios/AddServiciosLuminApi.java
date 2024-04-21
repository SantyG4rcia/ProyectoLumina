/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerServicios;

import com.Lumina.proyectolumina.gui.vistasAdminUser.vistasProductos.vistaCrearProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

public class AddServiciosLuminApi {

    public static void addServicio(vistaCrearProducto addServicio) {
        addServicio.getBtnAddServicio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomServicio = addServicio.getTxtNomServicio().getText();
                String descripcion = addServicio.getTxtAreaDescripcionServicio().getText();
                String tipoServicio = String.valueOf(addServicio.getCbTipoServicio().getSelectedItem());
                float precio = Float.parseFloat(addServicio.getTxtPrecio().getText());
                // setteando el estado del servicio
                boolean estado = true;
                if (addServicio.getCheckActivo().isSelected()) {
                    estado = true;
                } else if (addServicio.getCheckInactivo().isSelected()) {
                    estado = false;
                }
                // verificando si el resto de campos estan vacios
                if (nomServicio.equals("") || descripcion.equals("") || tipoServicio.equals("SELECCIONE") || precio == 0) {
                    JOptionPane.showMessageDialog(null, "HAY UNO O VARIOS CAMPOS VACIOS, VERIFIQUE LA INFORMACION E INTENTE DE NUEVO");
                } else {
                    try {
                        URL url = new URL("http://localhost:3001/crearproducto/");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("POST");
                        conn.setDoOutput(true);
                        conn.setRequestProperty("Content-Type", "application/json");

                        String requestBody = "{"
                                + "\"nombre\": \"" + nomServicio + "\","
                                + "\"descripcion\": \"" + descripcion + "\","
                                + "\"TipoServicio\": \"" + tipoServicio + "\","
                                + "\"precio\": \"" + precio + "\","
                                + "\"estado\": \"" + estado + "\"}";

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
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(null, "SERVICIO AGREGADO CORRECTAMENTE");
                }

            }
        });

    }
}
