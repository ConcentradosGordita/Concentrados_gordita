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
import modelo.Ventas;

/**
 *
 * @author kamt
 */
public class ControladoresVentas implements OperacionesVentas{

    @Override
    public String agregarVentas(Object objeto) {
       Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Ventas vent= (Ventas) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="insert into ventas values("+vent.getNum_venta()
                +",'"+vent.getNombre_prod()
                +"',"+vent.getPrecio_prod()
                +","+vent.getCantidad_prod()
                +",'"+vent.getForma_pago()
                +"',"+vent.getImpuesto_IVA()
                +",'"+vent.getDescuento()
                +"',"+vent.getId_cliente()
                +","+vent.getId_empleado()
                +","+vent.getId_producto()
                +","+vent.getId_fact()+")";
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "El Nuevo ventas se a ingresado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String modificarVentas(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Ventas vent= (Ventas) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="update ventas set nombre_prod='"+vent.getNombre_prod()
                +"',precio_prod="+vent.getPrecio_prod()
                +",cantidad_prod ="+vent.getCantidad_prod()
                +",forma_pago='"+vent.getForma_pago()
                +"',impuesto_IVA="+vent.getImpuesto_IVA()
                +",descuento='"+vent.getDescuento()
                +"',id_cliente="+vent.getId_cliente()
                +",id_empleado="+vent.getId_empleado()
                +",id_producto="+vent.getId_producto()
                +",id_fact int="+vent.getId_fact()
                +"where num_venta="+vent.getNum_venta();
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "La venta se a modificado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String eliminarVentas(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    Statement pst;
    String sql;
    String mensaje= null;
    Ventas vent= (Ventas) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="delete from ventas where num_venta="+vent.getNum_venta();
        pst=cn.prepareStatement(sql);
        pst.execute(sql);
        pst.close();
        cn.close();
        mensaje= "La venta se a eliminado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public ArrayList<Object> mostrarVentas() {
       Conexion con=new Conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        String sql;
        ArrayList<Object> listaVentas = new ArrayList<>();
        try {

            Class.forName(con.getDriver());
            cn = DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
            sql = "select * from celulares";
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                listaVentas.add(new Ventas(
                      rs.getInt("num_venta"),
                      rs.getString("nombre_prod"),
                      rs.getDouble("precio_prod"),
                      rs.getInt("cantidad_prod"),
                      rs.getString("forma_pago"),
                      rs.getDouble("impuesto_IVA"),
                      rs.getString("descuento"),
                      rs.getInt("id_cliente"),
                      rs.getInt("id_empleado"),
                      rs.getInt("id_producto"),
                      rs.getInt("id_fact")
                      
                      
                ));

            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            System.out.print(e);

        }
        return listaVentas;
    }
    
}
