package com.Lumina.proyectolumina.persistencia.controllerClients;

import com.Lumina.proyectolumina.gui.vistasAdminUser.vistasClientes.listaClientes;
import com.Lumina.proyectolumina.gui.vistasAdminUser.vistasClientes.vistaEliminarCliente;
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

public class DeleteClientLumiApi {

    public static void deleteClient(String nombreEncontrado, vistaEliminarCliente deleteCliente) {
        try {
            // hacer peticion get para obtener el registro a eliminar
            String strUrl = "http://localhost:3001/clientes/?name=" + URLEncoder.encode(nombreEncontrado, "UTF-8");
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

            // validando si el json llega vacio
            if (jsonArray.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO HAY DATOS PARA MOSTRAR");
            } else {
                String id = ""; // Inicializamos el ID fuera del bucle

                // Buscar el objeto JSON correspondiente al cliente
                System.out.println("Mostrando datos filtrados por nombre");
                JsonObject clienteEncontrado = null;
                String nombre = "";
                String correo = "";
                String telefono = "";
                String direccion = "";
                String tDocumento = "";
                String nDocumento = "";
                String tPago = "";

                for (JsonElement element : jsonArray) {
                    JsonObject jsonObject = element.getAsJsonObject();
                    if (jsonObject.get("nombre").getAsString().equals(nombreEncontrado)) {
                        clienteEncontrado = jsonObject;
                        id = clienteEncontrado.get("id").getAsString();
                        nombre = clienteEncontrado.get("nombre").getAsString();
                        correo = clienteEncontrado.get("correo").getAsString();
                        telefono = clienteEncontrado.get("telefono").getAsString();
                        direccion = clienteEncontrado.get("direccion").getAsString();
                        tDocumento = clienteEncontrado.get("tDocumento").getAsString();
                        nDocumento = clienteEncontrado.get("nDocumento").getAsString();
                        tPago = clienteEncontrado.get("tPago").getAsString();

                        System.out.println("id: " + id);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Cprreo: " + correo);
                        System.out.println("Telefono: " + telefono);
                        System.out.println("Direccion: " + direccion);
                        System.out.println("Tipo doc: " + tDocumento);
                        System.out.println("NumDoc: " + nDocumento);
                        System.out.println("Metodo Pago: " + tPago);

                        deleteCliente.getTxtNomClient().setText(nombre);
                        deleteCliente.getTxtCorreo().setText(correo);
                        deleteCliente.getTxtTelefono().setText(telefono);
                        deleteCliente.getTxtDireccion().setText(direccion);
                        deleteCliente.getCbTipoDoc().setSelectedItem(tDocumento);
                        deleteCliente.getTxtNumDoc().setText(nDocumento);
                        deleteCliente.getCbMetodoPago().setSelectedItem(tPago);

                    } else {
//                        JOptionPane.showMessageDialog(null, "NO EXISTE NINGUN CLIENTE CON LA INFORMACION SUMINISTRADA");
//                        deleteCliente.dispose();
//                        listaClientes clientes = new listaClientes();
//                        GetClientsLuninApi.GetClients(clientes.getTb_Clientes());
//                        clientes.setVisible(true);
//                        clientes.setLocationRelativeTo(null);
//                        break;
                    }

                }

                // HACER LA PETICION DELETE 
                final String id2 = id;
                final JsonObject clienteEncontrado2 = clienteEncontrado;
                deleteCliente.getBtnEliminarCliente().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (clienteEncontrado2 != null) {
                            try {
                                //crear url de peticion
                                String strUrlDelete = "http://localhost:3001/eliminarCliente/?id=" + URLEncoder.encode(id2, "UTF-8");
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
                        } 

                    }
                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
