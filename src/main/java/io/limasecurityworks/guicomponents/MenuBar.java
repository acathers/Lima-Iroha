package io.limasecurityworks.guicomponents;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import io.limasecurityworks.gui.IrohaFX;

public class MenuBar extends IrohaFX {

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
                break;
            case "ciphers":
                choice = 1;
                break;
            case "keyring":
                choice = 2;
                break;
            case "settings":
                choice = 3;
                break;
            case "help":
                choice = 4;
                break;
            case "about":
                choice = 5;
                break;
            default:
                choice = 0;
        }

        System.out.println(choice);
            
        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: -limaBlueMedium");

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
            new Button("Key Ring"),
            new Button("Settings"),
            new Button("Help"),
            new Button("About")
        };

        String optionNames[] = new String[] {
            new String("dash"),
            new String("ciphers"),
            new String("keyring"),
            new String("settings"),
            new String("help"),
            new String("about")
        };

        for (int i=0; i<6; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(options[i], new Insets(0, 0, 0, 0));
            options[i].setPrefWidth(menuButtonsW);
            options[i].setPrefHeight(menuButtonsH);

            final int count = i;

            options[i].setOnAction(e -> {
                io.limasecurityworks.gui.IrohaFX.currentSceneChoice = optionNames[count];
                io.limasecurityworks.gui.IrohaFX.splash.setLeft(addVBox(currentSceneChoice));
                io.limasecurityworks.gui.IrohaFX.splashInner.setCenter(buildCurrentSceneChoice(currentSceneChoice));
            });

            if (i == choice) {
                options[i].setStyle("-fx-background-color: rgb(41, 54, 65);");
            }
            vbox.getChildren().addAll(options[i]);
        }
        
        return vbox;
    }
    
}