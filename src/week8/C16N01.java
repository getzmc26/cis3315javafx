package week8;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Matt Getz
 */
public class C16N01 extends Application {
    private double paneWidth = 500;
    private double paneHeight = 150;
    
    @Override
    public void start(Stage primaryStage) {
        String printThisText = "Programming is fun";
        
        Text text = new Text((paneWidth/2) - (printThisText.length()*4), 50, printThisText);
        text.setFont(new Font ("Times", 20));
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        paneForText.setStyle("-fx-border-color: gray");
        
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbBlue = new RadioButton("Blue");
        RadioButton rbGreen = new RadioButton("Green");
        RadioButton rbOrange = new RadioButton("Orange");
        RadioButton rbPurple = new RadioButton("Purple");
        
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbBlue.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbOrange.setToggleGroup(group);
        rbPurple.setToggleGroup(group);
        
        
        HBox hBoxForRadioButtons = new HBox(20);
        hBoxForRadioButtons.getChildren().addAll(rbRed, rbBlue, rbGreen, rbOrange, rbPurple);
        hBoxForRadioButtons.setAlignment(Pos.CENTER);
        hBoxForRadioButtons.setStyle("-fx-border-color: red;-fx-padding: 10 0 10 0");
        
        Button btLeft = new Button("<--");
        Button btRight = new Button("-->");
        
        HBox hBoxForButtons = new HBox(5);
        hBoxForButtons.getChildren().addAll(btLeft, btRight);
        hBoxForButtons.setAlignment(Pos.CENTER);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBoxForRadioButtons);
        borderPane.setCenter(paneForText);
        borderPane.setBottom(hBoxForButtons);
        
        
        Scene scene = new Scene(borderPane, paneWidth, paneHeight);
        
        primaryStage.setTitle("C16N01");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        rbRed.setOnAction(e -> text.setStroke(Color.RED));
        rbBlue.setOnAction(e -> text.setStroke(Color.BLUE));
        rbGreen.setOnAction(e -> text.setStroke(Color.GREEN));
        rbOrange.setOnAction(e -> text.setStroke(Color.ORANGE));
        rbPurple.setOnAction(e -> text.setStroke(Color.PURPLE));
        
        btLeft.setOnAction(e -> text.setX(text.getX() - 8));
        btRight.setOnAction(e -> text.setX(text.getX() + 8));
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
