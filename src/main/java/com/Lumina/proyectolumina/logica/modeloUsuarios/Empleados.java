
package com.Lumina.proyectolumina.logica.modeloUsuarios;

import java.sql.Date;


public class Empleados extends Personas{
    
    private int idEmpleado;
    private String cargo;
    private double salario;
    private Date fechaIngreso;
    

    public Empleados(int idEmpleado, String cargo, double salario, Date fechaIngreso, String nombre, String telefono, String correo, String direccion) {
        super(nombre, telefono, correo, direccion);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
    }
    
    public int getIdEmpleado() {
        return idEmpleado;
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
    
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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
