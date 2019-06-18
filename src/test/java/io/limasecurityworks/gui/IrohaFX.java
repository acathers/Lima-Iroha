package io.limasecurityworks.gui;

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

public class IrohaFX extends Application {

    Stage window;
    Double menuButtonsW = 175.0;
    Double menuButtonsH = 50.0;
    Double topButtonsW = 100.0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("limaSecurityWorks - Iroha");

        //GridPane with 10px padding around edge
        BorderPane splash = new BorderPane();
        BorderPane splashInner = new BorderPane();
        
        splash.setLeft(addVBox("splash"));
        splash.setCenter(splashInner);
        splashInner.setTop(addHBox("splash"));
        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Iroha");
        GridPane.setConstraints(nameLabel, 0, 0);

        /*
        //Name Input
        TextField nameInput = new TextField("Bucky");
        GridPane.setConstraints(nameInput, 1, 0);
        //Password Label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 1, 1);
        //Password Input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);
        */

        Scene scene = new Scene(splash, 1475, 800);
        scene.getStylesheets().add("FlatRed.css");
        window.setScene(scene);
        window.show();
    }

    /*
    * Creates a VBox with a list of links for the left region
    */
    private VBox addVBox(String input) {

        int choice;

        switch(input) {
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

        Image logo = new Image("resources/FullColorRed.png");
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

    /*
    * Creates an HBox with two buttons for the top region
    */

    private HBox addHBox(String input) {

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