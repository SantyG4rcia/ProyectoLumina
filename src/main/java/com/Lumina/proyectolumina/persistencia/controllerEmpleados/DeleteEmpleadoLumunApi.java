/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerEmpleados;

import com.Lumina.proyectolumina.gui.vistasAdminUser.vistasEmpleados.vistaEliminarEmpleado;
import com.Lumina.proyectolumina.gui.vistasAdminUser.vistasEmpleados.vistaListaEmpleados;
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
public class DeleteEmpleadoLumunApi {

    public static void deleteEmpleado(String empleadoEncontrado, vistaEliminarEmpleado deleteEmpleado) {
        try {
            //crear url de conexion
            URL url = new URL("http://localhost:3001/empleados/?name=" + URLEncoder.encode(empleadoEncontrado, "UTF-8"));
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
                JsonObject empleadEncontrado = null;
                String nombre = "";
                String correo = "";
                String telefono = "";
                String direccion = "";
                String cargo = "";
                float salario = 0;
                for (JsonElement element : jsonArray) {
                    JsonObject jsonObject = element.getAsJsonObject();
                    if (jsonObject.get("nombre").getAsString().equals(empleadoEncontrado)) {
                        empleadEncontrado = jsonObject;
                        id = empleadEncontrado.get("id").getAsString();
                        nombre = empleadEncontrado.get("nombre").getAsString();
                        telefono = empleadEncontrado.get("telefono").getAsString();
                        correo = empleadEncontrado.get("correo").getAsString();
                        direccion = empleadEncontrado.get("direccion").getAsString();
                        cargo = empleadEncontrado.get("cargo").getAsString();
                        salario = empleadEncontrado.get("salario").getAsFloat();

                        deleteEmpleado.getTxtNombre().setText(nombre);
                        deleteEmpleado.getTxtCorreo().setText(correo);
                        deleteEmpleado.getTxtTelefono().setText(telefono);
                        deleteEmpleado.getTxtDireccion().setText(direccion);
                        deleteEmpleado.getTxtCargo().setText(cargo);
                        deleteEmpleado.getTxtSalario().setText(String.valueOf(salario));

                    } else {
//                        JOptionPane.showMessageDialog(null, "NO SE ENCONTRO NINGUN EMPLEADO QUE CONTEMGA LA INFORMACION SOLICITADA");
//                        deleteEmpleado.dispose();
//                        vistaListaEmpleados empleados = new vistaListaEmpleados();
//                        GetEmpleadosLuminApi.getEmpleados(empleados);
//                        empleados.setVisible(true);
//                        empleados.setLocationRelativeTo(null);
//                        break;
                    }
                }

                final String id2 = id;
                final JsonObject empleadoEncontrado2 = empleadEncontrado;
                System.out.println("Mostrando id q se envia en el put");
                System.out.println("id: " + id2);
                System.out.println(empleadoEncontrado2);

                deleteEmpleado.getBtnEliminarEmpleado().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (empleadoEncontrado2 != null) {
                            try {
                                //crear url de peticion
                                String strUrlDelete = "http://localhost:3001/eliminarEmpleado/?id=" + URLEncoder.encode(id2, "UTF-8");
                                URL urlDelete = new URL(strUrlDelete);

                                // Abre la conexión
                                HttpURLConnection connection = (HttpURLConnection) urlDelete.openConnection();

                                // Configura el método de la petición como DELETE
                                connection.setRequestMethod("DELETE");

                                // Obtiene el código de respuesta
                                int responseCode = connection.getResponseCode();
                                System.out.println("Código de respuesta: " + responseCode);

                                // Cierra la conexión
                                connection.disconnect();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            JOptionPane.showMessageDialog(null, "CLIENTE ELIMINADO CORRECTAMENTE");
                        } else {
                            JOptionPane.showMessageDialog(null, "NO SE ENCONTRO NINGUN EMPLEADO QUE CONTEMGA LA INFORMACION SOLICITADA");
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
