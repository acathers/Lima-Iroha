package io.limasecurityworks.guicomponents;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import io.limasecurityworks.gui.IrohaFX;
import io.limasecurityworks.guiforms.*;

public class TopBar extends IrohaFX {

    private static Double menuButtonsW = 175.0;
    private static Double menuButtonsH = 50.0;

    /*
     * Creates an HBox with buttons if needed for the left side of inner BorderPane
     * top
     */

    public static HBox addHBoxButtons(String input) {

        String topBarBackHex = "-fx-background-color: -limaBlueLight";
        String topBarDark = "-fx-background-color: -limaBlueDark";
        String topBarLight = "-fx-background-color: -limaBlueLight";

        HBox hboxButtons = new HBox();
        hboxButtons.setPadding(new Insets(0, 0, 0, 100));
        hboxButtons.setStyle(topBarBackHex);

        // Build Buttons for TopBar.
        switch (input) {

        case "dash":
            Button dashboardButton = new Button("Dashboard");
            dashboardButton.setPrefSize(menuButtonsW, menuButtonsH);
            dashboardButton.setStyle(topBarDark);
            hboxButtons.getChildren().add(dashboardButton);
            break;

        case "ciphers":
            Button ciphersButton = new Button("Ciphers");
            ciphersButton.setPrefSize(menuButtonsW, menuButtonsH);
            ciphersButton.setStyle(topBarDark);
            hboxButtons.getChildren().add(ciphersButton);
            break;

        case "keyring":
            Button keyringCiphers = new Button("Ciphers");
            keyringCiphers.setPrefSize(menuButtonsW, menuButtonsH);
            keyringCiphers.setStyle(topBarDark);
            hboxButtons.getChildren().add(keyringCiphers);
            break;

        case "settings":
            Button settingsButton = new Button("Settings");
            settingsButton.setPrefSize(menuButtonsW, menuButtonsH);
            settingsButton.setStyle(topBarDark);
            hboxButtons.getChildren().add(settingsButton);
            break;

        case "help":
            Button helpButton = new Button("Help");
            helpButton.setPrefSize(menuButtonsW, menuButtonsH);
            helpButton.setStyle(topBarDark);
            hboxButtons.getChildren().add(helpButton);
            break;

        case "about":
            Button aboutButton = new Button("About");
            aboutButton.setPrefSize(menuButtonsW, menuButtonsH);
            aboutButton.setStyle(topBarDark);
            hboxButtons.getChildren().add(aboutButton);
            break;

        case "ADFGVX":
            Button ADFGVXButton = new Button("ADFGVX Cipher");
            ADFGVXButton.setPrefSize(menuButtonsW, menuButtonsH);
            ADFGVXButton.setStyle(topBarDark);

            Button ADFGVXHelp = new Button("Help");
            ADFGVXHelp.setPrefSize(menuButtonsW, menuButtonsH);
            ADFGVXHelp.setStyle(topBarLight);

            Button ADFGVXAbout = new Button("About");
            ADFGVXAbout.setPrefSize(menuButtonsW, menuButtonsH);
            ADFGVXAbout.setStyle(topBarLight);

            // Add buttons to HBox.
            hboxButtons.getChildren().addAll(ADFGVXButton, ADFGVXHelp, ADFGVXAbout);

            // Set actions for each button.
            ADFGVXButton.setOnAction(e -> {
                ADFGVXButton.setStyle(topBarDark);
                ADFGVXHelp.setStyle(topBarLight);
                ADFGVXAbout.setStyle(topBarLight);
                splashInner.setCenter(ADFGVXFormFX.adfgvxFormFX());
            });

            ADFGVXHelp.setOnAction(e -> {
                ADFGVXButton.setStyle(topBarLight);
                ADFGVXHelp.setStyle(topBarDark);
                ADFGVXAbout.setStyle(topBarLight);
                splashInner.setCenter(ADFGVXFormFX.adfgvxHelp());
            });

            ADFGVXAbout.setOnAction(e -> {
                ADFGVXButton.setStyle(topBarLight);
                ADFGVXHelp.setStyle(topBarLight);
                ADFGVXAbout.setStyle(topBarDark);
                splashInner.setCenter(ADFGVXFormFX.adfgvxAbout());
            });
            break;

        case "ADFGX":
            Button ADFGXButton = new Button("ADFGX Cipher");
            ADFGXButton.setPrefSize(menuButtonsW, menuButtonsH);
            ADFGXButton.setStyle(topBarDark);

            Button ADFGXHelp = new Button("Help");
            ADFGXHelp.setPrefSize(menuButtonsW, menuButtonsH);
            ADFGXHelp.setStyle(topBarLight);

            Button ADFGXAbout = new Button("About");
            ADFGXAbout.setPrefSize(menuButtonsW, menuButtonsH);
            ADFGXAbout.setStyle(topBarLight);

            // Add buttons to HBox.
            hboxButtons.getChildren().addAll(ADFGXButton, ADFGXHelp, ADFGXAbout);

            // Set actions for each button.
            ADFGXButton.setOnAction(e -> {
                ADFGXButton.setStyle(topBarDark);
                ADFGXHelp.setStyle(topBarLight);
                ADFGXAbout.setStyle(topBarLight);
                splashInner.setCenter(ADFGXFormFX.adfgxFormFX());
            });

            ADFGXHelp.setOnAction(e -> {
                ADFGXButton.setStyle(topBarLight);
                ADFGXHelp.setStyle(topBarDark);
                ADFGXAbout.setStyle(topBarLight);
                splashInner.setCenter(ADFGXFormFX.adfgxHelp());
            });

            ADFGXAbout.setOnAction(e -> {
                ADFGXButton.setStyle(topBarLight);
                ADFGXHelp.setStyle(topBarLight);
                ADFGXAbout.setStyle(topBarDark);
                splashInner.setCenter(ADFGXFormFX.adfgxAbout());
            });
            break;

        case "affine":
            Button affineButton = new Button("affine Cipher");
            affineButton.setPrefSize(menuButtonsW, menuButtonsH);
            affineButton.setStyle(topBarDark);

            Button affineHelp = new Button("Help");
            affineHelp.setPrefSize(menuButtonsW, menuButtonsH);
            affineHelp.setStyle(topBarLight);

            Button affineAbout = new Button("About");
            affineAbout.setPrefSize(menuButtonsW, menuButtonsH);
            affineAbout.setStyle(topBarLight);

            // Add buttons to HBox.
            hboxButtons.getChildren().addAll(affineButton, affineHelp, affineAbout);

            // Set actions for each button.
            affineButton.setOnAction(e -> {
                affineButton.setStyle(topBarDark);
                affineHelp.setStyle(topBarLight);
                affineAbout.setStyle(topBarLight);
                splashInner.setCenter(AffineFormFX.affineFormFX());
            });

            affineHelp.setOnAction(e -> {
                affineButton.setStyle(topBarLight);
                affineHelp.setStyle(topBarDark);
                affineAbout.setStyle(topBarLight);
                splashInner.setCenter(AffineFormFX.affineHelp());
            });

            affineAbout.setOnAction(e -> {
                affineButton.setStyle(topBarLight);
                affineHelp.setStyle(topBarLight);
                affineAbout.setStyle(topBarDark);
                splashInner.setCenter(AffineFormFX.affineAbout());
            });
            break;

        case "atbash":
            Button atbashButton = new Button("atbash Cipher");
            atbashButton.setPrefSize(menuButtonsW, menuButtonsH);
            atbashButton.setStyle(topBarDark);

            Button atbashHelp = new Button("Help");
            atbashHelp.setPrefSize(menuButtonsW, menuButtonsH);
            atbashHelp.setStyle(topBarLight);

            Button atbashAbout = new Button("About");
            atbashAbout.setPrefSize(menuButtonsW, menuButtonsH);
            atbashAbout.setStyle(topBarLight);

            // Add buttons to HBox.
            hboxButtons.getChildren().addAll(atbashButton, atbashHelp, atbashAbout);

            // Set actions for each button.
            atbashButton.setOnAction(e -> {
                atbashButton.setStyle(topBarDark);
                atbashHelp.setStyle(topBarLight);
                atbashAbout.setStyle(topBarLight);
                splashInner.setCenter(AtbashFormFX.atbashFormFX());
            });

            atbashHelp.setOnAction(e -> {
                atbashButton.setStyle(topBarLight);
                atbashHelp.setStyle(topBarDark);
                atbashAbout.setStyle(topBarLight);
                splashInner.setCenter(AtbashFormFX.atbashHelp());
            });

            atbashAbout.setOnAction(e -> {
                atbashButton.setStyle(topBarLight);
                atbashHelp.setStyle(topBarLight);
                atbashAbout.setStyle(topBarDark);
                splashInner.setCenter(AtbashFormFX.atbashAbout());
            });
            break;

        case "autokey":
            Button autokeyButton = new Button("autokey Cipher");
            autokeyButton.setPrefSize(menuButtonsW, menuButtonsH);
            autokeyButton.setStyle(topBarDark);

            Button autokeyHelp = new Button("Help");
            autokeyHelp.setPrefSize(menuButtonsW, menuButtonsH);
            autokeyHelp.setStyle(topBarLight);

            Button autokeyAbout = new Button("About");
            autokeyAbout.setPrefSize(menuButtonsW, menuButtonsH);
            autokeyAbout.setStyle(topBarLight);

            // Add buttons to HBox.
            hboxButtons.getChildren().addAll(autokeyButton, autokeyHelp, autokeyAbout);

            // Set actions for each button.
            autokeyButton.setOnAction(e -> {
                autokeyButton.setStyle(topBarDark);
                autokeyHelp.setStyle(topBarLight);
                autokeyAbout.setStyle(topBarLight);
                splashInner.setCenter(AutokeyFormFX.autokeyFormFX());
            });

            autokeyHelp.setOnAction(e -> {
                autokeyButton.setStyle(topBarLight);
                autokeyHelp.setStyle(topBarDark);
                autokeyAbout.setStyle(topBarLight);
                splashInner.setCenter(AutokeyFormFX.autokeyHelp());
            });

            autokeyAbout.setOnAction(e -> {
                autokeyButton.setStyle(topBarLight);
                autokeyHelp.setStyle(topBarLight);
                autokeyAbout.setStyle(topBarDark);
                splashInner.setCenter(AutokeyFormFX.autokeyAbout());
            });
            break;

        case "baconian":
            Button baconianButton = new Button("baconian Cipher");
            baconianButton.setPrefSize(menuButtonsW, menuButtonsH);
            baconianButton.setStyle(topBarDark);

            Button baconianHelp = new Button("Help");
            baconianHelp.setPrefSize(menuButtonsW, menuButtonsH);
            baconianHelp.setStyle(topBarLight);

            Button baconianAbout = new Button("About");
            baconianAbout.setPrefSize(menuButtonsW, menuButtonsH);
            baconianAbout.setStyle(topBarLight);

            // Add buttons to HBox.
            hboxButtons.getChildren().addAll(baconianButton, baconianHelp, baconianAbout);

            // Set actions for each button.
            baconianButton.setOnAction(e -> {
                baconianButton.setStyle(topBarDark);
                baconianHelp.setStyle(topBarLight);
                baconianAbout.setStyle(topBarLight);
                splashInner.setCenter(BaconianFormFX.baconianFormFX());
            });

            baconianHelp.setOnAction(e -> {
                baconianButton.setStyle(topBarLight);
                baconianHelp.setStyle(topBarDark);
                baconianAbout.setStyle(topBarLight);
                splashInner.setCenter(BaconianFormFX.baconianHelp());
            });

            baconianAbout.setOnAction(e -> {
                baconianButton.setStyle(topBarLight);
                baconianHelp.setStyle(topBarLight);
                baconianAbout.setStyle(topBarDark);
                splashInner.setCenter(BaconianFormFX.baconianAbout());
            });
            break;

        case "base64":
            Button base64Button = new Button("base64 Cipher");
            base64Button.setPrefSize(menuButtonsW, menuButtonsH);
            base64Button.setStyle(topBarDark);

            Button base64Help = new Button("Help");
            base64Help.setPrefSize(menuButtonsW, menuButtonsH);
            base64Help.setStyle(topBarLight);

            Button base64About = new Button("About");
            base64About.setPrefSize(menuButtonsW, menuButtonsH);
            base64About.setStyle(topBarLight);

            // Add buttons to HBox.
            hboxButtons.getChildren().addAll(base64Button, base64Help, base64About);

            // Set actions for each button.
            base64Button.setOnAction(e -> {
                base64Button.setStyle(topBarDark);
                base64Help.setStyle(topBarLight);
                base64About.setStyle(topBarLight);
                splashInner.setCenter(Base64FormFX.base64FormFX());
            });

            base64Help.setOnAction(e -> {
                base64Button.setStyle(topBarLight);
                base64Help.setStyle(topBarDark);
                base64About.setStyle(topBarLight);
                splashInner.setCenter(Base64FormFX.base64Help());
            });

            base64About.setOnAction(e -> {
                base64Button.setStyle(topBarLight);
                base64Help.setStyle(topBarLight);
                base64About.setStyle(topBarDark);
                splashInner.setCenter(Base64FormFX.base64About());
            });
            break;

        case "beaufort":
            Button beaufortButton = new Button("beaufort Cipher");
            beaufortButton.setPrefSize(menuButtonsW, menuButtonsH);
            beaufortButton.setStyle(topBarDark);

            Button beaufortHelp = new Button("Help");
            beaufortHelp.setPrefSize(menuButtonsW, menuButtonsH);
            beaufortHelp.setStyle(topBarLight);

            Button beaufortAbout = new Button("About");
            beaufortAbout.setPrefSize(menuButtonsW, menuButtonsH);
            beaufortAbout.setStyle(topBarLight);

            // Add buttons to HBox.
            hboxButtons.getChildren().addAll(beaufortButton, beaufortHelp, beaufortAbout);

            // Set actions for each button.
            beaufortButton.setOnAction(e -> {
                beaufortButton.setStyle(topBarDark);
                beaufortHelp.setStyle(topBarLight);
                beaufortAbout.setStyle(topBarLight);
                splashInner.setCenter(BeaufortFormFX.beaufortFormFX());
            });

            beaufortHelp.setOnAction(e -> {
                beaufortButton.setStyle(topBarLight);
                beaufortHelp.setStyle(topBarDark);
                beaufortAbout.setStyle(topBarLight);
                splashInner.setCenter(BeaufortFormFX.beaufortHelp());
            });

            beaufortAbout.setOnAction(e -> {
                beaufortButton.setStyle(topBarLight);
                beaufortHelp.setStyle(topBarLight);
                beaufortAbout.setStyle(topBarDark);
                splashInner.setCenter(BeaufortFormFX.beaufortAbout());
            });
            break;

        case "bifid":
            Button bifidButton = new Button("bifid Cipher");
            bifidButton.setPrefSize(menuButtonsW, menuButtonsH);
            bifidButton.setStyle(topBarDark);

            Button bifidHelp = new Button("Help");
            bifidHelp.setPrefSize(menuButtonsW, menuButtonsH);
            bifidHelp.setStyle(topBarLight);

            Button bifidAbout = new Button("About");
            bifidAbout.setPrefSize(menuButtonsW, menuButtonsH);
            bifidAbout.setStyle(topBarLight);

            // Add buttons to HBox.
            hboxButtons.getChildren().addAll(bifidButton, bifidHelp, bifidAbout);

            // Set actions for each button.
            bifidButton.setOnAction(e -> {
                bifidButton.setStyle(topBarDark);
                bifidHelp.setStyle(topBarLight);
                bifidAbout.setStyle(topBarLight);
                splashInner.setCenter(BifidFormFX.bifidFormFX());
            });

            bifidHelp.setOnAction(e -> {
                bifidButton.setStyle(topBarLight);
                bifidHelp.setStyle(topBarDark);
                bifidAbout.setStyle(topBarLight);
                splashInner.setCenter(BifidFormFX.bifidHelp());
            });

            bifidAbout.setOnAction(e -> {
                bifidButton.setStyle(topBarLight);
                bifidHelp.setStyle(topBarLight);
                bifidAbout.setStyle(topBarDark);
                splashInner.setCenter(BifidFormFX.bifidAbout());
            });
            break;

        case "caesars":
            Button caesarsButton = new Button("Caesar's Cipher");
            caesarsButton.setPrefSize(menuButtonsW, menuButtonsH);
            caesarsButton.setStyle(topBarDark);

            Button caesarsHelp = new Button("Help");
            caesarsHelp.setPrefSize(menuButtonsW, menuButtonsH);
            caesarsHelp.setStyle(topBarLight);

            Button caesarsAbout = new Button("About");
            caesarsAbout.setPrefSize(menuButtonsW, menuButtonsH);
            caesarsAbout.setStyle(topBarLight);

            // Add buttons to HBox.
            hboxButtons.getChildren().addAll(caesarsButton, caesarsHelp, caesarsAbout);

            // Set actions for each button.
            caesarsButton.setOnAction(e -> {
                caesarsButton.setStyle(topBarDark);
                caesarsHelp.setStyle(topBarLight);
                caesarsAbout.setStyle(topBarLight);
                splashInner.setCenter(CaesarsFormFX.caesarsFormFX());
            });

            caesarsHelp.setOnAction(e -> {
                caesarsButton.setStyle(topBarLight);
                caesarsHelp.setStyle(topBarDark);
                caesarsAbout.setStyle(topBarLight);
                splashInner.setCenter(CaesarsFormFX.caesarsHelp());
            });

            caesarsAbout.setOnAction(e -> {
                caesarsButton.setStyle(topBarLight);
                caesarsHelp.setStyle(topBarLight);
                caesarsAbout.setStyle(topBarDark);
                splashInner.setCenter(CaesarsFormFX.caesarsAbout());
            });
            break;

        case "ROT13":
            Button ROT13Button = new Button("ROT13 Cipher");
            ROT13Button.setPrefSize(menuButtonsW, menuButtonsH);
            ROT13Button.setStyle(topBarDark);

            Button ROT13Help = new Button("Help");
            ROT13Help.setPrefSize(menuButtonsW, menuButtonsH);
            ROT13Help.setStyle(topBarLight);

            Button ROT13About = new Button("About");
            ROT13About.setPrefSize(menuButtonsW, menuButtonsH);
            ROT13About.setStyle(topBarLight);

            // Add buttons to HBox.
            hboxButtons.getChildren().addAll(ROT13Button, ROT13Help, ROT13About);

            // Set actions for each button.
            ROT13Button.setOnAction(e -> {
                ROT13Button.setStyle(topBarDark);
                ROT13Help.setStyle(topBarLight);
                ROT13About.setStyle(topBarLight);
                splashInner.setCenter(ROT13FormFX.rot13FormFX());
            });

            ROT13Help.setOnAction(e -> {
                ROT13Button.setStyle(topBarLight);
                ROT13Help.setStyle(topBarDark);
                ROT13About.setStyle(topBarLight);
                splashInner.setCenter(ROT13FormFX.rot13Help());
            });

            ROT13About.setOnAction(e -> {
                ROT13Button.setStyle(topBarLight);
                ROT13Help.setStyle(topBarLight);
                ROT13About.setStyle(topBarDark);
                splashInner.setCenter(ROT13FormFX.rot13About());
            });
            break;

        case "vegenere":
            Button vegenereButton = new Button("vegenere Cipher");
            vegenereButton.setPrefSize(menuButtonsW, menuButtonsH);
            vegenereButton.setStyle(topBarDark);

            Button vegenereHelp = new Button("Help");
            vegenereHelp.setPrefSize(menuButtonsW, menuButtonsH);
            vegenereHelp.setStyle(topBarLight);

            Button vegenereAbout = new Button("About");
            vegenereAbout.setPrefSize(menuButtonsW, menuButtonsH);
            vegenereAbout.setStyle(topBarLight);

            // Add buttons to HBox.
            hboxButtons.getChildren().addAll(vegenereButton, vegenereHelp, vegenereAbout);

            // Set actions for each button.
            vegenereButton.setOnAction(e -> {
                vegenereButton.setStyle(topBarDark);
                vegenereHelp.setStyle(topBarLight);
                vegenereAbout.setStyle(topBarLight);
                splashInner.setCenter(VegenereFormFX.vegenereFormFX());
            });

            vegenereHelp.setOnAction(e -> {
                vegenereButton.setStyle(topBarLight);
                vegenereHelp.setStyle(topBarDark);
                vegenereAbout.setStyle(topBarLight);
                splashInner.setCenter(VegenereFormFX.vegenereHelp());
            });

            vegenereAbout.setOnAction(e -> {
                vegenereButton.setStyle(topBarLight);
                vegenereHelp.setStyle(topBarLight);
                vegenereAbout.setStyle(topBarDark);
                splashInner.setCenter(VegenereFormFX.vegenereAbout());
            });
            break;

        default:
        }
        return hboxButtons;
    }
}