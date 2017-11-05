/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;

/**
 *
 * @author kamt
 */
public interface OperacionesVentas {
    public String agregarVentas(Object objeto);
    
    public String modificarVentas(Object objeto);
    
    public String eliminarVentas(Object objeto);
    
    public ArrayList<Object> mostrarVentas();
}
