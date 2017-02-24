package sample.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Game {


    private final IntegerProperty id;
    private final StringProperty typeOfGame;
    private final IntegerProperty numberOfPlayers;
    private final StringProperty[] playersNames;
    private ObservableList<RoundScores> points = FXCollections.observableArrayList();

    public Game(int id, String typeOfGame, int  numberOfPlayers, String[] playersNames){
        this.id = new SimpleIntegerProperty(id);
        this.numberOfPlayers = new SimpleIntegerProperty(numberOfPlayers);
        this.typeOfGame = new SimpleStringProperty(typeOfGame);
        this.playersNames = new StringProperty[numberOfPlayers];
        int[] zeroPoints = new int[numberOfPlayers];
        for(int i = 0 ; i < numberOfPlayers; i++) {
            zeroPoints[i] = 0;
            this.playersNames[i] = new SimpleStringProperty(playersNames[i]);
        }
        this.points.add(new RoundScores(numberOfPlayers, zeroPoints));
    }

    public void nextRound(int points[]){
        int tabSize = this.points.size();
        if(tabSize != 0){
            RoundScores lastScores = this.points.get(tabSize - 1);
            int[] newPoints = new int[numberOfPlayers.get()];
            for (int i = 0; i < newPoints.length; i++) {
                newPoints[i] = lastScores.getScores(i) + points[i];
            }
            RoundScores newScores = new RoundScores(numberOfPlayers.get(), newPoints);
            this.points.add(newScores);
        } else {
            this.points.add(new RoundScores(numberOfPlayers.get(), points));
        }
    }

    public StringProperty[] getPlayersNames(){
        return playersNames;
    }

    public String getName(int index){ return playersNames[index].get(); }

    public ObservableList<RoundScores> getPoints(){return points;}

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getTypeOfGame() {
        return typeOfGame.get();
    }

    public StringProperty typeOfGameProperty() {
        return typeOfGame;
    }

    public void setTypeOfGame(String typeOfGame) {
        this.typeOfGame.set(typeOfGame);
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers.get();
    }

    public IntegerProperty numberOfPlayersProperty() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers.set(numberOfPlayers);
    }


}
