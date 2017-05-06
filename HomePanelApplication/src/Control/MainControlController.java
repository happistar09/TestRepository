package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class MainControlController implements Initializable {

    @FXML
    private Button btnHeating;
    @FXML
    private Button btnLight;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnBack;
    @FXML
    private AnchorPane mainControl;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnHeating.setOnAction(e -> handleBtnHeating(e));
        btnLight.setOnAction(e -> handleBtnLight(e));
    }

    private void handleBtnHeating(ActionEvent e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Heating.fxml"));
            Scene scene = new Scene(parent);
            Stage primaryStage = (Stage) btnHeating.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (IOException ex) {
        }
    }

    private void handleBtnLight(ActionEvent e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Light.fxml"));
            Scene scene = new Scene(parent);
            Stage primaryStage = (Stage) btnLight.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (IOException ex) {
        }
    }

}
