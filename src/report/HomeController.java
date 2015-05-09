/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author mohar
 */
public class HomeController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showReport(ActionEvent event) {
        try {
            JasperReport report = null;
            JasperPrint print = null;
            JasperDesign design = null;
            
            Map params = new HashMap();
            
            design = JRXmlLoader.load("C:\\Users\\mohar\\Documents\\NetBeansProjects\\Report\\src\\report\\report.jrxml");
            
            report = JasperCompileManager.compileReport(design);
            print = JasperFillManager.fillReport(report, params, new JRBeanCollectionDataSource(Person.getPersons()));
            JasperExportManager.exportReportToPdfFile(print, "person.pdf");
            JasperViewer jv = new JasperViewer(print, false);
            jv.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
