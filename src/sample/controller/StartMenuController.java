package sample.controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.model.AppState;

public class StartMenuController {

    public Button newGameButton;
    public Button setupButton;
    public Button exit;

    public void switchToGameChooseScene() throws Exception {
        Stage stage;
        Parent root;
        stage=(Stage) newGameButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/gameChooseScene.fxml"));
        Scene scene = new Scene(root, 300, 300);
        root.getStylesheets().clear();
        root.getStylesheets().add(getClass().getResource("../view/" + AppState.getThemeName() + ".css").toString());
        stage.setScene(scene);
        stage.show();
    }

    public void exitApplication() throws Exception {
        Platform.exit();
    }

    public void goToSetupScene() throws Exception {
        Stage stage;
        Parent root;
        stage=(Stage) newGameButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/setupScene.fxml"));
        root.getStylesheets().clear();
        root.getStylesheets().add(getClass().getResource("../view/" + AppState.getThemeName() + ".css").toString());
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
}
