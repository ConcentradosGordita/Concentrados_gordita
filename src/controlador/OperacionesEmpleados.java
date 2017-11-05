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
public interface OperacionesEmpleados {
    public String agregarEmpleados(Object objeto);
    
    public String modificarEmpleados(Object objeto);
    
    public String eliminarEmpleados(Object objeto);
    
    public ArrayList<Object> mostrarEmpleados();
}
