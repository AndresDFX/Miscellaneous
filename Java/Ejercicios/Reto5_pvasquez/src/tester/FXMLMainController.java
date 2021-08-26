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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author julian.castano
 */
public class FXMLMainController implements Initializable {

    @FXML
    private Button agregarPaciente;
    @FXML
    private Button btnAgregarMedico;
    @FXML
    private Button btnDiagnosticar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    @FXML
    private void ventanaDiagnosticar(ActionEvent event) {
        try{
            Node source = (Node) event.getSource();
            Stage thisStage = (Stage) source.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tester/FXMLResultado.fxml"));  
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
    
    
    @FXML
    private void ventanaPaciente(ActionEvent event) {
        try{
            Node source = (Node) event.getSource();
            Stage thisStage = (Stage) source.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tester/FXMLPaciente.fxml"));  
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
    
    
    @FXML
    private void ventanaMedico(ActionEvent event) {
        try{
            Node source = (Node) event.getSource();
            Stage thisStage = (Stage) source.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tester/FXMLMedico.fxml"));  
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
