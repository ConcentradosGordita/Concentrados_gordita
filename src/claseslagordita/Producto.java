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


public class Producto {
    
    private int id_producto;
    private  String nombre_prod;
    private String fecha_lab;
    private String fecha_venc;
    private int cod_barras;
    private float precio_prod;
    private int unidades_exsistencias;
    private  String id_proveedor;
    private  String id_categoria;
    private int id_marca;

    public Producto(int id_producto, String nombre_prod, String fecha_lab, String fecha_venc, int cod_barras, float precio_prod, int unidades_exsistencias, String id_proveedor, String id_categoria, int id_marca) {
        this.id_producto = id_producto;
        this.nombre_prod = nombre_prod;
        this.fecha_lab = fecha_lab;
        this.fecha_venc = fecha_venc;
        this.cod_barras = cod_barras;
        this.precio_prod = precio_prod;
        this.unidades_exsistencias = unidades_exsistencias;
        this.id_proveedor = id_proveedor;
        this.id_categoria = id_categoria;
        this.id_marca = id_marca;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public String getFecha_lab() {
        return fecha_lab;
    }

    public void setFecha_lab(String fecha_lab) {
        this.fecha_lab = fecha_lab;
    }

    public String getFecha_venc() {
        return fecha_venc;
    }

    public void setFecha_venc(String fecha_venc) {
        this.fecha_venc = fecha_venc;
    }

    public int getCod_barras() {
        return cod_barras;
    }

    public void setCod_barras(int cod_barras) {
        this.cod_barras = cod_barras;
    }

    public float getPrecio_prod() {
        return precio_prod;
    }

    public void setPrecio_prod(float precio_prod) {
        this.precio_prod = precio_prod;
    }

    public int getUnidades_exsistencias() {
        return unidades_exsistencias;
    }

    public void setUnidades_exsistencias(int unidades_exsistencias) {
        this.unidades_exsistencias = unidades_exsistencias;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public Producto() {
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", nombre_prod=" + nombre_prod + ", fecha_lab=" + fecha_lab + ", fecha_venc=" + fecha_venc + ", cod_barras=" + cod_barras + ", precio_prod=" + precio_prod + ", unidades_exsistencias=" + unidades_exsistencias + ", id_proveedor=" + id_proveedor + ", id_categoria=" + id_categoria + ", id_marca=" + id_marca + '}';
    }
    
    
    
    
}
