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

public class Ventas {
    private int num_venta;
    private String nombre_prod;
    private double precio_prod;
    private int cantidad_prod;
    private String forma_pago;
    private float impuesto_IVA;
    private double descuento;
    private int id_cliente;
    private int id_empleado;
    private int id_producto;
    private int id_fact;

    public int getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(int num_venta) {
        this.num_venta = num_venta;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public double getPrecio_prod() {
        return precio_prod;
    }

    public void setPrecio_prod(double precio_prod) {
        this.precio_prod = precio_prod;
    }

    public int getCantidad_prod() {
        return cantidad_prod;
    }

    public void setCantidad_prod(int cantidad_prod) {
        this.cantidad_prod = cantidad_prod;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public float getImpuesto_IVA() {
        return impuesto_IVA;
    }

    public void setImpuesto_IVA(float impuesto_IVA) {
        this.impuesto_IVA = impuesto_IVA;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_fact() {
        return id_fact;
    }

    public void setId_fact(int id_fact) {
        this.id_fact = id_fact;
    }

    public Ventas() {
    }

    public Ventas(int num_venta, String nombre_prod, double precio_prod, int cantidad_prod, String forma_pago, float impuesto_IVA, double descuento, int id_cliente, int id_empleado, int id_producto, int id_fact) {
        this.num_venta = num_venta;
        this.nombre_prod = nombre_prod;
        this.precio_prod = precio_prod;
        this.cantidad_prod = cantidad_prod;
        this.forma_pago = forma_pago;
        this.impuesto_IVA = impuesto_IVA;
        this.descuento = descuento;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.id_producto = id_producto;
        this.id_fact = id_fact;
    }

    @Override
    public String toString() {
        return "Ventas{" + "num_venta=" + num_venta + ", nombre_prod=" + nombre_prod + ", precio_prod=" + precio_prod + ", cantidad_prod=" + cantidad_prod + ", forma_pago=" + forma_pago + ", impuesto_IVA=" + impuesto_IVA + ", descuento=" + descuento + ", id_cliente=" + id_cliente + ", id_empleado=" + id_empleado + ", id_producto=" + id_producto + ", id_fact=" + id_fact + '}';
    }

    
    
    
}
