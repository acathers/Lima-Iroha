package io.limasecurityworks.guicomponents;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import io.limasecurityworks.gui.IrohaFX;

public class MenuBar extends IrohaFX {

    private static Double menuButtonsW = 175.0;
    private static Double menuButtonsH = 50.0;

    /*
     * Creates a VBox with a list of links for the left region
     */
    public static VBox addVBox(String input) {

        int choice;

        switch (input) {
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

        HBox ciphersTopBar[] = new HBox[] { 
            TopBar.addHBoxButtons("dash"), 
            TopBar.addHBoxButtons("ciphers"), 
            TopBar.addHBoxButtons("keyring"), 
            TopBar.addHBoxButtons("settings"), 
            TopBar.addHBoxButtons("help"),
            TopBar.addHBoxButtons("about") 
        };

        for (int i = 0; i < 6; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(options[i], new Insets(0, 0, 0, 0));
            options[i].setPrefWidth(menuButtonsW);
            options[i].setPrefHeight(menuButtonsH);

            final int count = i;

            options[i].setOnAction(e -> {
                io.limasecurityworks.gui.IrohaFX.currentSceneChoice = optionNames[count];
                splash.setLeft(splashInnerLeft);
                splashInnerLeft.setTop(addVBox(currentSceneChoice));
                splashInnerLeft.setBottom(addHBoxSocial(currentSceneChoice));
                splashInner.setCenter(buildCurrentSceneChoice(currentSceneChoice));
                splashInnerTop.setLeft(ciphersTopBar[count]);
            });

            if (i == choice) {
                options[i].setStyle("-fx-background-color: rgb(41, 54, 65);");
            }
            vbox.getChildren().addAll(options[i]);
        }
        return vbox;
    }

    /*
     * Creates social icons to go on right side of the inner borderpane top bar.
     */

    public static HBox addHBoxSocial(String input) {

        String topBarBackHex = "-fx-background-color: -limaBlueMedium";

        // Build HBox for the social icons.
        HBox hboxSocial = new HBox();
        hboxSocial.setPadding(new Insets(0, 0, 0, 0));
        hboxSocial.setStyle(topBarBackHex);
        hboxSocial.setAlignment(Pos.CENTER);
        BorderPane.setMargin(hboxSocial, new Insets(12, 12, 12, 12));

        // Build Discord Button.
        Image discordTopBarImage = new Image("Discord-Logo-White.png");
        Button discordTopBar = new Button();
        discordTopBar.getStyleClass().add("discord-button");
        discordTopBar.setGraphic(new ImageView(discordTopBarImage));
        discordTopBar.setPadding(Insets.EMPTY);
        discordTopBar.setPrefSize(menuButtonsH, menuButtonsH);
        discordTopBar.setStyle(topBarBackHex);

        // Set Discord Button Action

        discordTopBar.setOnAction(e -> {
            IrohaFX show = new IrohaFX();
            show.openBrowser("https://discord.gg/pt5V336");
        });

        // Build GitHub Button.
        Image githubTopBarImage = new Image("GitHub-Mark-Light.png");
        Button githubTopBar = new Button();
        githubTopBar.getStyleClass().add("discord-button");
        githubTopBar.setGraphic(new ImageView(githubTopBarImage));
        githubTopBar.setPadding(Insets.EMPTY);
        githubTopBar.setPrefSize(menuButtonsH, menuButtonsH);
        githubTopBar.setStyle(topBarBackHex);

        // Set Github Button Action

        githubTopBar.setOnAction(e -> {
            IrohaFX show = new IrohaFX();
            show.openBrowser("https://github.com/iskra0332/Lima-Iroha");
        });

        // Get Buttons.
        hboxSocial.getChildren().addAll(discordTopBar, githubTopBar);

        return hboxSocial;
    }

}