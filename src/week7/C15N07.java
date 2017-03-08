package week7;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Matt Getz
 */
public class C15N07 extends Application {
    
    @Override
    public void start(Stage primaryStage) { 
        StackPane pane = new StackPane();
        Circle circle = new Circle(50, 50, 40);
        pane.getChildren().add(circle);
        pane.setAlignment(Pos.CENTER);
        circle.setFill(Color.GREEN);
        circle.setStroke(Color.BLACK);
        
        circle.setOnMousePressed(e -> {
            circle.setFill(Color.PURPLE);
        });
        
        circle.setOnMouseReleased(e -> {
            circle.setFill(Color.GREEN);
        });
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("C15N07");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }  
}
