package sensingcar;

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
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class MainController implements Initializable {

	@FXML
	private StackPane stackPane;
	@FXML
	private Button btnCameraMotor;
	@FXML
	private Button btnActuator;
	@FXML
	private Button btnWheel;
	@FXML
	private Button btnSensor1;
	@FXML
	private Button btnSensor2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
			btnCameraMotor.setOnAction(e -> handleBtnCameraMotor(e));
			btnActuator.setOnAction(e -> handleBtnActuator(e));
			btnWheel.setOnAction(e -> handleBtnWheel(e));
			btnSensor1.setOnAction(e -> handleBtnSensor1(e));
			btnSensor2.setOnAction(e -> handleBtnSensor2(e));
    }
		
	private void handleBtnCameraMotor(ActionEvent e) {
		try {			
			Parent parent = FXMLLoader.load(getClass().getResource("motor/cameramotor.fxml"));
			stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 Vidio.fxml이 쌓인다

			parent.setOpacity(0);

			KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
			Timeline timeLine = new Timeline();
			timeLine.getKeyFrames().add(keyFrame);
			timeLine.play();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void handleBtnActuator(ActionEvent e) {
		try {			
			Parent parent = FXMLLoader.load(getClass().getResource("actuator/Actuator.fxml"));
			stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 Vidio.fxml이 쌓인다

			parent.setOpacity(0);

			KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
			Timeline timeLine = new Timeline();
			timeLine.getKeyFrames().add(keyFrame);
			timeLine.play();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void handleBtnWheel(ActionEvent e) {
		try {			
			Parent parent = FXMLLoader.load(getClass().getResource("motor/wheel.fxml"));
			stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 Vidio.fxml이 쌓인다

			parent.setOpacity(0);

			KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
			Timeline timeLine = new Timeline();
			timeLine.getKeyFrames().add(keyFrame);
			timeLine.play();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void handleBtnSensor1(ActionEvent e) {
		try {			
			Parent parent = FXMLLoader.load(getClass().getResource("sensor/Sensor1.fxml"));
			stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 Vidio.fxml이 쌓인다

			parent.setOpacity(0);

			KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
			Timeline timeLine = new Timeline();
			timeLine.getKeyFrames().add(keyFrame);
			timeLine.play();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void handleBtnSensor2(ActionEvent e) {
		try {			
			Parent parent = FXMLLoader.load(getClass().getResource("sensor/Sensor2.fxml"));
			stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 Vidio.fxml이 쌓인다

			parent.setOpacity(0);

			KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
			Timeline timeLine = new Timeline();
			timeLine.getKeyFrames().add(keyFrame);
			timeLine.play();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
