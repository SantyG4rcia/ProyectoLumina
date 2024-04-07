
package com.Lumina.proyectolumina.logica.modeloProductos;

import java.util.ArrayList;


public class Productos {
    
    private String nombre;
    private String descripcion;
    private ArrayList<Categorias> categoria;
    private int idProducto;
    

    public Productos(String nombre, String descripcion, ArrayList<Categorias> categoria, int idProducto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Categorias> getCategoria() {
        return categoria;
    }

    public int getIdProducto() {
        return idProducto;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(ArrayList<Categorias> categoria) {
        this.categoria = categoria;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

}
