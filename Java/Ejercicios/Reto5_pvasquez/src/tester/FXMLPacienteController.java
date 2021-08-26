/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author julian.castano
 */
public class FXMLPacienteController implements Initializable {

    @FXML
    private Button btnAgregarP;
    @FXML
    private Label labelNPaciente;
    @FXML
    private Label labelCPaciente;
    @FXML
    private Label labelCMPaciente;
    @FXML
    private TextField txNPaciente;
    @FXML
    private TextField txCPaciente;
    @FXML
    private TextField txCPMedico;
    @FXML
    private Label label1;
    @FXML
    private TextField txDiagnostico;
    @FXML
    private Label labelDiagnostico;
    @FXML
    private Button btnMenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AgregarPaciente(ActionEvent event) {
        try{
            String nombre = txNPaciente.getText();
            int cedula = Integer.parseInt(txCPaciente.getText());
            int cedulaMedico = Integer.parseInt(txCPMedico.getText());
            String sintomas = txDiagnostico.getText();
            Paciente paciente = new Paciente(nombre, cedula, cedulaMedico,"",sintomas);
            Control.listaPacientes.add(paciente);
            JOptionPane.showMessageDialog(null, "Se agrego el paciente correctamente");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo agregar el paciente");
            e.printStackTrace();
        }     
    }

    @FXML
    private void btnMenu(ActionEvent event) {
        try{
            Node source = (Node) event.getSource();
            Stage thisStage = (Stage) source.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tester/FXMLMain.fxml"));  
            Parent root = loader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            thisStage.close();
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
