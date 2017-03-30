package week8;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Create a GUI Java FX application that implements a monthly expense
 * calculator. See the attached image for the screen design.
 *
 * @author Your Name Here
 */
public class ExpenseCalculator extends Application {

    private TextField tfRent, tfUtilities, tfFood, tfOther, tfTotal;

    @Override
    public void start(Stage primaryStage) {

        Text txTitle = new Text("Expense Calculator");
        txTitle.setStyle("-fx-font-size: 28pt;");
        HBox hBoxTitle = new HBox();
        hBoxTitle.setAlignment(Pos.CENTER);
        hBoxTitle.getChildren().add(txTitle);

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 20; -fx-alignment: center;");

        Label lbMonth = new Label("Month Name");
        lbMonth.setStyle("-fx-font-size: 14pt;");
        gridPane.add(lbMonth, 0, 0);

        // TODO - add the remaining months
        ObservableList<String> options = FXCollections.observableArrayList(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        final ComboBox comboBox = new ComboBox(options);
        gridPane.add(comboBox, 1, 0);

        Label lbRent = new Label("Rent");
        lbRent.setStyle("-fx-font-size: 14pt;");
        gridPane.add(lbRent, 0, 1);

        tfRent = new TextField();
        tfRent.setAlignment(Pos.BASELINE_RIGHT);
        gridPane.add(tfRent, 1, 1);
        
        Label lbUtilities = new Label("Utilities");
        lbUtilities.setStyle("-fx-font-size: 14pt;");
        gridPane.add(lbUtilities, 0, 2);

        tfUtilities = new TextField();
        tfUtilities.setAlignment(Pos.BASELINE_RIGHT);
        gridPane.add(tfUtilities, 1, 2);
        
        Label lbFood = new Label("Food");
        lbFood.setStyle("-fx-font-size: 14pt;");
        gridPane.add(lbFood, 0, 3);

        tfFood = new TextField();
        tfFood.setAlignment(Pos.BASELINE_RIGHT);
        gridPane.add(tfFood, 1, 3);
        
        Label lbOther = new Label("Other Expenses");
        lbOther.setStyle("-fx-font-size: 14pt;");
        gridPane.add(lbOther, 0, 4);

        tfOther = new TextField();
        tfOther.setAlignment(Pos.BASELINE_RIGHT);
        gridPane.add(tfOther, 1, 4);
        
        Label lbTotal = new Label("Total");
        lbTotal.setStyle("-fx-font-size: 14pt;");
        gridPane.add(lbTotal, 0, 5);

        tfTotal = new TextField();
        tfTotal.setAlignment(Pos.BASELINE_RIGHT);
        tfTotal.setEditable(false);
        gridPane.add(tfTotal, 1, 5);

        Button btnCalculate = new Button();
        btnCalculate.setText("Calculate");
        btnCalculate.setStyle("-fx-font-size: 16pt; -fx-padding: 10; -fx-text-fill: #ff0000;");
        btnCalculate.setOnAction((ActionEvent e) -> calculate());

        Button btnClear = new Button();
        btnClear.setText("Clear");
        btnClear.setStyle("-fx-font-size: 16pt; -fx-padding: 10;");
        btnClear.setOnAction((ActionEvent e) -> clear());

        HBox hBoxBtn = new HBox();
        hBoxBtn.setAlignment(Pos.CENTER);
        hBoxBtn.setSpacing(20);
        hBoxBtn.getChildren().addAll(btnClear, btnCalculate);

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-padding: 20; -fx-alignment: center;");
        borderPane.setTop(hBoxTitle);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(hBoxBtn);

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Monthly Expenses");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculate() {
        double rent = 0, utilities = 0, food = 0, other = 0;
        double total = 0;

        // TODO - check that each text field has a value and if not then set to 0.00
        if (tfRent.getText().equals("")) {
            tfRent.setText("0.00");
        }
        else {
            rent += Double.parseDouble(tfRent.getText());          
        }
        if (tfUtilities.getText().equals("")) {
            tfUtilities.setText("0.00");
        }
        else {
            utilities += Double.parseDouble(tfUtilities.getText());          
        }  
        if (tfFood.getText().equals("")) {
            tfFood.setText("0.00");
        }
        else {
            food += Double.parseDouble(tfFood.getText());          
        }  
        if (tfOther.getText().equals("")) {
            tfOther.setText("0.00");
        }
        else {
            other += Double.parseDouble(tfOther.getText());          
        }
        total += rent + utilities + food + other;
        tfTotal.setText(String.format("%.2f", total));
    }
    
    private void clear() {
        tfRent.setText("");
        tfUtilities.setText("");
        tfFood.setText("");
        tfOther.setText("");
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}
