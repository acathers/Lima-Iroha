package io.limasecurityworks.guicomponents;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import io.limasecurityworks.gui.IrohaFX;

public class TopBar extends IrohaFX {

    private static Double menuButtonsW = 175.0;
    private static Double menuButtonsH = 50.0;
    private static Double topButtonsW = 100.0;

    /*
    * Creates an HBox with buttons if needed for the left side of inner BorderPane top
    */

    public static HBox addHBoxButtons(String input) {

        String topBarBackHex = "-fx-background-color: -limaBlueLight";

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
}