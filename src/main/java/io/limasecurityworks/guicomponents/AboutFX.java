package io.limasecurityworks.guicomponents;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;
import io.limasecurityworks.gui.*;
import javafx.scene.control.Hyperlink;

public class AboutFX extends IrohaFX {
    
    public static BorderPane buildAbout() {

        // Set up GridPane for about.

        BorderPane aboutBorderPane = new BorderPane();

        GridPane aboutGridPane = new GridPane();

        aboutGridPane.setAlignment(Pos. CENTER);
        aboutGridPane.setVgap(50);
        aboutGridPane.setHgap(15);

        for (int i = 0; i < 5; i++) {
            ColumnConstraints column = new ColumnConstraints(200);
            RowConstraints row = new RowConstraints();
            aboutGridPane.getColumnConstraints().add(column);
            row.setPrefHeight(50);
        }

        // Build welcome message.

        Text welcome = new Text("Lima Security Works - Iroha");
        welcome.getStyleClass().add("background-text-title");
        aboutGridPane.add(welcome, 1, 0, 3, 1);
        welcome.setWrappingWidth(600);
        welcome.setTextAlignment(TextAlignment. CENTER);

        // Build hyperlink for readme

        Hyperlink readme = new Hyperlink("limasecurityworks.dev");

        readme.setOnAction(e -> {
            IrohaFX show = new IrohaFX();
            show.openBrowser("https://limasecurityworks.dev");
            });

        // Build about text.

        Text intro = new Text("The development goal for this application is to create an encryption program capable of simple text encryptions with a variety of classical ciphers as well as text and file encryption with modern encryption types. The program is planned to be developed to run Windows, linux, and mac and work as a terminal or command line program as well as with a gui. The initial plan is to include 26 classical ciphers and use of Two Fish as the modern encryption used for file encryption.");


        intro.getStyleClass().add("background-text");
        aboutGridPane.add(intro, 1, 1, 3, 1);
        intro.setWrappingWidth(1000);
        intro.setTextAlignment(TextAlignment. CENTER);

        //Add aboutGridPane to the BorderPane
        aboutBorderPane.setCenter(aboutGridPane);

        return aboutBorderPane;

    }
}