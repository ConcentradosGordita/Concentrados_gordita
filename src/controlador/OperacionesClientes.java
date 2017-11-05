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
public interface OperacionesClientes {
    public String agregarClientes(Object objeto);
    
    public String modificarClientes(Object objeto);
    
    public String eliminarClientes(Object objeto);
    
    public ArrayList<Object> mostrarClientes();
}
