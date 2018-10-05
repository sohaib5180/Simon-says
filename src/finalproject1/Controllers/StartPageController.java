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
 * The start page
 */
public class StartPageController implements Initializable {

    @FXML
    private VBox VBoxStartPage;

    @FXML
    private void HandleOnStartGame(ActionEvent e) throws IOException {
        SwitchPage sw = new SwitchPage(VBoxStartPage);
        sw.ToPage("Layouts/SelectModePage.fxml");

    }

    @FXML
    private void HandleOnHighScore(ActionEvent e) throws IOException {
        SwitchPage sw = new SwitchPage(VBoxStartPage);
        sw.ToPage("Layouts/HighScorePage.fxml");
    }

    @FXML
    private void HandleOnHowToPlay(ActionEvent e) throws IOException {
        SwitchPage sw = new SwitchPage(VBoxStartPage);
        sw.ToPage("Layouts/HowToPlay.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
