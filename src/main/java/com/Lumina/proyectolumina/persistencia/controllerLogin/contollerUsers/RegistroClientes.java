/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerLogin.contollerUsers;

import com.Lumina.proyectolumina.gui.vistasLogin.vistaRegistroUsuariosParte1;
import com.Lumina.proyectolumina.gui.vistasLogin.vistaRegistroUsuariosParte2;
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
public class RegistroClientes {

    public static void createUser(vistaRegistroUsuariosParte1 newUser) {
        vistaRegistroUsuariosParte2 newUserP2 = new vistaRegistroUsuariosParte2();
        newUser.getBtnPaso2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                newUser.dispose();
                newUserP2.setVisible(true);
                newUserP2.setLocationRelativeTo(null);
                AddNewUser.addClient(newUser); //Envia los datos a la clase que gestiona el post de los clientes
                newUserP2.getBtnRegistarse().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        String id = "";
                        String nombre = newUser.getTxtNombre().getText();
                        String nombreUsu = newUserP2.getTxtNomUsuario().getText();
                        String password = newUserP2.getTxtPasword().getText();
                        String confirmPassword = newUserP2.getTxtCofirnaPasword().getText();

                        if (nombreUsu.equals("") && password.equals("") && confirmPassword.equals(password)) {
                            JOptionPane.showMessageDialog(null, "HAY UNO O VARIOS CAMPOS VACIOS O NO COINIDEN LAS CONTRASEÑAS, VERIFIQUE LA INFORMACION E INTENTE DE NUEVO");
                        } else {
                            // Hacer el get para obtener el id del ultimo registro de la tabla clientes
                            try {
                                //crear url de conexion
                                String strUrl = "http://localhost:3001/clientes/?name=" + URLEncoder.encode(nombre, "UTF-8");
                                URL url = new URL(strUrl);
                                HttpURLConnection conn2 = (HttpURLConnection) url.openConnection();
                                conn2.setRequestMethod("GET");

                                // leer la respuesta del servidor
                                BufferedReader reader2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
                                StringBuilder responseGet = new StringBuilder();
                                String line;
                                while ((line = reader2.readLine()) != null) {
                                    responseGet.append(line);
                                }
                                reader2.close();

                                // Crear un objeto Gson
                                Gson gson = new Gson();

                                // Convertir la respuesta JSON en un array JsonArray en lugar de JsonObject
                                JsonArray jsonArray = gson.fromJson(responseGet.toString(), JsonArray.class);

                                //obtener el id del cliente creado recientemente
                                if (jsonArray.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "NO HAY DATOS PARA MOSTRAR, VERIFIQUE LA INFORMACION E INTENTE DE NUEVO");
                                } else {
                                    for (JsonElement element : jsonArray) {
                                        JsonObject jsonObject = element.getAsJsonObject();
                                        if (jsonObject.get("nombre").getAsString().equals(nombre)) {
                                            id = jsonObject.get("id").getAsString();
                                            System.out.println("Id del cliente: " + id);
                                        }
                                    }

                                }

                                conn2.disconnect();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            //Hacer el post para crear el nuevo usuario
                            try {

                                URL url = new URL("http://localhost:3001/crearUsuario/");
                                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                conn.setRequestMethod("POST");
                                conn.setDoOutput(true);
                                conn.setRequestProperty("Content-Type", "application/json");

                                String requestBody = "{"
                                        + "\"id\": \"" + id + "\","
                                        + "\"username\": \"" + nombreUsu + "\","
                                        + "\"password\": \"" + confirmPassword + "\"}";

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
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
        newUserP2.getChekShowPassword().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newUserP2.getChekShowPassword().isSelected()) {
                    newUserP2.getTxtPasword().setEchoChar((char) 0); // muestra contraseña
                    newUserP2.getTxtCofirnaPasword().setEchoChar((char) 0); // muestra contraseña
                } else {
                    newUserP2.getTxtPasword().setEchoChar('*'); // oculta contraseña
                    newUserP2.getTxtCofirnaPasword().setEchoChar('*'); // oculta contraseña
                }
            }
        });
    }
}
