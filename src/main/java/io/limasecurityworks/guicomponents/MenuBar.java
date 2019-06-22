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

public class MenuBar {

    private static Double menuButtonsW = 175.0;
    private static Double menuButtonsH = 50.0;
    private static Double topButtonsW = 100.0;

    /*
    * Creates a VBox with a list of links for the left region
    */
    public static VBox addVBox(String input) {

        int choice;

        switch(input) {
            case "dash":
                choice = 0;
            case "ciphers":
                choice = 1;
                break;
            case "settings":
                choice = 2;
                break;
            case "help":
                choice = 3;
                break;
            case "about":
                choice = 4;
                break;
            default:
                choice = 0;
        }
            
        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: rgb(50, 66, 80);");

        Image logo = new Image("FullColorOrangeR.png");
        ImageView logoIV = new ImageView();
        logoIV.setImage(logo);
        logoIV.setFitWidth(menuButtonsW);
        logoIV.setPreserveRatio(true);
        logoIV.setSmooth(true);
        logoIV.setCache(true);

        vbox.getChildren().add(0, logoIV);
        
        Button options[] = new Button[] {
            new Button("Dashboard"),
            new Button("Ciphers"),
            new Button("Settings"),
            new Button("Help"),
            new Button("About")};

        for (int i=0; i<5; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(options[i], new Insets(0, 0, 0, 0));
            options[i].setPrefWidth(menuButtonsW);
            options[i].setPrefHeight(menuButtonsH);

            if (i == choice) {
                options[i].setStyle("-fx-background-color: rgb(41, 54, 65);");
            }
            vbox.getChildren().addAll(options[i]);
        }
        
        return vbox;
    }
    
}