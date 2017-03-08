package week7;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Matt Getz
 */
public class C15N01 extends Application {

    @Override
    public void start(Stage primaryStage) {
        List<Integer> list = new ArrayList();
        for (int i = 1; i <= 52; i++) {
            list.add(i);
        }
        java.util.Collections.shuffle(list);

        HBox hbox = new HBox(-40);
        hbox.setAlignment(Pos.CENTER);
        for (int i = 0; i < 5; i++) {
            hbox.getChildren().add(new ImageView("image/card/" + list.get(i) + ".png"));
        }

        Button btRefresh = new Button("Refresh");
        btRefresh.setOnAction(e -> {
            java.util.Collections.shuffle(list);
            hbox.getChildren().clear();
            for (int i = 0; i < 5; i++) {
                hbox.getChildren().add(new ImageView("image/card/" + list.get(i) + ".png"));
            }
        });

        BorderPane pane = new BorderPane();
        pane.setCenter(hbox);
        pane.setBottom(btRefresh);
        pane.setPadding(new Insets(30, 30, 30, 30));
        BorderPane.setAlignment(btRefresh, Pos.TOP_CENTER);
        
        Scene scene = new Scene(pane, 500, 250);

        primaryStage.setTitle("C15N01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
