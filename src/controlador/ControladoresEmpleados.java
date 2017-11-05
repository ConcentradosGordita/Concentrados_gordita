/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Empleados;

/**
 *
 * @author kamt
 */
public class ControladoresEmpleados implements OperacionesEmpleados{

    @Override
    public String agregarEmpleados(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Empleados emp= (Empleados) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="insert into empleados values("+emp.getId_empleado()
                +",'"+emp.getNombre_emp()
                +"','"+emp.getApellido_emp()
                +"','"+emp.getCargo_emp()
                +"',"+emp.getSalario()
                +",'"+emp.getTelefono()
                +"',"+emp.getId_sucursal()
                +",'"+emp.getNombre_us()
                +"','"+emp.getCod_us()
                +"',"+emp.getNivel_us()+")";
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "El Nuevo empleado se a ingresado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String modificarEmpleados(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Empleados emp= (Empleados) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="update empleados set nombre_emp='"+emp.getNombre_emp()+"',apellido_emp='"+emp.getApellido_emp()
                +"',cargo_emp='"+emp.getCargo_emp()+"',salario ="+emp.getSalario()
                +",telefono='"+emp.getTelefono()+"',id_sucursal ="+emp.getId_sucursal()
                +",nombre_us='"+emp.getNombre_us()+"',cod_us ='"+emp.getCod_us()
                +"',nivel_us="+emp.getNivel_us()+"where id_empleado="+emp.getId_empleado();
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "El  celular se a modificado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String eliminarEmpleados(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    Statement pst;
    String sql;
    String mensaje= null;
    Empleados emp= (Empleados) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="delete from empleados where id_empleado="+emp.getId_empleado();
        pst=cn.prepareStatement(sql);
        pst.execute(sql);
        pst.close();
        cn.close();
        mensaje= "El  empleado se a eliminado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public ArrayList<Object> mostrarEmpleados() {
        Conexion con=new Conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        String sql;
        ArrayList<Object> listaEmpleados = new ArrayList<>();
        try {

            Class.forName(con.getDriver());
            cn = DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
            sql = "select * from empleados";
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                listaEmpleados.add(new Empleados(
                      rs.getInt("id_empleado"),
                      rs.getString("nombre_emp"),
                      rs.getString("apellido_emp"),
                      rs.getString("cargo_emp"),
                      rs.getDouble("salario"),
                      rs.getString("telefono"),
                      rs.getInt("id_sucursal"),
                      rs.getString("nombre_us"),
                      rs.getString("cod_us"),
                      rs.getInt("nivel_us")
                     
                ));

            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            System.out.print(e);

        }
        return listaEmpleados;
    }
    
}
