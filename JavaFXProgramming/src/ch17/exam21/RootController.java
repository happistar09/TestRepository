
package ch17.exam21;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class RootController implements Initializable {
    
    @FXML
    private ListView<Food> listView;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setCellFactory(new Callback<ListView<Food>, ListCell<Food>>(){
            @Override
            public ListCell<Food> call(ListView<Food> param) {
                ListCell<Food> listCell = new ListCell<Food>(){
                    @Override
                    protected void updateItem(Food item, boolean empty) {
                        super.updateItem(item, empty); 
                        if(empty) return;
                        
                        try {
                            HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("item.fxml"));
                            ImageView foodImage = (ImageView) hbox.lookup("#image");
                            Label foodName = (Label) hbox.lookup("#name");
                            ImageView scoreImage = (ImageView) hbox.lookup("#scoreImage");
                            Label foodDescription = (Label) hbox.lookup("#description");
                            
                            foodImage.setImage(new Image(getClass().getResource("images/"+item.getImage()).toString()));                           
                            foodName.setText(item.getName());                            
                            scoreImage.setImage(new Image(getClass().getResource("images/star"+item.getScore() + ".png").toString()));
                            foodDescription.setText(item.getDescription());
                            
                            setGraphic(hbox);
                            
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    
                    }
                   
                };
                return listCell;
            }            
        });
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Food>(){
            @Override
            public void changed(ObservableValue<? extends Food> observable, Food oldValue, Food newValue) {
                System.out.println(newValue.getName() + ":" + newValue.getImage());
            }
        
        });
        ObservableList<Food> value = FXCollections.observableArrayList();
        value.add(new Food("Food01.png", "삼겹살", 10, "최고 b"));
        value.add(new Food("Food02.png", "정체불명", 1, "이게 뭘까요"));
        value.add(new Food("Food03.png", "장어", 7, "힘이 난다!"));
        value.add(new Food("Food04.png", "비빔밥", 8, "한국 대표 음식 비빔밥"));
        value.add(new Food("Food05.png", "볶음밥", 6, "언제 먹어도 맛있다"));        
        listView.setItems(value);
    }


    
}
