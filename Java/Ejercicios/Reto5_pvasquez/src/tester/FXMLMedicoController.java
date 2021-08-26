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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author julian.castano
 */
public class FXMLMedicoController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private Label label;
    @FXML
    private Button btnAgregarM;
    @FXML
    private Label labelNmedico;
    @FXML
    private Label labelCMedico;
    @FXML
    private TextField txNMedico;
    @FXML
    private TextField txCMedico;
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
    private void AgregarMedico(ActionEvent event) {
        try{
            String nombre = txNMedico.getText();
            int cedula = Integer.parseInt(txCMedico.getText());
            Medico medico = new Medico(nombre, cedula);
            Control.listaMedicos.add(medico);
            JOptionPane.showMessageDialog(null, "Se agrego el medico correctamente");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo agregar el medico");
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
