package smarthomepanel.video;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author suyang
 */
public class VideoController implements Initializable {

    @FXML
    private Button btn_back;
    @FXML
    private Label lblTime;
    
    @FXML
    private Button btn_bfront;
    
    @FXML
    private Button btn_dfront;
    
    @FXML
    private Button btn_door;
 
    @FXML
    private Button btn_home;
    
  //  private StackPane callingControl;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //시간 표시
        SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm");
				String strTime = sdf.format(new Date());
        lblTime.setText(strTime);
        // 버튼 이벤트 처리
        btn_bfront.setOnAction(event->handleBtnBFront(event));
        btn_dfront.setOnAction(event->handleBtnDFront(event));
        btn_door.setOnAction(event->handleBtnOpen(event));
    }    
    @FXML
    private void handleBtnBFront(ActionEvent event1) {
        try{
            Stage dialog1 = new Stage(StageStyle.UTILITY);
            dialog1.initModality(Modality.WINDOW_MODAL);
            dialog1.initOwner(btn_bfront.getScene().getWindow());
            dialog1.setTitle("동 입구 화면");
            
            Parent parent1 = FXMLLoader.load(getClass().getResource("buildingScreen.fxml"));
            
            Button btn_back1 = (Button) parent1.lookup("#btn_back1");
            btn_back1.setOnAction(e1->dialog1.close());
            
            Scene scene1 = new Scene(parent1);
            dialog1.setScene(scene1);
            dialog1.setResizable(false);
            dialog1.show();
            
        }catch(IOException ex1){}
       
    }

    @FXML
    private void handleBtnDFront(ActionEvent event2) {
           try{
            Stage dialog2 = new Stage(StageStyle.UTILITY);
            dialog2.initModality(Modality.WINDOW_MODAL);
            dialog2.initOwner(btn_dfront.getScene().getWindow());
            dialog2.setTitle("현관 입구 화면");
            
            Parent parent2 = FXMLLoader.load(getClass().getResource("doorfrontScreen.fxml"));
            
            Button btn_back2 = (Button) parent2.lookup("#btn_back2");
            btn_back2.setOnAction(e2->dialog2.close());
            
            Scene scene2 = new Scene(parent2);
            dialog2.setScene(scene2);
            dialog2.setResizable(false);
            dialog2.show();
            
        }catch(IOException ex2){}
       
        
    }

    @FXML
    private void handleBtnOpen(ActionEvent event3) {
        Button btn_door = (Button) event3.getSource();
        System.out.println(event3.getSource().toString());
        if((btn_door.getText()).equals("문 열기")){
            btn_door.setText("문 닫기");
           // btn_door.setId("btn_door_back");
            //System.out.println(e3.getSource().toString());
            System.out.println("문이 열림");
        }
        else if((btn_door.getText()).equals("문 닫기")){
            btn_door.setText("문 열기");
           // btn_door.setId("btn_door");
//            System.out.println(e3.getSource().toString());
            System.out.println("문이 닫힘");
        }
                
        
        
        
    }
    
}
