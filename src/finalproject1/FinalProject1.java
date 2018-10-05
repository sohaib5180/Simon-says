/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject1;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Sohaib Hussain, Anastassia Koustova, Stefano Di Domenico
 * Start method 
 */
public class FinalProject1 extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        //Shapes shape = new Shapes(typeofshape.RECTANGLE);
        //System.out.println(shape.getShape());
        //gamenumbers num = new gamenumbers();
        //System.out.println(num.getNumber());
       File f1 = new File("Players");
       System.out.println(f1.exists());

        Pane root = FXMLLoader.load(getClass().getResource("Layouts/StartPage.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Simon Says");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
