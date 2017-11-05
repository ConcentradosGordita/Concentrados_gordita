/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

/**
 *
 * @author kamt
 */
public class Conexion {
    private String driver;
    private String db;
    private String url;
    private String usuario;
    private String clave;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Conexion() {
        
        driver ="com.mysql.jdbc.Driver";
        db="lagordita";
        url="jdbc:mysql://localhost:3306/" + db;
        usuario = "pma";
        clave = "";
    }

    public Conexion(String driver, String db, String url, String usuario, String clave) {
        this.driver = driver;
        this.db = db;
        this.url = url;
        this.usuario = usuario;
        this.clave = clave;
    }
    
    
}
