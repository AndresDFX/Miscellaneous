/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import INTERFACES.AsignacionesA;
import com.mysql.jdbc.Connection;
import java.awt.Frame;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Andres
 */
public class GenerarReportes {
    
    public void generar(){
        try{
            AsignacionesA conector = new AsignacionesA();
            Connection conexion = conector.getConnection();
            JasperReport  reporte = JasperCompileManager.compileReport("General.jrxml");
            JasperPrint j = JasperFillManager.fillReport(reporte,null,conexion);
            JasperViewer jv = new JasperViewer(j, false);
            jv.setTitle("General");
            jv.setExtendedState(Frame.MAXIMIZED_BOTH);
            jv.setVisible(true);
            
        }catch(Exception e){
            
            System.out.println("Excepcion al generar reporte "+e.toString());
            
        }
    }
    
}
