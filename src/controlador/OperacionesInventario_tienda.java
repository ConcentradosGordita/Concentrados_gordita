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
public interface OperacionesInventario_tienda {
    public String agregarInventario_tienda(Object objeto);
    
    public String modificarInventario_tienda(Object objeto);
    
    public String eliminarInventario_tienda(Object objeto);
    
    public ArrayList<Object> mostrarInventario_tienda();
    
}
