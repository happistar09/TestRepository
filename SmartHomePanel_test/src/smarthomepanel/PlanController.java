
package smarthomepanel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlanController implements Initializable {

	@FXML
	private ImageView imgRoom1;
	@FXML
	private ImageView imgRoom2;
	@FXML
	private ImageView imgMain;
	@FXML
	private ImageView imgBig;
	@FXML
	private ImageView imgKitchen;
	@FXML
	private Button btnMain;
	@FXML
	private Button btnBig;
	@FXML
	private Button btnKitchen;
	@FXML
	private Button btnRoom1;
	@FXML
	private Button btnRoom2;

	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		setting();
		btnMain.setOnAction(e->handleBtnMain(e));
		btnBig.setOnAction(e->handleBtnBig(e));
		btnKitchen.setOnAction(e->handleBtnKitchen(e));
		btnRoom1.setOnAction(e->handleBtnRoom1(e));
		btnRoom2.setOnAction(e->handleBtnRoom2(e));
	}	
	
	private void setting() {
		Image switch_off = new Image(getClass().getResource("images/icons/control/light_off2.png").toString());
		Image switch_on = new Image(getClass().getResource("images/icons/control/light_on.png").toString());
		if(LightController.onOffMain.equals("OFF")){
			imgMain.setImage(switch_off);
		} else {
			imgMain.setImage(switch_on);
		}
		if(LightController.onOffBig.equals("OFF")){
			imgBig.setImage(switch_off);
		} else {
			imgBig.setImage(switch_on);
		}
		if(LightController.onOffRoom1.equals("OFF")){
			imgRoom1.setImage(switch_off);
		} else {
			imgRoom1.setImage(switch_on);
		}
		if(LightController.onOffRoom2.equals("OFF")){
			imgRoom2.setImage(switch_off);
		} else {
			imgRoom2.setImage(switch_on);
		}
		if(LightController.onOffRoom3.equals("OFF")){
			imgKitchen.setImage(switch_off);
		} else {
			imgKitchen.setImage(switch_on);
		}		
	}
	private void handleBtnMain(ActionEvent e){
		if(LightController.onOffMain.equals("OFF")){
			LightController.onOffMain="ON";			
		} else {
			LightController.onOffMain="OFF";			
		}
		setting();
	}
	private void handleBtnBig(ActionEvent e){
		if(LightController.onOffBig.equals("OFF")){
			LightController.onOffBig="ON";			
		} else {
			LightController.onOffBig="OFF";			
		}
		setting();
	}
	private void handleBtnRoom1(ActionEvent e){
		if(LightController.onOffRoom1.equals("OFF")){
			LightController.onOffRoom1="ON";			
		} else {
			LightController.onOffRoom1="OFF";			
		}
		setting();
	}
	private void handleBtnRoom2(ActionEvent e){
		if(LightController.onOffRoom2.equals("OFF")){
			LightController.onOffRoom2="ON";			
		} else {
			LightController.onOffRoom2="OFF";			
		}
		setting();
	}
	private void handleBtnKitchen(ActionEvent e){
		if(LightController.onOffRoom3.equals("OFF")){
			LightController.onOffRoom3="ON";			
		} else {
			LightController.onOffRoom3="OFF";			
		}
		setting();
	}
}
