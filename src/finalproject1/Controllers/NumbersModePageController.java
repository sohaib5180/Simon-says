/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject1;

import finalprojectclasses.gamenumbers;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *Numbers mode Page
 * @author Anastassia Koustova
 */
public class NumbersModePageController implements Initializable {

    private final gamenumbers numbermode = new gamenumbers();
    private int tempnum = 1;
    private final ArrayList<String> numbersequence = new ArrayList();
    private final ArrayList<String> userNumbersequence = new ArrayList();
    private  int level;
    private int score = 0;
    private int scorelimitperlevel = 1000;
    
    @FXML
    private Label scoreLb1;
    @FXML
    private Label scoreLb2;
    @FXML
    private Button One;
    @FXML
    private Button Two;
    @FXML
    private Button Three;
    @FXML
    private Button Four;
    @FXML
    private Button Five;
    @FXML
    private Button Six;
    @FXML
    private Button Seven;
    @FXML
    private Button Eight;
    @FXML
    private Button Nine;
    
   @FXML
   private VBox anchorPanenumbermode;
    
    
    @FXML
    private void OnActionOne(ActionEvent e) throws InterruptedException, IOException {
        AllButtonActions(1);
    }

    @FXML
    private void OnActionTwo(ActionEvent e) throws InterruptedException, IOException {
        AllButtonActions(2);
    }

    @FXML
    private void OnActionThree(ActionEvent e) throws InterruptedException, IOException {
        AllButtonActions(3);
    }

    @FXML
    private void OnActionFour(ActionEvent e) throws InterruptedException, IOException {
        AllButtonActions(4);
    }

    @FXML
    private void OnActionFive(ActionEvent e) throws InterruptedException, IOException {
        AllButtonActions(5);
    }

    @FXML
    private void OnActionSix(ActionEvent e) throws InterruptedException, IOException {
        AllButtonActions(6);
    }

    @FXML
    private void OnActionSeven(ActionEvent e) throws InterruptedException, IOException {
        AllButtonActions(7);
    }

    @FXML
    private void OnActionEight(ActionEvent e) throws InterruptedException, IOException {
        AllButtonActions(8);
    }

    @FXML
    private void OnActionNine(ActionEvent e) throws InterruptedException, IOException {
        AllButtonActions(9);
    }
    
       /**
 *AllButtonAction- Full actions set on the buttons
 * @param i, passed number for button
 * @exception IOException , throws an exception on error 
     * @throws InterruptedException
     * 
 */ 
    
    public void AllButtonActions(int i) throws IOException, InterruptedException{
        if(userNumbersequence.size() != numbersequence.size()){
            userNumbersequence.add(NumtoString(i));
        }
        if(userNumbersequence.size()==level && numbersequence.size()==level){
            if(RightSequence()){
               System.out.println("Correct!");
               AddScores();
               numbersequence.clear();
               userNumbersequence.clear();
               FirstStepDelayMethod();
            }
            else{
                 SwitchPage sw = new SwitchPage(anchorPanenumbermode);    
                 sw.PassData("Layouts/EndScreenPage.fxml", Integer.toString(score));
                 Stage stage= (Stage) Three.getScene().getWindow();
                 stage.close();
                 System.out.println("Wrong!");
            }  
        }
    }
     /**
 *AddScores-adds the score and adds up the level
 * 
 * 
 */ 
    private void AddScores(){
        score = score + 100 + ((level) * 100);
        
        if(score >= scorelimitperlevel){
            scorelimitperlevel = (int) (scorelimitperlevel + (scorelimitperlevel*((level-1)*1.5)));
            level = level + 1;
        }
        scoreLb1.setText(score+"/"+scorelimitperlevel);
        scoreLb2.setText(Integer.toString(level-1));
        
         
    } 
     /**
 *BlinkButton - puts the fade transition on the buttons
 * @param button, button passed to blink
 * @throws InterruptedException, an exception that runs when there is an interrupted event
 * 
 */ 
    private void BlinkButton(Button button) throws InterruptedException{
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5),button);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
        
    }
     /**
 *NumtoString - translates the numbers that are generated into a string
 * @param i, the  number passed to be translated into a string
 * @return number , return the above number in a string 
 * 
 */ 
    private String NumtoString(int i){
          String number = null;
          
          switch(i){
              case 1: number="One";
                      break;
              case 2: number="Two";
                      break;
              case 3: number="Three";
                      break;
              case 4: number="Four";
                      break;
              case 5: number="Five";
                      break;
              case 6: number="Six";  
                      break;
              case 7: number="Seven";
                      break;
              case 8: number="Eight";
                      break;
              case 9: number="Nine"; 
                      break;
          }
          return number;    
    }
    
     /**
 *getButton - gets the button that matches the string value
 * @param i, number passed to match the button to a number
 * @return button, returns which button is matched
 * 
 */ 
    private Button getbutton(int i){
        Button button =null;
          
          switch(i){
              case 1: button=One;
                      break;
              case 2: button=Two;
                      break;
              case 3: button=Three;
                      break;
              case 4: button=Four;
                      break;
              case 5: button=Five;
                      break;
              case 6: button=Six;  
                      break;
              case 7: button=Seven;
                      break;
              case 8: button=Eight;
                      break;
              case 9: button=Nine; 
                      break;
          }
          return button;    
    }
     /**
 *FirstStepDelayMethod
 * @throws InterruptedException, an exception that runs when there is an interrupted event
 * Delays the FirstStepMethod
 * 
 */  
    private void FirstStepDelayMethod() throws InterruptedException {       
       Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(1000),
                ae -> {
                    try {
                        FirstStepMethod();
                    } catch (InterruptedException ex) {
                       System.out.println("FirstStepMethod issue");
                    }
                }));
           timeline.setCycleCount(level);
           timeline.play(); 
    }
   
 /**
 *FirstStepMethod- starts by picking a number, pushing it into an arraylist,
 * and calling the BlinkButton method
 * @throws InterruptedException, an exception that runs when there is an interrupted event
 * 
 */     
    private void FirstStepMethod() throws InterruptedException{
        tempnum = numbermode.getNumber();
        numbersequence.add(NumtoString(tempnum));
        BlinkButton(getbutton(tempnum));
    }
    /**
    *RightSequence - checks if the sequence matches the user sequence,
 * and that its all there
 * @return equals && containsAll, returns the booleans for comparison and if it has the full sequence 
 * 
 */ 
    private boolean RightSequence(){
        
        boolean equals = numbersequence.equals(userNumbersequence);
        boolean containsAll = numbersequence.containsAll(userNumbersequence) &&
                              userNumbersequence.containsAll(numbersequence);
        return equals && containsAll;
    }

    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        level = 2;
        try {
            FirstStepDelayMethod();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumbersModePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
     

    
}
