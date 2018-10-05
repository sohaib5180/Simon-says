/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *This page is for the highscore page, it is connected via buttons 
 * and uses the 
 * 
 * @author Sohaib Hussain
 */
public class HighScorePageController implements Initializable {

    @FXML
    private ListView<String>  HighscoreList;

    @FXML
    private VBox VBoxHighscore;
    
    private ObservableList<String> items = FXCollections.observableArrayList();
     
    @FXML         
    private void backhome(ActionEvent e) throws IOException{
        System.out.println("WORKING!!");    
        SwitchPage sw = new SwitchPage(VBoxHighscore);
        sw.ToPage("Layouts/StartPage.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       FromFile fromfile = new FromFile("Players");
       ArrayList<String> finalw = new ArrayList();
       int c1=0,c2=1;
       
        try {
            if(fromfile.retrieve() != null || !(fromfile.retrieve().isEmpty())){
                finalw.addAll(fromfile.retrieve());
            }
            else{
                System.out.println("No Files or no data in files!");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HighScorePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      if(!finalw.isEmpty()){
         for (int i = 0; i < finalw.size()/2; i++) {
            items.add(finalw.get(c1) +"        "+ finalw.get(c2));
            System.out.println(finalw.get(c1) +" " + finalw.get(c2));
            c1=c1+2;
            c2=c2+2;
        } 
      }
      else{
          System.out.println("Arraylist is empty");
      }
        
        if(!items.isEmpty()){
             HighscoreList.setItems(items);
        }
        else{
            System.out.println("ObservableList is Empty");
        }
       
    }
} 
