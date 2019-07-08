package io.limasecurityworks.guicomponents;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.HBox;
import io.limasecurityworks.gui.*;
import io.limasecurityworks.guiforms.*;

public class CiphersFX extends IrohaFX {

    private static Double menuButtonsW = 175.0;
    private static Double menuButtonsH = 50.0;
    
    public static BorderPane buildCiphers() {

        //Create the BorderPane for the TilePane;
        BorderPane ciphersBorderPane = new BorderPane();

        //Build GridPane to hold TilePane to allow setPrefColumns to work.
        GridPane ciphersGridPane = new GridPane();

        //Create the tilepane for ciphers options.
        TilePane ciphersTilePane = new TilePane();
        ciphersTilePane.setHgap(15);
        ciphersTilePane.setVgap(15);
        ciphersTilePane.setPrefColumns(2);
        GridPane.setMargin(ciphersTilePane, new Insets(50,15,15,50));
        
        //Create Buttons.
        Button ciphers[] = new Button[] {
            new Button("ADFGVX"),
            new Button("ADFGX"),
            new Button("Affine"),
            new Button("Atbash"),
            new Button("Autokey"),
            new Button("Baconian"),
            new Button("Base64"),
            new Button("Beaufort"),
            new Button("Bifid"),
            new Button("Caesars Cipher"),
            new Button("Rot13"),
            new Button("Vegenere & Gronsfeld") 
        };

        GridPane ciphersForm[] = new GridPane[] {
            ADFGVXFormFX.adfgvxFormFX(),
            ADFGXFormFX.adfgxFormFX(),
            AffineFormFX.affineFormFX(),
            AtbashFormFX.atbashFormFX(),
            AutokeyFormFX.autokeyFormFX(),
            BaconianFormFX.baconianFormFX(),
            Base64FormFX.base64FormFX(),
            BeaufortFormFX.beaufortFormFX(),
            BifidFormFX.bifidFormFX(),
            CaesarsFormFX.caesarsFormFX(),
            ROT13FormFX.rot13FormFX(),
            VegenereFormFX.vegenereFormFX()
        };

        HBox ciphersTopBar[] = new HBox[] {
            TopBar.addHBoxButtons("ADFGVX"),
            TopBar.addHBoxButtons("ADFGX"),
            TopBar.addHBoxButtons("Affine"),
            TopBar.addHBoxButtons("atbash"),
            TopBar.addHBoxButtons("autokey"),
            TopBar.addHBoxButtons("baconian"),
            TopBar.addHBoxButtons("base64"),
            TopBar.addHBoxButtons("beaufort"),
            TopBar.addHBoxButtons("bifid"),
            TopBar.addHBoxButtons("caesars"),
            TopBar.addHBoxButtons("ROT13"),
            TopBar.addHBoxButtons("vegenere")
        };

        for (int i=0; i<12; i++) {
            // Add offset to left side to indent from title
            
            ciphers[i].setPrefWidth(menuButtonsW);
            ciphers[i].setPrefHeight(menuButtonsH);
            ciphers[i].setStyle("-fx-background-color: -limaBlueLight");
            ciphers[i].setStyle(".button:pressed");

            final int count = i;

            ciphers[i].setOnAction(e -> {
                splashInner.setCenter(ciphersForm[count]);
                splashInnerTop.setLeft(ciphersTopBar[count]);
            });

            ciphersTilePane.getChildren().addAll(ciphers[i]);
        }

        // Add TilePane to GridPane and GridPane to BorderPane
        ciphersGridPane.add(ciphersTilePane, 0, 0);
        ciphersBorderPane.setLeft(ciphersGridPane);

        return ciphersBorderPane;
    }
}