
package com.Lumina.proyectolumina.logica.modeloUsuarios;

import java.sql.Date;


public class Empleados extends Personas{
    
    private String cargo;
    private double salario;
    private Date fechaIngreso;
    

    public Empleados(String cargo, double salario, Date fechaIngreso, String nombre, String telefono, String correo, String direccion) {
        super(nombre, telefono, correo, direccion);
        this.cargo = cargo;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    
}
