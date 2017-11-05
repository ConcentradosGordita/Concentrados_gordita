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
public interface OperacionesCategoria {
    
    public String agregarCategoria(Object objeto);
    
    public String modificarCategoria(Object objeto);
    
    public String eliminarCategoria(Object objeto);
    
    public ArrayList<Object> mostrarCategoria();
}
