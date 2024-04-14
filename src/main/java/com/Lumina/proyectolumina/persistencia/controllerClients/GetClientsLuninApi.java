/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerClients;



import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class GetClientsLuninApi {
    public static void GetClients(JTable tabla) {
        DefaultTableModel tablaClientes = new DefaultTableModel();
        tablaClientes.addColumn("Id");
        tablaClientes.addColumn("Nombre");
        tablaClientes.addColumn("Telefono");
        tablaClientes.addColumn("Tipo Documento");
        tablaClientes.addColumn("Numero Documento");
        tablaClientes.addColumn("Correo");
        tablaClientes.addColumn("Direccion");
        tablaClientes.addColumn("Estado");
        tablaClientes.addColumn("Activo Desde");
        tablaClientes.addColumn("Metodo pago");
        int id = 1;
        try {
            //crear url de conexion
            URL url = new URL("http://localhost:3001/clientes/");
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

            // Iterar sobre el array y agregar cada objeto como una fila en la tabla
            for (JsonElement element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();
                String nombre = jsonObject.get("nombre").getAsString();
                String telCliente = jsonObject.get("telefono").getAsString();
                String correoCliente = jsonObject.get("correo").getAsString();
                String tDocuCliente = jsonObject.get("tDocumento").getAsString();
                String nDocumento = jsonObject.get("nDocumento").getAsString();
                String direccion = jsonObject.get("direccion").getAsString();
                String activoDesde = jsonObject.get("activoDesde").getAsString();
                boolean estado = jsonObject.get("estado").getAsBoolean();
                String setEstado = estado ? "Activo" : "Inactivo";
                String metodoPago = jsonObject.get("tPago").getAsString();

                tablaClientes.addRow(new Object[]{
                        id, nombre, telCliente, tDocuCliente, nDocumento, correoCliente, direccion, setEstado, activoDesde, metodoPago
                });
                id++;
            }

            // Asignar el modelo de tabla a la JTable
            tabla.setModel(tablaClientes);
            
            // Actualizar la interfaz gráfica
            tablaClientes.fireTableDataChanged();

            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

