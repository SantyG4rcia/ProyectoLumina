/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerLogin.controllerUserActions;

import com.Lumina.proyectolumina.gui.vistasAdminUser.vistaMenuAdmin;
import com.Lumina.proyectolumina.gui.vistasClientUser.vistaCatalogo;
import com.Lumina.proyectolumina.gui.vistasLogin.vistaInicioSesion;
import com.Lumina.proyectolumina.persistencia.controllerLogin.controllerOptionSelected;
import com.google.gson.Gson;
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
public class IniciarSesion {

    public static void login(vistaInicioSesion login, vistaCatalogo catalogo) {
        login.getBtnInicioSesion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = login.getTxtUser().getText();
                String password = login.getTxtPasword().getText();
                String[] nomUsuario = {""};

                if (userName.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(null, "NO DEBE HABER CAMPOS VACIOS");
                } else {
                    if (userName.equals("admin") && password.equals("1234")) {
                        login.dispose();
                        vistaMenuAdmin admin = new vistaMenuAdmin();
                        admin.setVisible(true);
                        admin.setLocationRelativeTo(null);
                    } else {
                        try {
                            String strUrl = "http://localhost:3001/login/?username=" + URLEncoder.encode(userName, "UTF-8") + "&password=" + URLEncoder.encode(password, "UTF-8");
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

                            boolean encontrado = jsonObject.get("encontrado").getAsBoolean();

                            if (encontrado == true) {

                                try {
                                    String strUrlGetUser = "http://localhost:3001/usuario/?username=" + URLEncoder.encode(userName, "UTF-8");
                                    URL urlGetUser = new URL(strUrlGetUser);
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
                                    JsonObject jsonObjectUser = gsonGetUser.fromJson(response2.toString(), JsonObject.class);

                                    if (jsonObjectUser.get("username").getAsString().equals(userName)) {
                                        nomUsuario[0] = jsonObjectUser.get("username").getAsString();
                                        login.dispose();
                                        catalogo.setVisible(true);
                                        catalogo.setLocationRelativeTo(null);
                                        catalogo.getLblNombreUsu().setText(nomUsuario[0]);
                                        controllerOptionSelected.seleccionerVista(catalogo);
                                    }
                                    conn2.disconnect();
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTOS, POR FAVOR VERIFIQUE LA INFORMACION E INTENTE DE NUEVO");
                            }
                            conn.disconnect();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTOS, POR FAVOR VERIFIQUE LA INFORMACION E INTENTE DE NUEVO");
                        }
                    }

                }
            }
        });
        login.getChekShowPassword().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (login.getChekShowPassword().isSelected()) {
                    login.getTxtPasword().setEchoChar((char) 0); // muestra contraseña
                } else {
                    login.getTxtPasword().setEchoChar('*'); // oculta contraseña
                }
            }
        });


    }
}
