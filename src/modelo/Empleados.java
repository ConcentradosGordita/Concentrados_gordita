/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author kamt
 */

public class Empleados {
    private int id_empleado;
    private String nombre_emp;
    private String apellido_emp;
    private String cargo_emp;
    private double salario;
    private String telefono;
    private int id_sucursal;
    private String nombre_us ;
    private String cod_us;
    private int nivel_us ;

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_emp() {
        return nombre_emp;
    }

    public void setNombre_emp(String nombre_emp) {
        this.nombre_emp = nombre_emp;
    }

    public String getApellido_emp() {
        return apellido_emp;
    }

    public void setApellido_emp(String apellido_emp) {
        this.apellido_emp = apellido_emp;
    }

    public String getCargo_emp() {
        return cargo_emp;
    }

    public void setCargo_emp(String cargo_emp) {
        this.cargo_emp = cargo_emp;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombre_us() {
        return nombre_us;
    }

    public void setNombre_us(String nombre_us) {
        this.nombre_us = nombre_us;
    }

    public String getCod_us() {
        return cod_us;
    }

    public void setCod_us(String cod_us) {
        this.cod_us = cod_us;
    }

    public int getNivel_us() {
        return nivel_us;
    }

    public void setNivel_us(int nivel_us) {
        this.nivel_us = nivel_us;
    }

    public Empleados() {
    }

    public Empleados(int id_empleado, String nombre_emp, String apellido_emp, String cargo_emp, double salario, String telefono, int id_sucursal, String nombre_us, String cod_us, int nivel_us) {
        this.id_empleado = id_empleado;
        this.nombre_emp = nombre_emp;
        this.apellido_emp = apellido_emp;
        this.cargo_emp = cargo_emp;
        this.salario = salario;
        this.telefono = telefono;
        this.id_sucursal = id_sucursal;
        this.nombre_us = nombre_us;
        this.cod_us = cod_us;
        this.nivel_us = nivel_us;
    }

    @Override
    public String toString() {
        return "Empleados{" + "id_empleado=" + id_empleado + ", nombre_emp=" + nombre_emp + ", apellido_emp=" + apellido_emp + ", cargo_emp=" + cargo_emp + ", salario=" + salario + ", telefono=" + telefono + ", id_sucursal=" + id_sucursal + ", nombre_us=" + nombre_us + ", cod_us=" + cod_us + ", nivel_us=" + nivel_us + '}';
    }
    
}