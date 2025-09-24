package assignment2;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        boolean testMode = false;
        if (args.length > 0 && args[0].equals("1")) {
            testMode = true;
        }
        
        Scanner scanner = new Scanner(System.in);
        
        Game game = new Game(testMode, scanner);
        
        game.runGame();
        
        scanner.close();
    }
}