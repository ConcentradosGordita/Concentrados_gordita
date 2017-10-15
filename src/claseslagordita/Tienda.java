
package claseslagordita;
/**
 *
 * @author kamt
 */
public class Tienda {
  
    private int id_tienda;
    private String nombre_tienda;
    private String direccion_tienda;
    private String pais_tienda;
    private String telefono_suc;
    
    
    
    

    public Tienda(int id_tienda, String nombre_tienda, String direccion_tienda, String pais_tienda, String telefono_suc) {
        this.id_tienda = id_tienda;
        this.nombre_tienda = nombre_tienda;
        this.direccion_tienda = direccion_tienda;
        this.pais_tienda = pais_tienda;
        this.telefono_suc = telefono_suc;
    }

    
    
    
    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public String getNombre_tienda() {
        return nombre_tienda;
    }

    public void setNombre_tienda(String nombre_tienda) {
        this.nombre_tienda = nombre_tienda;
    }

    public String getDireccion_tienda() {
        return direccion_tienda;
    }

    public void setDireccion_tienda(String direccion_tienda) {
        this.direccion_tienda = direccion_tienda;
    }

    public String getPais_tienda() {
        return pais_tienda;
    }

    public void setPais_tienda(String pais_tienda) {
        this.pais_tienda = pais_tienda;
    }

    public String getTelefono_suc() {
        return telefono_suc;
    }

    public void setTelefono_suc(String telefono_suc) {
        this.telefono_suc = telefono_suc;
    }

    
    
    
    public Tienda() {
    }

    @Override
    public String toString() {
        return "Tienda{" + "id_tienda=" + id_tienda + ", nombre_tienda=" + nombre_tienda + ", direccion_tienda=" + direccion_tienda + ", pais_tienda=" + pais_tienda + ", telefono_suc=" + telefono_suc + '}';
    }

    
    
    
    
 
    
    
}
