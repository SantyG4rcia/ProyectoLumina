/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerEmpleados;

import com.Lumina.proyectolumina.gui.vistasAdminUser.vistasEmpleados.vistaEditarEmpleado;
import com.Lumina.proyectolumina.gui.vistasAdminUser.vistasEmpleados.vistaListaEmpleados;
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
public class UpdateEmpleadoLuminApi {

    public static void updateEmpleado(String empleadoEncontrado, vistaEditarEmpleado editEmpleado) {
        if (empleadoEncontrado.equals("")) {
            JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA EL EMPLEADO SOLICITADO");
        } else {
            try {
                // Hacer peticion get para saber cual registro se debe editar
                String strUrl = "http://localhost:3001/empleados/?name=" + URLEncoder.encode(empleadoEncontrado, "UTF-8");
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
                    JsonObject empleadEncontrado = null;
                    String nombre = "";
                    String correo = "";
                    String telefono = "";
                    String direccion = "";
                    String cargo = "";
                    float salario = 0;

                    for (JsonElement element : jsonArray) {
                        JsonObject jsonObject = element.getAsJsonObject();
                        if (jsonObject.get("nombre").getAsString().equals(empleadoEncontrado)) {
                            empleadEncontrado = jsonObject;
                            id = empleadEncontrado.get("id").getAsString();
                            nombre = empleadEncontrado.get("nombre").getAsString();
                            telefono = empleadEncontrado.get("telefono").getAsString();
                            correo = empleadEncontrado.get("correo").getAsString();
                            direccion = empleadEncontrado.get("direccion").getAsString();
                            cargo = empleadEncontrado.get("cargo").getAsString();
                            salario = empleadEncontrado.get("salario").getAsFloat();

                            editEmpleado.getTxtNombre().setText(nombre);
                            editEmpleado.getTxtCorreo().setText(correo);
                            editEmpleado.getTxtTelefono().setText(telefono);
                            editEmpleado.getTxtDireccion().setText(direccion);
                            editEmpleado.getTxtCargo().setText(cargo);
                            editEmpleado.getTxtSalario().setText(String.valueOf(salario));

                        } else {
//                            JOptionPane.showMessageDialog(null, "NO SE ENCONTRO NINGUN EMPLEADO QUE CONTEMGA LA INFORMACION SOLICITADA");
//                            editEmpleado.dispose();
//                            vistaListaEmpleados empleados = new vistaListaEmpleados();
//                            GetEmpleadosLuminApi.getEmpleados(empleados);
//                            empleados.setVisible(true);
//                            empleados.setLocationRelativeTo(null);
//                            break;
                        }
                    }

                    final String id2 = id;
                    final JsonObject empleadoEncontrado2 = empleadEncontrado;
                    System.out.println("Mostrando id q se envia en el put");
                    System.out.println("id: " + id2);
                    System.out.println(empleadoEncontrado2);

                    editEmpleado.getBtnEditarEmpleado().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (empleadoEncontrado2 != null) {
                                try {
                                    String urlPut = "http://localhost:3001/actualizarEmpleado/?id=" + URLEncoder.encode(id2, "UTF-8");
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

                                    String nombre = editEmpleado.getTxtNombre().getText();
                                    String correo = editEmpleado.getTxtCorreo().getText();
                                    String telefono = editEmpleado.getTxtTelefono().getText();
                                    String direccion = editEmpleado.getTxtDireccion().getText();
                                    String cargo = editEmpleado.getTxtCargo().getText();
                                    float salario = Float.parseFloat(editEmpleado.getTxtSalario().getText());

                                    // verificando si el resto de campos estan vacios
                                    if (nombre.equals("") || correo.equals("") || telefono.equals("") || direccion.equals("")
                                            || cargo.equals("") || salario == 0) {
                                        JOptionPane.showMessageDialog(null, "HAY UNO O VARIOS CAMPOS VACIOS, VERIFIQUE LA INFORMACION E INTENTE DE NUEVO");
                                    } else {
                                        String requestBody = "{"
                                                + "\"id\": \"" + id2 + "\","
                                                + "\"nombre\": \"" + nombre + "\","
                                                + "\"correo\": \"" + correo + "\","
                                                + "\"telefono\": \"" + telefono + "\","
                                                + "\"salario\": \"" + Float.parseFloat(String.valueOf(salario)) + "\","
                                                + "\"cargo\": \"" + cargo + "\"}";

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
                                    JOptionPane.showMessageDialog(null, "EMPLEADO ACTUALIZADO CORRECTAMENTE");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "EMPLEADO NO ENCONTRADO");
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
