/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author evilnapsis
 */
public class Db {
    public static Connection connection;
    public static Connection connect(){
    String url = "jdbc:mysql://localhost:3306/lagordita";
    String user = "root";
    String pass = "";
    System.out.println("Conectando...");
    try{
         connection = DriverManager.getConnection(url, user,pass);
    
        
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    return connection;
    }
    
}
