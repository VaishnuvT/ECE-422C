package assignment2;

import java.util.ArrayList;

public class Board {
    private ArrayList<Code> guesses;
    private ArrayList<Result> results;
    
    public Board() {
        guesses = new ArrayList<>();
        results = new ArrayList<>();
    }
    
    public void addGuess(Code guess, Result result) {
        guesses.add(guess);
        results.add(result);
    }
    
    public void printHistory() {
        if (guesses.size() == 0) {
            return;
        }

        for (int i = 0; i < guesses.size(); i++) {
            System.out.println(guesses.get(i).toString() + "        " + results.get(i).toString());
        }
    }
}