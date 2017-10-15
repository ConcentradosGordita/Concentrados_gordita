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



public class Marca {
    private int id_marca;
    private String nombre_marca;

    public Marca(int id_marca, String nombre_marca) {
        this.id_marca = id_marca;
        this.nombre_marca = nombre_marca;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public Marca() {
    }

    @Override
    public String toString() {
        return "Marca{" + "id_marca=" + id_marca + ", nombre_marca=" + nombre_marca + '}';
    }
}
