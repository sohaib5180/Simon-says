
package finalproject1;
import finalprojectclasses.*;
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
 * FXML Controller class
 *
 * @author Stefano Di Domenico
 */
public class ColourModePageController implements Initializable {

   private Colours colours;
   private ArrayList<String> coloursequence = new ArrayList();
   private ArrayList<String> userColoursequence = new ArrayList();
   private int level;
   private int score;
   private int scorelimitperlevel = 1000;
   
   @FXML
   private VBox VBoxColourMode;
   
   @FXML
   private Label scoreLb1;
   
   @FXML
   private Label scoreLb2;
   
   @FXML
   private Button btnRed;
   
   @FXML 
   private Button btnBlue;
   
   @FXML
   private Button btnGreen;
   
   @FXML
   private Button btnYellow;
   
  @FXML 
   public void ButtonRed() throws InterruptedException, IOException{
       AllButtonAction(new Colours(EnumColours.RED).getColourName());
   }
   
  @FXML 
   public void ButtonBlue(ActionEvent e) throws InterruptedException, IOException{
       AllButtonAction(new Colours(EnumColours.BLUE).getColourName());
   }
   
   @FXML
   public void ButtonGreen(ActionEvent e) throws InterruptedException, IOException{
       AllButtonAction(new Colours(EnumColours.GREEN).getColourName());
   }
   
  @FXML
   public void ButtonYellow(ActionEvent e) throws InterruptedException, IOException{
       AllButtonAction(new Colours(EnumColours.YELLOW).getColourName());
   }
   
    /**
 *AllButtonAction- Full actions set on the buttons
 * @throws IOException, InterruptedException
 * 
 */ 
   
   private void AllButtonAction(String Colour) throws InterruptedException, IOException{
       if(userColoursequence.size() != coloursequence.size()){
           userColoursequence.add((Colour));
        }
        if(userColoursequence.size()==level && coloursequence.size()==level){
            if(RightSequence()){
               System.out.println("Correct!");
               AddScores();
               coloursequence.clear();
               userColoursequence.clear();
               FirstStepDelayMethod();
            }
            else{
                 SwitchPage sw = new SwitchPage(VBoxColourMode);    
                 sw.PassData("Layouts/EndScreenPage.fxml", Integer.toString(score));
                 Stage stage = (Stage) btnRed.getScene().getWindow();
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
 *FirstStepDelayMethod
 * @throws InterruptedException
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
 *RightSequence - checks if the sequence matches the user sequence,
 * and that its all there
 * @return equals && containsAll
 * 
 */ 
   private boolean RightSequence(){
        
        boolean equals = coloursequence.equals(userColoursequence);
        boolean containsAll = coloursequence.containsAll(userColoursequence) &&
                              userColoursequence.containsAll(coloursequence);
        return equals && containsAll;
    }
 /**
 *BlinkButton - puts the fade transition on the buttons
 * @param Button button
 * @throws InterruptedException
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
 *getButton - gets the button that matches the string value
 * @param String i
 * 
 */ 
   private Button getbutton(String i){
          
         if(i.compareToIgnoreCase("red")==0){
             return btnRed;
         }
         if(i.compareToIgnoreCase("blue")==0){
             return btnBlue;
         }
         if(i.compareToIgnoreCase("green")==0){
             return btnGreen;
         }
         if(i.compareToIgnoreCase("yellow")==0){
             return btnYellow;
         }
         else{
             return null; 
         }
  
}
    /**
 *getRandomColour -gets a random colour
 * @return colours
 */ 
   private Colours getRandomColour(){
        
        int temp = (int) (Math.random()*4 +1);
        switch (temp) {
            case 1:
                colours = new Colours(EnumColours.BLUE);
                break;
            case 2:
                colours = new Colours(EnumColours.GREEN);
                break;
            case 3:
                colours = new Colours(EnumColours.RED);
                break;
            default:
                colours = new Colours(EnumColours.YELLOW);
                break;
        }
         return colours;
    }
   
 /**
 *FirstStepMethod- starts by picking a colour, pushing it into an arraylist,
 * and calling the BlinkButton method
 * @throws InterruptedException
 * 
 */    
   private void FirstStepMethod() throws InterruptedException{
        Colours tempcolour = getRandomColour();
        coloursequence.add(tempcolour.getColourName());
        BlinkButton(getbutton(tempcolour.getColourName()));
    }

   @Override
    public void initialize(URL location, ResourceBundle resources) {
        level=2;
        try {
            FirstStepDelayMethod();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumbersModePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
