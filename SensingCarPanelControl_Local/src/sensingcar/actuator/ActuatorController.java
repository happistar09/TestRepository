package sensingcar.actuator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

public class ActuatorController implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private Button btnBuzzerOn;
    @FXML
    private Button btnBuzzerOff;
    @FXML
    private Button btnLaserOn;
    @FXML
    private Button btnLaserOff;
    @FXML
    private Slider sliderRed;
    @FXML
    private Slider sliderGreen;
    @FXML
    private Slider sliderBlue;
    @FXML
    private TextField textLine0;
    @FXML
    private TextField textLine1;

    private String uri = "192.168.35.142";
    
    @FXML
    private Label lbBuzzer;
    @FXML
    private Label lbLaser;
    @FXML
    private Label lbLine0;
    @FXML
    private Label lbLine1;
    @FXML
    private Button btnSend;
    @FXML
    private AnchorPane actuatorPane;
    private Region regionRgb;
    @FXML
    private ImageView imgLaser;
    @FXML
    private Circle circleRgb;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        actuatorClients();

        // rgbled
        sliderRed.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String redValue = String.valueOf((int) ((sliderRed.getValue()) / 100 * 255));
                String greenValue = String.valueOf((int) ((sliderGreen.getValue()) / 100 * 255));
                String blueValue = String.valueOf((int) ((sliderBlue.getValue()) / 100 * 255));
                CoapClient coapClient = new CoapClient();
                JSONObject reqJsonObject = new JSONObject();
                reqJsonObject.put("command", "change");
                reqJsonObject.put("red", redValue);
                reqJsonObject.put("green", greenValue);
                reqJsonObject.put("blue", blueValue);
                String reqJson = reqJsonObject.toString();
                coapClient.setURI("coap://" + uri + "/rgbled");
                coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
                coapClient.shutdown();
                circleRgb.setFill(Color.rgb(Integer.parseInt(redValue), Integer.parseInt(greenValue), Integer.parseInt(blueValue)));
            }
        });

        sliderGreen.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String redValue = String.valueOf((int) ((sliderRed.getValue()) / 100 * 255));
                String greenValue = String.valueOf((int) ((sliderGreen.getValue()) / 100 * 255));
                String blueValue = String.valueOf((int) ((sliderBlue.getValue()) / 100 * 255));
                CoapClient coapClient = new CoapClient();
                JSONObject reqJsonObject = new JSONObject();
                reqJsonObject.put("command", "change");
                reqJsonObject.put("red", redValue);
                reqJsonObject.put("green", greenValue);
                reqJsonObject.put("blue", blueValue);
                String reqJson = reqJsonObject.toString();
                coapClient.setURI("coap://" + uri + "/rgbled");
                coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
                coapClient.shutdown();
                circleRgb.setFill(Color.rgb(Integer.parseInt(redValue), Integer.parseInt(greenValue), Integer.parseInt(blueValue)));
            }
        });

        sliderBlue.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String redValue = String.valueOf((int) ((sliderRed.getValue()) / 100 * 255));
                String greenValue = String.valueOf((int) ((sliderGreen.getValue()) / 100 * 255));
                String blueValue = String.valueOf((int) ((sliderBlue.getValue()) / 100 * 255));
                CoapClient coapClient = new CoapClient();
                JSONObject reqJsonObject = new JSONObject();
                reqJsonObject.put("command", "change");
                reqJsonObject.put("red", redValue);
                reqJsonObject.put("green", greenValue);
                reqJsonObject.put("blue", blueValue);
                String reqJson = reqJsonObject.toString();
                coapClient.setURI("coap://" + uri + "/rgbled");
                coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
                coapClient.shutdown();
                circleRgb.setFill(Color.rgb(Integer.parseInt(redValue), Integer.parseInt(greenValue), Integer.parseInt(blueValue)));
            }
        });

        //buzzer
        btnBuzzerOn.setOnAction(e -> handleBtnBuzzerOn(e));
        btnBuzzerOff.setOnAction(e -> handleBtnBuzzerOff(e));

        //laser
        btnLaserOn.setOnAction(e -> handleBtnLaserOn(e));
        btnLaserOff.setOnAction(e -> handleBtnLaserOff(e));

        //lcd
        btnSend.setOnAction(e -> handleBtnSend(e));

        //home
        btnHome.setOnAction(e -> handleBtnHome(e));

    }

    private void actuatorClients() {
        double sliderRValue;
        double sliderGValue;
        double sliderBValue;
        CoapClient coapClient = new CoapClient();
        JSONObject resJsonObject = null;
        CoapResponse coapResponse = null;
        String resJson = null;

        JSONObject reqJsonObject = new JSONObject();
        reqJsonObject.put("command", "status");
        String reqJson = reqJsonObject.toString();

        // rgbled
        coapClient.setURI("coap://" + uri + "/rgbled");
        coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        resJson = coapResponse.getResponseText();
        resJsonObject = new JSONObject(resJson);
        sliderRValue = (resJsonObject.getDouble("red")) / 255 * 100;
        sliderRed.setValue(sliderRValue);
        sliderGValue = (resJsonObject.getDouble("green")) / 255 * 100;
        sliderGreen.setValue(sliderGValue);
        sliderBValue = (resJsonObject.getDouble("blue")) / 255 * 100;
        sliderBlue.setValue(sliderBValue);
        circleRgb.setFill(Color.rgb(resJsonObject.getInt("red"), resJsonObject.getInt("green"), resJsonObject.getInt("blue")));

        // buzzer
        coapClient.setURI("coap://" + uri + "/buzzer");
        coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        resJson = coapResponse.getResponseText();
        resJsonObject = new JSONObject(resJson);
        if ((resJsonObject.getString("status")).equals("off")) {
            lbBuzzer.setText("OFF");
        } else if ((resJsonObject.getString("status")).equals("on")) {
            lbBuzzer.setText("ON");
        }

        //laser
        coapClient.setURI("coap://" + uri + "/laseremitter");
        coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        resJson = coapResponse.getResponseText();
        resJsonObject = new JSONObject(resJson);
        if ((resJsonObject.getString("status")).equals("off")) {
            lbLaser.setText("OFF");
        } else if ((resJsonObject.getString("status")).equals("on")) {
            lbLaser.setText("ON");
        }

        //lcd
        coapClient.setURI("coap://" + uri + "/lcd");
        coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        resJson = coapResponse.getResponseText();
        resJsonObject = new JSONObject(resJson);
        lbLine0.setText(resJsonObject.getString("line0"));
        lbLine1.setText(resJsonObject.getString("line1"));

        coapClient.shutdown();
    }

    private void handleBtnBuzzerOn(ActionEvent e) {
        CoapClient coapClient = new CoapClient();
        JSONObject reqJsonObject = new JSONObject();
        reqJsonObject.put("command", "change");
        reqJsonObject.put("status", "on");
        String reqJson = reqJsonObject.toString();
        coapClient.setURI("coap://" + uri + "/buzzer");
        coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        coapClient.shutdown();
        lbBuzzer.setText("ON");

    }

    private void handleBtnBuzzerOff(ActionEvent e) {
        CoapClient coapClient = new CoapClient();
        JSONObject reqJsonObject = new JSONObject();
        reqJsonObject.put("command", "change");
        reqJsonObject.put("status", "off");
        String reqJson = reqJsonObject.toString();
        coapClient.setURI("coap://" + uri + "/buzzer");
        coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        coapClient.shutdown();
        lbBuzzer.setText("OFF");
    }

    private void handleBtnLaserOn(ActionEvent e) {
        CoapClient coapClient = new CoapClient();
        JSONObject reqJsonObject = new JSONObject();
        reqJsonObject.put("command", "change");
        reqJsonObject.put("status", "on");
        String reqJson = reqJsonObject.toString();
        coapClient.setURI("coap://" + uri + "/laseremitter");
        coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        coapClient.shutdown();
        lbLaser.setText("ON");

    }

    private void handleBtnLaserOff(ActionEvent e) {
        CoapClient coapClient = new CoapClient();
        JSONObject reqJsonObject = new JSONObject();
        reqJsonObject.put("command", "change");
        reqJsonObject.put("status", "off");
        String reqJson = reqJsonObject.toString();
        coapClient.setURI("coap://" + uri + "/laseremitter");
        coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        coapClient.shutdown();
        lbLaser.setText("OFF");

    }

    private void handleBtnSend(ActionEvent e) {

        CoapClient coapClient = new CoapClient();
        JSONObject reqJsonObject = new JSONObject();
        reqJsonObject.put("command", "change");
        reqJsonObject.put("line0", textLine0.getText());
        reqJsonObject.put("line1", textLine1.getText());
        String reqJson = reqJsonObject.toString();
        coapClient.setURI("coap://" + uri + "/lcd");
        CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        String resJson = coapResponse.getResponseText();
        JSONObject resJsonObject = new JSONObject(resJson);
        lbLine0.setText(resJsonObject.getString("line0"));
        lbLine1.setText(resJsonObject.getString("line1"));

        coapClient.shutdown();

    }

    private void handleBtnHome(ActionEvent e) {
        StackPane rootPane = (StackPane) btnHome.getScene().getRoot();
        actuatorPane.setOpacity(1);
        KeyValue keyValue = new KeyValue(actuatorPane.opacityProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),
                event -> rootPane.getChildren().remove(actuatorPane),
                keyValue
        );
        Timeline timeLine = new Timeline();
        timeLine.getKeyFrames().add(keyFrame);
        timeLine.play();
    }

}
