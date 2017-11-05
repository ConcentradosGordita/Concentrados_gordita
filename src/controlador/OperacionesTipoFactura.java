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
public interface OperacionesTipoFactura {
    public String agregarTipoFactura(Object objeto);
    
    public String modificarTipoFactura(Object objeto);
    
    public String eliminarTipoFactura(Object objeto);
    
    public ArrayList<Object> mostrarTipoFactura();
}
