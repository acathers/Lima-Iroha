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
import io.limasecurityworks.ciphers.ADFGX;
import io.limasecurityworks.guicomponents.*;

public class ADFGXFormFX {

    public static GridPane adfgxFormFX() {

        //Create top bar buttons
        TopBar.addHBoxButtons("adfgx");

        //Create Gridpane for adfgxs Form.
        GridPane adfgxFormFX = new GridPane();
        BorderPane.setMargin(adfgxFormFX, new Insets(50, 15, 15, 50));
        adfgxFormFX.setHgap(15);
        adfgxFormFX.setVgap(15);

        //Create Label for input TextFeild.
        Label input = new Label("Input: ");
        GridPane.setValignment(input, VPos.TOP);
        adfgxFormFX.add(input, 0, 0);
        
        //Create TextField for input Label.
        TextField inputTF = new TextField();
        inputTF.setPromptText("Text to be encrypted or decrypted, click the function button to switch.");
        inputTF.setPrefWidth(700);
        inputTF.setPrefHeight(200);
        inputTF.setAlignment(Pos.TOP_LEFT);
        adfgxFormFX.add(inputTF, 1, 0, 4, 1);
        
        //Create Label for function.
        Label function = new Label("Function Selection: ");
        adfgxFormFX.add(function, 0, 2);
        
        //Create a button for encrypt or decrypt.
        Button functionButton = new Button("Encrypt");
        functionButton.setPrefWidth(175);
        functionButton.setPrefHeight(50);
        functionButton.setStyle("-fx-background-color: -limaBlueLight");
        functionButton.setStyle(".button:pressed");
        adfgxFormFX.add(functionButton, 1, 2);
        
        functionButton.setOnAction(e -> {
            if(functionButton.getText().equals("Encrypt")) {
                functionButton.setText("Decrypt");
            }
            else {
                functionButton.setText("Encrypt");
            }
        });

        //Create a Label for shift.
        Label keySquare = new Label("keySquare: ");
        adfgxFormFX.add(keySquare, 2, 1);

        //Create a TexField for shift.
        TextField keySquareTF = new TextField();
        keySquareTF.setText("abcdefghiklmnopqrstuvwxyz");
        adfgxFormFX.add(keySquareTF, 3, 1, 2, 1);

        //Create Generate KeySquare button;
        Button genKeySquare = new Button("Random Key Sq.");
        genKeySquare.setPrefWidth(175);
        genKeySquare.setPrefHeight(50);
        genKeySquare.setStyle("-fx-background-color: -limaBlueLight");
        genKeySquare.setStyle(".button:pressed");
        adfgxFormFX.add(genKeySquare, 1, 1);

        //Define genKeySquare button action
        genKeySquare.setOnAction(e -> {
            keySquareTF.setText(ADFGX.generateKeySquare());
        });

        //Create Key Label.
        Label key = new Label("key: ");
        adfgxFormFX.add(key, 2, 2);

        //Create Key text field.
        TextField keyTF = new TextField();
        inputTF.setPromptText("Enter key");
        adfgxFormFX.add(keyTF, 3, 2);

        //Create an Execute Button.
        Button execute = new Button("Execute");
        execute.setPrefWidth(175);
        execute.setPrefHeight(50);
        execute.setStyle("-fx-background-color: -limaBlueLight");
        execute.setStyle(".button:pressed");
        GridPane.setHalignment(execute, HPos.RIGHT);
        adfgxFormFX.add(execute, 4, 2);

        //Create Label for output.
        Label output = new Label("Output: ");
        GridPane.setValignment(output, VPos.TOP);
        GridPane.setMargin(output, new Insets(20, 0, 0, 0));
        adfgxFormFX.add(output, 0, 3);

        //Create TextField for output.
        TextField outputTF = new TextField();
        outputTF.setPromptText("Output text.");
        outputTF.setEditable(false);
        outputTF.setPrefWidth(500);
        outputTF.setPrefHeight(200);
        outputTF.setAlignment(Pos.TOP_LEFT);
        GridPane.setMargin(outputTF, new Insets(20, 0, 0, 0));
        adfgxFormFX.add(outputTF, 1, 3, 4, 1);

        // Removes focus from TextFeild if background is clicked

        /*
        adfgxFormFX.setOnMousePressed(e -> {
            if (!inputTF.equals(e.getSource())) {
                        inputTF.getParent().requestFocus();
            }
        });
        */

        adfgxFormFX.setOnMousePressed(e-> adfgxFormFX.requestFocus());

        execute.setOnAction(e -> {

            boolean complete = false;

            String help = null;
            String about = null;

            // If true, key has characters other than numbers and must be fixed.
            if(!ADFGX.checkKey(keySquareTF.getText())) {

            }
            if(!ADFGX.checkKeySquare(keySquareTF.getText())) {

            }

            // Checks are good, ready to complete encryption or decryption.
            if(ADFGX.checkKey(keyTF.getText())) {
                complete = true;
            }
            
            // If checks were good, then execute.
            if(complete) {

                ADFGX newAVC = new ADFGX(functionButton.getText(), keyTF.getText(), keySquareTF.getText(), help, about);

                switch(functionButton.getText()) {
                    case "Encrypt":
                    outputTF.setText(newAVC.encryptText(ADFGX.cleanInput(inputTF.getText())));
                    System.out.println("Tried encrypt");
                    break;
                    case "Decrypt":
                    outputTF.setText(newAVC.decryptText(ADFGX.cleanInput(inputTF.getText())));
                    System.out.println("Tried Decrypt");
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