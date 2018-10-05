/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 *How To Play page. Connected via buttons.
 * @author Anastassia Koustova 
 */
public class HowToPlayPageController implements Initializable {
    
    @FXML
    private AnchorPane HowToPlayPane;
    @FXML
    private void GoBackHome(ActionEvent e) throws IOException{
        SwitchPage sw = new SwitchPage(HowToPlayPane);
        sw.ToPage("Layouts/StartPage.fxml");  
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
