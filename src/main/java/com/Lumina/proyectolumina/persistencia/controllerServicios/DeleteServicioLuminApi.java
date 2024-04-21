/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerServicios;

import com.Lumina.proyectolumina.gui.vistasAdminUser.vistasProductos.vistaEliminarServicio;
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
public class DeleteServicioLuminApi {

    public static void deleteServicio(String servicioEncontrado, vistaEliminarServicio deleteServicio) {
        try {
            // hacer la peticion get para saber el registro a editar
            String strUrl = "http://localhost:3001/productos/?name=" + URLEncoder.encode(servicioEncontrado, "UTF-8");
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
            if (jsonArray.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO HAY DATOS PARA MOSTRAR");
            } else {
                String id = "";

                // Buscar el objeto JSON correspondiente al cliente
                System.out.println("Mostrando datos filtrados por nombre");
                JsonObject serviciosEncontrados = null;
                String nombre = "";
                String descripcion = "";
                String tipoServicio = "";
                float precio = 0;
                boolean estado = true;

                for (JsonElement element : jsonArray) {
                    JsonObject jsonObject = element.getAsJsonObject();
                    if (jsonObject.get("nombre").getAsString().equals(servicioEncontrado)) {
                        serviciosEncontrados = jsonObject;
                        id = serviciosEncontrados.get("id").getAsString();
                        nombre = serviciosEncontrados.get("nombre").getAsString();
                        descripcion = serviciosEncontrados.get("descripcion").getAsString();
                        tipoServicio = serviciosEncontrados.get("TipoServicio").getAsString();
                        precio = serviciosEncontrados.get("precio").getAsFloat();
                        estado = serviciosEncontrados.get("estado").getAsBoolean();

                        deleteServicio.getTxtNomServicio().setText(nombre);
                        deleteServicio.getTextAreaDescripcion().setText(descripcion);
                        deleteServicio.getCbTipoServicio().setSelectedItem(tipoServicio);
                        deleteServicio.getTxtPrecio().setText(String.valueOf(precio));

                        if (estado == true) {
                            deleteServicio.getCheckActivo().setSelected(true);
                        } else {
                            deleteServicio.getCheckInactivo().setSelected(true);
                        }
                    }
                }
                final String id2 = id;
                final JsonObject servicioEncontrado2 = serviciosEncontrados;
                System.out.println("Mostrando id q se envia en el put");
                System.out.println("id: " + id2);
                System.out.println(servicioEncontrado2);

                deleteServicio.getBtnEliminarServicio().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (servicioEncontrado2 != null) {
                            try {
                                String urlDelete = "http://localhost:3001/eliminarProducto/?id=" + URLEncoder.encode(id2, "UTF-8");
                                System.out.println("Mostrando id q se envia en el put");
                                System.out.println("id: " + id2);
                                URL url2 = new URL(urlDelete);
                                // abriendo conecion
                                HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();

                                //estableciendo el tipo de peticion
                                conn2.setRequestMethod("DELETE");
                                // Obtiene el código de respuesta
                                int responseCode = conn2.getResponseCode();
                                System.out.println("Código de respuesta: " + responseCode);

                                // Cierra la conexión
                                conn2.disconnect();
                                JOptionPane.showMessageDialog(null, "SERVICIO ELIMINADO CORRECTAMENTE");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "NO SE HA ENCONTRADO EL SERVICIO");
                        }
                    }
                });
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
