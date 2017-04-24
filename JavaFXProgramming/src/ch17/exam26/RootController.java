
package ch17.exam26;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Background;


public class RootController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<String, Integer> barChart;
    @FXML
    private AreaChart<String, Integer> areaChart;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<PieChart.Data> data1 = FXCollections.observableArrayList();
        data1.add(new PieChart.Data("AWT",10));
        data1.add(new PieChart.Data("Swing",30));
        data1.add(new PieChart.Data("SWT",25));
        data1.add(new PieChart.Data("JavaFX",35));
        pieChart.setData(data1);
        
        XYChart.Series series1 = new XYChart.Series<>();
        series1.setName("남자");
        ObservableList<XYChart.Data> data2 = FXCollections.observableArrayList();
        data2.add(new XYChart.Data("2015", 70));
        data2.add(new XYChart.Data("2016", 40));
        data2.add(new XYChart.Data("2017", 50));
        data2.add(new XYChart.Data("2018", 30));
        series1.setData(data2);
        barChart.getData().add(series1);
        
        
        XYChart.Series series2 = new XYChart.Series<>();
        series2.setName("여자");
        ObservableList<XYChart.Data> data3 = FXCollections.observableArrayList();
        data3.add(new XYChart.Data("2015", 30));
        data3.add(new XYChart.Data("2016", 60));
        data3.add(new XYChart.Data("2017", 50));
        data3.add(new XYChart.Data("2018", 70));
        series2.setData(data3);
        barChart.getData().add(series2);
        
        XYChart.Series series3 = new XYChart.Series<>();
        series3.setName("평균온도");
        ObservableList<XYChart.Data> data4 = FXCollections.observableArrayList();
        data4.add(new XYChart.Data("2015", 13));
        data4.add(new XYChart.Data("2016", 11));
        data4.add(new XYChart.Data("2017", 15));
        data4.add(new XYChart.Data("2018", 7));
        series3.setData(data4);        
        areaChart.getData().add(series3);
        
        XYChart.Series series4 = new XYChart.Series<>();
        series4.setName("최고온도");
        ObservableList<XYChart.Data> data5 = FXCollections.observableArrayList();
        data5.add(new XYChart.Data("2015", 25));
        data5.add(new XYChart.Data("2016", 26));
        data5.add(new XYChart.Data("2017", 31));
        data5.add(new XYChart.Data("2018", 24));
        series4.setData(data5);        
        areaChart.getData().add(series4);
        
        
        
        
    }    
    
}
