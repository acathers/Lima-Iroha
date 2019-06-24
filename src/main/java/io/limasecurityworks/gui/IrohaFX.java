package io.limasecurityworks.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.Image;
import javafx.geometry.Pos;
import static io.limasecurityworks.guicomponents.AboutFX.buildAbout;
import static io.limasecurityworks.guicomponents.CiphersFX.buildCiphers;
import static io.limasecurityworks.guicomponents.KeyRingFX.buildKeyRing;
import static io.limasecurityworks.guicomponents.DashFX.buildDash;
import static io.limasecurityworks.guicomponents.HelpFX.buildHelp;
import static io.limasecurityworks.guicomponents.SettingsFX.buildSettings;
import static io.limasecurityworks.guicomponents.MenuBar.addVBox;
import static io.limasecurityworks.guicomponents.TopBar.addHBoxButtons;
import static io.limasecurityworks.guicomponents.TopBar.addHBoxSocial;


public class IrohaFX extends Application {

    Stage primaryStage;
    Scene menu, dash, ciphers, settings, help, about;
    public static String currentSceneChoice = "dash";
    public static BorderPane splash = new BorderPane();
    public static BorderPane splashInner = new BorderPane();
    public static BorderPane splashInnerTop = new BorderPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Build Stage and set the Logo to the top left of the Stage.
        primaryStage.setTitle("limaSecurityWorks - Iroha");
        primaryStage.getIcons().add(new Image("FullColorOrangeIcon.png"));

        //Build menu bar on left.
        splash.setLeft(addVBox(currentSceneChoice));

        // Build inner BorderPane.
        splash.setCenter(splashInner);

        // Build inner BorderPane and add borderpane to the top and build top bar.
        splashInner.setTop(splashInnerTop);
        splashInnerTop.setRight(addHBoxSocial(currentSceneChoice));
        splashInnerTop.setLeft(addHBoxButtons(currentSceneChoice));
        splashInnerTop.setStyle("-fx-background-color: -limaBlueLight");


        // Build inner BorderPane Center.
        GridPane workingScene = buildCurrentSceneChoice(currentSceneChoice);
        splashInner.setCenter(workingScene);
        BorderPane.setMargin(workingScene, new Insets(25, 25, 25, 25));

        // Set the Scene.
        Scene scene = new Scene(splash, 1475, 800);
        scene.getStylesheets().add("limaBlue.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    } 

    //Method used to opening the browser and going to a link.
    public void openBrowser(final String url) {
        getHostServices().showDocument(url);
    }

    //Method used to build the Center of the inner BorderPane.
    public static GridPane buildCurrentSceneChoice(String input) {

        switch(input) {
            case "dash":
                return buildDash();
            case "ciphers":
                return buildCiphers();
            case "keyring":
                return buildKeyRing();
            case "settings":
                return buildSettings();
            case "help":
                return buildHelp();
            case "about":
                return buildAbout();
            default:
                return buildDash();
        }
    }
}