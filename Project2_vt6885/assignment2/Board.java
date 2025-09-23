package assignment2;

import java.util.ArrayList;

public class Board {
    private ArrayList<Code> guesses;
    private ArrayList<Result> results;  // This should be Result not r
    
    public Board() {
        guesses = new ArrayList<>();
        results = new ArrayList<>();
    }
    
    public void addGuess(Code guess, Result result) {
        guesses.add(guess);
        results.add(result);
    }
    
    public void printHistory() {
        for (int i = 0; i < guesses.size(); i++) {
            System.out.println(guesses.get(i).toString() + "\t\t" + results.get(i).toString());
        }
    }
}