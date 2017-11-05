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
public interface OperacionesTienda {
    public String agregarTienda(Object objeto);
    
    public String modificarTienda(Object objeto);
    
    public String eliminarTienda(Object objeto);
    
    public ArrayList<Object> mostrarTienda();
}
