package sensingcar.actuator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;


public class ActuatorController implements Initializable {

	@FXML
	private AnchorPane mainControl;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnHeating11;
	@FXML
	private ImageView imageMain1;
	@FXML
	private ImageView imageMain2;
	@FXML
	private ImageView imageMain11;
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
	
	private String uri = "192.168.3.24";
	


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		actuatorClients();
		
		sliderRed.setValue(0);
		sliderGreen.setValue(0);
		sliderBlue.setValue(0);
		sliderRed.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(sliderRed.getValue());
				CoapClient coapClient = new CoapClient();
				JSONObject reqJsonObject = new JSONObject();
				reqJsonObject.put("command", "change");
				reqJsonObject.put("red", String.valueOf(sliderRed.getValue()));
				reqJsonObject.put("green", String.valueOf(sliderGreen.getValue()));
				reqJsonObject.put("blue", String.valueOf(sliderBlue.getValue()));
				String reqJson = reqJsonObject.toString();

				coapClient.setURI("coap://" + uri + "/rgbled");
				CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
				String resJson = coapResponse.getResponseText();
				coapClient.shutdown();

				JSONObject resJsonObject = new JSONObject(resJson);
				sliderRed.setValue(resJsonObject.getDouble("red"));
				sliderGreen.setValue(resJsonObject.getDouble("green"));
				sliderBlue.setValue(resJsonObject.getDouble("blue"));
			}
        });
		sliderGreen.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(sliderRed.getValue());
				CoapClient coapClient = new CoapClient();
				JSONObject reqJsonObject = new JSONObject();
				reqJsonObject.put("command", "change");
				reqJsonObject.put("red", String.valueOf(sliderRed.getValue()));
				reqJsonObject.put("green", String.valueOf(sliderGreen.getValue()));
				reqJsonObject.put("blue", String.valueOf(sliderBlue.getValue()));
				String reqJson = reqJsonObject.toString();

				coapClient.setURI("coap://" + uri + "/rgbled");
				CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
				String resJson = coapResponse.getResponseText();
				coapClient.shutdown();

				JSONObject resJsonObject = new JSONObject(resJson);
				sliderRed.setValue(resJsonObject.getDouble("red"));
				sliderGreen.setValue(resJsonObject.getDouble("green"));
				sliderBlue.setValue(resJsonObject.getDouble("blue"));
			}
		});
		sliderBlue.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(sliderRed.getValue());
				CoapClient coapClient = new CoapClient();
				JSONObject reqJsonObject = new JSONObject();
				reqJsonObject.put("command", "change");
				reqJsonObject.put("red", String.valueOf(sliderRed.getValue()));
				reqJsonObject.put("green", String.valueOf(sliderGreen.getValue()));
				reqJsonObject.put("blue", String.valueOf(sliderBlue.getValue()));	
				String reqJson = reqJsonObject.toString();

				coapClient.setURI("coap://" + uri + "/rgbled");
				CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
				String resJson = coapResponse.getResponseText();
				coapClient.shutdown();

				JSONObject resJsonObject = new JSONObject(resJson);
				sliderRed.setValue(resJsonObject.getDouble("red"));
				sliderGreen.setValue(resJsonObject.getDouble("green"));
				sliderBlue.setValue(resJsonObject.getDouble("blue"));
			}
        });
		
		
	}	
	
	private void actuatorClients(){
		CoapClient coapClient = new CoapClient();
        JSONObject resJsonObject = null;
        CoapResponse coapResponse = null;
        String resJson = null;

        JSONObject reqJsonObject = new JSONObject();
        reqJsonObject.put("command", "status");
        String reqJson = reqJsonObject.toString();
		coapClient.setURI("coap://" + uri + "/rgbled");
        coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        resJson = coapResponse.getResponseText();
        resJsonObject = new JSONObject(resJson);
		
		sliderRed.setValue(resJsonObject.getDouble("red"));
		sliderGreen.setValue(resJsonObject.getDouble("green"));
		sliderBlue.setValue(resJsonObject.getDouble("blue"));
		
		
	}
	
}
