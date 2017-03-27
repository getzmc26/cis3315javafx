package week8;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Create a Java FX application that calculates the hypotenuse of a triangle
 * given the length of the sides. See the attached image for the screen design.
 * Complete the TODO sections.
 *
 * @author Matt Getz
 */
public class HypotenuseCalculatorFX extends Application {

    TextField tfA, tfB, tfC;

    @Override
    public void start(Stage primaryStage) {

        Label lbTitle = new Label("Pythagorean Calculator");
        lbTitle.setStyle(" -fx-font-size: 24pt; -fx-text-fill: #ff0000;");
        HBox hBoxTitle = new HBox();
        hBoxTitle.setAlignment(Pos.CENTER);
        hBoxTitle.getChildren().add(lbTitle);

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 20; -fx-alignment: center;");

        Label lbSideA = new Label("Side A");
        lbSideA.setStyle("-fx-font-size: 18pt; -fx-text-fill: #0000ff;");
        gridPane.add(lbSideA, 0, 0);
        tfA = new TextField();
        gridPane.add(tfA, 1, 0);
        
        Label lbSideB = new Label("Side B");
        lbSideB.setStyle("-fx-font-size: 18pt; -fx-text-fill: #0000ff;");
        gridPane.add(lbSideB, 0, 1);
        tfB = new TextField();
        gridPane.add(tfB, 1, 1);
        
        Label lbSideC = new Label("Side C");
        lbSideC.setStyle("-fx-font-size: 18pt; -fx-text-fill: #0000ff;");
        gridPane.add(lbSideC, 0, 2);
        tfC = new TextField();
        tfC.setPromptText("Enter A and B then calc C");
        tfC.setEditable(false);
        gridPane.add(tfC, 1, 2);
        
        Button btn = new Button();
        btn.setText("Calculate");
        btn.setStyle("-fx-font-size: 18pt; -fx-padding: 10; -fx-text-fill: #0000ff;");
        btn.setOnAction((ActionEvent e) -> calculate());

        HBox hBoxBtn = new HBox();
        hBoxBtn.setAlignment(Pos.CENTER);
        hBoxBtn.getChildren().add(btn);

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-padding: 20;");
        borderPane.setTop(hBoxTitle);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(btn);
        BorderPane.setAlignment(btn, Pos.BOTTOM_CENTER);
        
        

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Calculator!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculate() {
       double sideA = Double.parseDouble(tfA.getText());
       double sideB = Double.parseDouble(tfB.getText());
       double answer =  Math.sqrt(Math.pow(sideA, 2) + (Math.pow(sideB, 2)));
       
       tfC.setText(String.format("%.2f", answer));   
    }

    public static void main(String[] args) {
        launch(args);
    }

}
