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
import modelo.Producto;

/**
 *
 * @author kamt
 */
public class ControladoresProducto implements OperacionesProducto{

    @Override
    public String agregarProducto(Object objeto) {
       Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Producto pro= (Producto) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="insert into producto values("+pro.getId_producto()
                +",'"+pro.getNombre_prod()
                +"','"+pro.getFecha_lab()
                +"','"+pro.getFecha_venc()
                +"',"+pro.getCod_barras()
                +","+pro.getPrecio_prod()
                +","+pro.getUnidades_exsistencias()
                +",'"+pro.getId_proveedor()
                +"','"+pro.getId_categoria()
                +"',"+pro.getId_marca()+")";
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "El Nuevo producto se a ingresado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String modificarProducto(Object objeto) {
       Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Producto pro= (Producto) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="update producto set nombre_prod='"+pro.getNombre_prod()
                +"',fecha_lab='"+pro.getFecha_lab()
                +"',fecha_venc ='"+pro.getFecha_venc()
                +"',cod_barras="+pro.getCod_barras()
                +",precio_prod="+pro.getPrecio_prod()
                +",unidades_exsistencias="+pro.getUnidades_exsistencias()
                +",id_proveedor='"+pro.getId_proveedor()
                +"',id_categoria ='"+pro.getId_categoria()
                +"',id_marca="+pro.getId_marca()
                +" where id_producto = "+pro.getId_producto();
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "El  producto se a modificado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String eliminarProducto(Object objeto) {
       Conexion con=new Conexion();
    Connection cn;
    Statement pst;
    String sql;
    String mensaje= null;
    Producto pro= (Producto) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="delete from producto where id_producto="+pro.getId_producto();
        pst=cn.prepareStatement(sql);
        pst.execute(sql);
        pst.close();
        cn.close();
        mensaje= "El  producto se a eliminado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public ArrayList<Object> mostrarProducto() {
        Conexion con=new Conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        String sql;
        ArrayList<Object> listaProduct = new ArrayList<>();
        try {

            Class.forName(con.getDriver());
            cn = DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
            sql = "select * from producto";
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                listaProduct.add(new Producto(
                      rs.getInt("id_producto"),
                      rs.getString("nombre_prod"),
                      rs.getString("fecha_lab"),
                      rs.getString("fecha_venc"),
                      rs.getInt("cod_barras"),
                      rs.getDouble("precio_prod"),
                      rs.getInt("unidades_exsistencias"),
                      rs.getString("id_proveedor"),
                      rs.getString("id_categoria"),
                      rs.getInt("id_marca")
                ));

            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            System.out.print(e);

        }
        return listaProduct;
    }
    
}
