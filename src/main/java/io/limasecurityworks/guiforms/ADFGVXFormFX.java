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
import io.limasecurityworks.ciphers.ADFGVX;
import io.limasecurityworks.guicomponents.*;

public class ADFGVXFormFX {

    public static GridPane adfgvxFormFX() {

        // Create top bar buttons
        TopBar.addHBoxButtons("adfgvx");

        // Create Gridpane for adfgvxs Form.
        GridPane adfgvxFormFX = new GridPane();
        BorderPane.setMargin(adfgvxFormFX, new Insets(50, 15, 15, 50));
        adfgvxFormFX.setHgap(15);
        adfgvxFormFX.setVgap(15);

        // Create Label for input TextFeild.
        Label input = new Label("Input: ");
        GridPane.setValignment(input, VPos.TOP);
        adfgvxFormFX.add(input, 0, 0);

        // Create TextField for input Label.
        TextArea inputTA = new TextArea();
        inputTA.setPromptText("Text to be encrypted or decrypted, click the function button to switch.");
        inputTA.setWrapText(true);
        inputTA.setPrefWidth(700);
        inputTA.setPrefHeight(200);
        adfgvxFormFX.add(inputTA, 1, 0, 4, 1);

        // Create Label for function.
        Label function = new Label("Function Selection: ");
        adfgvxFormFX.add(function, 0, 2);

        // Create a button for encrypt or decrypt.
        Button functionButton = new Button("Encrypt");
        functionButton.setPrefWidth(175);
        functionButton.setPrefHeight(50);
        functionButton.setStyle("-fx-background-color: -limaBlueLight");
        functionButton.setStyle(".button:pressed");
        adfgvxFormFX.add(functionButton, 1, 2);

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
        adfgvxFormFX.add(keySquare, 2, 1);

        // Create a TexField for shift.
        TextField keySquareTF = new TextField();
        keySquareTF.setText("avjzt7n5iwgm8u0q9dhb2rfcxyke4s13p6ol");
        adfgvxFormFX.add(keySquareTF, 3, 1, 2, 1);

        // Create Generate KeySquare button;
        Button genKeySquare = new Button("Random Key Sq.");
        genKeySquare.setPrefWidth(175);
        genKeySquare.setPrefHeight(50);
        genKeySquare.setStyle("-fx-background-color: -limaBlueLight");
        genKeySquare.setStyle(".button:pressed");
        adfgvxFormFX.add(genKeySquare, 1, 1);

        // Define genKeySquare button action
        genKeySquare.setOnAction(e -> {
            keySquareTF.setText(ADFGVX.generateKeySquare());
        });

        // Create Key Label.
        Label key = new Label("key: ");
        adfgvxFormFX.add(key, 2, 2);

        // Create Key text field.
        TextField keyTF = new TextField();
        keyTF.setPromptText("Enter key");
        adfgvxFormFX.add(keyTF, 3, 2);

        // Create an Execute Button.
        Button execute = new Button("Execute");
        execute.setPrefWidth(175);
        execute.setPrefHeight(50);
        execute.setStyle("-fx-background-color: -limaBlueLight");
        execute.setStyle(".button:pressed");
        GridPane.setHalignment(execute, HPos.RIGHT);
        adfgvxFormFX.add(execute, 4, 2);

        // Create Label for output.
        Label output = new Label("Output: ");
        GridPane.setValignment(output, VPos.TOP);
        GridPane.setMargin(output, new Insets(20, 0, 0, 0));
        adfgvxFormFX.add(output, 0, 3);

        // Create TextArea for output.
        TextArea outputTA = new TextArea();
        outputTA.setPromptText("Output text.");
        outputTA.setWrapText(true);
        outputTA.setEditable(false);
        outputTA.setPrefWidth(700);
        outputTA.setPrefHeight(200);
        GridPane.setMargin(outputTA, new Insets(20, 0, 0, 0));
        adfgvxFormFX.add(outputTA, 1, 3, 4, 1);

        // Removes focus from TextFeild if background is clicked
        adfgvxFormFX.setOnMousePressed(e -> adfgvxFormFX.requestFocus());

        // Set action for execute button.
        execute.setOnAction(e -> {

            String help = null;
            String about = null;

            String inputError = "Input Error: You must enter text to be encrypted or decrypted." + "\n" + "\n";
            String keySquareError = "Key Square Error: The keysquare must contain numbers 0-9 and all letters of the alphabet once. Fix the key square or press the 'Random Key Sq.' button to generate one." + "\n" + "\n";
            String keySquareBlank = "Key Square Error: You must enter a key square" + "\n" + "\n";
            String keyError = "Key Error: The key must contain only letters and no spaces.";
            String keyBlank = "Key Error: You must enter a key";

            String outputErrorList = "";

            if (inputTA.getText().trim().length() == 0 || keySquareTF.getText().trim().length() == 0 || !ADFGVX.checkKeySquare(keySquareTF.getText()) || keyTF.getText().trim().length() == 0 || !ADFGVX.checkKey(keyTF.getText())) {

                if (inputTA.getText().trim().length() == 0) {
                    outputErrorList += inputError;
                }

                if (keySquareTF.getText().trim().length() == 0) {
                    outputErrorList += keySquareBlank;
                }

                else if (!ADFGVX.checkKeySquare(keySquareTF.getText())) {
                    outputErrorList += keySquareError;
                }

                if (keyTF.getText().trim().length() == 0) {
                    outputErrorList += keyBlank;
                }

                else if (!ADFGVX.checkKey(keyTF.getText())) {
                    outputErrorList += keyError;
                }

                outputTA.setText(outputErrorList);
            }

            else {

                ADFGVX newAVC = new ADFGVX(execute.getText(), keyTF.getText(), keySquareTF.getText(), help, about);

                switch (functionButton.getText()) {
                case "Encrypt":
                    outputTA.setText(newAVC.encryptText(ADFGVX.cleanInput(inputTA.getText())));
                    break;
                case "Decrypt":
                    outputTA.setText(newAVC.decryptText(ADFGVX.cleanInput(inputTA.getText())));
                    break;
                default:
                }
            }
        });
        return adfgvxFormFX;
    }

    public static GridPane adfgvxHelp() {

        GridPane adfgvxHelp = new GridPane();

        return adfgvxHelp;
    }

    public static GridPane adfgvxAbout() {

        GridPane adfgvxAbout = new GridPane();

        return adfgvxAbout;
    }
}