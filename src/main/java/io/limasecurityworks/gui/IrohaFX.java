package io.limasecurityworks.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static io.limasecurityworks.guicomponents.AboutFX;
import static io.limasecurityworks.guicomponents.CiphersFX;
import static io.limasecurityworks.guicomponents.DashFX.buildDash;
import static io.limasecurityworks.guicomponents.HelpFX;
import static io.limasecurityworks.guicomponents.SettingsFX;
import static io.limasecurityworks.guicomponents.MenuBar.addVBox;
import static io.limasecurityworks.guicomponents.TopBar.addHBox;
import javafx.application.HostServices; 


public class IrohaFX extends Application {

    Stage primaryStage;
    Scene menu, dash, ciphers, settings, help, about;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane workingScene = buildDash();
        primaryStage.setTitle("limaSecurityWorks - Iroha");
        primaryStage.getIcons().add(new Image("FullColorOrangeIcon.png"));


        BorderPane splash = new BorderPane();
        BorderPane splashInner = new BorderPane();
        
        splash.setLeft(addVBox("dash"));
        splash.setCenter(splashInner);
        splashInner.setTop(addHBox("dash"));
        splashInner.setCenter(workingScene);
        BorderPane.setMargin(workingScene, new Insets(25, 25, 25, 25));
    
        Scene scene = new Scene(splash, 1475, 800);
        scene.getStylesheets().add("FlatRed.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    } 

    public void openBrowser(final String url) {
        getHostServices().showDocument(url);
    }


}

        /*
        //Name Input
        TextField nameInput = new TextField("Bucky");
        GridPane.setConstraints(nameInput, 1, 0);
        //Password Label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 1, 1);
        //Password Input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);
        */