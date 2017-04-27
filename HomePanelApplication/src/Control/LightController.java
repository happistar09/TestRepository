
package Control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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

@Override
	public void initialize(URL url, ResourceBundle rb) {
		btnOnOffMain.setOnAction(e -> handleBtnOnOffMain(e));
		btnOnOffBigRoom.setOnAction(e -> handleBtnOnOffBigRoom(e));
		btnOnOffRoom1.setOnAction(e -> handleBtnOnOffRoom1(e));
		btnOnOffRoom2.setOnAction(e -> handleBtnOnOffRoom2(e));
		btnOnOffRoom3.setOnAction(e -> handleBtnOnOffRoom3(e));
	}	
	private void handleBtnOnOffMain(ActionEvent e){	
		if((btnOnOffMain.getText()).equals("ON")){
			btnOnOffMain.setText("OFF");
		}
		else{
			btnOnOffMain.setText("ON");
		}
	}
	
	private void handleBtnOnOffBigRoom(ActionEvent e){	
		if((btnOnOffBigRoom.getText()).equals("ON")){
			btnOnOffBigRoom.setText("OFF");
		}
		else{
			btnOnOffBigRoom.setText("ON");
		}
	}
	
	private void handleBtnOnOffRoom1(ActionEvent e){	
		if((btnOnOffRoom1.getText()).equals("ON")){
			btnOnOffRoom1.setText("OFF");
		}
		else{
			btnOnOffRoom1.setText("ON");
		}
	}
	
	private void handleBtnOnOffRoom2(ActionEvent e){	
		if((btnOnOffRoom2.getText()).equals("ON")){
			btnOnOffRoom2.setText("OFF");
		}
		else{
			btnOnOffRoom2.setText("ON");
		}
	}
	
	private void handleBtnOnOffRoom3(ActionEvent e){	
		if((btnOnOffRoom3.getText()).equals("ON")){
			btnOnOffRoom3.setText("OFF");
		}
		else{
			btnOnOffRoom3.setText("ON");
		}
	}
}