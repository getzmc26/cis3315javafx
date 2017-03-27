package week8;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

/**
 *
 * @author Matt Getz
 */
public class C16N22 extends Application {
    AudioClip audioClip = new AudioClip(
            "http://www.cs.armstrong.edu/liang/common/audio/anthem/anthem2.mp3");
    
    @Override
    public void start(Stage primaryStage) {
        Button btPlay = new Button("Play");
        Button btLoop = new Button("Loop");
        Button btStop = new Button("Stop");
        
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btPlay, btLoop, btStop);
        
        btPlay.setOnAction(e -> {
            audioClip.setCycleCount(1);
            audioClip.play();
        });
        
        btLoop.setOnAction(e -> {
            audioClip.setCycleCount(Timeline.INDEFINITE);
            audioClip.play();
        });
        
        btLoop.setOnAction(e -> {
            audioClip.setCycleCount(Timeline.INDEFINITE);
            audioClip.play();
        });
        
        btLoop.setOnAction(e -> audioClip.stop());
        
        Scene scene = new Scene(hBox, 200, 150);
        
        primaryStage.setTitle("C16N22");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
