/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerCatalogo;

import com.Lumina.proyectolumina.gui.vistasClientUser.vistaContratarServicio3;
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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class ContactarEmpleado {

    public static void comtactarEmpleado(vistaContratarServicio3 hireService) {
        try {
            //crear url de conexion
            URL url = new URL("http://localhost:3001/empleados/");
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
            int id = 1;
            double randomValue;
            double calificaciones;
            DefaultTableModel tabla = (DefaultTableModel) hireService.getTbContratarEmpleado().getModel();
            for (JsonElement element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();
                String nombre = jsonObject.get("nombre").getAsString();
                String cargo = jsonObject.get("cargo").getAsString();
                randomValue = Math.random()*4.9;
                calificaciones = Math.round(randomValue * 10) / 10.0;
                tabla.addRow(new Object[]{
                    id, nombre, cargo, calificaciones
                });
                id++;
            }
            // Actualizar la interfaz gráfica
            tabla.fireTableDataChanged();
            
            
            hireService.getBtnContactarEmpleado().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                }
            });

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
