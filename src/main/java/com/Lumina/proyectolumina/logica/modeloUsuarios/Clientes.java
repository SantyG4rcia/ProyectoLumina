
package com.Lumina.proyectolumina.logica.modeloUsuarios;

import java.sql.Date;


public class Clientes extends Personas{
    private int idCliente;
    private boolean estado;
    private Date activoDeste;

    public Clientes(int idCliente, boolean estado, Date activoDeste, String nombre, String telefono, String correo, String direccion) {
        super(nombre, telefono, correo, direccion);
        this.idCliente = idCliente;
        this.estado = estado;
        this.activoDeste = activoDeste;
    }
    
    public int getIdCliente(){
        return idCliente;
    }

    public boolean isEstado() {
        return estado;
    }

    public Date getActivoDeste() {
        return activoDeste;
    }
    
    public void setIdCliente(int idCliente){
        this.idCliente = idCliente;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setActivoDeste(Date activoDeste) {
        this.activoDeste = activoDeste;
    }
    
    
    
}
