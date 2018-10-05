/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject1;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

  /**
 *SwitchPage
 * @author Sohaib Hussain
 */
public class SwitchPage {
    
    private final Pane currentpage;
    
  
     /**
 * SwitchPage -switches pages
 * @param currentpage, passes the current page the stage is on
 * 
 */ 
    public SwitchPage(Pane currentpage){
        this.currentpage=currentpage;
    }
  /**
 *ToPage
 * @param ToPageDir, a string of the dir. to page
 * @throws IOException
 * 
 */   
    public void ToPage(String ToPageDir) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(ToPageDir));
        Stage stage = (Stage) currentpage.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    
     /**
 *PassData
 * @param destURL, the destURL that is passed so the stages can switch
 * @param data, score label data
 * @throws IOException
 * 
 */ 
    public void PassData(String destURL ,String data) throws IOException{
        FXMLLoader Loader = new FXMLLoader(getClass().getResource(destURL));
        Parent root = (Parent) Loader.load();
        EndScreenPageController endpage = Loader.getController();
        endpage.ScoreLabelSetText(data);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }   
    
}
