package io.limasecurityworks.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import io.limasecurityworks.ui.*;

public class IrohaFX extends Application {

    Stage window;
    Double menuButtons = 175.0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("limaSecurityWorks - Iroha");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30, 10, 10, 0));
        grid.setVgap(0);
        grid.setHgap(0);

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

        //Dashboard button
        Button dashButton = new Button("Dash Board");
        GridPane.setConstraints(dashButton, 0, 1);
        dashButton.setPrefWidth(menuButtons);
        dashButton.setStyle("-fx-background-radius: 0");

        //Ciphers button
        Button ciphersButton = new Button("Ciphers");
        GridPane.setConstraints(ciphersButton, 0, 2);
        ciphersButton.setPrefWidth(menuButtons);
        ciphersButton.setStyle("-fx-background-radius: 0");

        //Settings button
        Button settingsButton = new Button("Settings");
        GridPane.setConstraints(settingsButton, 0, 3);
        settingsButton.setPrefWidth(menuButtons);
        settingsButton.setStyle("-fx-background-radius: 0");

        //Help button
        Button helpButton = new Button("Help");
        GridPane.setConstraints(helpButton, 0, 4);
        helpButton.setPrefWidth(menuButtons);
        helpButton.setStyle("-fx-background-radius: 0");

        //About button
        Button aboutButton = new Button("About");
        GridPane.setConstraints(aboutButton, 0, 5);
        aboutButton.setPrefWidth(menuButtons);
        aboutButton.setStyle("-fx-background-radius: 0");

        //Add everything to grid
        grid.getChildren().addAll(nameLabel, dashButton, ciphersButton, settingsButton, helpButton, aboutButton);

        Scene scene = new Scene(grid, 800, 600);
        scene.getStylesheets().add("FlatRed.css");
        window.setScene(scene);
        window.show();


    }
}