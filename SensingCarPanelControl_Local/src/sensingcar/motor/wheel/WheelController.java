package sensingcar.motor.wheel;

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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sensingcar.motor.wheel.knob.Knob;

public class WheelController implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(WheelController.class);

    private int fronttireAngle;
    private int backtireSpeed;
    private String backtireDirection;
    private String uri = "192.168.3.30";

    private Rotate rotationTransform;

    @FXML
    private Knob speedControlKnob;
    @FXML
    private Label lblKnobSpeed;
    @FXML
    private AnchorPane knobPane;
    @FXML
    private Button btnLeftWheel;
    @FXML
    private Button btnRightWheel;
    @FXML
    private ImageView imgFrontWheels;
    @FXML
    private Button btnDirectionForward;
    @FXML
    private Button btnDirectionBackward;
    @FXML
    private Label lblFrontAngle;
    @FXML
    private Button btnHome;
    @FXML
    private Label lblDirection;
    @FXML
    private Button btnStop;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        wheelClients();

        //Front Wheels
        btnLeftWheel.setOnAction(e -> handleBtnWheel(e, "left"));
        btnRightWheel.setOnAction(e -> handleBtnWheel(e, "right"));

        //Back Wheels(direction)
        btnDirectionForward.setOnAction(e -> handleBackTire(e, "forward"));
        btnDirectionBackward.setOnAction(e -> handleBackTire(e, "backward"));
        btnStop.setOnAction(e -> handleBtnStop(e));

        //Back Wheels(speed)
        speedControlKnob.setMarkerColor(Color.rgb(46, 147, 184));
        speedControlKnob.setValue(backtireSpeed * 100 / 4095);
        lblKnobSpeed.setText(String.valueOf(backtireSpeed));
        lblKnobSpeed.setTextFill(Color.rgb(46, 147, 184));
        speedControlKnob.setOnMouseDragged((event) -> {
            //System.out.println(Math.atan2(225-event.getSceneY(),225-event.getSceneX())*180/Math.PI);
            if ((Math.atan2(speedControlKnob.getHeight() / 2 - event.getY(), speedControlKnob.getWidth() / 2 - event.getX()) * 180 / Math.PI) > 0) {
                speedControlKnob.setValue((Math.atan2(speedControlKnob.getHeight() / 2 - event.getY(), speedControlKnob.getWidth() / 2 - event.getX()) * 180 / Math.PI) * 100 / 180);
            } else if ((Math.atan2(speedControlKnob.getHeight() / 2 - event.getY(), speedControlKnob.getWidth() / 2 - event.getX()) * 180 / Math.PI) > -90) {
                speedControlKnob.setValue(0);
            } else if ((Math.atan2(speedControlKnob.getHeight() / 2 - event.getY(), speedControlKnob.getWidth() / 2 - event.getX()) * 180 / Math.PI) < -90) {
                speedControlKnob.setValue(100);
            }
        });

        speedControlKnob.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                lblKnobSpeed.setText(String.valueOf(newValue.intValue() * 4095 / 100));
                backtireSpeed = (newValue.intValue() * 4095 / 100);

                CoapClient coapClient = new CoapClient();

                JSONObject reqJsonObject = new JSONObject();
                reqJsonObject.put("command", "change");
                reqJsonObject.put("speed", String.valueOf(backtireSpeed));
                reqJsonObject.put("direction", backtireDirection);
                String reqJson = reqJsonObject.toString();

                coapClient.setURI("coap://" + uri + "/backtire");
                CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
                String resJson = coapResponse.getResponseText();
                coapClient.shutdown();
            }
        });
    }

    private void wheelClients() {
        logger.info("");
        CoapClient coapClient = new CoapClient();
        JSONObject resJsonObject = null;
        CoapResponse coapResponse = null;
        String resJson = null;

        JSONObject reqJsonObject = new JSONObject();
        reqJsonObject.put("command", "status");
        String reqJson = reqJsonObject.toString();

        // 앞바퀴 -----------------------------------------------------------------------
        coapClient.setURI("coap://" + uri + "/fronttire");
        coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        resJson = coapResponse.getResponseText();
        resJsonObject = new JSONObject(resJson);
        fronttireAngle = resJsonObject.getInt("angle");
        rotationTransform = new Rotate(fronttireAngle - 90, 75, 75);
        imgFrontWheels.getTransforms().add(rotationTransform);
        lblFrontAngle.setText(fronttireAngle + "°");

        // 뒷바퀴 -----------------------------------------------------------------------
        coapClient.setURI("coap://" + uri + "/backtire");
        coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        resJson = coapResponse.getResponseText();
        resJsonObject = new JSONObject(resJson);
        backtireDirection = resJsonObject.getString("direction");
        backtireSpeed = resJsonObject.getInt("speed");
        lblKnobSpeed.setText(String.valueOf(backtireSpeed));
        lblDirection.setText(backtireDirection);
    }

    private void handleBtnWheel(ActionEvent e, String direction) {

        imgFrontWheels.getTransforms().remove(rotationTransform);
        rotationTransform.setAngle(fronttireAngle - 90);
        imgFrontWheels.getTransforms().add(rotationTransform);

        if (direction.equals("left") && fronttireAngle >= 50) {
            fronttireAngle -= 20;

            Timeline rotationAnimation = new Timeline();
            rotationAnimation.getKeyFrames().add(
                    new KeyFrame(
                            Duration.millis(500),
                            new KeyValue(rotationTransform.angleProperty(), fronttireAngle - 90)
                    )
            );
            rotationAnimation.play();
        } else if (direction.equals("right") && fronttireAngle <= 130) {
            fronttireAngle += 20;

            Timeline rotationAnimation = new Timeline();
            rotationAnimation.getKeyFrames().add(
                    new KeyFrame(
                            Duration.millis(500),
                            new KeyValue(rotationTransform.angleProperty(), fronttireAngle - 90)
                    )
            );
            rotationAnimation.play();
        }
        CoapClient coapClient = new CoapClient();

        JSONObject reqJsonObject = new JSONObject();
        reqJsonObject.put("command", "change");
        reqJsonObject.put("angle", String.valueOf(fronttireAngle));
        String reqJson = reqJsonObject.toString();

        coapClient.setURI("coap://" + uri + "/fronttire");
        CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        String resJson = coapResponse.getResponseText();
        coapClient.shutdown();

        JSONObject resJsonObject = new JSONObject(resJson);
        fronttireAngle = resJsonObject.getInt("angle");
        lblFrontAngle.setText(fronttireAngle + "°");
    }

    private void handleBackTire(ActionEvent e, String direction) {
        CoapClient coapClient = new CoapClient();

        JSONObject reqJsonObject = new JSONObject();
        reqJsonObject.put("command", "change");
        reqJsonObject.put("direction", direction);
        reqJsonObject.put("speed", String.valueOf(backtireSpeed));
        String reqJson = reqJsonObject.toString();

        coapClient.setURI("coap://" + uri + "/backtire");
        CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        String resJson = coapResponse.getResponseText();
        coapClient.shutdown();

        JSONObject resJsonObject = new JSONObject(resJson);
        backtireDirection = resJsonObject.getString("direction");
        lblDirection.setText(backtireDirection);
    }

    private void handleBtnStop(ActionEvent e) {
        CoapClient coapClient = new CoapClient();
        
        JSONObject reqJsonObject = new JSONObject();
        reqJsonObject.put("command", "change");
        reqJsonObject.put("direction", backtireDirection);
        reqJsonObject.put("speed", "0");
        String reqJson = reqJsonObject.toString();

        coapClient.setURI("coap://" + uri + "/backtire");
        CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        String resJson = coapResponse.getResponseText();
        coapClient.shutdown();
        
        JSONObject resJsonObject = new JSONObject(resJson);
        backtireSpeed = Integer.parseInt(resJsonObject.getString("speed"));
        lblKnobSpeed.setText(resJsonObject.getString("speed"));
        
        speedControlKnob.setValue(0);
    }

}
