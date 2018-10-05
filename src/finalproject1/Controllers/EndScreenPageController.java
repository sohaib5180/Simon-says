/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sohaib Hussain, Anastassia Koustova
 */
public class EndScreenPageController implements Initializable {

    @FXML
    private VBox VBoxEndScreen;
    
    @FXML
    private Label ScoreAfterEnd;
    
    @FXML TextField Username;
    
    private int score;
    
    @FXML
    private void GoBackHome(ActionEvent e) throws IOException{
        //Stage stage = (Stage) ScoreAfterEnd.getScene().getWindow();
        //stage.close();       
        SwitchPage sw = new SwitchPage(VBoxEndScreen);
        sw.ToPage("Layouts/StartPage.fxml");
    }
    @FXML
    private void ExitApplication(ActionEvent e){
        Platform.exit();
    }
    @FXML
    private void Submit(ActionEvent e) throws IOException{
        if(Username.getText().compareToIgnoreCase("")==0){
            Alert fail= new Alert(AlertType.INFORMATION);
            fail.setHeaderText("failure");
            fail.setContentText("you havent typed a username");
            fail.showAndWait();
        }
        else{
            ToFile tofile = new ToFile(score,Username.getText(),"Players",true);
            tofile.send();
        }
    }
 /**
 *ScoreLabelSetText - sets the scorelabel
 * 
     * @param i, is a passed strong for the score
 */        
    public void ScoreLabelSetText(String i){
        try{
            score = Integer.parseInt(i);
        }
        catch (NumberFormatException e){
            System.out.println("Not a valid score, could not save score");
        }
     
     this.ScoreAfterEnd.setText(i);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
