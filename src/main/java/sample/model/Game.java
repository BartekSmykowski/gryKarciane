package sample.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;


public class Game {

    private final StringProperty typeOfGame;
    private final IntegerProperty numberOfPlayers;
    private final StringProperty[] playersNames;
    private IntegerProperty whoseTurn;
    private ObservableList<RoundScores> points = FXCollections.observableArrayList();

    public Game(int id, String typeOfGame, int  numberOfPlayers, String[] playersNames){
        this.numberOfPlayers = new SimpleIntegerProperty(numberOfPlayers);
        this.typeOfGame = new SimpleStringProperty(typeOfGame);
        this.playersNames = new StringProperty[numberOfPlayers];
        int[] zeroPoints = new int[numberOfPlayers];
        for(int i = 0 ; i < numberOfPlayers; i++) {
            zeroPoints[i] = 0;
            this.playersNames[i] = new SimpleStringProperty(playersNames[i]);
        }
        this.points.add(new RoundScores(numberOfPlayers, zeroPoints));
        Random rand = new Random();
        this.whoseTurn = new SimpleIntegerProperty(rand.nextInt(numberOfPlayers));
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
        whoseTurn.set((whoseTurn.get() + 1)%numberOfPlayers.get());
    }

    public String getName(int index){ return playersNames[index].get(); }

    public ObservableList<RoundScores> getPoints(){return points;}

    public int getNumberOfPlayers() {
        return numberOfPlayers.get();
    }


    public int getWhoseTurn() { return whoseTurn.get(); }

}
