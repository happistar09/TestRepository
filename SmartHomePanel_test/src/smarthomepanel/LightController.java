package smarthomepanel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LightController implements Initializable {

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
    private ImageView imageMain;
    @FXML
    private Button btnAllOn;
    @FXML
    private Button btnAllOff;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnHome;
    @FXML
    private ImageView imageBigRoom;
    @FXML
    private ImageView imageRoom1;
    @FXML
    private ImageView imageRoom2;
    @FXML
    private ImageView imageRoom3;
    @FXML
    private ImageView imgLightMain;
    @FXML
    private ImageView imgLightBig;
    @FXML
    private ImageView imgLightRoom1;
    @FXML
    private ImageView imgLightRoom2;
    @FXML
    private ImageView imgLightRoom3;
    @FXML
    private AnchorPane lightControl;

    Image switch_off = new Image(getClass().getResource("images/icons/control/off.png").toString());
    Image light_off = new Image(getClass().getResource("images/icons/control/light_off.png").toString());
    Image switch_on = new Image(getClass().getResource("images/icons/control/on.png").toString());
    Image light_on = new Image(getClass().getResource("images/icons/control/light_on.png").toString());
    public static String onOffMain = "OFF";
    public static String onOffBig = "OFF";
    public static String onOffRoom1 = "OFF";
    public static String onOffRoom2 = "OFF";
    public static String onOffRoom3 = "OFF";
	@FXML
	private Button btnPlan;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        savedInfo();

        btnOnOffMain.setOnAction(e -> handleBtnOnOffMain(e));
        btnOnOffBigRoom.setOnAction(e -> handleBtnOnOffBigRoom(e));
        btnOnOffRoom1.setOnAction(e -> handleBtnOnOffRoom1(e));
        btnOnOffRoom2.setOnAction(e -> handleBtnOnOffRoom2(e));
        btnOnOffRoom3.setOnAction(e -> handleBtnOnOffRoom3(e));
        btnBack.setOnAction(e -> handleBtnBack(e));
        btnHome.setOnAction(e -> handleBtnHome(e));
        btnAllOn.setOnAction(e -> handleBtnAllOn(e));
        btnAllOff.setOnAction(e -> handleBtnAllOff(e));
		btnPlan.setOnAction(e -> handleBtnPlan(e));
    }

    private void handleBtnOnOffMain(ActionEvent e) {
        if ((btnOnOffMain.getText()).equals("ON")) {
            mainSwitchOff();
        } else {
            mainSwitchOn();
        }
    }

    private void handleBtnOnOffBigRoom(ActionEvent e) {
        if ((btnOnOffBigRoom.getText()).equals("ON")) {
            bigSwitchOff();
        } else {
            bigSwitchOn();
        }
    }

    private void handleBtnOnOffRoom1(ActionEvent e) {
        if ((btnOnOffRoom1.getText()).equals("ON")) {
            room1SwitchOff();
        } else {
            room1SwitchOn();
        }
    }

    private void handleBtnOnOffRoom2(ActionEvent e) {
        if ((btnOnOffRoom2.getText()).equals("ON")) {
            room2SwitchOff();
        } else {
            room2SwitchOn();
        }
    }

    private void handleBtnOnOffRoom3(ActionEvent e) {
        if ((btnOnOffRoom3.getText()).equals("ON")) {
            room3SwitchOff();
        } else {
            room3SwitchOn();
        }
    }

    private void handleBtnAllOn(ActionEvent e) {
        if ((btnOnOffMain.getText()).equals("OFF")) {
            handleBtnOnOffMain(e);
        }
        if ((btnOnOffBigRoom.getText()).equals("OFF")) {
            handleBtnOnOffBigRoom(e);
        }
        if ((btnOnOffRoom1.getText()).equals("OFF")) {
            handleBtnOnOffRoom1(e);
        }
        if ((btnOnOffRoom2.getText()).equals("OFF")) {
            handleBtnOnOffRoom2(e);
        }
        if ((btnOnOffRoom3.getText()).equals("OFF")) {
            handleBtnOnOffRoom3(e);
        }
        try {
            showNotification("알림", "전체 조명 ON");
        } catch (IOException ex) {
        }

    }

    private void handleBtnAllOff(ActionEvent e) {

        if ((btnOnOffMain.getText()).equals("ON")) {
            handleBtnOnOffMain(e);
        }
        if ((btnOnOffBigRoom.getText()).equals("ON")) {
            handleBtnOnOffBigRoom(e);
        }
        if ((btnOnOffRoom1.getText()).equals("ON")) {
            handleBtnOnOffRoom1(e);
        }
        if ((btnOnOffRoom2.getText()).equals("ON")) {
            handleBtnOnOffRoom2(e);
        }
        if ((btnOnOffRoom3.getText()).equals("ON")) {
            handleBtnOnOffRoom3(e);
        }
        try {
            showNotification("알림", "전체 조명 OFF");
        } catch (IOException ex) {
        }
    }

    private void handleBtnBack(ActionEvent e) {
        StackPane rootPane = (StackPane) btnHome.getScene().getRoot();
        lightControl.setOpacity(1);
        KeyValue keyValue = new KeyValue(lightControl.opacityProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),
                event -> rootPane.getChildren().remove(lightControl),
                keyValue
        );
        Timeline timeLine = new Timeline();
        timeLine.getKeyFrames().add(keyFrame);
        timeLine.play();
    }

    private void handleBtnHome(ActionEvent e) {
        StackPane rootPane = (StackPane) btnHome.getScene().getRoot();
        rootPane.getChildren().remove(1);
        lightControl.setOpacity(1);
        KeyValue keyValue = new KeyValue(lightControl.opacityProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),
                event -> rootPane.getChildren().remove(lightControl),
                keyValue
        );
        Timeline timeLine = new Timeline();
        timeLine.getKeyFrames().add(keyFrame);
        timeLine.play();
    }
		
	private void handleBtnPlan(ActionEvent e) {
		try {
            Parent parent = FXMLLoader.load(getClass().getResource("Plan.fxml"));
            StackPane rootPane = (StackPane) btnHome.getScene().getRoot();
            rootPane.getChildren().add(parent);
            parent.setOpacity(0);
            KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            timeLine.play();

        } catch (IOException ex) {
        }
		
	}
	
	

    private void showNotification(String type, String message) throws IOException {
        Popup popup = new Popup();
        HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("popup.fxml"));
        ImageView imgMessage = (ImageView) hbox.lookup("#imgMessage");
        Label lbMessage = (Label) hbox.lookup("#lbMessage");
        if (type.equals("알림")) {
            imgMessage.setImage(new Image(getClass().getResource("images/icons/control/dialog-info.png").toString()));
        } else if (type.equals("경고")) {
            imgMessage.setImage(new Image(getClass().getResource("images/icons/control/dialog-warning.png").toString()));
        }
        lbMessage.setText(message);
        popup.getContent().add(hbox);
        popup.setAutoHide(true);
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        popup.show(primaryStage);
    }

    private void mainSwitchOff() {
        btnOnOffMain.setText("OFF");
        onOffMain = "OFF";
        imageMain.setImage(switch_off);
        imgLightMain.setImage(light_off);
    }

    private void mainSwitchOn() {
        btnOnOffMain.setText("ON");
        onOffMain = "ON";
        imageMain.setImage(switch_on);
        imgLightMain.setImage(light_on);
    }

    private void bigSwitchOff() {
        btnOnOffBigRoom.setText("OFF");
        onOffBig = "OFF";
        imageBigRoom.setImage(switch_off);
        imgLightBig.setImage(light_off);
    }

    private void bigSwitchOn() {
        btnOnOffBigRoom.setText("ON");
        onOffBig = "ON";
        imageBigRoom.setImage(switch_on);
        imgLightBig.setImage(light_on);
    }

    private void room1SwitchOff() {
        btnOnOffRoom1.setText("OFF");
        onOffRoom1 = "OFF";
        imageRoom1.setImage(switch_off);
        imgLightRoom1.setImage(light_off);
    }

    private void room1SwitchOn() {
        btnOnOffRoom1.setText("ON");
        onOffRoom1 = "ON";
        imageRoom1.setImage(switch_on);
        imgLightRoom1.setImage(light_on);
    }

    private void room2SwitchOff() {
        btnOnOffRoom2.setText("OFF");
        onOffRoom2 = "OFF";
        imageRoom2.setImage(switch_off);
        imgLightRoom2.setImage(light_off);
    }

    private void room2SwitchOn() {
        btnOnOffRoom2.setText("ON");
        onOffRoom2 = "ON";
        imageRoom2.setImage(switch_on);
        imgLightRoom2.setImage(light_on);
    }

    private void room3SwitchOff() {
        btnOnOffRoom3.setText("OFF");
        onOffRoom3 = "OFF";
        imageRoom3.setImage(switch_off);
        imgLightRoom3.setImage(light_off);
    }

    private void room3SwitchOn() {
        btnOnOffRoom3.setText("ON");
        onOffRoom3 = "ON";
        imageRoom3.setImage(switch_on);
        imgLightRoom3.setImage(light_on);
    }

    //다른화면으로 나갔다 왔을 때 전에 했던 설정을 불러온다
    private void savedInfo() {
        if (onOffMain.equals("OFF")) {
            mainSwitchOff();
        } else if (onOffMain.equals("ON")) {
            mainSwitchOn();
        }
        if (onOffBig.equals("OFF")) {
            bigSwitchOff();
        } else if (onOffBig.equals("ON")) {
            bigSwitchOn();
        }
        if (onOffRoom1.equals("OFF")) {
            room1SwitchOff();
        } else if (onOffRoom1.equals("ON")) {
            room1SwitchOn();
        }
        if (onOffRoom2.equals("OFF")) {
            room2SwitchOff();
        } else if (onOffRoom2.equals("ON")) {
            room2SwitchOn();
        }
        if (onOffRoom3.equals("OFF")) {
            room3SwitchOff();
        } else if (onOffRoom3.equals("ON")) {
            room3SwitchOn();
        }
    }

}
