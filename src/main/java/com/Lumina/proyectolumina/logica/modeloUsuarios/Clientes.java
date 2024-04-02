
package com.Lumina.proyectolumina.logica.modeloUsuarios;

import java.sql.Date;


public class Clientes extends Personas{
    private boolean estado;
    private Date activoDeste;

    public Clientes(boolean estado, Date activoDeste, String nombre, String telefono, String correo, String direccion) {
        super(nombre, telefono, correo, direccion);
        this.estado = estado;
        this.activoDeste = activoDeste;
    }

    public boolean isEstado() {
        return estado;
    }

    public Date getActivoDeste() {
        return activoDeste;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setActivoDeste(Date activoDeste) {
        this.activoDeste = activoDeste;
    }
    
    
    
}
