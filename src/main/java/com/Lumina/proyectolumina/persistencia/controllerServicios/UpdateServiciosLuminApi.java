/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerServicios;

import com.Lumina.proyectolumina.gui.vistasAdminUser.vistasProductos.vistaEditarServicio;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class UpdateServiciosLuminApi {

    public static void updateServices(String servicioEncontrado, vistaEditarServicio editServicios) {
        if (servicioEncontrado.equals("")) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE OBTENER LA INFORMACION");
        } else {
            try {
                // hacer la peticion get para saber el registro a editar
                String strUrl = "http://localhost:3001/productos/?name=" + URLEncoder.encode(servicioEncontrado, "UTF-8");
                URL url = new URL(strUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                // leer la respuesta del servidor
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Crear un objeto Gson
                Gson gson = new Gson();

                // Convertir la respuesta JSON en un array JsonArray en lugar de JsonObject
                JsonArray jsonArray = gson.fromJson(response.toString(), JsonArray.class);
                // validando si el json llega vacio
                if (jsonArray.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "NO HAY DATOS PARA MOSTRAR");
                } else {
                    String id = "";

                    // Buscar el objeto JSON correspondiente al cliente
                    System.out.println("Mostrando datos filtrados por nombre");
                    JsonObject serviciosEncontrados = null;
                    String nombre = "";
                    String descripcion = "";
                    String tipoServicio = "";
                    float precio = 0;
                    boolean estado = true;

                    for (JsonElement element : jsonArray) {
                        JsonObject jsonObject = element.getAsJsonObject();
                        if (jsonObject.get("nombre").getAsString().equals(servicioEncontrado)) {
                            serviciosEncontrados = jsonObject;
                            id = serviciosEncontrados.get("id").getAsString();
                            nombre = serviciosEncontrados.get("nombre").getAsString();
                            descripcion = serviciosEncontrados.get("descripcion").getAsString();
                            tipoServicio = serviciosEncontrados.get("TipoServicio").getAsString();
                            precio = serviciosEncontrados.get("precio").getAsFloat();
                            estado = serviciosEncontrados.get("estado").getAsBoolean();

                            editServicios.getTxtNomServicio().setText(nombre);
                            editServicios.getTextAreaDescripcion().setText(descripcion);
                            editServicios.getCbTipoServicio().setSelectedItem(tipoServicio);
                            editServicios.getTxtPrecio().setText(String.valueOf(precio));

                            if (estado == true) {
                                editServicios.getCheckActivo().setSelected(true);
                            } else {
                                editServicios.getCheckInactivo().setSelected(true);
                            }
                        }
                    }
                    final String id2 = id;
                    final JsonObject servicioEncontrado2 = serviciosEncontrados;
                    System.out.println("Mostrando id q se envia en el put");
                    System.out.println("id: " + id2);
                    System.out.println(servicioEncontrado2);

                    editServicios.getBtnEditarServicio().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (servicioEncontrado2 != null) {
                                try {
                                    String urlPut = "http://localhost:3001/actualizarServicio/?id=" + URLEncoder.encode(id2, "UTF-8");
                                    System.out.println("Mostrando id q se envia en el put");
                                    System.out.println("id: " + id2);
                                    URL url2 = new URL(urlPut);
                                    // abriendo conecion
                                    HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();

                                    //estableciendo el tipo de peticion
                                    conn2.setRequestMethod("PUT");
                                    // se menciona el tipo de contenido a enviar
                                    conn2.setRequestProperty("Content-Type", "application/json");

                                    // permite el envio de datos
                                    conn2.setDoOutput(true);

                                    //obtener la informacion a actualizar
                                    String nomServicio = editServicios.getTxtNomServicio().getText();
                                    String descripcion = editServicios.getTextAreaDescripcion().getText();
                                    String tipoServicio = String.valueOf(editServicios.getCbTipoServicio().getSelectedItem());
                                    float precio = Float.parseFloat(editServicios.getTxtPrecio().getText());
                                    // setteando el estado del servicio
                                    boolean estado = true;
                                    if (editServicios.getCheckActivo().isSelected()) {
                                        estado = true;
                                    } else if (editServicios.getCheckInactivo().isSelected()) {
                                        estado = false;
                                    }
                                    // verificando si el resto de campos estan vacios
                                    if (nomServicio.equals("") || descripcion.equals("") || tipoServicio.equals("SELECCIONE") || precio == 0) {
                                        JOptionPane.showMessageDialog(null, "HAY UNO O VARIOS CAMPOS VACIOS, VERIFIQUE LA INFORMACION E INTENTE DE NUEVO");
                                    } else {
                                        String requestBody = "{"
                                                + "\"id\": \"" + id2 + "\","
                                                + "\"nombre\": \"" + nomServicio + "\","
                                                + "\"descripcion\": \"" + descripcion + "\","
                                                + "\"TipoServicio\": \"" + tipoServicio + "\","
                                                + "\"precio\": \"" + Float.parseFloat(String.valueOf(precio)) + "\","
                                                + "\"estado\": \"" + Boolean.parseBoolean(String.valueOf(estado)) + "\"}";
                                        
                                        System.out.println("Mostrando el json antes de enviar");
                                        System.out.println(requestBody);

                                        OutputStream outputStream = conn2.getOutputStream();

                                        // Escribir cuerpo de la solicitud en el flujo de salida
                                        outputStream.write(requestBody.getBytes());
                                        outputStream.flush();
                                        outputStream.close();

                                        // Obtener código de respuesta
                                        int responseCode = conn2.getResponseCode();
                                        System.out.println("Código de respuesta: " + responseCode);

                                        // Leer respuesta del servidor
                                        BufferedReader reader2;
                                        if (responseCode == HttpURLConnection.HTTP_OK) {
                                            reader2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
                                        } else {
                                            reader2 = new BufferedReader(new InputStreamReader(conn2.getErrorStream()));
                                        }
                                        String inputLine;
                                        StringBuilder response2 = new StringBuilder();
                                        while ((inputLine = reader2.readLine()) != null) {
                                            response2.append(inputLine);
                                        }
                                        reader2.close();

                                        // Imprimir respuesta del servidor
                                        System.out.println("Respuesta del servidor: " + response2.toString());
                                        conn2.disconnect();
                                    }

                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "SERVICIO NO ENCONTRADO");
                            }
                        }
                    });
                }
                conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
