/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerClients;

import com.Lumina.proyectolumina.gui.vistasClientes.vistaEditarCliente;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class UpdateClientLumApi {

    public static void UpdateClient(String nombreEncontrado, vistaEditarCliente editCliente) {
        // validando que los campos no vengan vacios
        if (nombreEncontrado.equals("")) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE OBTENER LA INFORMACION");
        } else {
            try {
                // Hacer peticion get para saber cual registro se debe editar
                String strUrl = "http://localhost:3001/clientes/?name=" + URLEncoder.encode(nombreEncontrado, "UTF-8");
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
                    String id = ""; // Inicializamos el ID fuera del bucle

                    // Buscar el objeto JSON correspondiente al cliente
                    System.out.println("Mostrando datos filtrados por nombre");
                    JsonObject clienteEncontrado = null;
                    String nombre = "";
                    String correo = "";
                    String telefono = "";
                    String direccion = "";
                    String tDocumento = "";
                    String nDocumento = "";
                    String tPago = "";
                    for (JsonElement element : jsonArray) {
                        JsonObject jsonObject = element.getAsJsonObject();
                        if (jsonObject.get("nombre").getAsString().equals(nombreEncontrado)) {
                            clienteEncontrado = jsonObject;
                            id = clienteEncontrado.get("id").getAsString();
                            nombre = clienteEncontrado.get("nombre").getAsString();
                            correo = clienteEncontrado.get("correo").getAsString();
                            telefono = clienteEncontrado.get("telefono").getAsString();
                            direccion = clienteEncontrado.get("direccion").getAsString();
                            tDocumento = clienteEncontrado.get("tDocumento").getAsString();
                            nDocumento = clienteEncontrado.get("nDocumento").getAsString();
                            tPago = clienteEncontrado.get("tPago").getAsString();

                            System.out.println("id: " + id);
                            System.out.println("Nombre: " + nombre);
                            System.out.println("Cprreo: " + correo);
                            System.out.println("Telefono: " + telefono);
                            System.out.println("Direccion: " + direccion);
                            System.out.println("Tipo doc: " + tDocumento);
                            System.out.println("NumDoc: " + nDocumento);
                            System.out.println("Metodo Pago: " + tPago);

                            editCliente.getTxtNombre().setText(nombre);
                            editCliente.getTxtCorreo().setText(correo);
                            editCliente.getTxtTelefono().setText(telefono);
                            editCliente.getTxtDireccion().setText(direccion);
                            editCliente.getCb_TipoDocumento().setSelectedItem(tDocumento);
                            editCliente.getTxtNomDocumento().setText(nDocumento);
                            editCliente.getCbMetodoPago().setSelectedItem(tPago);

                        }

                    }
                    final String id2 = id;
                    final JsonObject clienteEncontrado2 = clienteEncontrado;
                    System.out.println("Mostrando id q se envia en el put");
                    System.out.println("id: " + id2);
                    System.out.println(clienteEncontrado2);
                    editCliente.getBtnEditarCliente().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (clienteEncontrado2 != null) {
                                try {
                                    String urlPut = "http://localhost:3001/actualizarCliente/?id=" + URLEncoder.encode(id2, "UTF-8");
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
                                    String nombreV = editCliente.getTxtNombre().getText();
                                    String correoV = editCliente.getTxtCorreo().getText();
                                    String telefonoV = editCliente.getTxtTelefono().getText();
                                    String direccionV = editCliente.getTxtDireccion().getText();
                                    String tDocumentoV = String.valueOf(editCliente.getCb_TipoDocumento().getSelectedItem());
                                    String nDocumentoV = editCliente.getTxtNomDocumento().getText();
                                    String tPagoV = String.valueOf(editCliente.getCbMetodoPago().getSelectedItem());
                                    
                                    System.out.println("Mostrando informacion de los componentes antes de envarla al servidor");
                                    System.out.println("id: " + id2);
                                    System.out.println("Nombre: " + nombreV);
                                    System.out.println("Cprreo: " + correoV);
                                    System.out.println("Telefono: " + telefonoV);
                                    System.out.println("Direccion: " + direccionV);
                                    System.out.println("Tipo doc: " + tDocumentoV);
                                    System.out.println("NumDoc: " + nDocumentoV);
                                    System.out.println("Metodo Pago: " + tPagoV);

                                    Map<String, String> dataMap = new HashMap<>();
                                    dataMap.put("id", id2);
                                    if (!"".equals(nombreV)) {
                                        dataMap.put("nombre", nombreV);
                                    }
                                    if (!"".equals(correoV)) {
                                        dataMap.put("correo", correoV);
                                    }
                                    if (!"".equals(telefonoV)) {
                                        dataMap.put("telefono", telefonoV);
                                    }
                                    if (!"".equals(direccionV)) {
                                        dataMap.put("direccion", direccionV);
                                    }
                                    if (!"SELECCIONE".equals(tDocumentoV)) {
                                        dataMap.put("tDocumento", tDocumentoV);
                                    }
                                    if (!"".equals(nDocumentoV)) {
                                        dataMap.put("nDocumento", nDocumentoV);
                                    }
                                    if (!"SELECCIONE".equals(tPagoV)) {
                                        dataMap.put("tPago", tPagoV);
                                    }
                                    
                                    System.out.println("Mostrando el objeto Json q se va aenviar");
                                    System.out.println(dataMap);

                                    // Convertir mapa a JSON
                                    String requestBody = gson.toJson(dataMap);

                                    // Obtener flujo de salida de la conexión
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

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });

                }
                conn.disconnect();
            } catch (JsonSyntaxException | HeadlessException | IOException e) {
                e.printStackTrace();
            }
        }
    }

}
