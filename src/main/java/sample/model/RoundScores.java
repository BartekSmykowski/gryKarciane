package sample.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class RoundScores {
    private IntegerProperty[] scores;

    RoundScores(int numberOfPlayers, int scores[]){
        this.scores = new IntegerProperty[numberOfPlayers];
        for(int i = 0; i < numberOfPlayers; i++){
            this.scores[i] = new SimpleIntegerProperty(scores[i]);
        }
    }

    public IntegerProperty scoresPropertyValue(int index){
        return scores[index];
    }

    int getScores(int index) {
        return scores[index].get();
    }
}
