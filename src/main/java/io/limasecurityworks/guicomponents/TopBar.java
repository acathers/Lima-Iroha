package io.limasecurityworks.guicomponents;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import io.limasecurityworks.gui.IrohaFX;
import javafx.geometry.Pos;

public class TopBar extends IrohaFX {

    private static Double menuButtonsW = 175.0;
    private static Double menuButtonsH = 50.0;
    private static Double topButtonsW = 100.0;

    /*
    * Creates an HBox with buttons if needed for the left side of inner BorderPane top
    */

    public static HBox addHBoxButtons(String input) {

        String topBarBackHex = "-fx-background-color: -limaBlueLight";

        HBox hboxButtons = new HBox();
        hboxButtons.setPadding(new Insets(0, 0, 0, 0));
        hboxButtons.setStyle(topBarBackHex);

        Button spacer1 = new Button("");
        spacer1.setPrefSize(topButtonsW, menuButtonsH);
        spacer1.setStyle(topBarBackHex);

        Button buttonCurrent = new Button("Current");
        buttonCurrent.setPrefSize(topButtonsW, menuButtonsH);
        buttonCurrent.setStyle(topBarBackHex);

        Button buttonProjected = new Button("Projected");
        buttonProjected.setPrefSize(topButtonsW, menuButtonsH);
        buttonProjected.setStyle(topBarBackHex);
        
        hboxButtons.getChildren().addAll(spacer1, buttonCurrent, buttonProjected);
        
        return hboxButtons;
    }

    /*
    * Creates social icons to go on right side of the inner borderpane top bar.
    */

    public static HBox addHBoxSocial(String input) {

        String topBarBackHex = "-fx-background-color: -limaBlueLight";

        // Build HBox for the social icons.
        HBox hboxSocial = new HBox();
        hboxSocial.setPadding(new Insets(0, 0, 0, 0));
        hboxSocial.setStyle(topBarBackHex);

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
        hboxSocial.setAlignment(Pos. CENTER_RIGHT);

        return hboxSocial;
    }
}