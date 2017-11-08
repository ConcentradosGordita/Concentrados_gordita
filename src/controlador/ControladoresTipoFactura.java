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
import modelo.Tipo_factura;

/**
 *
 * @author kamt
 */
public class ControladoresTipoFactura implements OperacionesTipoFactura{

    @Override
    public String agregarTipoFactura(Object objeto) {
       Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Tipo_factura tipf= (Tipo_factura) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="insert into tipo_factura values("+tipf.getId_fact()
                +",'"+tipf.getFecha_fact()
                +"','"+tipf.getTipo_pago()
                +"',"+tipf.getCantidad()
                +","+tipf.getTotal()
                +" , '"+tipf.getNom_cliente()+"') ";
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "El Nuevo tipo de factura se a ingresado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String modificarTipoFactura(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Tipo_factura tipf= (Tipo_factura) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="update tipo_factura set fecha_fact='"+tipf.getFecha_fact()
                +"',tipo_pago='"+tipf.getTipo_pago()
                +"',cantidad ="+tipf.getCantidad()
                +",total="+tipf.getTotal()
                +",nom_cliente='"+tipf.getNom_cliente()
                +"' where id_fact="+tipf.getId_fact();
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "El  tipo de factura se a modificado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String eliminarTipoFactura(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    Statement pst;
    String sql;
    String mensaje= null;
    Tipo_factura tipf= (Tipo_factura) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="delete from tipo_factura where id_fact="+tipf.getId_fact();
        pst=cn.prepareStatement(sql);
        pst.execute(sql);
        pst.close();
        cn.close();
        mensaje= "El  tipo de factura se a eliminado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public ArrayList<Object> mostrarTipoFactura() {
        Conexion con=new Conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        String sql;
        ArrayList<Object> listaTipo_factura = new ArrayList<>();
        try {

            Class.forName(con.getDriver());
            cn = DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
            sql = "select * from tipo_factura";
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                listaTipo_factura.add(new Tipo_factura(
                      rs.getInt("id_fact"),
                      rs.getString("fecha_fact"),
                      rs.getString("tipo_pago"),
                      rs.getInt("cantidad"),
                      rs.getInt("total"),
                      rs.getString("nom_cliente")
                      
                ));

            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            System.out.print(e);

        }
        return listaTipo_factura;
    }
    
}
