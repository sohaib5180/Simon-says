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
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Sohaib Hussain
 * 
 * This page connects all the modes
 */
public class SelectModePageController implements Initializable {

   @FXML
   private VBox VBoxSelectMode;
   
   @FXML
   private void shapesmode(ActionEvent e) throws IOException{
       System.out.println("Shapes Mode!!");
       SwitchPage sw = new SwitchPage(VBoxSelectMode);
       sw.ToPage("Layouts/shapesModePage.fxml");
   }
   
  @FXML 
   private void numbersmode(ActionEvent e) throws IOException, InterruptedException{
       SwitchPage sw = new SwitchPage(VBoxSelectMode);
       sw.ToPage("Layouts/NumbersModePage.fxml");      
   }
   
   @FXML
   private void coloursmode(ActionEvent e) throws IOException{
       System.out.println("Colours Mode!!");
       SwitchPage sw = new SwitchPage(VBoxSelectMode);
       sw.ToPage("Layouts/ColourMode.fxml");
   }
   
   @FXML
   private void backhome(ActionEvent e) throws IOException{
       SwitchPage sw = new SwitchPage(VBoxSelectMode);
       sw.ToPage("Layouts/StartPage.fxml");
   }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
