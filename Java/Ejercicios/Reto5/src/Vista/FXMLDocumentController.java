package Vista;

import Controlador.Control;
import Modelo.*;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Label label1;
    @FXML
    private Button btnAgregarP;
    @FXML
    private Label labelNPaciente;
    @FXML
    private Label labelCPaciente;
    @FXML
    private TextField txNPaciente;
    @FXML
    private TextField txCPaciente;
    @FXML
    private TextField txCMedico;
    @FXML
    private Button btnAgregarM;
    @FXML
    private Label labelNmedico;
    @FXML
    private Label labelCMedico;
    @FXML
    private TextField txNMedico;
    @FXML
    private Label labelCMPaciente;
    @FXML
    private TextField txCPMedico;
    @FXML
    private Separator sp1;
    @FXML
    private Button btnDiagnosticar;
    @FXML
    private TextField txDiagnostico;
    @FXML
    private Label labelDiagnostico;
    
    
    @FXML
    private void AgregarPaciente(ActionEvent event) {
        try{
            String nombre = txNPaciente.getText();
            int cedula = Integer.parseInt(txCPaciente.getText());
            int cedulaMedico = Integer.parseInt(txCPMedico.getText());
            String sintomas = txDiagnostico.getText();
            Paciente paciente = new Paciente(nombre, cedula, cedulaMedico,"",sintomas);
            Control.pacientes.add(paciente);
            JOptionPane.showMessageDialog(null, "Se agrego el paciente correctamente");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo agregar el paciente");
            e.printStackTrace();
        }     
    }
    
    @FXML
    private void AgregarMedico(ActionEvent event) {
        try{
            String nombre = txNMedico.getText();
            int cedula = Integer.parseInt(txCMedico.getText());
            Medico medico = new Medico(nombre, cedula);
            Control.medicos.add(medico);
            JOptionPane.showMessageDialog(null, "Se agrego el medico correctamente");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo agregar el medico");
            e.printStackTrace();
        }
    }
    
    @FXML
    private void Diagnosticar(ActionEvent event) {
        try{
            String resultado = "";
            for(int i=0; i<Control.pacientes.size(); i++){
                String cadena = "";
                Paciente paciente = Control.pacientes.get(i);
                String sintomas = paciente.getSintomas();
                String []partes = sintomas.split(",");
                Arrays.sort(partes);
                for (int j=0; j<partes.length; j++){
                    cadena += partes[j] +",";
                }
                paciente.diagnosticar(cadena, i);
            }
            
            Node source = (Node) event.getSource();
            Stage thisStage = (Stage) source.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/FXMLResultado.fxml"));  
            Parent root = loader.load();
   
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            thisStage.close();
            stage.show();
            
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo diagnosticar los pacientes");
            e.printStackTrace();
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
