package io.limasecurityworks.guicomponents;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TopBar {

    private static Double menuButtonsW = 175.0;
    private static Double menuButtonsH = 50.0;
    private static Double topButtonsW = 100.0;

    /*
    * Creates an HBox with two buttons for the top region
    */

    public static HBox addHBox(String input) {

        String topBarBack = "-fx-background-color: rgba(66, 93, 117, 0.5);";
        String topBarBackHex = "-fx-background-color: #36495B";

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(0, 0, 0, 0));
        hbox.setStyle(topBarBackHex);

        Button spacer1 = new Button("");
        spacer1.setPrefSize(topButtonsW, menuButtonsH);
        spacer1.setStyle(topBarBackHex);

        Button buttonCurrent = new Button("Current");
        buttonCurrent.setPrefSize(topButtonsW, menuButtonsH);
        buttonCurrent.setStyle(topBarBackHex);

        Button buttonProjected = new Button("Projected");
        buttonProjected.setPrefSize(topButtonsW, menuButtonsH);
        buttonProjected.setStyle(topBarBackHex);
        
        hbox.getChildren().addAll(spacer1, buttonCurrent, buttonProjected);
        
        return hbox;
    }
}