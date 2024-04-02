
package com.Lumina.proyectolumina.logica.modeloProductos;

import java.util.ArrayList;


public class Productos {
    
    private String nombre;
    private String fabricante;
    private String descripcion;
    private ArrayList<Categorias> categoria;
    private int stock;
    private int unidVendidas;

    public Productos(String nombre, String fabricante, String descripcion, ArrayList<Categorias> categoria, int stock, int unidVendidas) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.stock = stock;
        this.unidVendidas = unidVendidas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Categorias> getCategoria() {
        return categoria;
    }

    public int getStock() {
        return stock;
    }

    public int getUnidVendidas() {
        return unidVendidas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(ArrayList<Categorias> categoria) {
        this.categoria = categoria;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setUnidVendidas(int unidVendidas) {
        this.unidVendidas = unidVendidas;
    }
    
    
}
