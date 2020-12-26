package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

public class GameController implements Initializable{
	@FXML
	private ProgressBar progress;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		progress = new ProgressBar();
        progress.setMinWidth(200);
        progress.setMaxWidth(Double.MAX_VALUE);
        IntegerProperty seconds = new SimpleIntegerProperty();
        progress.progressProperty().bind(seconds.divide(60.0));
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(seconds, 0)),
            new KeyFrame(Duration.minutes(1), e-> {
                // do anything you need here on completion...
                System.out.println("Minute over");
            }, new KeyValue(seconds, 60))   
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
		
	}

}
