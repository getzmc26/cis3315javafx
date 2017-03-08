package week7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class C15N02 extends Application {

    @Override
    public void start(Stage primaryStage) {

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(200);
        rectangle.setHeight(75);
        rectangle.setFill(Color.GREEN);

        
        Button rotateRight = new Button("-->");

        rotateRight.setOnAction(e -> {
            rectangle.setRotate(rectangle.getRotate() + 10);
        });

        Button rotateLeft = new Button("<--");

        rotateLeft.setOnAction(e -> {
            rectangle.setRotate(rectangle.getRotate() - 10);
        });

        
        BorderPane pane = new BorderPane();
        pane.setCenter(rectangle);
        pane.setLeft(rotateLeft);
        pane.setRight(rotateRight);
        BorderPane.setAlignment(rectangle, Pos.CENTER);
        BorderPane.setAlignment(rotateLeft, Pos.CENTER);
        BorderPane.setAlignment(rotateRight, Pos.CENTER);
        pane.setPadding(new Insets(30, 30, 30, 30));

        Scene scene = new Scene(pane, 500, 350);
        primaryStage.setTitle("C15N02");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
