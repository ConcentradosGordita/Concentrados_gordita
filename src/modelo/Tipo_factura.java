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

public class Tipo_factura {
    
    
    private int id_fact;
    private String fecha_fact;
    private String tipo_pago;
    private int cantidad;
    private double total;
    private String nom_cliente;

    public int getId_fact() {
        return id_fact;
    }

    public void setId_fact(int id_fact) {
        this.id_fact = id_fact;
    }

    public String getFecha_fact() {
        return fecha_fact;
    }

    public void setFecha_fact(String fecha_fact) {
        this.fecha_fact = fecha_fact;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }

    public Tipo_factura() {
    }

    public Tipo_factura(int id_fact, String fecha_fact, String tipo_pago, int cantidad, double total, String nom_cliente) {
        this.id_fact = id_fact;
        this.fecha_fact = fecha_fact;
        this.tipo_pago = tipo_pago;
        this.cantidad = cantidad;
        this.total = total;
        this.nom_cliente = nom_cliente;
    }

    @Override
    public String toString() {
        return "Tipo_factura{" + "id_fact=" + id_fact + ", fecha_fact=" + fecha_fact + ", tipo_pago=" + tipo_pago + ", cantidad=" + cantidad + ", total=" + total + ", nom_cliente=" + nom_cliente + '}';
    }

   
}
