/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseslagordita;

/**
 *
 * @author kamt
 */

public class Empleados {
    private int id_empleado;
    private String nombre_emp;
    private String apellido_emp;
    private String cargo_emp;
    private float salario;
    private String telefono;
    private int id_sucursal;

    public Empleados(int id_empleado, String nombre_emp, String apellido_emp, String cargo_emp, float salario, String telefono, int id_sucursal) {
        this.id_empleado = id_empleado;
        this.nombre_emp = nombre_emp;
        this.apellido_emp = apellido_emp;
        this.cargo_emp = cargo_emp;
        this.salario = salario;
        this.telefono = telefono;
        this.id_sucursal = id_sucursal;
    }

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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
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

    public Empleados() {
    }

    @Override
    public String toString() {
        return "Empleados{" + "id_empleado=" + id_empleado + ", nombre_emp=" + nombre_emp + ", apellido_emp=" + apellido_emp + ", cargo_emp=" + cargo_emp + ", salario=" + salario + ", telefono=" + telefono + ", id_sucursal=" + id_sucursal + '}';
    }
    
    
    
}
