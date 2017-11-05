/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author kamt
 */
public class Inventario_tienda {
    
    private String nombre_producto;
    private String marca_producto;
    private String catego_producto;
    private int id_producto;
    private String id_proveedor;
    private int stock;

    public Inventario_tienda(String nombre_producto, String marca_producto, String catego_producto, int id_producto, String id_proveedor, int stock) {
        this.nombre_producto = nombre_producto;
        this.marca_producto = marca_producto;
        this.catego_producto = catego_producto;
        this.id_producto = id_producto;
        this.id_proveedor = id_proveedor;
        this.stock = stock;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getMarca_producto() {
        return marca_producto;
    }

    public void setMarca_producto(String marca_producto) {
        this.marca_producto = marca_producto;
    }

    public String getCatego_producto() {
        return catego_producto;
    }

    public void setCatego_producto(String catego_producto) {
        this.catego_producto = catego_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Inventario_tienda() {
    }

    @Override
    public String toString() {
        return "Inventario_tienda{" + "nombre_producto=" + nombre_producto + ", marca_producto=" + marca_producto + ", catego_producto=" + catego_producto + ", id_producto=" + id_producto + ", id_proveedor=" + id_proveedor + ", stock=" + stock + '}';
    }
    
    
}
