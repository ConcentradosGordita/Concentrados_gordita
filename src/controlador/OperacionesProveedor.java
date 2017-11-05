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
public interface OperacionesProveedor {
    public String agregarProveedor(Object objeto);
    
    public String modificarProveedor(Object objeto);
    
    public String eliminarProveedor(Object objeto);
    
    public ArrayList<Object> mostrarProveedor();
}
