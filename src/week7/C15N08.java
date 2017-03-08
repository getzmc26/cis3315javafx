package week7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class C15N08 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Text text = new Text();
        pane.getChildren().add(text);
        
        pane.setOnMousePressed(e -> {
           text.setX(e.getX());
           text.setY(e.getY());
           text.setText(e.getX() + ", " + e.getY());
        });
        
        Scene scene = new Scene(pane, 500, 500);
        
        primaryStage.setTitle("C15N08");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    } 
}
