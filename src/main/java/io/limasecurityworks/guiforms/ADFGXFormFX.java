package io.limasecurityworks.guiforms;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.geometry.HPos;
import io.limasecurityworks.ciphers.ADFGX;
import io.limasecurityworks.guicomponents.*;

public class ADFGXFormFX {

    public static GridPane adfgxFormFX() {

        // Create top bar buttons
        TopBar.addHBoxButtons("adfgx");

        // Create Gridpane for adfgxs Form.
        GridPane adfgxFormFX = new GridPane();
        BorderPane.setMargin(adfgxFormFX, new Insets(50, 15, 15, 50));
        adfgxFormFX.setHgap(15);
        adfgxFormFX.setVgap(15);

        // Create Label for input TextFeild.
        Label input = new Label("Input: ");
        GridPane.setValignment(input, VPos.TOP);
        adfgxFormFX.add(input, 0, 0);

        // Create TextField for input Label.
        TextArea inputTA = new TextArea();
        inputTA.setPromptText("Text to be encrypted or decrypted, click the function button to switch.");
        inputTA.setWrapText(true);
        inputTA.setPrefWidth(700);
        inputTA.setPrefHeight(200);
        adfgxFormFX.add(inputTA, 1, 0, 4, 1);

        // Create Label for function.
        Label function = new Label("Function Selection: ");
        adfgxFormFX.add(function, 0, 2);

        // Create a button for encrypt or decrypt.
        Button functionButton = new Button("Encrypt");
        functionButton.setPrefWidth(175);
        functionButton.setPrefHeight(50);
        functionButton.setStyle("-fx-background-color: -limaBlueLight");
        functionButton.setStyle(".button:pressed");
        adfgxFormFX.add(functionButton, 1, 2);

        functionButton.setOnAction(e -> {
            if (functionButton.getText().equals("Encrypt")) {
                functionButton.setText("Decrypt");
            }
            else {
                functionButton.setText("Encrypt");
            }
        });

        // Create a Label for shift.
        Label keySquare = new Label("keySquare: ");
        adfgxFormFX.add(keySquare, 2, 1);

        // Create a TexField for shift.
        TextField keySquareTF = new TextField();
        keySquareTF.setText("avztniwgmuqdhbrfcxykespol");
        adfgxFormFX.add(keySquareTF, 3, 1, 2, 1);

        // Create Generate KeySquare button;
        Button genKeySquare = new Button("Random Key Sq.");
        genKeySquare.setPrefWidth(175);
        genKeySquare.setPrefHeight(50);
        genKeySquare.setStyle("-fx-background-color: -limaBlueLight");
        genKeySquare.setStyle(".button:pressed");
        adfgxFormFX.add(genKeySquare, 1, 1);

        // Define genKeySquare button action
        genKeySquare.setOnAction(e -> {
            keySquareTF.setText(ADFGX.generateKeySquare());
        });

        // Create Key Label.
        Label key = new Label("key: ");
        adfgxFormFX.add(key, 2, 2);

        // Create Key text field.
        TextField keyTF = new TextField();
        inputTA.setPromptText("Enter key");
        adfgxFormFX.add(keyTF, 3, 2);

        // Create an Execute Button.
        Button execute = new Button("Execute");
        execute.setPrefWidth(175);
        execute.setPrefHeight(50);
        execute.setStyle("-fx-background-color: -limaBlueLight");
        execute.setStyle(".button:pressed");
        GridPane.setHalignment(execute, HPos.RIGHT);
        adfgxFormFX.add(execute, 4, 2);

        // Create Label for output.
        Label output = new Label("Output: ");
        GridPane.setValignment(output, VPos.TOP);
        GridPane.setMargin(output, new Insets(20, 0, 0, 0));
        adfgxFormFX.add(output, 0, 3);

        // Create TextField for output.
        TextArea outputTA = new TextArea();
        outputTA.setPromptText("Output text.");
        outputTA.setWrapText(true);
        outputTA.setEditable(false);
        outputTA.setPrefWidth(700);
        outputTA.setPrefHeight(200);
        GridPane.setMargin(outputTA, new Insets(20, 0, 0, 0));
        adfgxFormFX.add(outputTA, 1, 3, 4, 1);

        // Removes focus from TextFeild if background is clicked
        adfgxFormFX.setOnMousePressed(e -> adfgxFormFX.requestFocus());

        // Set action for execute button.
        execute.setOnAction(e -> {

            String help = null;
            String about = null;

            String inputError = "Input Error: You must enter text to be encrypted or decrypted." + "\n" + "\n";

            String keySquareError = "Key Square Error: The keysquare must all letters of the alphabet once. Fix the key square or press the 'Random Key Sq.' button to generate one." + "\n" + "\n";
            String keySquareBlank = "Key Square Error: You must enter a key square" + "\n" + "\n";

            String keyError = "Key Error: The key must contain only letters and no spaces.";
            String keyBlank = "Key Error: You must enter a key";

            String outputErrorList = "";

            if (inputTA.getText().trim().length() == 0 || keySquareTF.getText().trim().length() == 0 || !ADFGX.checkKeySquare(keySquareTF.getText()) || keyTF.getText().trim().length() == 0 || !ADFGX.checkKey(keyTF.getText())) {

                if (inputTA.getText().trim().length() == 0) {
                    outputErrorList += inputError;
                }

                if (keySquareTF.getText().trim().length() == 0) {
                    outputErrorList += keySquareBlank;
                }

                else if (!ADFGX.checkKeySquare(keySquareTF.getText())) {
                    outputErrorList += keySquareError;
                }

                if (keyTF.getText().trim().length() == 0) {
                    outputErrorList += keyBlank;
                }

                else if (!ADFGX.checkKey(keyTF.getText())) {
                    outputErrorList += keyError;
                }

                outputTA.setText(outputErrorList);
            }

            else {

                ADFGX newAVC = new ADFGX(execute.getText(), keyTF.getText(), keySquareTF.getText(), help, about);

                switch (functionButton.getText()) {
                case "Encrypt":
                    outputTA.setText(newAVC.encryptText(ADFGX.cleanInput(inputTA.getText())));
                    break;
                case "Decrypt":
                    outputTA.setText(newAVC.decryptText(ADFGX.cleanInput(inputTA.getText())));
                    break;
                default:
                }
            }
        });
        return adfgxFormFX;
    }

    public static GridPane adfgxHelp() {

        GridPane adfgxHelp = new GridPane();

        return adfgxHelp;
    }

    public static GridPane adfgxAbout() {

        GridPane adfgxAbout = new GridPane();

        return adfgxAbout;
    }
}