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
import modelo.Inventario_tienda;

/**
 *
 * @author kamt
 */
public class ControladoresInventario_tienda implements OperacionesInventario_tienda{

    @Override
    public String agregarInventario_tienda(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Inventario_tienda iti= (Inventario_tienda) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="insert into inventario_tienda values('"+iti.getNombre_producto()
                +"','"+iti.getMarca_producto()
                +"','"+iti.getCatego_producto()
                +"',"+iti.getId_producto()
                +",'"+iti.getId_proveedor()
                +"',"+iti.getStock()+")";
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "El Nuevo inventario se a ingresado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String modificarInventario_tienda(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Inventario_tienda iti= (Inventario_tienda) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="update inventario_tienda set nombre_producto='"+iti.getNombre_producto()
                +"',marca_producto='"+iti.getMarca_producto()+"',catego_producto ='"+iti.getCatego_producto()
                +"',id_proveedor='"+iti.getId_proveedor()+"',stock="+iti.getStock()+" where id_producto="+iti.getId_producto();
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "El  inventario se a modificado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String eliminarInventario_tienda(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    Statement pst;
    String sql;
    String mensaje= null;
    Inventario_tienda iti= (Inventario_tienda) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="delete from inventario_tienda where codCelular="+iti.getId_producto();
        pst=cn.prepareStatement(sql);
        pst.execute(sql);
        pst.close();
        cn.close();
        mensaje= "El  inventario se a eliminado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    
    }

    @Override
    public ArrayList<Object> mostrarInventario_tienda() {
        Conexion con=new Conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        String sql;
        ArrayList<Object> listainventario_tienda = new ArrayList<>();
        try {

            Class.forName(con.getDriver());
            cn = DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
            sql = "select * from inventario_tienda";
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                listainventario_tienda.add(new Inventario_tienda(
                      rs.getString("nombre_producto"),
                      rs.getString("marca_producto"),
                      rs.getString("catego_producto"),
                      rs.getInt("id_producto"),
                      rs.getString("id_proveedor"),
                      rs.getInt("stock")
                ));

            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            System.out.print(e);

        }
        return listainventario_tienda;
    }
    
}
