/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerLogin.contollerUsers;

import com.Lumina.proyectolumina.gui.vistasAdminUser.vistasClientes.listaClientes;
import com.Lumina.proyectolumina.gui.vistasLogin.vistaAgregarCredencialesUsuario;
import com.Lumina.proyectolumina.persistencia.controllerClients.GetClientsLuninApi;
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
public class AgregarCredenciales {

    public static void agregarCredenciales(vistaAgregarCredencialesUsuario agregarCredenciales, String nombreEncontrado) {
        String[] idClient = {""}; // id del cliente a partir del nombre 
        String idUserName = ""; // identificador del objeto usuario
        String idUser = ""; // id del cliente que ya tiene credenciales
        boolean tieneUsuarioAsignado = true;
        try {
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
            JsonArray jsonArrayClients = gson.fromJson(response.toString(), JsonArray.class);
            for (JsonElement elementClient : jsonArrayClients) {
                JsonObject jsonObjectCliuent = elementClient.getAsJsonObject();
                if (jsonObjectCliuent.get("nombre").getAsString().equals(nombreEncontrado)) {
                    idClient[0] = jsonObjectCliuent.get("id").getAsString();
                    System.out.println("Id del cliente: " + idClient[0]);
                    try {
                        String StrlUrlGetUser = "http://localhost:3001/usuarios/";
                        URL urlGetUser = new URL(StrlUrlGetUser);
                        HttpURLConnection conn2 = (HttpURLConnection) urlGetUser.openConnection();
                        conn2.setRequestMethod("GET");

                        // leer la respuesta del servidor
                        BufferedReader reader2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
                        StringBuilder response2 = new StringBuilder();
                        String line2;
                        while ((line2 = reader2.readLine()) != null) {
                            response2.append(line2);
                        }
                        reader2.close();

                        // Crear un objeto Gson
                        Gson gsonGetUser = new Gson();

                        // Convertir la respuesta JSON en un array JsonArray en lugar de JsonObject
                        JsonArray jsonArrayUsers = gsonGetUser.fromJson(response2.toString(), JsonArray.class);
                        for (JsonElement jsonElement : jsonArrayUsers) {
                            JsonObject jsonObjetUser = jsonElement.getAsJsonObject();
                            idUser = jsonObjetUser.get("userId").getAsString();
                            System.out.println("Id del cliente dentro del objeto de usuario: " + idUser);
                            if (idClient[0].equals(idUser)) {
                                System.out.println("El cliente ya tiene credenciales asignadas");
                                tieneUsuarioAsignado = true;
                                idUserName = jsonObjetUser.get("id").getAsString();
                                System.out.println("Identificador del objeto de usuario: " + idUserName);
                                break;
                            } else {
                                tieneUsuarioAsignado = false;
                                System.out.println("El cliente no tiene credenciales asignadas");
                                break;
                            }
                        }
                        conn2.disconnect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (tieneUsuarioAsignado == false) {
            int opcion = JOptionPane.showConfirmDialog(null, "El cliente solicitado no tiene credenciales asignadas, ¿Desea añadirle credenciales personalizadas? De lo contrario se le asignará credenciales por defecto", "Confirmación", JOptionPane.YES_NO_OPTION);

            // Verificamos la opción seleccionada por el usuario
            if (opcion == JOptionPane.YES_OPTION && tieneUsuarioAsignado == false) {
                System.out.println("El usuario ha seleccionado 'Sí' desea personalizar sus credenciales");
                agregarCredenciales.setVisible(true);
                agregarCredenciales.setLocationRelativeTo(null);
                agregarCredenciales.getBtnAgregarCredenciales().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nomUsuario = agregarCredenciales.getTxtNomUsuario().getText();
                        String password = agregarCredenciales.getTxtPasword().getText();
                        String confirmaPassword = agregarCredenciales.getTxtCofirnaPasword().getText();

                        if (nomUsuario.equals("") && password.equals("") && confirmaPassword.equals(password)) {
                            JOptionPane.showMessageDialog(null, "HAY UNO O VARIOS CAMPOS VACIOS O NO COINIDEN LAS CONTRASEÑAS, VERIFIQUE LA INFORMACION E INTENTE DE NUEVO");
                        } else {
                            //Hacer el post para crear el nuevo usuario
                            try {

                                URL url = new URL("http://localhost:3001/crearUsuario/");
                                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                conn.setRequestMethod("POST");
                                conn.setDoOutput(true);
                                conn.setRequestProperty("Content-Type", "application/json");

                                String requestBody = "{"
                                        + "\"id\": \"" + idClient[0] + "\","
                                        + "\"username\": \"" + nomUsuario + "\","
                                        + "\"password\": \"" + confirmaPassword + "\"}";

                                System.out.println("Datos que se envian en el post: " + requestBody);

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
                        }
                    }
                });

            } else if (opcion == JOptionPane.NO_OPTION && tieneUsuarioAsignado == false) {
                System.out.println("El usuario ha seleccionado 'No' no desea personalizar sus credenciales");
                System.out.println("Se asigna credenciales por defecto");
                try {
                    String strUrl = "http://localhost:3001/clientes/?id=" + URLEncoder.encode(idClient[0], "UTF-8");
                    System.out.println("Id del cliente: " + idClient[0]);
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
                    for (JsonElement jsonElement : jsonArray) {
                        JsonObject jsonObject = jsonElement.getAsJsonObject();
                        if (jsonObject.get("id").getAsString().equals(idClient[0])) {
                            System.out.println("confirmar Id del cliente: " + idClient[0]);
                            String nomCliente = jsonObject.get("nombre").getAsString();
                            String numDocumento = jsonObject.get("nDocumento").getAsString();
                            System.out.println("Nombre: " + nomCliente);
                            System.out.println("Num Doc: " + numDocumento);
                            try {

                                URL urlPostUserName = new URL("http://localhost:3001/crearUsuario/");
                                HttpURLConnection conn2 = (HttpURLConnection) urlPostUserName.openConnection();
                                conn2.setRequestMethod("POST");
                                conn2.setDoOutput(true);
                                conn2.setRequestProperty("Content-Type", "application/json");

                                String requestBody = "{"
                                        + "\"id\": \"" + idClient[0] + "\","
                                        + "\"username\": \"" + nomCliente + "\","
                                        + "\"password\": \"" + numDocumento + "\"}";

                                System.out.println("Datos que se envian en el post: " + requestBody);

                                OutputStream os = conn2.getOutputStream();
                                os.write(requestBody.getBytes());
                                os.flush();
                                os.close();

                                BufferedReader br = new BufferedReader(new InputStreamReader((conn2.getInputStream())));
                                String output;
                                System.out.println("Respuesta de la API:");
                                while ((output = br.readLine()) != null) {
                                    System.out.println(output);
                                }

                                conn2.disconnect();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                listaClientes clientes = new listaClientes();
                GetClientsLuninApi.GetClients(clientes.getTb_Clientes());
                clientes.setVisible(true);
                clientes.setLocationRelativeTo(null);

            } else if (tieneUsuarioAsignado == true) {
                try {
                    String StrlUrlGetUser = "http://localhost:3001/usuario/?id=" + URLEncoder.encode(idUserName, "UTF-8");
                    URL urlGetUser = new URL(StrlUrlGetUser);
                    HttpURLConnection conn2 = (HttpURLConnection) urlGetUser.openConnection();
                    conn2.setRequestMethod("GET");

                    // leer la respuesta del servidor
                    BufferedReader reader2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
                    StringBuilder response2 = new StringBuilder();
                    String line2;
                    while ((line2 = reader2.readLine()) != null) {
                        response2.append(line2);
                    }
                    reader2.close();

                    // Crear un objeto Gson
                    Gson gsonGetUser = new Gson();

                    JsonObject jsonObject = gsonGetUser.fromJson(response2.toString(), JsonObject.class);

                    if (jsonObject.get("id").getAsString().equals(idUserName)) {
                        JOptionPane.showMessageDialog(null, "El cliente ya tiene credenciales asignadas, si desea actualizarlas debe iniciar sesion");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        agregarCredenciales.getChekShowPassword().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (agregarCredenciales.getChekShowPassword().isSelected()) {
                    agregarCredenciales.getTxtPasword().setEchoChar((char) 0); // muestra contraseña
                    agregarCredenciales.getTxtCofirnaPasword().setEchoChar((char) 0); // muestra contraseña
                } else {
                    agregarCredenciales.getTxtPasword().setEchoChar('*'); // oculta contraseña
                    agregarCredenciales.getTxtCofirnaPasword().setEchoChar('*'); // oculta contraseña
                }
            }
        });
    }
}
