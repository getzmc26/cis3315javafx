/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class C14N06 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        
        for (int row = 0; row < 8; row++) {
            boolean isWhite = row % 2 == 0;
            for (int col = 0; col < 8; col++) {
                Rectangle rect = new Rectangle(25+row*50, 25+col*50, 50, 50);
                if (isWhite) {
                    rect.setFill(Color.GREEN);
                }
                else {
                    rect.setFill(Color.BLACK);
                }
                isWhite = !isWhite;
                pane.getChildren().add(rect);
            }
        }

        Scene scene = new Scene(pane, 450, 450);
        
        primaryStage.setTitle("C14N06");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
