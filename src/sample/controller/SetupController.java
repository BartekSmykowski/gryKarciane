package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import sample.model.AppState;

public class SetupController {
    public Button backToMainMenuButton;
    public ChoiceBox<String> themeChoiceBox;


    private String themeName;

    @FXML
    public void initialize(){
        themeName = AppState.getThemeName();
        changeTheme(themeName);
        themeChoiceBox.getSelectionModel().select("Ciemne");
        themeChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    themeName = newValue;
                    String themeName = "";
                    switch (newValue){
                        case "Jasne": themeName = "Bright"; break;
                        case "Ciemne": themeName = "Dark";break;
                        case "Kolor": themeName = "Colour";break;
                    }
                    changeTheme(themeName);
                }
        );
    }

    private void changeTheme(String themeName){
        AppState.changeTheme(themeName);
        backToMainMenuButton.getParent().getStylesheets().clear();
        backToMainMenuButton.getParent().getStylesheets().add(getClass().getResource("../view/" + AppState.getThemeName() + ".css").toString());
    }

    public void backToMainMenu() throws Exception {
        Stage stage;
        Parent root;
        stage=(Stage) backToMainMenuButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/mainScene.fxml"));
        root.getStylesheets().clear();
        root.getStylesheets().add(getClass().getResource("../view/" + AppState.getThemeName() + ".css").toString());
        stage.setScene(new Scene(root, 300, 300));
        stage.show();
    }
}
