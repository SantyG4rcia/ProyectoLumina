/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerCatalogo;

import com.Lumina.proyectolumina.gui.vistasClientUser.vistaContratarServicio3;
import com.Lumina.proyectolumina.gui.vistasClientUser.vistaVerInfoEmpleado;
import com.Lumina.proyectolumina.persistencia.controllerEmpleados.GetEmpleadosLuminApi;
import com.Lumina.proyectolumina.persistencia.controllerLogin.controllerOptionSelected;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class ContactarEmpleado {

    public static void comtactarEmpleado(vistaContratarServicio3 hireService, String servicioSelec, String categoriaSelect, String nomUsuario) {
        hireService.getLblNombreUsu().setText(nomUsuario);
        hireService.getLblCategoriaSelec().setText(categoriaSelect);
        hireService.getLblServicioSelec().setText(servicioSelec);

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
                randomValue = Math.random() * 4.9;
                calificaciones = Math.round(randomValue * 10) / 10.0;
                tabla.addRow(new Object[]{
                    id, nombre, cargo, calificaciones
                });
                id++;
            }
            // Actualizar la interfaz gráfica
            tabla.fireTableDataChanged();

            final DefaultTableModel tablaEmpleados = tabla;
            MouseListener mouseListener = new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    hireService.getBtnContactarEmpleado().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            vistaVerInfoEmpleado empleado = new vistaVerInfoEmpleado();
                            int seleccion = hireService.getTbContratarEmpleado().getSelectedRow();
                            empleado.getTxtNombre().setText(String.valueOf(tablaEmpleados.getValueAt(seleccion, 1)));
                            empleado.getTxtCargo().setText(String.valueOf(tablaEmpleados.getValueAt(seleccion, 2)));
                            empleado.getLblCategoriaSelec().setText(categoriaSelect);
                            empleado.getLblServicioSelec().setText(servicioSelec);
                            String nomEmpleado = String.valueOf(tablaEmpleados.getValueAt(seleccion, 1));
                            GetEmpleadosLuminApi.getEmpleado(empleado, nomEmpleado);
                            empleado.setVisible(true);
                            empleado.setLocationRelativeTo(null);
                            controllerOptionSelected.seleccionerVista(empleado);
                        }
                    });

                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            };
            hireService.getTbContratarEmpleado().addMouseListener(mouseListener);

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
