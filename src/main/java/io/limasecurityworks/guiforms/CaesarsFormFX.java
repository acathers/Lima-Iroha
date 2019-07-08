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
import io.limasecurityworks.ciphers.Caesar;
import io.limasecurityworks.guicomponents.*;

public class CaesarsFormFX {

    public static GridPane caesarsFormFX() {

        //Create top bar buttons
        TopBar.addHBoxButtons("caesars");

        //Create Gridpane for Caesars Form.
        GridPane caesarsFormFX = new GridPane();
        BorderPane.setMargin(caesarsFormFX, new Insets(50, 15, 15, 50));
        caesarsFormFX.setHgap(15);
        caesarsFormFX.setVgap(15);

        //Create Label for input TextFeild.
        Label input = new Label("Input: ");
        GridPane.setValignment(input, VPos.TOP);
        caesarsFormFX.add(input, 0, 0);
        
        //Create TextField for input Label.
        TextArea inputTA = new TextArea();
        inputTA.setPromptText("Text to be encrypted or decrypted, click the function button to switch.");
        inputTA.setWrapText(true);
        inputTA.setPrefWidth(700);
        inputTA.setPrefHeight(200);
        caesarsFormFX.add(inputTA, 1, 0, 3, 1);
        
        //Create Label for function.
        Label function = new Label("Function Selection: ");
        caesarsFormFX.add(function, 0, 1);
        
        //Create a button for encrypt or decrypt.
        Button functionButton = new Button("Encrypt");
        functionButton.setPrefWidth(175);
        functionButton.setPrefHeight(50);
        functionButton.setStyle("-fx-background-color: -limaBlueLight");
        functionButton.setStyle(".button:pressed");
        caesarsFormFX.add(functionButton, 1, 1);
        
        functionButton.setOnAction(e -> {
            if (functionButton.getText().equals("Encrypt")) {
                functionButton.setText("Decrypt");
            }
            else {
                functionButton.setText("Encrypt");
            }
        });

        //Create a Label for key.
        Label key = new Label("Key: ");
        caesarsFormFX.add(key, 2, 1);

        //Create a TexField for key.
        TextField keyTF = new TextField();
        keyTF.setPrefWidth(175);
        keyTF.setText("3");
        caesarsFormFX.add(keyTF, 3, 1);

        //Create an Execute Button.
        Button execute = new Button("Execute");
        execute.setPrefWidth(175);
        execute.setPrefHeight(50);
        execute.setStyle("-fx-background-color: -limaBlueLight");
        execute.setStyle(".button:pressed");
        GridPane.setHalignment(execute, HPos.RIGHT);
        caesarsFormFX.add(execute, 3, 2);

        //Create Label for output.
        Label output = new Label("Output: ");
        GridPane.setValignment(output, VPos.TOP);
        GridPane.setMargin(output, new Insets(20, 0, 0, 0));
        caesarsFormFX.add(output, 0, 3);

        //Create TextField for output.
        TextArea outputTA = new TextArea();
        outputTA.setPromptText("Output text.");
        outputTA.setWrapText(true);
        outputTA.setEditable(false);
        outputTA.setPrefWidth(700);
        outputTA.setPrefHeight(200);
        GridPane.setMargin(outputTA, new Insets(20, 0, 0, 0));
        caesarsFormFX.add(outputTA, 1, 3, 3, 1);

        // Removes focus from TextFeild if background is clicked
        caesarsFormFX.setOnMousePressed(e-> caesarsFormFX.requestFocus());

        // Set action for execute button.
        execute.setOnAction(e -> {

            String help = null;
            String about = null;

            String inputError = "Input Error: Input may only contain letters." + "\n" + "\n";
            String inputErrorBlank = "Input Error: You must enter text to be encrypted or decrypted." + "\n" + "\n";

            String keyError = "Key Error: The key must contain only letters and no spaces.";
            String keyBlank = "Key Error: You must enter a key";

            String outputErrorList = "";

            if (inputTA.getText().trim().length() == 0 || !Caesar.checkInput(inputTA.getText()) || keyTF.getText().trim().length() == 0 || !Caesar.checkKey(keyTF.getText())) {

                if (inputTA.getText().trim().length() == 0){
                    outputErrorList += inputErrorBlank;
                }

                else if (!Caesar.checkInput(inputTA.getText())) {
                    outputErrorList += inputError;
                }

                if (keyTF.getText().trim().length() == 0) {
                    outputErrorList += keyBlank;
                }

                else if (!Caesar.checkKey(keyTF.getText())) {
                    outputErrorList += keyError;
                }

                outputTA.setText(outputErrorList);
            }
            
            else {

                Caesar newCC = new Caesar(functionButton.getText(), keyTF.getText(), help, about);

                switch(functionButton.getText()) {

                    case "Encrypt":
                    outputTA.setText(newCC.encryptText(Caesar.cleanInput(inputTA.getText())));
                    break;
                    case "Decrypt":
                    outputTA.setText(newCC.decryptText(Caesar.cleanInput(inputTA.getText())));
                    break;
                }   
            }   
        });

        return caesarsFormFX;
    }

    public static GridPane caesarsHelp() {

        GridPane caesarsHelp = new GridPane();
        return caesarsHelp;
    }

    public static GridPane caesarsAbout() {

        GridPane caesarsAbout = new GridPane();
        return caesarsAbout;
    }
}