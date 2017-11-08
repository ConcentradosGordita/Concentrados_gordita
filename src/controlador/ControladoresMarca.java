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
import modelo.Marca;

/**
 *
 * @author kamt
 */
public class ControladoresMarca implements OperacionesMarca{

    @Override
    public String agregarMarca(Object objeto) {
       Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Marca mrc= (Marca) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="insert into marca values("+mrc.getId_marca()
                +",'"+mrc.getNombre_marca()
                +"')";
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "El Nuevo marca se a ingresado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String modificarMarca(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Marca mrc= (Marca) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="update marca set nombre_marca='"+mrc.getNombre_marca()
                +"' where id_marca="+mrc.getId_marca();
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "La  marca se a modificado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String eliminarMarca(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    Statement pst;
    String sql;
    String mensaje= null;
    Marca mrc= (Marca) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="delete from marca where id_marca="+mrc.getId_marca();
        pst=cn.prepareStatement(sql);
        pst.execute(sql);
        pst.close();
        cn.close();
        mensaje= "La marca se a eliminado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public ArrayList<Object> mostrarMarca() {
        Conexion con=new Conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        String sql;
        ArrayList<Object> listaMarca = new ArrayList<>();
        try {

            Class.forName(con.getDriver());
            cn = DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
            sql = "select * from marca";
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                listaMarca.add(new Marca(
                      rs.getInt("id_marca"),
                      rs.getString("nombre_marca")
                      
                ));

            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            System.out.print(e);

        }
        return listaMarca;
    }
    
}
