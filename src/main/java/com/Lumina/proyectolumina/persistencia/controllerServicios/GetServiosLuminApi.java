/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerServicios;

import com.Lumina.proyectolumina.gui.vistasAdminUser.vistasProductos.vistaListaServicios;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class GetServiosLuminApi {

    public static void getServicios(vistaListaServicios servicios) {
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
            int id = 1;
            DefaultTableModel tabla = (DefaultTableModel) servicios.getTb_Servicios().getModel();
            for (JsonElement element : jsonArray) {
                 JsonObject jsonObject = element.getAsJsonObject();
                 String nombre = jsonObject.get("nombre").getAsString();
                 String tipoServicio = jsonObject.get("TipoServicio").getAsString();
                 String descripcion = jsonObject.get("descripcion").getAsString();
                 float precio = jsonObject.get("precio").getAsFloat();
                 boolean estado = jsonObject.get("estado").getAsBoolean();
                 String setEstado = estado ? "Activo" : "Inactivo";
                 
                 tabla.addRow(new Object[]{
                     id, nombre, tipoServicio, descripcion, precio, setEstado
                 });
                 id++;
            }
            
             // Actualizar la interfaz gráfica
            tabla.fireTableDataChanged();

            conn.disconnect();

        } catch (Exception e) {
             e.printStackTrace();
        }
    }
}
