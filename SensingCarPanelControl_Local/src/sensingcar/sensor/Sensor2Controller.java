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
import javafx.util.Duration;

public class Sensor2Controller implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private LineChart chartTemp;
    @FXML
    private LineChart chartPhoto;
    @FXML
    private LineChart chartGas;

    private XYChart.Series<Number, Number> seriesTemp;
    private XYChart.Series<Number, Number> seriesPhoto;
    private XYChart.Series<Number, Number> seriesGas;
    private static final int MAX_DATA_POINTS = 8;
    private double sequence1 = 0;
    private double sequence2 = 0;
    private double sequence3 = 0;
    NumberAxis xAxisTemp;
    NumberAxis yAxisTemp;
    NumberAxis xAxisPhoto;
    NumberAxis yAxisPhoto;
    NumberAxis xAxisGas;
    NumberAxis yAxisGas;
    Observation observation = Observation.getInstance();
    @FXML
    private Label lblTemp;
    @FXML
    private Label lblPhoto;
    @FXML
    private Label lblGas;

    private double getTemperature() {
        return observation.getTemperature();
    }

    private double getPhotoresistor() {
        return observation.getPhotoresistorValue();
    }

    private double getGasValue() {
        return observation.getGasValue();
    }

    private void timeToGraph() {
        if (sequence1 > MAX_DATA_POINTS + 2) {
            seriesTemp.getData().remove(0);
        }
        if (sequence2 > MAX_DATA_POINTS + 2) {
            seriesPhoto.getData().remove(0);
        }
        if (sequence3 > MAX_DATA_POINTS + 2) {
            seriesGas.getData().remove(0);
        }
        seriesTemp.getData().add(new XYChart.Data<Number, Number>(sequence1, getTemperature()));
        seriesPhoto.getData().add(new XYChart.Data<Number, Number>(sequence2, getPhotoresistor()));
        seriesGas.getData().add(new XYChart.Data<Number, Number>(sequence3, getGasValue()));
        sequence1++;
        sequence2++;
        sequence3++;
        if (sequence1 > MAX_DATA_POINTS + 1) {
            //ThermistorSensor Chart
            Timeline timeLineTemp1 = new Timeline();
            KeyValue kvTemp1 = new KeyValue(xAxisTemp.lowerBoundProperty(), xAxisTemp.getLowerBound() + 1);
            KeyFrame kfTemp1 = new KeyFrame(Duration.millis(500), kvTemp1);
            timeLineTemp1.getKeyFrames().add(kfTemp1);
            timeLineTemp1.play();
            Timeline timeLineTemp2 = new Timeline();
            KeyValue kvTemp2 = new KeyValue(xAxisTemp.upperBoundProperty(), xAxisTemp.getUpperBound() + 1);
            KeyFrame kfTemp2 = new KeyFrame(Duration.millis(500), kvTemp2);
            timeLineTemp2.getKeyFrames().add(kfTemp2);
            timeLineTemp2.play();
        }
        if (sequence2 > MAX_DATA_POINTS + 1) {
            //PhotoresistorSensor Chart
            Timeline timeLinePhoto1 = new Timeline();
            KeyValue kvPhoto1 = new KeyValue(xAxisPhoto.lowerBoundProperty(), xAxisPhoto.getLowerBound() + 1);
            KeyFrame kfPhoto1 = new KeyFrame(Duration.millis(500), kvPhoto1);
            timeLinePhoto1.getKeyFrames().add(kfPhoto1);
            timeLinePhoto1.play();
            Timeline timeLinePhoto2 = new Timeline();
            KeyValue kvPhoto2 = new KeyValue(xAxisPhoto.upperBoundProperty(), xAxisPhoto.getUpperBound() + 1);
            KeyFrame kfPhoto2 = new KeyFrame(Duration.millis(500), kvPhoto2);
            timeLinePhoto2.getKeyFrames().add(kfPhoto2);
            timeLinePhoto2.play();
        }
        if (sequence3 > MAX_DATA_POINTS + 1) {
            //GasSensor Chart
            Timeline timeLineGas1 = new Timeline();
            KeyValue kvGas1 = new KeyValue(xAxisGas.lowerBoundProperty(), xAxisGas.getLowerBound() + 1);
            KeyFrame kfGas1 = new KeyFrame(Duration.millis(500), kvGas1);
            timeLineGas1.getKeyFrames().add(kfGas1);
            timeLineGas1.play();
            Timeline timeLineGas2 = new Timeline();
            KeyValue kvGas2 = new KeyValue(xAxisGas.upperBoundProperty(), xAxisGas.getUpperBound() + 1);
            KeyFrame kfGas2 = new KeyFrame(Duration.millis(500), kvGas2);
            timeLineGas2.getKeyFrames().add(kfGas2);
            timeLineGas2.play();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblTemp.setText(String.valueOf(getTemperature()));
        lblPhoto.setText(String.valueOf(getPhotoresistor()));
        lblGas.setText(String.valueOf(getGasValue()));
        //ThermistorSensor Chart
        yAxisTemp = (NumberAxis) chartTemp.getYAxis();
        yAxisTemp.setAutoRanging(true);
        yAxisTemp.setForceZeroInRange(false);
        chartTemp.setAnimated(true);
        chartTemp.setLegendVisible(false);
        xAxisTemp = (NumberAxis) chartTemp.getXAxis();
        xAxisTemp.setAnimated(false);
        xAxisTemp.setLowerBound(0);
        xAxisTemp.setUpperBound(MAX_DATA_POINTS + 1);
        xAxisTemp.setForceZeroInRange(false);
        xAxisTemp.setAutoRanging(false);
        xAxisTemp.setTickUnit(1);
        xAxisTemp.setTickLabelsVisible(false);
        xAxisTemp.setTickMarkVisible(false);
        xAxisTemp.setMinorTickVisible(false);

        seriesTemp = new XYChart.Series();
        seriesTemp.setName("Temperature");
        seriesTemp.getData().add(new XYChart.Data<Number, Number>(sequence1++, getTemperature()));

        chartTemp.getData().add(seriesTemp);

        chartTemp.getStylesheets().add(getClass().getResource("TemperatureChart.css").toString());
        chartTemp.applyCss();
        chartTemp.setTitle("      ThermistorSensor");

        //PhotoresistorSensor Chart
        yAxisPhoto = (NumberAxis) chartPhoto.getYAxis();
        yAxisPhoto.setAutoRanging(true);
        yAxisPhoto.setForceZeroInRange(false);
        chartPhoto.setAnimated(true);
        chartPhoto.setLegendVisible(false);
        xAxisPhoto = (NumberAxis) chartPhoto.getXAxis();
        xAxisPhoto.setAnimated(false);
        xAxisPhoto.setLowerBound(0);
        xAxisPhoto.setUpperBound(MAX_DATA_POINTS + 1);
        xAxisPhoto.setForceZeroInRange(false);
        xAxisPhoto.setAutoRanging(false);
        xAxisPhoto.setTickUnit(1);
        xAxisPhoto.setTickLabelsVisible(false);
        xAxisPhoto.setTickMarkVisible(false);
        xAxisPhoto.setMinorTickVisible(false);

        seriesPhoto = new XYChart.Series();
        seriesPhoto.setName("Photoresistor");
        seriesPhoto.getData().add(new XYChart.Data<Number, Number>(sequence2++, getPhotoresistor()));

        chartPhoto.getData().add(seriesPhoto);

        chartPhoto.getStylesheets().add(getClass().getResource("PhotoresistorChart.css").toString());
        chartPhoto.applyCss();
        chartPhoto.setTitle("        PhotoresistorSensor");

        //GasSensor Chart
        yAxisGas = (NumberAxis) chartGas.getYAxis();
        yAxisGas.setAutoRanging(true);
        yAxisGas.setForceZeroInRange(false);
        chartGas.setAnimated(true);
        chartGas.setLegendVisible(false);
        xAxisGas = (NumberAxis) chartGas.getXAxis();
        xAxisGas.setAnimated(false);
        xAxisGas.setLowerBound(0);
        xAxisGas.setUpperBound(MAX_DATA_POINTS + 1);
        xAxisGas.setForceZeroInRange(false);
        xAxisGas.setAutoRanging(false);
        xAxisGas.setTickUnit(1);
        xAxisGas.setTickLabelsVisible(false);
        xAxisGas.setTickMarkVisible(false);
        xAxisGas.setMinorTickVisible(false);

        seriesGas = new XYChart.Series();
        seriesGas.setName("GasSensor");
        seriesGas.getData().add(new XYChart.Data<Number, Number>(sequence3++, getGasValue()));

        chartGas.getData().add(seriesGas);

        chartGas.getStylesheets().add(getClass().getResource("GasChart.css").toString());
        chartGas.applyCss();
        chartGas.setTitle("     GasSensor");

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
                Platform.runLater(() -> {
                    lblTemp.setText(String.valueOf(getTemperature()));
                    lblPhoto.setText(String.valueOf(getPhotoresistor()));
                    lblGas.setText(String.valueOf(getGasValue()));
                    timeToGraph();
                });

            }
        });
        thread.setDaemon(true);
        thread.start();

    }

}
