// Driver.java
package assignment2;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        // Check command line arguments for test mode
        boolean testMode = false;
        if (args.length > 0 && args[0].equals("1")) {
            testMode = true;
        }
        
        // Create single Scanner for entire program
        Scanner scanner = new Scanner(System.in);
        
        // Create Game object with test mode and scanner
        Game game = new Game(testMode, scanner);
        
        // Start the game loop
        game.runGame();
        
        // Close scanner when done
        scanner.close();
    }
}