/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerCatalogo;

import com.Lumina.proyectolumina.gui.vistasClientUser.vistaContrararServicio1;
import com.Lumina.proyectolumina.gui.vistasClientUser.vistaContratarServicio2;
import com.Lumina.proyectolumina.persistencia.controllerCatalogo.GetInfoCliente;
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
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ContratarServicio {

    public static void selectService(vistaContrararServicio1 hireService, String categoriaSeleccionada, String nomUsuario) {
        hireService.getLblNombreUsu().setText(nomUsuario);
        hireService.getLblCategoriaSelec().setText(categoriaSeleccionada);
         controllerOptionSelected.seleccionerVista(hireService);
        try {
            //crear url de conexion
            URL url = new URL("http://localhost:3001/productos/");
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

            for (JsonElement element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();
                if (jsonObject.get("TipoServicio").getAsString().equals(categoriaSeleccionada)) {
                    String nomServicio = jsonObject.get("nombre").getAsString();
                    hireService.getCbSelectServicio().addItem(nomServicio);
                }

            }

            hireService.getBtnPaso2().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String servicioSeleccionado = hireService.getCbSelectServicio().getSelectedItem().toString();
                    String categoriaSeleccionada =  hireService.getLblCategoriaSelec().getText();
                    String peticionCliente = hireService.getTxtAreaDescripcionServicio().getText();

                    if (servicioSeleccionado.equals("SELECCIONE") || peticionCliente.equals("")) {
                        JOptionPane.showMessageDialog(null, "NO DEBE HABER CAMPOS VACIOS");
                    } else {
                        hireService.dispose();
                        vistaContratarServicio2 hireService2 = new vistaContratarServicio2();
                        hireService2.setVisible(true);
                        hireService2.setLocationRelativeTo(null);
                        GetInfoCliente.getInfoCliente(hireService2, peticionCliente, servicioSeleccionado, categoriaSeleccionada, nomUsuario);
                        
                    }
                }
            });

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
