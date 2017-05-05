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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
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
        @FXML
        private ImageView imgTempMain;
        @FXML
        private ImageView imgTempBig;
        @FXML
        private ImageView imgTempRoom1;
        @FXML
        private ImageView imgTempRoom2;
        @FXML
        private ImageView imgTempRoom3;
        
        public static String tempTitle="";
        public static int tempMain=20;
        public static int tempBig=20;
        public static int tempRoom1=20;
        public static int tempRoom2=20;
        public static int tempRoom3=20;
        public static int tempNew=20;
    @FXML
    private ImageView imgFireMain;
    @FXML
    private ImageView imgFireBig;
    @FXML
    private ImageView imgFireRoom1;
    @FXML
    private ImageView imgFireRoom2;
    @FXML
    private ImageView imgFireRoom3;
     
        
	
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
                btnTemperBigRoom.setOnAction(e -> handleBtnTemperBig(e));
                btnTemperRoom1.setOnAction(e -> handleBtnTemperRoom1(e));
                btnTemperRoom2.setOnAction(e -> handleBtnTemperRoom2(e));
                btnTemperRoom3.setOnAction(e -> handleBtnTemperRoom3(e));
                
	}	
	private void handleBtnOnOffMain(ActionEvent e){	
		if((btnOnOffMain.getText()).equals("ON")){
			btnOnOffMain.setText("OFF");
                        imageMain.setImage(new Image(getClass().getResource("images/off.png").toString()));
                        imgTempMain.setImage(new Image(getClass().getResource("images/thermometer_off.png").toString()));
                        imgFireMain.setImage(new Image(getClass().getResource("images/fire_off.png").toString()));
                        System.out.println("거실 난방 OFF");
		}
		else{
			btnOnOffMain.setText("ON");
                        imageMain.setImage(new Image(getClass().getResource("images/on.png").toString()));
                        imgTempMain.setImage(new Image(getClass().getResource("images/thermometer_on.png").toString()));
                        imgFireMain.setImage(new Image(getClass().getResource("images/fire_on.png").toString()));
                        System.out.println("거실 난방 ON");
		}
	}
	
	private void handleBtnOnOffBigRoom(ActionEvent e){	
		if((btnOnOffBigRoom.getText()).equals("ON")){
			btnOnOffBigRoom.setText("OFF");
                        imageBigRoom.setImage(new Image(getClass().getResource("images/off.png").toString()));
                        imgTempBig.setImage(new Image(getClass().getResource("images/thermometer_off.png").toString()));
                        imgFireBig.setImage(new Image(getClass().getResource("images/fire_off.png").toString()));
                        System.out.println("안방 난방 OFF");
		}
		else{
			btnOnOffBigRoom.setText("ON");
                        imageBigRoom.setImage(new Image(getClass().getResource("images/on.png").toString()));
                        imgTempBig.setImage(new Image(getClass().getResource("images/thermometer_on.png").toString()));
                        imgFireBig.setImage(new Image(getClass().getResource("images/fire_on.png").toString()));
                        System.out.println("안방 난방 ON");
		}
	}
	
	private void handleBtnOnOffRoom1(ActionEvent e){	
		if((btnOnOffRoom1.getText()).equals("ON")){
			btnOnOffRoom1.setText("OFF");
                        imageRoom1.setImage(new Image(getClass().getResource("images/off.png").toString()));
                        imgTempRoom1.setImage(new Image(getClass().getResource("images/thermometer_off.png").toString()));
                        imgFireRoom1.setImage(new Image(getClass().getResource("images/fire_off.png").toString()));
                        System.out.println("침실1 난방 OFF");
		}
		else{
			btnOnOffRoom1.setText("ON");
                        imageRoom1.setImage(new Image(getClass().getResource("images/on.png").toString()));
                        imgTempRoom1.setImage(new Image(getClass().getResource("images/thermometer_on.png").toString()));
                        imgFireRoom1.setImage(new Image(getClass().getResource("images/fire_on.png").toString()));
                        System.out.println("침실1 난방 ON");
		}
	}
	
	private void handleBtnOnOffRoom2(ActionEvent e){	
		if((btnOnOffRoom2.getText()).equals("ON")){
			btnOnOffRoom2.setText("OFF");
                        imageRoom2.setImage(new Image(getClass().getResource("images/off.png").toString()));
                        imgTempRoom2.setImage(new Image(getClass().getResource("images/thermometer_off.png").toString()));
                        imgFireRoom2.setImage(new Image(getClass().getResource("images/fire_off.png").toString()));
                        System.out.println("침실2 난방 OFF");
		}
		else{
			btnOnOffRoom2.setText("ON");
                        imageRoom2.setImage(new Image(getClass().getResource("images/on.png").toString()));
                        imgTempRoom2.setImage(new Image(getClass().getResource("images/thermometer_on.png").toString()));
                        imgFireRoom2.setImage(new Image(getClass().getResource("images/fire_on.png").toString()));
                        System.out.println("침실2 난방 ON");
		}
	}
	
	private void handleBtnOnOffRoom3(ActionEvent e){	
		if((btnOnOffRoom3.getText()).equals("ON")){
			btnOnOffRoom3.setText("OFF");
                        imageRoom3.setImage(new Image(getClass().getResource("images/off.png").toString()));
                        imgTempRoom3.setImage(new Image(getClass().getResource("images/thermometer_off.png").toString()));
                        imgFireRoom3.setImage(new Image(getClass().getResource("images/fire_off.png").toString()));
                        System.out.println("침실3 난방 OFF");
		}
		else{
			btnOnOffRoom3.setText("ON");
                        imageRoom3.setImage(new Image(getClass().getResource("images/on.png").toString()));
                        imgTempRoom3.setImage(new Image(getClass().getResource("images/thermometer_on.png").toString()));
                        imgFireRoom3.setImage(new Image(getClass().getResource("images/fire_on.png").toString()));
                        System.out.println("침실3 난방 ON");
		}
	}
    
        private void handleBtnAllOn(ActionEvent e){
            if((btnOnOffMain.getText()).equals("OFF")) handleBtnOnOffMain(e);
            if((btnOnOffBigRoom.getText()).equals("OFF")) handleBtnOnOffBigRoom(e);
            if((btnOnOffRoom1.getText()).equals("OFF")) handleBtnOnOffRoom1(e);
            if((btnOnOffRoom2.getText()).equals("OFF")) handleBtnOnOffRoom2(e);
            if((btnOnOffRoom3.getText()).equals("OFF")) handleBtnOnOffRoom3(e);
            try {            
                showNotification("알림", "전체 난방 ON");
            } catch (IOException ex) {}
        }
        
        private void handleBtnAllOff(ActionEvent e){
            if((btnOnOffMain.getText()).equals("ON")) handleBtnOnOffMain(e);
            if((btnOnOffBigRoom.getText()).equals("ON")) handleBtnOnOffBigRoom(e);
            if((btnOnOffRoom1.getText()).equals("ON")) handleBtnOnOffRoom1(e);
            if((btnOnOffRoom2.getText()).equals("ON")) handleBtnOnOffRoom2(e);
            if((btnOnOffRoom3.getText()).equals("ON")) handleBtnOnOffRoom3(e);
            try {            
                showNotification("알림", "전체 난방 OFF");
            } catch (IOException ex) {}
              
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
                    if((btnOnOffMain.getText()).equals("ON")){
                        tempTitle="거실";
                        tempNew=tempMain;
                        TemperatureController.tempKey=1;

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
                    }
                    else showNotification("경고", "난방을 켠 후 온도를 조절해주세요");
                    
                } catch (IOException ex) { }        
        
        }
        
        private void handleBtnTemperBig(ActionEvent e){            
            
                try {
                    if((btnOnOffBigRoom.getText()).equals("ON")){
                        tempTitle="안방";
                        tempNew=tempBig;
                        TemperatureController.tempKey=2;

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
                    }
                    else showNotification("경고", "난방을 켠 후 온도를 조절해주세요");
                } catch (IOException ex) { }            
            
        }
        
        private void handleBtnTemperRoom1(ActionEvent e){            
            
                try {  
                    if((btnOnOffRoom1.getText()).equals("ON")){
                        tempTitle="침실1";
                        tempNew=tempRoom1;
                        TemperatureController.tempKey=3;

                        Stage dialog = new Stage(StageStyle.UTILITY);
                        dialog.initModality(Modality.WINDOW_MODAL);
                        Stage primaryStage = (Stage) btnTemperMain.getScene().getWindow();
                        dialog.initOwner(primaryStage);
                        dialog.setTitle("온도설정");
                        Parent parent = FXMLLoader.load(getClass().getResource("Temperature.fxml"));
                        Scene scene = new Scene(parent);
                        dialog.setScene(scene);
                        dialog.setResizable(false);
                        dialog.show();
                    }
                    else showNotification("경고", "난방을 켠 후 온도를 조절해주세요");
                } catch (IOException ex) { }            
            
        }
        
        private void handleBtnTemperRoom2(ActionEvent e){            
            
                try {
                    if((btnOnOffRoom2.getText()).equals("ON")){
                        tempTitle="침실2";
                        tempNew=tempRoom2;
                        TemperatureController.tempKey=4;

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
                    }
                    else showNotification("경고", "난방을 켠 후 온도를 조절해주세요");
                } catch (IOException ex) { }            
            
        }
        
        private void handleBtnTemperRoom3(ActionEvent e){          
                try {
                    if((btnOnOffRoom3.getText()).equals("ON")){
                        tempTitle="침실3";
                        tempNew=tempRoom3;
                        TemperatureController.tempKey=5;

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
                    }
                    else showNotification("경고", "난방을 켠 후 온도를 조절해주세요");
                } catch (IOException ex) { }            
            
        }
        
        private void showNotification(String type, String message) throws IOException {
            Popup popup = new Popup();
            HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("popup.fxml"));
            ImageView imgMessage =(ImageView) hbox.lookup("#imgMessage");
            Label lbMessage = (Label) hbox.lookup("#lbMessage");
            if(type.equals("알림")) imgMessage.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));        
            else if(type.equals("경고")) imgMessage.setImage(new Image(getClass().getResource("images/dialog-warning.png").toString()));   
            lbMessage.setText(message);        
            popup.getContent().add(hbox);
            popup.setAutoHide(true);
            Stage primaryStage = (Stage)btnTemperMain.getScene().getWindow();
            popup.show(primaryStage);        
        }
}
