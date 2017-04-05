package week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 *
 * @author Matt Getz
 */
public class DataStructureTester extends Application {

    Stage pStage;
    TextArea taStatus;
    ScrollPane spStatus;
    TextArea taData;
    ScrollPane spData;

    @Override
    public void start(Stage primaryStage) {
        pStage = primaryStage;

        taData = new TextArea();
        spData = new ScrollPane(taData);
        spData.setFitToWidth(true);
        spData.setFitToHeight(true);

        taStatus = new TextArea();
        spStatus = new ScrollPane(taStatus);
        spStatus.setFitToWidth(true);
        spStatus.setPrefViewportHeight(50);
//        spStatus.setFitToHeight(true);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(myMenuBar());
        borderPane.setCenter(spData);
        borderPane.setBottom(spStatus);

//        Scene scene = new Scene(borderPane, 800, 500);
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Data Structures");
        primaryStage.setScene(scene);

//        primaryStage.setMaximized(true);
//        primaryStage.setFullScreen(true);
        primaryStage.hide();
        primaryStage.show();
    }

    public MenuBar myMenuBar() {
        MenuBar myBar = new MenuBar();
        final Menu fileMenu = new Menu("File");
        final Menu dataMenu = new Menu("Data");
        final Menu sortMenu = new Menu("Sort");
        final Menu searchMenu = new Menu("Search");
        final Menu helpMenu = new Menu("Help");

        myBar.getMenus().addAll(fileMenu, dataMenu, sortMenu, searchMenu, helpMenu);

        /**
         * *********************************************************************
         * File Menu Section
         */
        MenuItem newCanvas = new MenuItem("New");
        newCanvas.setOnAction(e -> {
            taData.clear();
        });
        fileMenu.getItems().add(newCanvas);

        MenuItem open = new MenuItem("Open");
        open.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(pStage);
            if (file != null) {
                readFile(file);
            }
        });
        fileMenu.getItems().add(open);

        MenuItem save = new MenuItem("Save");
        save.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(pStage);
            if (file != null) {
                writeFile(file);
            }
        });
        fileMenu.getItems().add(save);

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> System.exit(0));
        fileMenu.getItems().add(exit);

        /**
         * *********************************************************************
         * Data Menu Section
         */
        MenuItem miGenerateIntegers = new MenuItem("Generate Integers");
        miGenerateIntegers.setOnAction(e -> {
            for (int i = 0; i < 1000; i++) {
                taData.appendText("" + i + "\n");
            }
        });
        dataMenu.getItems().add(miGenerateIntegers);

        MenuItem miRandom = new MenuItem("Randomize Data");
        miRandom.setOnAction(e -> {

        });
        dataMenu.getItems().add(miRandom);

        /**
         * *********************************************************************
         * Sort Menu Section
         */
        MenuItem miSelectionSortAsc = new MenuItem("Selection Sort Ascending");
        sortMenu.getItems().add(miSelectionSortAsc);

        MenuItem miSelectionSortDsc = new MenuItem("Selection Sort Descending");
        sortMenu.getItems().add(miSelectionSortDsc);

        MenuItem miMergeSortAsc = new MenuItem("Merge Sort Ascending");
        sortMenu.getItems().add(miMergeSortAsc);

        MenuItem miMergeSortDsc = new MenuItem("Merge Sort Descending");
        sortMenu.getItems().add(miMergeSortDsc);

        /**
         * *********************************************************************
         * Search Menu Section
         */
        MenuItem miSequentialSearch = new MenuItem("Sequential Search");
        searchMenu.getItems().add(miSequentialSearch);

        MenuItem miBinarySearch = new MenuItem("Binary Search");
        searchMenu.getItems().add(miBinarySearch);

        /**
         * *********************************************************************
         * Help Menu Section
         */
        MenuItem about = new MenuItem("About");
        about.setOnAction(e -> {
            String message = "DATA STRUCTURES AND ALGORITHMS\n";
            Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
            alert.setTitle("About");
            alert.setHeaderText("v1.0 by Matt Getz");
            alert.showAndWait();
        });
        helpMenu.getItems().add(about);

        return myBar;
    }

    /**
     * *************************************************************************
     * File helper methods
     */
    private void readFile(File myFile) {
        int y = 0;
        try (Scanner sc = new Scanner(myFile)) {
            taData.clear();
            while (sc.hasNextLine()) {
                taData.appendText(sc.nextLine() + "\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataStructureTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeFile(File myFile) {
        try (PrintWriter writer = new PrintWriter(myFile)) {
            for (String line : taData.getText().split("\\n")) {
                writer.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(DataStructureTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int[] textToIntArray(String s, int n) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[n];
        for (int i=0; sc.hasNextInt(); i++) {
            nums[i] = sc.nextInt();
        }
        return nums;
    }
    
    public static String intArrayToString (int[] a) {
        StringBuilder sb = new StringBuilder();
        String newLine = "\n";
        for (int value : a) {
            sb.append(Integer.toString(value)).append(newLine);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
