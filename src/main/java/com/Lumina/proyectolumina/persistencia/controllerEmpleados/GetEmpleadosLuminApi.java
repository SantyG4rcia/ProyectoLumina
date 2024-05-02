/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerEmpleados;

import com.Lumina.proyectolumina.gui.vistasAdminUser.vistasEmpleados.vistaListaEmpleados;
import com.Lumina.proyectolumina.gui.vistasClientUser.vistaVerInfoEmpleado;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class GetEmpleadosLuminApi {

    public static void getEmpleados(vistaListaEmpleados empleados) {
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
            DefaultTableModel tabla = (DefaultTableModel) empleados.getTb_empleados().getModel();
            for (JsonElement element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();
                String nombre = jsonObject.get("nombre").getAsString();
                String telefono = jsonObject.get("telefono").getAsString();
                String correo = jsonObject.get("correo").getAsString();
                String direccion = jsonObject.get("direccion").getAsString();
                String cargo = jsonObject.get("cargo").getAsString();
                float salaario = jsonObject.get("salario").getAsFloat();
                String fechaIngreso = jsonObject.get("fechaIngreso").getAsString();

                tabla.addRow(new Object[]{
                    id, nombre, telefono, correo, direccion, cargo, salaario, fechaIngreso
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

    public static void getEmpleado(vistaVerInfoEmpleado empleado, String nombreEmpleado) {
        try {
            //crear url de conexion
            URL url = new URL("http://localhost:3001/empleados/?name=" + URLEncoder.encode(nombreEmpleado, "UTF-8"));
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
                if (jsonObject.get("nombre").getAsString().equals(nombreEmpleado)) {
                    String telefono = jsonObject.get("telefono").getAsString();
                    String correo = jsonObject.get("correo").getAsString();
                    float salaario = jsonObject.get("salario").getAsFloat();
                    
                    empleado.getTxtCorreo().setText(correo);
                    empleado.getTxtPrecioServicio().setText(String.valueOf(salaario));
                    empleado.getTxtTelefono().setText(telefono);
                }
            }
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
