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
import modelo.Tienda;

/**
 *
 * @author kamt
 */
public class ControladoresTienda implements OperacionesTienda{

    @Override
    public String agregarTienda(Object objeto) {
       Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Tienda tien= (Tienda) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="insert into tienda values("+tien.getId_tienda()
                +",'"+tien.getNombre_tienda()
                +"','"+tien.getDireccion_tienda()
                +"','"+tien.getPais_tienda()
                +"','"+tien.getTelefono_suc()+"')";
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "la Nueva tienda se a ingresado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String modificarTienda(Object objeto) {
       Conexion con=new Conexion();
    Connection cn;
    PreparedStatement pst;
    String sql;
    String mensaje= null;
    Tienda tien= (Tienda) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="update tienda set nombre_tienda='"+tien.getNombre_tienda()
                +"',direccion_tienda='"+tien.getDireccion_tienda()
                +"',pais_tienda ='"+tien.getPais_tienda()
                +"',telefono_suc='"+tien.getTelefono_suc()
                +"' where id_tienda="+tien.getId_tienda();
        pst=cn.prepareStatement(sql);
        pst.execute();
        pst.close();
        cn.close();
        mensaje= "La tienda se a modificado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public String eliminarTienda(Object objeto) {
        Conexion con=new Conexion();
    Connection cn;
    Statement pst;
    String sql;
    String mensaje= null;
    Tienda tien= (Tienda) objeto;
    try{
        Class.forName(con.getDriver());
        cn=DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
        sql="delete from tienda where id_tienda="+tien.getId_tienda();
        pst=cn.prepareStatement(sql);
        pst.execute(sql);
        pst.close();
        cn.close();
        mensaje= "El  celular se a eliminado correctamente";
        
    }catch(Exception e){
        mensaje= e.toString();     
    }
    return mensaje;
    }

    @Override
    public ArrayList<Object> mostrarTienda() {
         Conexion con=new Conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        String sql;
        ArrayList<Object> listaTienda = new ArrayList<>();
        try {

            Class.forName(con.getDriver());
            cn = DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
            sql = "select * from tienda";
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                listaTienda.add(new Tienda(
                      rs.getInt("id_tienda"),
                      rs.getString("nombre_tienda"),
                      rs.getString("direccion_tienda"),
                      rs.getString("pais_tienda"),
                      rs.getString("telefono_suc")
                       
                ));

            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            System.out.print(e);

        }
        return listaTienda;
    }
    
}
