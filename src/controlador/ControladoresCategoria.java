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
import modelo.Categoria;

/**
 *
 * @author kamt
 */
public class ControladoresCategoria implements OperacionesCategoria{

    @Override
    public String agregarCategoria(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Categoria cat= (Categoria) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="insert into categoria values("+cat.getId_categoria()
                +",'"+cat.getDescripcion_categoria()+
                "')";
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "El Nueva categoria se a ingresado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String modificarCategoria(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Categoria cat= (Categoria) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="update categoria set descripcion_categoria='"+cat.getDescripcion_categoria()
                +"' where id_categoria="+cat.getId_categoria();
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "La categoria se a modificado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String eliminarCategoria(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    Statement pst;
    String sql;
    String mensaje= null;
    Categoria cat= (Categoria) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="delete from categoria where id_categoria="+cat.getId_categoria();
        pst=cn.prepareStatement(sql);
        pst.execute(sql);
        pst.close();
        cn.close();
        mensaje= "La categoria se a eliminado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public ArrayList<Object> mostrarCategoria() {
        Conexion con=new Conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        String sql;
        ArrayList<Object> listaCategoria = new ArrayList<>();
        try {

            Class.forName(con.getDriver());
            cn = DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
            sql = "select * from categoria";
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                listaCategoria.add(new Categoria(
                      rs.getString("id_categoria"),
                      rs.getString("descripcion_categoria")                     
                ));

            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            System.out.print(e);

        }
        return listaCategoria;
    }
    
}
