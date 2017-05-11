package lightbulb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Administrator
 */
public class rootController implements Initializable {

    @FXML
    private ImageView planImage;
    private ImageView lightBulbImage;
    @FXML
    private Button btnLight;
    @FXML
    private ImageView livingroomImage;
	@FXML
	private ImageView imgLightMain;
	@FXML
	private ImageView imgLightBigRoom;
	@FXML
	private ImageView imgLightRoom2;
	@FXML
	private ImageView imgLightRoom3;
	@FXML
	private ImageView imgLightKitchen;
	@FXML
	private Button btnBigRoom;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLight.setOnAction(e -> handleBtnLight(e));
		btnBigRoom.setOnAction(e -> handleBtnBigRoom(e));
    }

    private void handleBtnLight(ActionEvent e) {
        livingroomImage.setOpacity(0);
        lightBulbImage.setImage(new Image(getClass().getResource("lightbulb(bright).png").toString()));
    }
		
	private void handleBtnBigRoom(ActionEvent e) {
		System.out.println("버튼 클릭");
	}

}
