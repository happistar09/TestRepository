/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam27;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class RootController implements Initializable {

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void menuItemNew(ActionEvent event) {
        System.out.println("새로만들기 클릭됨");
    }

    @FXML
    private void menuItemSave(ActionEvent event) {
        System.out.println("파일이 저장됨");
    }
    
}
