package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.util.Pair;
import sample.model.AppState;

public class SetupController {
    public Button backToMainMenuButton;
    public ChoiceBox<Pair<String, String>> themeChoiceBox;

    @FXML
    public void initialize(){
        ObservableList<Pair<String, String>> selectionList = FXCollections.observableArrayList();
        selectionList.add(new Pair<>("Dark", "Ciemne"));
        selectionList.add(new Pair<>("Bright", "Jasne"));
        selectionList.add(new Pair<>("Colour", "Kolor"));
        themeChoiceBox.setItems(selectionList);
        themeChoiceBox.getSelectionModel().select(new Pair<>("Dark", "Ciemne"));
        themeChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> changeTheme(newValue.getKey())
        );
    }

    private void changeTheme(String themeName){
        AppState.changeTheme(themeName);
        backToMainMenuButton.getParent().getStylesheets().clear();
        backToMainMenuButton.getParent().getStylesheets().add(getClass().getResource("/" + AppState.getThemeName() + ".css").toString());
    }

    public void backToMainMenu() throws Exception {
        Stage stage;
        Parent root;
        stage=(Stage) backToMainMenuButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/mainScene.fxml"));
        root.getStylesheets().clear();
        root.getStylesheets().add(getClass().getResource("/" + AppState.getThemeName() + ".css").toString());
        stage.setScene(new Scene(root, 300, 300));
        stage.show();
    }
}
