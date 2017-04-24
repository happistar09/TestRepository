/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.hw13.exam01;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class RootController implements Initializable {

    @FXML
    private CheckBox checkBox1;
    @FXML
    private CheckBox checkBox2;
    @FXML
    private Button btnClose;
    @FXML
    private ImageView checkImageView;
    @FXML
    private ToggleGroup players;
    @FXML
    private ImageView radioImageView;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnClose.setOnAction(e->{
            Platform.exit();
        });
        
        checkBox1.setOnAction(e->{
            handleCheckAction(e);
        });
        
        checkBox2.setOnAction(e->{
            handleCheckAction(e);
        });
        
        players.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                //System.out.println("images/" + newValue.getUserData().toString()+".jpg");
                Image image = new Image(getClass().getResource("images/" + newValue.getUserData().toString()+".jpg").toString());
                radioImageView.setImage(image);
            }
            
        });
        
    }    
    public void handleCheckAction(ActionEvent e){
        if(checkBox1.isSelected() && checkBox2.isSelected()){
            checkImageView.setImage(new Image(getClass().getResource("images/lfp.jpg").toString()));
        } else if(checkBox1.isSelected()){
            checkImageView.setImage(new Image(getClass().getResource("images/barcelona.png").toString()));
        } else if(checkBox2.isSelected()){
            checkImageView.setImage(new Image(getClass().getResource("images/realmadrid.png").toString()));
        }
        
    
    }
    
}
