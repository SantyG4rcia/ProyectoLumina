/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerCatalogo;

import com.Lumina.proyectolumina.gui.vistasClientUser.vistaCatalogo;
import com.Lumina.proyectolumina.gui.vistasClientUser.vistaContratarServicio2;
import com.Lumina.proyectolumina.gui.vistasClientUser.vistaContratarServicio3;
import com.Lumina.proyectolumina.persistencia.controllerLogin.controllerOptionSelected;
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
public class GetInfoCliente {

    public static void getInfoCliente(vistaContratarServicio2 hireService, String descripServicio, String nomServicio, String categoriaSelec, String nomUsuario) {

        String idClient = "";

        hireService.getLblNombreUsu().setText(nomUsuario);
        hireService.getLblCategoriaSelec().setText(categoriaSelec);
        hireService.getLblServicioSelec().setText(nomServicio);
        hireService.getTxtAreaDescripcionServicio().setText(descripServicio);
        controllerOptionSelected.seleccionerVista(hireService);

        String userName = hireService.getLblNombreUsu().getText();
        try {
            String strUrl = "http://localhost:3001/usuario/?username=" + URLEncoder.encode(userName, "UTF-8");
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
            if (jsonObject.get("username").getAsString().equals(userName)) {
                idClient = jsonObject.get("userId").getAsString();
                try {
                    String strUrlCli = "http://localhost:3001/clientes/?id=" + URLEncoder.encode(idClient, "UTF-8");
                    URL urlCli = new URL(strUrlCli);
                    HttpURLConnection conn2 = (HttpURLConnection) urlCli.openConnection();
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
                    Gson gsonClients = new Gson();

                    // Convertir la respuesta JSON en un array JsonArray en lugar de JsonObject
                    JsonArray jsonArray = gsonClients.fromJson(response2.toString(), JsonArray.class);

                    for (JsonElement element : jsonArray) {

                        JsonObject jsonObjectClients = element.getAsJsonObject();
                        if (jsonObjectClients.get("id").getAsString().equals(idClient)) {
                            String nombreCli = jsonObjectClients.get("nombre").getAsString();
                            String telCliente = jsonObjectClients.get("telefono").getAsString();
                            String correoCliente = jsonObjectClients.get("correo").getAsString();
                            String tDocuCliente = jsonObjectClients.get("tDocumento").getAsString();
                            String nDocumentoCli = jsonObjectClients.get("nDocumento").getAsString();
                            String direccionCli = jsonObjectClients.get("direccion").getAsString();
                            String metodoPagoCli = jsonObjectClients.get("tPago").getAsString();
                            hireService.getTxtNombre().setText(nombreCli);
                            hireService.getTxtCorreo().setText(correoCliente);
                            hireService.getTxtTelefono().setText(telCliente);
                            hireService.getTxtDireccion().setText(direccionCli);
                            hireService.getCbTdocumento().setSelectedItem(tDocuCliente);
                            hireService.getTxtNumDocumento().setText(nDocumentoCli);
                            hireService.getCb_tPago().setSelectedItem(metodoPagoCli);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        hireService.getBtnPaso3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hireService.dispose();
                vistaContratarServicio3 hireService = new vistaContratarServicio3();
                hireService.setVisible(true);
                hireService.setLocationRelativeTo(null);
                ContactarEmpleado.comtactarEmpleado(hireService, nomServicio, categoriaSelec, nomUsuario);
                controllerOptionSelected.seleccionerVista(hireService);
            }
        });

        hireService.getBtnRegresar().addActionListener((ActionEvent e) -> {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas cancelar el proceso de contratación de este servicio?\n "
                    + "Si tu respuesta es afirmativa deberás reiniciar el proceso desde el principio", "Confirmación", JOptionPane.YES_NO_OPTION);

            // Verificamos la opción seleccionada por el usuario
            if (opcion == JOptionPane.YES_OPTION) {
                hireService.dispose();
                vistaCatalogo catalogo = new vistaCatalogo();
                catalogo.getLblNombreUsu().setText(hireService.getLblNombreUsu().getText());
                catalogo.setVisible(true);
                catalogo.setLocationRelativeTo(null);
                controllerOptionSelected.seleccionerVista(catalogo);
            }
        });
    }
}
