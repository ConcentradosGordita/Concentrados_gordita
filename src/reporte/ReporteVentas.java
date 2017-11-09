/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte;

import conexion.Conexion;
import java.sql.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;

public class ReporteVentas {
    public String generarReporte(){
        Conexion con = new Conexion();
        Connection cn;
        String mensaje;
        try {
           Class.forName(con.getDriver());
           cn = DriverManager.getConnection(con.getUrl(), con.getUsuario(), con.getClave());
                                                                           //nombre del paquete
           JasperReport rp = (JasperReport) JRLoader.loadObject(getClass().getResource("/reporte/Reporte1.jasper"));
           JasperPrint pr = JasperFillManager.fillReport(rp,null,cn);
           JasperViewer vista = new JasperViewer(pr, false);
           vista.setVisible(true);
           mensaje = "El reporte se ha generado exitosamente";
        } catch (Exception e) {
        mensaje = e.toString();
        }
        return mensaje;
    }
    

    

}
