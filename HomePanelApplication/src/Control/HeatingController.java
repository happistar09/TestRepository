package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class HeatingController implements Initializable {

	
	@FXML
	private Button btnOnOffMain;
	@FXML
	private Button btnOnOffBigRoom;
	@FXML
	private Button btnOnOffRoom1;
	@FXML
	private Button btnOnOffRoom2;
	@FXML
	private Button btnOnOffRoom3;
	@FXML
	private Button btnBack;
	@FXML
	private Button btnHome;
        @FXML
        private Button btnAllOn;
        @FXML
        private Button btnAllOff;
        @FXML
        private ImageView imageMain;
        @FXML
        private ImageView imageBigRoom;
        @FXML
        private ImageView imageRoom1;
        @FXML
        private ImageView imageRoom2;
        @FXML
        private ImageView imageRoom3;
        @FXML
        private Button btnTemperMain;
        @FXML
        private Button btnTemperBigRoom;
        @FXML
        private Button btnTemperRoom1;
        @FXML
        private Button btnTemperRoom2;
        @FXML
        private Button btnTemperRoom3;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btnOnOffMain.setOnAction(e -> handleBtnOnOffMain(e));
		btnOnOffBigRoom.setOnAction(e -> handleBtnOnOffBigRoom(e));
		btnOnOffRoom1.setOnAction(e -> handleBtnOnOffRoom1(e));
		btnOnOffRoom2.setOnAction(e -> handleBtnOnOffRoom2(e));
		btnOnOffRoom3.setOnAction(e -> handleBtnOnOffRoom3(e));
		btnBack.setOnAction(e -> handleBtnBack(e));
                btnHome.setOnAction(e -> handleBtnHome(e));
                btnAllOn.setOnAction(e -> handleBtnAllOn(e));
                btnAllOff.setOnAction(e -> handleBtnAllOff(e));
                btnTemperMain.setOnAction(e -> handleBtnTemperMain(e));
	}	
	private void handleBtnOnOffMain(ActionEvent e){	
		if((btnOnOffMain.getText()).equals("ON")){
			btnOnOffMain.setText("OFF");
                        imageMain.setImage(new Image(getClass().getResource("images/off.png").toString()));
                        System.out.println("거실 난방 OFF");
		}
		else{
			btnOnOffMain.setText("ON");
                        imageMain.setImage(new Image(getClass().getResource("images/on.png").toString()));
                        System.out.println("거실 난방 ON");
		}
	}
	
	private void handleBtnOnOffBigRoom(ActionEvent e){	
		if((btnOnOffBigRoom.getText()).equals("ON")){
			btnOnOffBigRoom.setText("OFF");
                        imageBigRoom.setImage(new Image(getClass().getResource("images/off.png").toString()));
                        System.out.println("안방 난방 OFF");
		}
		else{
			btnOnOffBigRoom.setText("ON");
                        imageBigRoom.setImage(new Image(getClass().getResource("images/on.png").toString()));
                        System.out.println("안방 난방 ON");
		}
	}
	
	private void handleBtnOnOffRoom1(ActionEvent e){	
		if((btnOnOffRoom1.getText()).equals("ON")){
			btnOnOffRoom1.setText("OFF");
                        imageRoom1.setImage(new Image(getClass().getResource("images/off.png").toString()));
                        System.out.println("침실1 난방 OFF");
		}
		else{
			btnOnOffRoom1.setText("ON");
                        imageRoom1.setImage(new Image(getClass().getResource("images/on.png").toString()));
                        System.out.println("침실1 난방 ON");
		}
	}
	
	private void handleBtnOnOffRoom2(ActionEvent e){	
		if((btnOnOffRoom2.getText()).equals("ON")){
			btnOnOffRoom2.setText("OFF");
                        imageRoom2.setImage(new Image(getClass().getResource("images/off.png").toString()));
                        System.out.println("침실2 난방 OFF");
		}
		else{
			btnOnOffRoom2.setText("ON");
                        imageRoom2.setImage(new Image(getClass().getResource("images/on.png").toString()));
                        System.out.println("침실2 난방 ON");
		}
	}
	
	private void handleBtnOnOffRoom3(ActionEvent e){	
		if((btnOnOffRoom3.getText()).equals("ON")){
			btnOnOffRoom3.setText("OFF");
                        imageRoom3.setImage(new Image(getClass().getResource("images/off.png").toString()));
                        System.out.println("침실3 난방 OFF");
		}
		else{
			btnOnOffRoom3.setText("ON");
                        imageRoom1.setImage(new Image(getClass().getResource("images/on.png").toString()));
                        System.out.println("침실3 난방 ON");
		}
	}
    
        private void handleBtnAllOn(ActionEvent e){
                btnOnOffMain.setText("ON");
                imageMain.setImage(new Image(getClass().getResource("images/on.png").toString()));
                btnOnOffBigRoom.setText("ON");
                imageBigRoom.setImage(new Image(getClass().getResource("images/on.png").toString()));   
                btnOnOffRoom1.setText("ON");
                imageRoom1.setImage(new Image(getClass().getResource("images/on.png").toString())); 
                btnOnOffRoom2.setText("ON");
                imageRoom2.setImage(new Image(getClass().getResource("images/on.png").toString()));
                btnOnOffRoom3.setText("ON");
                imageRoom3.setImage(new Image(getClass().getResource("images/on.png").toString()));
                System.out.println("전체 난방 ON");
          
          
        }
        
        private void handleBtnAllOff(ActionEvent e){
                btnOnOffMain.setText("OFF");
                imageMain.setImage(new Image(getClass().getResource("images/off.png").toString()));
                btnOnOffBigRoom.setText("OFF");
                imageBigRoom.setImage(new Image(getClass().getResource("images/off.png").toString()));   
                btnOnOffRoom1.setText("OFF");
                imageRoom1.setImage(new Image(getClass().getResource("images/off.png").toString())); 
                btnOnOffRoom2.setText("OFF");
                imageRoom2.setImage(new Image(getClass().getResource("images/off.png").toString()));
                btnOnOffRoom3.setText("OFF");
                imageRoom3.setImage(new Image(getClass().getResource("images/off.png").toString()));
                System.out.println("전체 난방 OFF");
              
        }
	
	private void handleBtnBack(ActionEvent e){
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("MainControl.fxml"));
                Scene scene = new Scene(parent);
                Stage primaryStage = (Stage)btnBack.getScene().getWindow();
                primaryStage.setScene(scene);
            } catch (IOException ex) { }
        
	}
    
        private void handleBtnHome(ActionEvent e){
		
	}
        
        private void handleBtnTemperMain(ActionEvent e){        
            
            
            try {
                Stage dialog = new Stage(StageStyle.UTILITY);
                dialog.initModality(Modality.WINDOW_MODAL);
                Stage primaryStage = (Stage)btnTemperMain.getScene().getWindow();
                dialog.initOwner(primaryStage);
                dialog.setTitle("온도설정");
                Parent parent = FXMLLoader.load(getClass().getResource("Temperature.fxml"));
                Scene scene = new Scene(parent);
                dialog.setScene(scene);
                dialog.setResizable(false);
                dialog.show();
                
            } catch (IOException ex) { }
            
        }
	
}
