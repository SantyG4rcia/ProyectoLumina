/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerLogin.controllerUserActions;

import com.Lumina.proyectolumina.gui.vistasLogin.vistaActualizarPerfilUsuario;
import com.Lumina.proyectolumina.persistencia.controllerClients.UpdateClientLumApi;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ActualizarPerfilUsuario {

    public static void actualizarCliente(vistaActualizarPerfilUsuario updateClient) {
        String nomUsuario = updateClient.getLblNombreUsu().getText();
        String[] idUser = {""};
        String[] idClient = {""};
        JsonObject usuarioEncontrado = null;
        String nomUsu = "";
        String password = "";
        String nombre = "";
        String correo = "";
        String telefono = "";
        String direccion = "";
        String tDocumento = "";
        String nDocumento = "";
        String tPago = "";
        try {
            // Hacer peticion get para saber cual registro se debe editar
            String strUrl = "http://localhost:3001/usuario/?username=" + URLEncoder.encode(nomUsuario, "UTF-8");
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
            JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);

            if (jsonObject.get("username").getAsString().equals(nomUsuario)) {
                usuarioEncontrado = jsonObject;
                idUser[0] = usuarioEncontrado.get("id").getAsString();
                idClient[0] = usuarioEncontrado.get("userId").getAsString();
                nomUsu = usuarioEncontrado.get("username").getAsString();
                password = usuarioEncontrado.get("password").getAsString();

                updateClient.getTxtNomUsuario().setText(nomUsu);
                updateClient.getTxtPassword().setText(password);

                updateClient.getCheckShowPassword().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (updateClient.getCheckShowPassword().isSelected()) {
                            updateClient.getTxtPassword().setEchoChar((char) 0); // muestra contraseña
                        } else {
                            updateClient.getTxtPassword().setEchoChar('*'); // oculta contraseña
                        }
                    }
                });

                try {
                    String strUrlGetClient = "http://localhost:3001/clientes/?id=" + URLEncoder.encode(idClient[0], "UTF-8");
                    URL urlGetClient = new URL(strUrlGetClient);
                    HttpURLConnection conn2 = (HttpURLConnection) urlGetClient.openConnection();
                    conn2.setRequestMethod("GET");

                    // leer la respuesta del servidor
                    BufferedReader reader2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
                    StringBuilder response2 = new StringBuilder();
                    String line2;
                    while ((line2 = reader2.readLine()) != null) {
                        response2.append(line2);
                    }
                    reader2.close();

                    Gson gsonClients = new Gson();

                    // Convertir la respuesta JSON en un array JsonArray en lugar de JsonObject
                    JsonArray jsonArray = gsonClients.fromJson(response2.toString(), JsonArray.class);

                    if (jsonArray.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NO HAY DATOS PARA MOSTRAR");
                    } else {
                        for (JsonElement element2 : jsonArray) {
                            JsonObject jsonObjectClients = element2.getAsJsonObject();
                            if (jsonObjectClients.get("id").getAsString().equals(idClient[0])) {
                                idClient[0] = jsonObjectClients.get("id").getAsString();
                                nombre = jsonObjectClients.get("nombre").getAsString();
                                correo = jsonObjectClients.get("correo").getAsString();
                                telefono = jsonObjectClients.get("telefono").getAsString();
                                direccion = jsonObjectClients.get("direccion").getAsString();
                                tDocumento = jsonObjectClients.get("tDocumento").getAsString();
                                nDocumento = jsonObjectClients.get("nDocumento").getAsString();
                                tPago = jsonObjectClients.get("tPago").getAsString();

                                updateClient.getTxtNombre().setText(nombre);
                                updateClient.getTxtCorreo().setText(correo);
                                updateClient.getTxtTelefono().setText(telefono);
                                updateClient.getTxtDireccion().setText(direccion);
                                updateClient.getCb_TipoDocumento().setSelectedItem(tDocumento);
                                updateClient.getTxtNomDocumento().setText(nDocumento);
                                updateClient.getCbMetodoPago().setSelectedItem(tPago);
                            }
                        }
                    }
                    conn2.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            updateClient.getBtnEditarPerfil().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Id Cliente: "+ idClient[0]);
                    System.out.println("Id usuario" + idUser[0]);
                    UpdateClientLumApi.UpdateClient(updateClient, idClient[0], idUser[0]);
                }
            });
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
