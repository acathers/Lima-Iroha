package io.limasecurityworks.guiforms;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.geometry.HPos;
import io.limasecurityworks.ciphers.Affine;
import io.limasecurityworks.guicomponents.*;

public class AffineFormFX {

    public static GridPane affineFormFX() {

        // Create top bar buttons
        TopBar.addHBoxButtons("affine");

        // Create Gridpane for affines Form.
        GridPane affineFormFX = new GridPane();
        BorderPane.setMargin(affineFormFX, new Insets(50, 15, 15, 50));
        affineFormFX.setHgap(15);
        affineFormFX.setVgap(15);

        // Create Label for input TextFeild.
        Label input = new Label("Input: ");
        GridPane.setValignment(input, VPos.TOP);
        affineFormFX.add(input, 0, 0);

        // Create TextField for input Label.
        TextArea inputTA = new TextArea();
        inputTA.setPromptText("Text to be encrypted or decrypted, click the function button to switch.");
        inputTA.setWrapText(true);
        inputTA.setPrefWidth(700);
        inputTA.setPrefHeight(200);
        affineFormFX.add(inputTA, 1, 0, 5, 1);

        // Create Label for function.
        Label function = new Label("Function Selection: ");
        affineFormFX.add(function, 0, 2);

        // Create a button for encrypt or decrypt.
        Button functionButton = new Button("Encrypt");
        functionButton.setPrefWidth(175);
        functionButton.setPrefHeight(50);
        functionButton.setStyle("-fx-background-color: -limaBlueLight");
        functionButton.setStyle(".button:pressed");
        affineFormFX.add(functionButton, 1, 2);

        functionButton.setOnAction(e -> {
            if (functionButton.getText().equals("Encrypt")) {
                functionButton.setText("Decrypt");
            }
            else {
                functionButton.setText("Encrypt");
            }
        });

        //Create Label for key 1 combo box.
        Label modLabel = new Label("Mod: ");
        affineFormFX.add(modLabel, 0, 1);

        // Create key 1 combo box.

        ObservableList<String> optionsMod = FXCollections.observableArrayList(
            "26",
            "52",
            "92"
        );

        ComboBox<String> modComboBox = new ComboBox<>(optionsMod);
        modComboBox.setPromptText("Select Modulo");
        modComboBox.setPrefWidth(175);
        modComboBox.setPrefHeight(50);
        modComboBox.setStyle("-fx-background-color: -limaBlueLight");
        modComboBox.setStyle(".button:pressed");
        affineFormFX.add(modComboBox, 1, 1);

        // Create a Label for key 1 Text Field.
        Label key1TFLabel = new Label("Key 1: ");
        affineFormFX.add(key1TFLabel, 2, 1);

        // Create a TexField for shift.
        TextField key1TF = new TextField();
        key1TF.setPromptText("Odd number < mod.");
        affineFormFX.add(key1TF, 3, 1);

        // Create a Label for key 1 Text Field.
        Label key2TFLabel = new Label("Key 2: ");
        affineFormFX.add(key2TFLabel, 4, 1);

        // Create a TexField for shift.
        TextField key2TF = new TextField();
        key2TF.setPromptText("Number < mod.");
        affineFormFX.add(key2TF, 5, 1);

        // Create an Execute Button.
        Button execute = new Button("Execute");
        execute.setPrefWidth(175);
        execute.setPrefHeight(50);
        execute.setStyle("-fx-background-color: -limaBlueLight");
        execute.setStyle(".button:pressed");
        GridPane.setHalignment(execute, HPos.RIGHT);
        affineFormFX.add(execute, 5, 2);

        // Create Label for output.
        Label output = new Label("Output: ");
        GridPane.setValignment(output, VPos.TOP);
        GridPane.setMargin(output, new Insets(20, 0, 0, 0));
        affineFormFX.add(output, 0, 3);

        // Create TextArea for output.
        TextArea outputTA = new TextArea();
        outputTA.setPromptText("Output text.");
        outputTA.setWrapText(true);
        outputTA.setEditable(false);
        outputTA.setPrefWidth(700);
        outputTA.setPrefHeight(200);
        GridPane.setMargin(outputTA, new Insets(20, 0, 0, 0));
        affineFormFX.add(outputTA, 1, 3, 5, 1);

        // Removes focus from TextFeild if background is clicked
        affineFormFX.setOnMousePressed(e -> affineFormFX.requestFocus());

        // Set action for execute button.
        execute.setOnAction(e -> {

            String help = null;
            String about = null;

            String inputBlank = "Input Error: You must enter text to be encrypted or decrypted." + "\n" + "\n";
            String moduloCBBlank = "Modulo Error: You must enter a value for modulo." + "\n" + "\n";
            String key1Error = "Key 1 Error: That number is not a coprime with the mod. Your first key must have a greatest common factor with the mod of '1'." + "\n" + "\n";
            String key1Blank = "Key 1 Error: You must enter a value for key 1, it needs to be an odd number." + "\n" + "\n";
            String key2Error = "Key 2 Error: You have entered an invalid value for key 2, it must be less than key 1.";
            String key2Blank = "Key 2 Error: You must enter a value for key 2, it needs to be less than key 1."; 

            String outputErrorList = "";

            if (modComboBox.getValue() == null || inputTA.getText().trim().length() == 0 || key1TF.getText().trim().length() == 0 || !Affine.isCoprime(Integer.parseInt(key1TF.getText()), Integer.parseInt(modComboBox.getValue())) || key2TF.getText().trim().length() == 0 || !(Integer.parseInt(key2TF.getText()) < Integer.parseInt(modComboBox.getValue()))) {

                if (inputTA.getText().trim().length() == 0) {
                    outputErrorList += inputBlank;
                }

                if (modComboBox.getValue() == null) {
                    outputErrorList += moduloCBBlank;
                }

                if (key1TF.getText().trim().length() == 0) {
                    outputErrorList += key1Blank;
                }

                else if (!Affine.isCoprime(Integer.parseInt(key1TF.getText()), Integer.parseInt(modComboBox.getValue()))) {
                    outputErrorList += key1Error;
                }

                if (key2TF.getText().trim().length() == 0) {
                    outputErrorList += key2Blank;
                }

                else if (!(Integer.parseInt(key2TF.getText()) < Integer.parseInt(modComboBox.getValue()))) {
                    outputErrorList += key2Error;
                }

                outputTA.setText(outputErrorList);
            }

            else {

                Affine newAffine = new Affine(functionButton.getText(), Integer.parseInt(key1TF.getText()), Integer.parseInt(key2TF.getText()), help, about);
                Affine.setModulo(Integer.parseInt(modComboBox.getValue()));

                switch (functionButton.getText()) {
                case "Encrypt":
                    outputTA.setText(newAffine.encryptText(inputTA.getText()));
                    break;
                case "Decrypt":
                    outputTA.setText(newAffine.decryptText(inputTA.getText()));
                    break;
                default:
                }
            }
        });
        return affineFormFX;
    }

    public static GridPane affineHelp() {

        GridPane affineHelp = new GridPane();

        return affineHelp;
    }

    public static GridPane affineAbout() {

        GridPane affineAbout = new GridPane();

        return affineAbout;
    }
}