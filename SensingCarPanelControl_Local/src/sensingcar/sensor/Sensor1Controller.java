/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this Ultralate file, choose Tools | Ultralates
 * and open the Ultralate in the editor.
 */
package sensingcar.sensor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class Sensor1Controller implements Initializable {

    @FXML
    private AnchorPane btnAngle90;
    @FXML
    private Button btnAngle10;
    @FXML
    private Button btnAngle170;
    @FXML
    private Button btnConfirm;
    @FXML
    private TextField texAngle;

    private String uri = "192.168.35.142";
    @FXML
    private Label lbAngle;
    @FXML
    private Label lbDistance;
    @FXML
    private LineChart chartUltra;

    private XYChart.Series<Number, Number> seriesUltra;
    private XYChart.Series<Number, Number> seriesTracking;
    private static final int MAX_DATA_POINTS = 8;
    private double sequenceUltra = 0;    
    private double sequenceTracking = 0;    
    NumberAxis xAxisUltra;
    NumberAxis yAxisUltra;
    NumberAxis xAxisTracking;
    NumberAxis yAxisTracking;
    
    Observation observation = Observation.getInstance();
    @FXML
    private LineChart chartTracking;
    @FXML
    private Label lbStatus;
    
     private double getDistance() {
        return observation.getDistance();
    }

    private double getTracking() {
        return observation.getTracking();
    }
    
    private void timeToGraph() {
        sensor1Clients();
        
        if (sequenceUltra > MAX_DATA_POINTS + 2) {
            seriesUltra.getData().remove(0);
        } 
        
        seriesUltra.getData().add(new XYChart.Data<Number, Number>(sequenceUltra, getDistance()));      
       
        sequenceUltra++;        
        
        if (sequenceUltra > MAX_DATA_POINTS + 1) {
            //ThermistorSensor Chart
            Timeline timeLineUltra1 = new Timeline();
            KeyValue kvUltra1 = new KeyValue(xAxisUltra.lowerBoundProperty(), xAxisUltra.getLowerBound() + 1);
            KeyFrame kfUltra1 = new KeyFrame(Duration.millis(500), kvUltra1);
            timeLineUltra1.getKeyFrames().add(kfUltra1);
            timeLineUltra1.play();
            Timeline timeLineUltra2 = new Timeline();
            KeyValue kvUltra2 = new KeyValue(xAxisUltra.upperBoundProperty(), xAxisUltra.getUpperBound() + 1);
            KeyFrame kfUltra2 = new KeyFrame(Duration.millis(500), kvUltra2);
            timeLineUltra2.getKeyFrames().add(kfUltra2);
            timeLineUltra2.play();
        }
        
         if (sequenceTracking > MAX_DATA_POINTS + 2) {
            seriesTracking.getData().remove(0);
        }
       
        
        seriesTracking.getData().add(new XYChart.Data<Number, Number>(sequenceTracking, getTracking()));
       
       
        sequenceTracking++;        
        
        if (sequenceTracking > MAX_DATA_POINTS + 1) {
            //ThermistorSensor Chart
            Timeline timeLineTracking1 = new Timeline();
            KeyValue kvTracking1 = new KeyValue(xAxisTracking.lowerBoundProperty(), xAxisTracking.getLowerBound() + 1);
            KeyFrame kfTracking1 = new KeyFrame(Duration.millis(500), kvTracking1);
            timeLineTracking1.getKeyFrames().add(kfTracking1);
            timeLineTracking1.play();
            Timeline timeLineTracking2 = new Timeline();
            KeyValue kvTracking2 = new KeyValue(xAxisTracking.upperBoundProperty(), xAxisTracking.getUpperBound() + 1);
            KeyFrame kfTracking2 = new KeyFrame(Duration.millis(500), kvTracking2);
            timeLineTracking2.getKeyFrames().add(kfTracking2);
            timeLineTracking2.play();
        }
       
       
        
    }
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	       sensor1Clients();
            //UltrasonicSensor Chart
            yAxisUltra = (NumberAxis) chartUltra.getYAxis();
            yAxisUltra.setAutoRanging(true);
            yAxisUltra.setForceZeroInRange(false);
            chartUltra.setAnimated(true);
            chartUltra.setLegendVisible(false);
            xAxisUltra = (NumberAxis) chartUltra.getXAxis();
            xAxisUltra.setAnimated(false);
            xAxisUltra.setLowerBound(0);
            xAxisUltra.setUpperBound(MAX_DATA_POINTS + 1);
            xAxisUltra.setForceZeroInRange(false);
            xAxisUltra.setAutoRanging(false);
            xAxisUltra.setTickUnit(1);
            xAxisUltra.setTickLabelsVisible(false);
            xAxisUltra.setTickMarkVisible(false);
            xAxisUltra.setMinorTickVisible(false);

            seriesUltra = new XYChart.Series();
            seriesUltra.setName("Distance");
            seriesUltra.getData().add(new XYChart.Data<Number, Number>(sequenceUltra++, getDistance()));

            chartUltra.getData().add(seriesUltra);
            
             //TrackingSensor Chart
            yAxisTracking = (NumberAxis) chartTracking.getYAxis();
            yAxisTracking.setAutoRanging(true);
            yAxisTracking.setForceZeroInRange(false);
            chartTracking.setAnimated(true);
            chartTracking.setLegendVisible(false);
            xAxisTracking = (NumberAxis) chartTracking.getXAxis();
            xAxisTracking.setAnimated(false);
            xAxisTracking.setLowerBound(0);
            xAxisTracking.setUpperBound(MAX_DATA_POINTS + 1);
            xAxisTracking.setForceZeroInRange(false);
            xAxisTracking.setAutoRanging(false);
            xAxisTracking.setTickUnit(1);
            xAxisTracking.setTickLabelsVisible(false);
            xAxisTracking.setTickMarkVisible(false);
            xAxisTracking.setMinorTickVisible(false);

            seriesTracking = new XYChart.Series();
            seriesTracking.setName("Tracking");
            seriesTracking.getData().add(new XYChart.Data<Number, Number>(sequenceTracking++, getTracking()));

            chartTracking.getData().add(seriesTracking);
            
           Thread thread = new Thread(() -> {
               while (true) {
                   try {
                       Thread.sleep(1500);
                   } catch (InterruptedException ex) {
                   }
                   Platform.runLater(() -> {
                       timeToGraph();
                   });

               }
           });
           thread.setDaemon(true);
           thread.start();

    }
	
        private void sensor1Clients() {
        
        CoapClient coapClient = new CoapClient();
        JSONObject resJsonObject = null;
        CoapResponse coapResponse = null;
        String resJson = null;

        JSONObject reqJsonObject = new JSONObject();
        reqJsonObject.put("command", "status");
        String reqJson = reqJsonObject.toString();

        // ultrasonicsensor
        coapClient.setURI("coap://" + uri + "/ultrasonicsensor");
        coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        resJson = coapResponse.getResponseText();
        resJsonObject = new JSONObject(resJson);
        lbAngle.setText(resJsonObject.getString("angle"));
        lbDistance.setText(resJsonObject.getString("distance"));
        
        // trackingsensor
        coapClient.setURI("coap://" + uri + "/trackingsensor");
        coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        resJson = coapResponse.getResponseText();
        resJsonObject = new JSONObject(resJson);
        lbStatus.setText(resJsonObject.getString("tracking"));
        
        
       coapClient.shutdown();
       
       
        }
}
