/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseslagordita;

/**
 *
 * @author kamt
 */

public class Proveedor {
    private String id_proveedor;
    private String nombre_proveedor;
    private String telefono_empresa;
    private String nombre_empresa;

    public Proveedor(String id_proveedor, String nombre_proveedor, String telefono_empresa, String nombre_empresa) {
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.telefono_empresa = telefono_empresa;
        this.nombre_empresa = nombre_empresa;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getTelefono_empresa() {
        return telefono_empresa;
    }

    public void setTelefono_empresa(String telefono_empresa) {
        this.telefono_empresa = telefono_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public Proveedor() {
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id_proveedor=" + id_proveedor + ", nombre_proveedor=" + nombre_proveedor + ", telefono_empresa=" + telefono_empresa + ", nombre_empresa=" + nombre_empresa + '}';
    }
}
