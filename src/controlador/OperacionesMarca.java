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
public interface OperacionesMarca {
    public String agregarMarca(Object objeto);
    
    public String modificarMarca(Object objeto);
    
    public String eliminarMarca(Object objeto);
    
    public ArrayList<Object> mostrarMarca();
}
