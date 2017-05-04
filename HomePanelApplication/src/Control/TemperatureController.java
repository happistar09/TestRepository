package Control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TemperatureController implements Initializable {

    @FXML
    private Button btnUp;
    @FXML
    private Button btnDown;
    @FXML
    private Label lbTitle;
    @FXML
    private Label lbTempNow;
    @FXML
    private Label lbTempSetting;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lbTitle.setText(HeatingController.tempTitle);
        btnUp.setOnAction(e -> handleBtnUp(e));
        btnDown.setOnAction(e -> handleBtnDown(e));
        
    }    
    
    private void handleBtnUp(ActionEvent e){     
        lbTempSetting.setText(String.valueOf(Integer.parseInt(lbTempSetting.getText())+1));
    }
    private void handleBtnDown(ActionEvent e){     
        lbTempSetting.setText(String.valueOf(Integer.parseInt(lbTempSetting.getText())-1));
    }
    
}
