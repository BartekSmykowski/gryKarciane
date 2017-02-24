package sample.controller;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.model.AppState;
import sample.model.Game;
import sample.model.RoundScores;

public class TysiacController {

    @FXML
    public Button backToGameChooseButton;
    @FXML
    public TableView<RoundScores> scoresTable;
    @FXML
    public Button nextRoundButton;
    @FXML
    public HBox hBoxWithScoresTextFields;

    private Game game;
    private TextField[] scoreTextFields;


    @FXML
    public void initialize(){

    }

    public void switchToGameChooseScene() throws Exception {
        Stage stage;
        Parent root;
        stage=(Stage) backToGameChooseButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/gameChooseScene.fxml"));
        root.getStylesheets().clear();
        root.getStylesheets().add(getClass().getResource("../view/" + AppState.getThemeName() + ".css").toString());
        stage.setScene(new Scene(root, 300, 300));
        stage.show();
    }

    public void setGame(Game game){
        this.game = game;
        scoresTable.setItems(game.getPoints());
        TableColumn<RoundScores, Integer>[] columns = (TableColumn<RoundScores, Integer>[]) new TableColumn[game.getNumberOfPlayers()];
        scoreTextFields = new TextField[game.getNumberOfPlayers()];
        hBoxWithScoresTextFields.getChildren().clear();
        for(int i = 0; i < game.getNumberOfPlayers(); i++) {
            final int finali= i;
            columns[i] = new TableColumn<>(game.getName(i));
            columns[i].setCellValueFactory(cellData -> cellData.getValue().scoresPropertyValue(finali).asObject());
            columns[i].setPrefWidth(80);
            scoreTextFields[i] = new TextField("0");
            hBoxWithScoresTextFields.getChildren().add(scoreTextFields[i]);
            scoreTextFields[i].setText("0");
        }
        scoresTable.getColumns().setAll(columns);

        scoresTable.getItems().addListener(
                (ListChangeListener<RoundScores>) c -> scoresTable.scrollTo(scoresTable.getItems().size() - 1)
        );
    }

    public void nextRound() {
        int[] points = new int[game.getNumberOfPlayers()];
        for(int i = 0; i < game.getNumberOfPlayers(); i++) {
            points[i] = Integer.parseInt(scoreTextFields[i].getText());
            scoreTextFields[i].setText("0");
        }
        game.nextRound(points);
    }
}
