
package com.Lumina.proyectolumina.logica.modeloProductos;


public class Categorias {
    
    private int idCategoria;
    private String nombre;
    private boolean estado;
    private String descripcion;

    public Categorias(int idCategoria, String nombre, boolean estado, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
