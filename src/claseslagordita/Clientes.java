
package claseslagordita;
/*
(id_cliente int primary key,
nombre_cliente varchar(60) not null,
direccion_cliente varchar(100)not null,
numero_tarjeta varchar(20) null,
telefono_cliente varchar(20) not null,
);

*/


public class Clientes {
    
    private int id_cliente;
    private String nombre_cliente;
    private String direccion_cliente;
    private String numero_tarjeta;
    private String telefono_cliente;

    
    
    public Clientes(int id_cliente, String nombre_cliente, String direccion_cliente, String numero_tarjeta, String telefono_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.direccion_cliente = direccion_cliente;
        this.numero_tarjeta = numero_tarjeta;
        this.telefono_cliente = telefono_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public Clientes() {
    }

    @Override
    public String toString() {
        return "Clientes{" + "id_cliente=" + id_cliente + ", nombre_cliente=" + nombre_cliente + ", direccion_cliente=" + direccion_cliente + ", numero_tarjeta=" + numero_tarjeta + ", telefono_cliente=" + telefono_cliente + '}';
    }
    
    
    
    
    
}
