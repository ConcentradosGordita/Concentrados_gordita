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
import modelo.Proveedor;

/**
 *
 * @author kamt
 */
public class ControladoresProveedor implements OperacionesProveedor{

    @Override
    public String agregarProveedor(Object objeto) {
       Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Proveedor prov= (Proveedor) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="insert into proveedor values('"+prov.getId_proveedor()
                +"','"+prov.getNombre_proveedor()
                +"','"+prov.getTelefono_empresa()
                +"','"+prov.getNombre_empresa()
                +"')";
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "El Proveedor  se a ingresado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String modificarProveedor(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
     Proveedor prov= (Proveedor) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="update proveedor set nombre_proveedor='"+prov.getNombre_proveedor()
                +"',telefono_empresa='"+prov.getTelefono_empresa()
                +"',nombre_empresa='"+prov.getNombre_empresa()
                +"' where id_proveedor='"+prov.getId_proveedor()+"'";
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "El  Proveedor se a modificado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String eliminarProveedor(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    Statement pst;
    String sql;
    String mensaje= null;
    Proveedor prov= (Proveedor) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="delete from proveedor where id_proveedor='"+prov.getId_proveedor()+"'";
        pst=cn.prepareStatement(sql);
        pst.execute(sql);
        pst.close();
        cn.close();
        mensaje= "El  proveedor se a eliminado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public ArrayList<Object> mostrarProveedor() {
        Conexion con=new Conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        String sql;
        ArrayList<Object> listaProveedor = new ArrayList<>();
        try {

            Class.forName(con.getDriver());
            cn = DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
            sql = "select * from proveedor";
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                listaProveedor.add(new Proveedor(
                      
                      rs.getString("id_proveedor"),
                      rs.getString("nombre_proveedor"),
                      rs.getString("telefono_empresa"),
                      rs.getString("nombre_empresa")
                       
                ));

            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            System.out.print(e);

        }
        return listaProveedor;
    }
    
}
