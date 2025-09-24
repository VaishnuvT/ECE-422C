package assignment2;

import java.util.Scanner;

public class Game {
    private boolean testMode;
    private Scanner scanner;
    
    public Game(boolean testMode, Scanner scanner) {
        this.testMode = testMode;
        this.scanner = scanner;
    }
    
    public void runGame() {
        boolean playAgain = true;
        
        printWelcomeMessage();
        
        while (playAgain) {
            playSingleGame();
            
            System.out.println();
            System.out.println("Are you ready for another game (Y/N):");
            String response = scanner.nextLine().trim();
            playAgain = response.equalsIgnoreCase("Y");
        }
    }
    
    private void playSingleGame() {
        System.out.println();
        System.out.println("Generating secret code ...");
        Code secretCode = new Code(SecretCodeGenerator.getInstance().getNewSecretCode());
        
        if (testMode) {
            System.out.println("(for this example the secret code is " + secretCode.toString() + ")");
        }
        
        Board board = new Board();
        int remainingGuesses = GameConfiguration.guessNumber;
        boolean won = false;
        
        while (remainingGuesses > 0 && !won) {
            System.out.println();
            System.out.println("You have " + remainingGuesses + " guesses left.");
            System.out.println("What is your next guess?");
            System.out.println("Type in the characters for your guess and press enter.");
            System.out.println("Enter guess:");

            String input = scanner.nextLine().trim();
            
            if (input.equals("HISTORY")) {
                board.printHistory();
                continue;
            }
            
            if (!isValidGuess(input)) {
                System.out.println(input + " -> INVALID GUESS");
                continue;
            }
            
            Code guess = new Code(input);
            Result result = evaluateGuess(secretCode, guess);
            board.addGuess(guess, result);
            
            remainingGuesses--;
            
            if (result.getBlackPegs() == GameConfiguration.pegNumber) {
                System.out.println(guess.toString() + " -> " + result.toString() + " - You win");
                won = true;
            } else if (remainingGuesses > 0) {
                System.out.println(guess.toString() + " -> " + result.toString());
            }
        }
        
        if (!won) {
            System.out.println();
            System.out.println("Sorry, you are out of guesses. You lose, boo-hoo.");
        }
    }
    
    private void printWelcomeMessage() {
        System.out.println("Welcome to Mastermind.  Here are the rules.");
        System.out.println();
        System.out.println("This is a text version of the classic board game Mastermind.");
        System.out.println();
    System.out.println("The computer will think of a secret code. The code consists of 4");
        System.out.println("colored pegs. The pegs MUST be one of six colors: blue, green,");
        System.out.println("orange, purple, red, or yellow. A color may appear more than once in");
        System.out.println("the code. You try to guess what colored pegs are in the code and");
        System.out.println("what order they are in. After you make a valid guess the result");
        System.out.println("(feedback) will be displayed.");
        System.out.println();
        System.out.println("The result consists of a black peg for each peg you have guessed");
        System.out.println("exactly correct (color and position) in your guess. For each peg in");
        System.out.println("the guess that is the correct color, but is out of position, you get");
        System.out.println("a white peg. For each peg, which is fully incorrect, you get no");
        System.out.println("feedback.");
        System.out.println();
        System.out.println("Only the first letter of the color is displayed. B for Blue, R for");
        System.out.println("Red, and so forth. When entering guesses you only need to enter the");
        System.out.println("first character of each color as a capital letter.");
        System.out.println();
    System.out.println("You have 12 guesses to figure out the secret code or you lose the");
    System.out.println("game. Are you ready to play? (Y/N):");

    String response = scanner.nextLine().trim();
    }
    
    private boolean isValidGuess(String input) {
        if (input.length() != GameConfiguration.pegNumber) {
            return false;
        }
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            boolean valid = false;
            for (String color : GameConfiguration.colors) {
                if (color.charAt(0) == ch) {
                    valid = true;
                    break;
                }
            }
            if (!valid) {
                return false;
            }
        }
        
        return true;
    }
    
    private Result evaluateGuess(Code secretCode, Code guess) {
        char[] secretCopy = secretCode.toString().toCharArray();
        char[] guessCopy = guess.toString().toCharArray();
        
        int blackPegs = 0;
        int whitePegs = 0;
        
        for (int i = 0; i < GameConfiguration.pegNumber; i++) {
            if (secretCopy[i] == guessCopy[i]) {
                blackPegs++;
                secretCopy[i] = '-';
                guessCopy[i] = '-';
            }
        }
        
        for (int i = 0; i < GameConfiguration.pegNumber; i++) {
            if (guessCopy[i] != '-') {
                for (int j = 0; j < GameConfiguration.pegNumber; j++) {
                    if (secretCopy[j] != '-' && guessCopy[i] == secretCopy[j]) {
                        whitePegs++;
                        secretCopy[j] = '-';
                        guessCopy[i] = '-';
                        break;
                    }
                }
            }
        }
        
        return new Result(blackPegs, whitePegs);
    }
}