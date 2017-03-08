package week6;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Matt Getz
 */
public class C14N03 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ImageView> view = new ArrayList<>();
        
        for (int i=1; i<=52; i++) {
            list.add(i);
        }
        java.util.Collections.shuffle(list);
        
        for (int i = 0; i<5; i++) {
            view.add(new ImageView("image/card/" + list.get(i) + ".png"));        
        }
        
        HBox pane = new HBox(5);
        pane.setAlignment(Pos.CENTER);
        
        for (int i = 0; i<5; i++) {
//            pane.getChildren().add(new ImageView("image/card/" + list.get(i) + ".png"));
            pane.getChildren().add(view.get(i));
        }
//        pane.getChildren().add(new ImageView("image/card/" + list.get(0) + ".png"));
//        pane.getChildren().add(new ImageView("image/card/" + list.get(1) + ".png"));
//        pane.getChildren().add(new ImageView("image/card/" + list.get(2) + ".png"));
//        pane.getChildren().add(new ImageView("image/card/" + list.get(3) + ".png"));
//        pane.getChildren().add(new ImageView("image/card/" + list.get(4) + ".png"));
        
        Scene scene = new Scene(pane, 500, 250);
        
        primaryStage.setTitle("C14N03");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
