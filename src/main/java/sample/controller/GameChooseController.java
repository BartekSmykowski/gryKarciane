package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.model.AppState;
import sample.model.Game;

public class GameChooseController {

    @FXML
    public Button beginButton;
    @FXML
    public ChoiceBox gameChoiceBox;
    @FXML
    public Button backToMenuButton;
    @FXML
    public ChoiceBox<String> numberOfPlayersChoiceBox;

    public HBox hBoxWithPlayerNamesTextAreas;
    private TextField[] playersNamesTextFields;

    private int selectedNumberOfPlayers = 3;

    @FXML
    public void initialize(){
        changeNumberOfTextFields(3);
        numberOfPlayersChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    selectedNumberOfPlayers = Integer.parseInt(newValue);
                    changeNumberOfTextFields(selectedNumberOfPlayers);
                }
        );
    }

    private void changeNumberOfTextFields(int toHowMany){
        hBoxWithPlayerNamesTextAreas.getChildren().clear();
        playersNamesTextFields = new TextField[toHowMany];
        for (int i = 0; i< toHowMany;i++){
            playersNamesTextFields[i] = new TextField();
            hBoxWithPlayerNamesTextAreas.getChildren().add(playersNamesTextFields[i]);
        }
    }

    public void beginGame() throws Exception {
        int numberOfPlayers = Integer.parseInt(numberOfPlayersChoiceBox.getSelectionModel().getSelectedItem());
        String[] playersNames = new String[numberOfPlayers];
        String gameType = gameChoiceBox.getSelectionModel().getSelectedItem().toString();
        for(int i = 0; i < numberOfPlayers; i++) {
            playersNames[i] = playersNamesTextFields[i].getText();
        }
        Game game = new Game(0, gameType, numberOfPlayers, playersNames);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tysiacScene.fxml"));
        Parent root = loader.load();
        root.getStylesheets().clear();
        root.getStylesheets().add(getClass().getResource("/" + AppState.getThemeName() + ".css").toString());
        TysiacController tysiacController = loader.getController();
        tysiacController.setGame(game);

        Stage stage = (Stage) backToMenuButton.getScene().getWindow();
        stage.setScene(new Scene(root, 300, 500));
        stage.show();

    }

    public void backToMenu() throws Exception {
        Stage stage;
        Parent root;
        stage=(Stage) backToMenuButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/mainScene.fxml"));
        root.getStylesheets().clear();
        root.getStylesheets().add(getClass().getResource("/" + AppState.getThemeName() + ".css").toString());
        stage.setScene(new Scene(root, 300, 300));
        stage.show();
    }
}
