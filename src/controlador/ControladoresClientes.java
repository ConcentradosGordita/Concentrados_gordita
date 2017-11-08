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
import modelo.Clientes;

/**
 *
 * @author kamt
 */
public class ControladoresClientes implements OperacionesClientes{

    @Override
    public String agregarClientes(Object objeto) {
        
    Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Clientes cli= (Clientes) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="insert into clientes values("+cli.getId_cliente()
                +",'"+cli.getNombre_cliente()
                +"','"+cli.getDireccion_cliente()+"','"+cli.getNumero_tarjeta()
                +"','"+cli.getTelefono_cliente()+"')";
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "El Nuevo cliente se a ingresado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String modificarClientes(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Clientes cli= (Clientes) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="update clientes set nombre_cliente='"+cli.getNombre_cliente()
                +"',direccion_cliente='"+cli.getDireccion_cliente()+"',numero_tarjeta ='"+cli.getNumero_tarjeta()
                +"',telefono_cliente='"+cli.getTelefono_cliente()+"' where id_cliente="+cli.getId_cliente();
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "El  cliente se a modificado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String eliminarClientes(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    Statement pst;
    String sql;
    String mensaje= null;
    Clientes cli= (Clientes) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="delete from clientes where id_cliente="+cli.getId_cliente();
        pst=cn.prepareStatement(sql);
        pst.execute(sql);
        pst.close();
        cn.close();
        mensaje= "El  cliente se a eliminado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public ArrayList<Object> mostrarClientes() {
        Conexion con=new Conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        String sql;
        ArrayList<Object> listaClientes = new ArrayList<>();
        try {

            Class.forName(con.getDriver());
            cn = DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
            sql = "select * from clientes";
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                listaClientes.add(new Clientes(
                      rs.getInt("id_cliente"),
                      rs.getString("nombre_cliente"),
                      rs.getString("direccion_cliente"),
                      rs.getString("numero_tarjeta"),
                      rs.getString("telefono_cliente")
                ));

            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            System.out.print(e);

        }
        return listaClientes;
    }
    
}
