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
import io.limasecurityworks.ciphers.ADFGVX;
import io.limasecurityworks.guicomponents.*;

public class ADFGVXFormFX {

    public static GridPane adfgvxFormFX() {

        //Create top bar buttons
        TopBar.addHBoxButtons("adfgvx");

        //Create Gridpane for adfgvxs Form.
        GridPane adfgvxFormFX = new GridPane();
        BorderPane.setMargin(adfgvxFormFX, new Insets(50, 15, 15, 50));
        adfgvxFormFX.setHgap(15);
        adfgvxFormFX.setVgap(15);

        //Create Label for input TextFeild.
        Label input = new Label("Input: ");
        GridPane.setValignment(input, VPos.TOP);
        adfgvxFormFX.add(input, 0, 0);
        
        //Create TextField for input Label.
        TextField inputTF = new TextField();
        inputTF.setPromptText("Text to be encrypted or decrypted, click the function button to switch.");
        inputTF.setPrefWidth(700);
        inputTF.setPrefHeight(200);
        inputTF.setAlignment(Pos.TOP_LEFT);
        adfgvxFormFX.add(inputTF, 1, 0, 4, 1);
        
        //Create Label for function.
        Label function = new Label("Function Selection: ");
        adfgvxFormFX.add(function, 0, 2);
        
        //Create a button for encrypt or decrypt.
        Button functionButton = new Button("Encrypt");
        functionButton.setPrefWidth(175);
        functionButton.setPrefHeight(50);
        functionButton.setStyle("-fx-background-color: -limaBlueLight");
        functionButton.setStyle(".button:pressed");
        adfgvxFormFX.add(functionButton, 1, 2);
        
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
        adfgvxFormFX.add(keySquare, 2, 1);

        //Create a TexField for shift.
        TextField keySquareTF = new TextField();
        keySquareTF.setText("avjzt7n5iwgm8u0q9dhb2rfcxyke4s13p6ol");
        adfgvxFormFX.add(keySquareTF, 3, 1, 2, 1);

        //Create Generate KeySquare button;
        Button genKeySquare = new Button("Random Key Sq.");
        genKeySquare.setPrefWidth(175);
        genKeySquare.setPrefHeight(50);
        genKeySquare.setStyle("-fx-background-color: -limaBlueLight");
        genKeySquare.setStyle(".button:pressed");
        adfgvxFormFX.add(genKeySquare, 1, 1);

        //Define genKeySquare button action
        genKeySquare.setOnAction(e -> {
            keySquareTF.setText(ADFGVX.generateKeySquare());
        });

        //Create Key Label.
        Label key = new Label("key: ");
        adfgvxFormFX.add(key, 2, 2);

        //Create Key text field.
        TextField keyTF = new TextField();
        inputTF.setPromptText("Enter key");
        adfgvxFormFX.add(keyTF, 3, 2);

        //Create an Execute Button.
        Button execute = new Button("Execute");
        execute.setPrefWidth(175);
        execute.setPrefHeight(50);
        execute.setStyle("-fx-background-color: -limaBlueLight");
        execute.setStyle(".button:pressed");
        GridPane.setHalignment(execute, HPos.RIGHT);
        adfgvxFormFX.add(execute, 4, 2);

        //Create Label for output.
        Label output = new Label("Output: ");
        GridPane.setValignment(output, VPos.TOP);
        GridPane.setMargin(output, new Insets(20, 0, 0, 0));
        adfgvxFormFX.add(output, 0, 3);

        //Create TextField for output.
        TextField outputTF = new TextField();
        outputTF.setPromptText("Output text.");
        outputTF.setEditable(false);
        outputTF.setPrefWidth(500);
        outputTF.setPrefHeight(200);
        outputTF.setAlignment(Pos.TOP_LEFT);
        GridPane.setMargin(outputTF, new Insets(20, 0, 0, 0));
        adfgvxFormFX.add(outputTF, 1, 3, 4, 1);

        // Removes focus from TextFeild if background is clicked

        /*
        adfgvxFormFX.setOnMousePressed(e -> {
            if (!inputTF.equals(e.getSource())) {
                       inputTF.getParent().requestFocus();
            }
        });
        */

        adfgvxFormFX.setOnMousePressed(e-> adfgvxFormFX.requestFocus());

        execute.setOnAction(e -> {

            boolean complete = false;

            String help = null;
            String about = null;

            // If true, key has characters other than numbers and must be fixed.
            if(!ADFGVX.checkKey(keySquareTF.getText())) {

            }
            if(!ADFGVX.checkKeySquare(keySquareTF.getText())) {

            }

            // Checks are good, ready to complete encryption or decryption.
            if(ADFGVX.checkKey(keyTF.getText())) {
                complete = true;
            }
            
            // If checks were good, then execute.
            if(complete) {

                ADFGVX newAVC = new ADFGVX(execute.getText(), keyTF.getText(), keySquareTF.getText(), help, about);

                switch(functionButton.getText()) {
                    case "Encrypt":
                    outputTF.setText(newAVC.encryptText(ADFGVX.cleanInput(inputTF.getText())));
                    System.out.println("Tried encrypt");
                    break;
                    case "Decrypt":
                    outputTF.setText(newAVC.decryptText(ADFGVX.cleanInput(inputTF.getText())));
                    System.out.println("Tried Decrypt");
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