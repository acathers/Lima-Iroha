package io.limasecurityworks.guiforms;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
        TextField inputTF = new TextField();
        inputTF.setPromptText("Text to be encrypted or decrypted, click the function button to switch.");
        inputTF.setPrefWidth(600);
        inputTF.setPrefHeight(200);
        inputTF.setAlignment(Pos.TOP_LEFT);
        caesarsFormFX.add(inputTF, 1, 0, 3, 1);
        
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

        //Create a Label for shift.
        Label shift = new Label("Shift: ");
        caesarsFormFX.add(shift, 2, 1);

        //Create a TexField for shift.
        TextField shiftTF = new TextField();
        shiftTF.setPrefWidth(175);
        shiftTF.setText("3");
        caesarsFormFX.add(shiftTF, 3, 1);

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
        TextField outputTF = new TextField();
        outputTF.setPromptText("Output text.");
        outputTF.setEditable(false);
        outputTF.setPrefWidth(500);
        outputTF.setPrefHeight(200);
        outputTF.setAlignment(Pos.TOP_LEFT);
        GridPane.setMargin(outputTF, new Insets(20, 0, 0, 0));
        caesarsFormFX.add(outputTF, 1, 3, 3, 1);

        // Removes focus from TextFeild if background is clicked

        /*
        caesarsFormFX.setOnMousePressed(e -> {
            if (!inputTF.equals(e.getSource())) {
                       inputTF.getParent().requestFocus();
            }
        });
        */

        caesarsFormFX.setOnMousePressed(e-> caesarsFormFX.requestFocus());

        execute.setOnAction(e -> {

            boolean complete = false;
            String help = null;
            String about = null;

            // If true, key has characters other than numbers and must be fixed.
            if (!Caesar.checkKey(shiftTF.getText())) {
                System.out.println("error key");
            }

            // If true, input has numbers and must be fixed.
            if (!Caesar.checkInput(inputTF.getText())) {
                System.out.println("errorInput");
            }

            if (Caesar.checkKey(shiftTF.getText()) && Caesar.checkInput(inputTF.getText())) {
                complete = true;
            }
            
            if (complete) {

                Caesar newCC = new Caesar(functionButton.getText(), shiftTF.getText(), help, about);

                switch(functionButton.getText()) {

                    case "Encrypt":
                    outputTF.setText(newCC.encryptText(Caesar.cleanInput(inputTF.getText())));
                    break;
                    case "Decrypt":
                    outputTF.setText(newCC.decryptText(Caesar.cleanInput(inputTF.getText())));
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