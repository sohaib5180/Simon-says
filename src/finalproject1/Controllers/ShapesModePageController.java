/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Sohaib Hussain
 */
public class ShapesModePageController implements Initializable{
  
    
    private final Shapes Triangle = new Shapes(typeofshape.TRIANGLE);
    private final Shapes Trapezoid = new Shapes(typeofshape.TRAPEZOID);
    private final Shapes Hexagon = new Shapes(typeofshape.HEXAGON);
    private final Shapes rectangle = new Shapes(typeofshape.RECTANGLE);
    private ArrayList<String> shapesequence = new ArrayList();
    private ArrayList<String> userShapesequence = new ArrayList();
    private boolean correct;
    private int level;
    private Shapes shapes;
    private int score;
    private int scorelimitperlevel=1000;
   
    
    
    @FXML
    private VBox VBoxShapeMode;
    @FXML
    private Label scoreLb1;
    @FXML
    private Label scoreLb2;
    @FXML
    private Button ButtonTriangle;
    @FXML 
    private Button ButtonHexagon;
    @FXML
    private Button ButtonTrapezoid;
    @FXML
    private Button ButtonRectangle;
    
    @FXML
    private void OnActionTriangle(ActionEvent e) throws InterruptedException, IOException{
        AllButtonAction(Triangle.getShape());
    }
    @FXML
    private void OnActionRectangle(ActionEvent e) throws InterruptedException, IOException{
        AllButtonAction(rectangle.getShape());
    }
    @FXML
    private void OnActionHexagon(ActionEvent e) throws InterruptedException, IOException{
        AllButtonAction(Hexagon.getShape());
    }
    @FXML
    private void OnActionTrapezoid(ActionEvent e) throws InterruptedException, IOException{
        AllButtonAction(Trapezoid.getShape());
    }
    
         /**
 *AllButtonAction- Full actions set on the buttons
 * @param String shape
 * @throws IOException, InterruptedException
 * 
 */ 
    
    private void AllButtonAction(String shape) throws InterruptedException, IOException{
        if(userShapesequence.size() != shapesequence.size()){
           userShapesequence.add(shape);
        }
        if(userShapesequence.size()==level && shapesequence.size()==level){
            if(RightSequence()){
               System.out.println("Correct!");
               AddScores();
               shapesequence.clear();
               userShapesequence.clear();
               FirstStepDelayMethod();
            }
            else{
                 SwitchPage sw = new SwitchPage(VBoxShapeMode);    
                 sw.PassData("Layouts/EndScreenPage.fxml", Integer.toString(score));
                 Stage stage = (Stage) ButtonTriangle.getScene().getWindow();
                 stage.close();
                 System.out.println("Wrong!");
            }  
        }
    }
    
       /**
 *getButton - gets the button that matches the string value
 * @param String i
 * @return button
 * 
 */  
    private Button getbutton(String i){
          
         if(i.compareToIgnoreCase("triangle")==0){
             return ButtonTriangle;
         }
         if(i.compareToIgnoreCase("hexagon")==0){
             return ButtonHexagon;
         }
         if(i.compareToIgnoreCase("trapezoid")==0){
             return ButtonTrapezoid;
         }
         if(i.compareToIgnoreCase("rectangle")==0){
             return ButtonRectangle;
         }
         else{
             return null; 
         }
 }
    
       /**
 *getRandomShape -gets a random shape
 * @return shape
 */ 
    private Shapes getRandomShape(){
        
        int temp = (int) (Math.random()*4 +1);
        switch (temp) {
            case 1:
                shapes = new Shapes(typeofshape.HEXAGON);
                break;
            case 2:
                shapes = new Shapes(typeofshape.RECTANGLE);
                break;
            case 3:
                shapes=new Shapes(typeofshape.TRAPEZOID);
                break;
            default:
                shapes = new Shapes(typeofshape.TRIANGLE);
                break;
        }
         return shapes;
    }

    
   /**
 *FirstStepMethod- starts by picking a shape, pushing it into an arraylist,
 * and calling the BlinkButton method
 * @throws InterruptedException
 * 
 */   
private void FirstStepMethod() throws InterruptedException{
        Shapes tempshape = getRandomShape();
        shapesequence.add(tempshape.getShape());
        BlinkButton(getbutton(tempshape.getShape()));
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
        
        boolean equals = shapesequence.equals(userShapesequence);
        boolean containsAll = shapesequence.containsAll(userShapesequence) &&
                              userShapesequence.containsAll(shapesequence);
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
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {    
      level=2;
      ButtonTriangle.setShape(Triangle.getShapeDrawing());
      ButtonTrapezoid.setShape(Trapezoid.getShapeDrawing());
      ButtonHexagon.setShape(Hexagon.getShapeDrawing());
        try {
            FirstStepDelayMethod();
        } catch (InterruptedException ex) {
            Logger.getLogger(NumbersModePageController.class.getName()).log(Level.SEVERE, null, ex);
        }

      
    }    
    
}
