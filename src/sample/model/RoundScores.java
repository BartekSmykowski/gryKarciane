package sample.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class RoundScores {
    private IntegerProperty[] scores;
    private int numberOfPlayers;

    public RoundScores(){
        this(3, new int[] {0,0,0});
    }

    public RoundScores(int numberOfPlayers, int scores[]){
        this.numberOfPlayers = numberOfPlayers;
        this.scores = new IntegerProperty[numberOfPlayers];
        for(int i = 0; i < numberOfPlayers; i++){
            this.scores[i] = new SimpleIntegerProperty(scores[i]);
        }
    }

    public void setScores(IntegerProperty[] scores) {
        this.scores = scores;
    }

    public IntegerProperty scoresPropertyValue(int index){
        return scores[index];
    }

    public IntegerProperty[] scoresProperty(){
        return scores;
    }

    public int getScores(int index) {
        return scores[index].get();
    }
}
