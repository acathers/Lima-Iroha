package io.limasecurityworks.guicomponents; 

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;
import io.limasecurityworks.gui.*;

public class DashFX extends IrohaFX{

    public static GridPane buildDash() {

        // Set up GridPane for dash.

        GridPane dashGridPane = new GridPane();

        dashGridPane.setAlignment(Pos.TOP_CENTER);
        dashGridPane.setVgap(50);
        dashGridPane.setHgap(15);

        for (int i = 0; i < 5; i++) {
            ColumnConstraints column = new ColumnConstraints(200);
            RowConstraints row = new RowConstraints();
            dashGridPane.getColumnConstraints().add(column);
            row.setPrefHeight(50);
        }

        // Build welcome message.

        Text welcome = new Text(" Welcome to Iroha!");
        welcome.getStyleClass().add("background-text-title");
        dashGridPane.add(welcome, 1, 0, 3, 1);
        welcome.setWrappingWidth(600);
        welcome.setTextAlignment(TextAlignment.CENTER);

        // Build introduction text.

        Text intro = new Text(
                "If you are new here, be sure to check out the Readme which is below for information on capabilities and upgrades planned in the future."
                        + "\n" + "\n"
                        + "Also below you can see a join button which is a link to our Discord if you would like to join the community and speak with us there, either just for common interests or questions and concerncs related to this program.");
        intro.getStyleClass().add("background-text");
        dashGridPane.add(intro, 1, 1, 3, 1);
        intro.setWrappingWidth(600);
        intro.setTextAlignment(TextAlignment.CENTER);

        // Build left box for dash.

        StackPane discordStackPane = new StackPane();

        Rectangle discordBox = new Rectangle(0, 0, 415, 250);
        discordBox.getStyleClass().add("yellow-rect");

        Label discordLabel = new Label("Join the community on discord!");

        discordLabel.getStyleClass().add("dark-text");
        discordLabel.setFont(new Font(30));
        discordLabel.setWrapText(true);
        discordLabel.setTextAlignment(TextAlignment.CENTER);
        StackPane.setAlignment(discordLabel, Pos.TOP_CENTER);
        discordLabel.setPadding(new Insets(20, 10, 10, 10));

        Image discordInvite = new Image("LimaDiscord.png");
        Button discordButton = new Button();
        discordButton.setGraphic(new ImageView(discordInvite));
        discordButton.setPrefWidth(175);
        discordButton.setPrefHeight(50);
        StackPane.setAlignment(discordButton, Pos.BOTTOM_CENTER);
        discordButton.setTranslateY(-50);
        discordButton.setPadding(Insets.EMPTY);

        discordButton.setOnAction(e -> {
        IrohaFX show = new IrohaFX();
        show.openBrowser("https://discord.gg/pt5V336");
        });

        discordStackPane.getChildren().addAll(discordBox, discordLabel, discordButton);
        dashGridPane.add(discordStackPane, 0, 3, 2, 1);

        //Build right box for dash.

        Rectangle readme = new Rectangle(0, 0, 415, 250);
        readme.getStyleClass().add("yellow-rect");
        dashGridPane.add(readme, 3, 3, 2, 1);

        return dashGridPane;
    }
    
}