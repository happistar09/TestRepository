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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class MainController implements Initializable {

	@FXML
	private StackPane stackPane;
	@FXML
	private Button btnVideo;
	@FXML
	private Button btnControl;
	@FXML
	private Button btnConsumed;
	@FXML
	private Button btnNotice;
	@FXML
	private Button btnSetting;
	@FXML
	private Label lblTime;
	@FXML
	private Button btnCall;
	@FXML
	private ImageView packImage;
	@FXML
	private ImageView noticeImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
			btnCall.setOnAction(e -> handleBtnCall(e));
			
    }

	@FXML
	private void handleBtnCheckArrived(ActionEvent event) {
	}

	@FXML
	private void handleBtnCheckAdded(ActionEvent event) {
	}

	private void handleBtnCall(ActionEvent e) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("actuator/Actuator.fxml"));
			stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 Call.fxml이 쌓인다

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
