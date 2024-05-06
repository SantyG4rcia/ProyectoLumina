/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Lumina.proyectolumina.persistencia.controllerLogin;

import com.Lumina.proyectolumina.gui.landingPage;
import com.Lumina.proyectolumina.gui.vistasClientUser.vistaCatalogo;
import com.Lumina.proyectolumina.gui.vistasClientUser.vistaContrararServicio1;
import com.Lumina.proyectolumina.gui.vistasClientUser.vistaContratarServicio2;
import com.Lumina.proyectolumina.gui.vistasClientUser.vistaContratarServicio3;
import com.Lumina.proyectolumina.gui.vistasClientUser.vistaVerInfoEmpleado;
import com.Lumina.proyectolumina.gui.vistasLogin.vistaActualizarPerfilUsuario;
import com.Lumina.proyectolumina.persistencia.controllerLogin.controllerUserActions.ActualizarPerfilUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class controllerOptionSelected {

    public static void seleccionerVista(vistaCatalogo catalogo) {
        catalogo.getJmiEditarPerfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                String textoMenuItem = menuItem.getText();

                if (textoMenuItem.equals("Editar perfil")) {
                    catalogo.dispose();
                    vistaActualizarPerfilUsuario updateClient = new vistaActualizarPerfilUsuario();
                    updateClient.setVisible(true);
                    updateClient.setLocationRelativeTo(null);
                    ActualizarPerfilUsuario.actualizarCliente(updateClient, catalogo.getLblNombreUsu().getText());

                    updateClient.getBtnRegresar().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            updateClient.dispose();
                            catalogo.setVisible(true);
                            catalogo.setLocationRelativeTo(null);
                        }
                    });
                }
            }
        });

        catalogo.getJmiCerrarSesion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                String textoMenuItem = menuItem.getText();

                if ((textoMenuItem.equals("Cerrar sesion"))) {
                    // ACA SE LLAMA A LA VISTA DE CIERRE DE SESION Y A LA CLASE QUE CONTIENE LA LOGICA
                    // Mensaje de confirmación con opciones Si/No
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

                    // Verificamos la opción seleccionada por el usuario
                    if (opcion == JOptionPane.YES_OPTION) {
                        System.out.println("El usuario ha seleccionado 'Sí'");
                        catalogo.dispose();
                        landingPage lp;
                        lp = new landingPage();
                        lp.setVisible(true);
                        lp.setLocationRelativeTo(null);
                    }
                }
            }
        });

        catalogo.getBtnRegresar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

                // Verificamos la opción seleccionada por el usuario
                if (opcion == JOptionPane.YES_OPTION) {
                    System.out.println("El usuario ha seleccionado 'Sí'");
                    catalogo.dispose();
                    landingPage lp;
                    lp = new landingPage();
                    lp.setVisible(true);
                    lp.setLocationRelativeTo(null);
                }
            }
        });
    }
//FIN VISTA CATALOGO

    public static void seleccionerVista(vistaContrararServicio1 hireService) {
        hireService.getJmiEditarPerfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                String textoMenuItem = menuItem.getText();

                if (textoMenuItem.equals("Editar perfil")) {
                    hireService.dispose();
                    vistaActualizarPerfilUsuario updateClient = new vistaActualizarPerfilUsuario();
                    updateClient.setVisible(true);
                    updateClient.setLocationRelativeTo(null);
                    ActualizarPerfilUsuario.actualizarCliente(updateClient, hireService.getLblNombreUsu().getText());

                    updateClient.getBtnRegresar().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            updateClient.dispose();
                            hireService.setVisible(true);
                            hireService.setLocationRelativeTo(null);
                        }
                    });
                }
            }
        });

        hireService.getJmiCerrarSesion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                String textoMenuItem = menuItem.getText();

                if ((textoMenuItem.equals("Cerrar sesion"))) {
                    // ACA SE LLAMA A LA VISTA DE CIERRE DE SESION Y A LA CLASE QUE CONTIENE LA LOGICA
                    // Mensaje de confirmación con opciones Si/No
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

                    // Verificamos la opción seleccionada por el usuario
                    if (opcion == JOptionPane.YES_OPTION) {
                        System.out.println("El usuario ha seleccionado 'Sí'");
                        hireService.dispose();
                        landingPage lp;
                        lp = new landingPage();
                        lp.setVisible(true);
                        lp.setLocationRelativeTo(null);
                    }
                }
            }
        });
    }

    // FIN CONTRATAR SERVICIO 1
    public static void seleccionerVista(vistaContratarServicio2 hireService) {
        hireService.getJmiEditarPerfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                String textoMenuItem = menuItem.getText();

                if (textoMenuItem.equals("Editar perfil")) {
                    hireService.dispose();
                    vistaActualizarPerfilUsuario updateClient = new vistaActualizarPerfilUsuario();
                    updateClient.setVisible(true);
                    updateClient.setLocationRelativeTo(null);
                    ActualizarPerfilUsuario.actualizarCliente(updateClient, hireService.getLblNombreUsu().getText());

                    updateClient.getBtnRegresar().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            updateClient.dispose();
                            hireService.setVisible(true);
                            hireService.setLocationRelativeTo(null);
                        }
                    });
                }
            }
        });

        hireService.getJmiCerrarSesion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                String textoMenuItem = menuItem.getText();

                if ((textoMenuItem.equals("Cerrar sesion"))) {
                    // ACA SE LLAMA A LA VISTA DE CIERRE DE SESION Y A LA CLASE QUE CONTIENE LA LOGICA
                    // Mensaje de confirmación con opciones Si/No
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

                    // Verificamos la opción seleccionada por el usuario
                    if (opcion == JOptionPane.YES_OPTION) {
                        System.out.println("El usuario ha seleccionado 'Sí'");
                        hireService.dispose();
                        landingPage lp;
                        lp = new landingPage();
                        lp.setVisible(true);
                        lp.setLocationRelativeTo(null);
                    }
                }
            }
        });
    }

    // FIN CONTRATAR SERVICIO 2
    public static void seleccionerVista(vistaContratarServicio3 hireService) {
        hireService.getJmiEditarPerfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                String textoMenuItem = menuItem.getText();

                if (textoMenuItem.equals("Editar perfil")) {
                    hireService.dispose();
                    vistaActualizarPerfilUsuario updateClient = new vistaActualizarPerfilUsuario();
                    updateClient.setVisible(true);
                    updateClient.setLocationRelativeTo(null);
                    ActualizarPerfilUsuario.actualizarCliente(updateClient, hireService.getLblNombreUsu().getText());

                    updateClient.getBtnRegresar().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            updateClient.dispose();
                            hireService.setVisible(true);
                            hireService.setLocationRelativeTo(null);
                        }
                    });
                }
            }
        });

        hireService.getJmiCerrarSesion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                String textoMenuItem = menuItem.getText();

                if ((textoMenuItem.equals("Cerrar sesion"))) {
                    // ACA SE LLAMA A LA VISTA DE CIERRE DE SESION Y A LA CLASE QUE CONTIENE LA LOGICA
                    // Mensaje de confirmación con opciones Si/No
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

                    // Verificamos la opción seleccionada por el usuario
                    if (opcion == JOptionPane.YES_OPTION) {
                        System.out.println("El usuario ha seleccionado 'Sí'");
                        hireService.dispose();
                        landingPage lp;
                        lp = new landingPage();
                        lp.setVisible(true);
                        lp.setLocationRelativeTo(null);
                    }
                }
            }
        });

    }

    // FIN CONTRATAR SERVICIO 3
    public static void seleccionerVista(vistaVerInfoEmpleado viewEmpleado) {
        viewEmpleado.getJmiEditarPerfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                String textoMenuItem = menuItem.getText();

                if (textoMenuItem.equals("Editar perfil")) {
                    viewEmpleado.dispose();
                    vistaActualizarPerfilUsuario updateClient = new vistaActualizarPerfilUsuario();
                    updateClient.setVisible(true);
                    updateClient.setLocationRelativeTo(null);
                    ActualizarPerfilUsuario.actualizarCliente(updateClient, viewEmpleado.getLblNombreUsu().getText());

                    updateClient.getBtnRegresar().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            updateClient.dispose();
                            viewEmpleado.setVisible(true);
                            viewEmpleado.setLocationRelativeTo(null);
                        }
                    });
                }
            }
        });

        viewEmpleado.getJmiCerrarSesion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                String textoMenuItem = menuItem.getText();

                if ((textoMenuItem.equals("Cerrar sesion"))) {
                    // ACA SE LLAMA A LA VISTA DE CIERRE DE SESION Y A LA CLASE QUE CONTIENE LA LOGICA
                    // Mensaje de confirmación con opciones Si/No
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

                    // Verificamos la opción seleccionada por el usuario
                    if (opcion == JOptionPane.YES_OPTION) {
                        System.out.println("El usuario ha seleccionado 'Sí'");
                        viewEmpleado.dispose();
                        landingPage lp;
                        lp = new landingPage();
                        lp.setVisible(true);
                        lp.setLocationRelativeTo(null);
                    }
                }
            }
        });
    }

    // FIN CONTACTAR EMPLEADO
}
