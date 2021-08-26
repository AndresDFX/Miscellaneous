package Vista;

import Controlador.Control;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;


public class FXMLResultadoController implements Initializable {

    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label1;
    @FXML
    private ScrollPane scroll1;
    @FXML
    private TextArea text1;
    @FXML
    private ScrollPane scroll2;
    @FXML
    private TextArea text2;
    @FXML
    private ScrollPane scroll3;
    @FXML
    private TextArea text3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       text1.setText(Control.diagnosticoPorPaciente());
       text2.setText(Control.diagnosticoMasComun());
       text3.setText(String.valueOf(Control.pacientesSinDiagnostico()));
    }    
    
}
