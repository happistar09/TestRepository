
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

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
    }

    private void handleBtnOnOffMain(ActionEvent e) {
        if ((btnOnOffMain.getText()).equals("ON")) {
            btnOnOffMain.setText("OFF");
            imageMain.setImage(switch_off);
            imgLightMain.setImage(light_off);
            System.out.println("거실 조명 OFF");
        } else {
            btnOnOffMain.setText("ON");
            imageMain.setImage(switch_on);
            imgLightMain.setImage(light_on);
            System.out.println("거실 조명 ON");
        }
    }

    private void handleBtnOnOffBigRoom(ActionEvent e) {
        if ((btnOnOffBigRoom.getText()).equals("ON")) {
            btnOnOffBigRoom.setText("OFF");
            imageBigRoom.setImage(switch_off);
            imgLightBig.setImage(light_off);
            System.out.println("안방 조명 OFF");
        } else {
            btnOnOffBigRoom.setText("ON");
            imageBigRoom.setImage(switch_on);
            imgLightBig.setImage(light_on);
            System.out.println("안방 조명 ON");
        }
    }

    private void handleBtnOnOffRoom1(ActionEvent e) {
        if ((btnOnOffRoom1.getText()).equals("ON")) {
            btnOnOffRoom1.setText("OFF");
            imageRoom1.setImage(switch_off);
            imgLightRoom1.setImage(light_off);
            System.out.println("침실1 조명 OFF");
        } else {
            btnOnOffRoom1.setText("ON");
            imageRoom1.setImage(switch_on);
            imgLightRoom1.setImage(light_on);
            System.out.println("침실1 조명 ON");
        }
    }

    private void handleBtnOnOffRoom2(ActionEvent e) {
        if ((btnOnOffRoom2.getText()).equals("ON")) {
            btnOnOffRoom2.setText("OFF");
            imageRoom2.setImage(switch_off);
            imgLightRoom2.setImage(light_off);
            System.out.println("침실2 조명 OFF");
        } else {
            btnOnOffRoom2.setText("ON");
            imageRoom2.setImage(switch_on);
            imgLightRoom2.setImage(light_on);
            System.out.println("침실2 조명 ON");
        }
    }

    private void handleBtnOnOffRoom3(ActionEvent e) {
        if ((btnOnOffRoom3.getText()).equals("ON")) {
            btnOnOffRoom3.setText("OFF");
            imageRoom3.setImage(switch_off);
            imgLightRoom3.setImage(light_off);
            System.out.println("침실3 조명 OFF");
        } else {
            btnOnOffRoom3.setText("ON");
            imageRoom3.setImage(switch_on);
            imgLightRoom3.setImage(light_on);
            System.out.println("침실3 조명 ON");
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
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("MainControl.fxml"));
            Scene scene = new Scene(parent);
            Stage primaryStage = (Stage) btnBack.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (IOException ex) {
        }

    }

    private void handleBtnHome(ActionEvent e) {

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

}
