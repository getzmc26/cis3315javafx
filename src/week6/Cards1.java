/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Panes:
 *  Pane - parent pane (often used as a canvas)
 *  StackPane - places objects on top of each other, like placing a circle and then text on top of the circle
 *  FlowPane - places objects left to right in pane as long as it has room in the set pane size, then objects drop down to a new row (expand the window will auto adjust everything)
 *  HBox - Horizontally across the screen
 *  VBox - vertically across the screen
 *  GridPane - rows and columns
 *  BorderPane - top, bottom, left, right, and center
 * @author Matt Getz
 */
public class Cards1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane hbox1 = new HBox(-40);
        ScrollPane sp1 = new ScrollPane(hbox1);
        hbox1.setPadding(new Insets(50, 50, 50, 50));
        
        ImageView[] iv1 = new ImageView[5];
        for (int i = 0; i < 5; i++) {
            iv1[i] = new ImageView(new Image("image/card/" + (i+1) + ".png"));
        }
        
        hbox1.getChildren().addAll(iv1);
        
        
        Pane hbox2 = new HBox(-40);
        ScrollPane sp2 = new ScrollPane(hbox2);
        hbox2.setPadding(new Insets(50, 50, 50, 50));
        
        ImageView[] iv2 = new ImageView[5];
        for (int i = 0; i < 5; i++) {
            iv2[i] = new ImageView(new Image("image/card/" + (i+1) + ".png"));
        }
        
        hbox2.getChildren().addAll(iv2);
        
        BorderPane bpane = new BorderPane();
        bpane.setLeft(sp1);
        bpane.setRight(sp2);
        
        
        
        
        
//        iv[1].setImage(new Image("image/card/" + (53) + ".png"));
        
        Scene scene = new Scene(bpane, 600, 250);
        
        primaryStage.setTitle("Cards1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
