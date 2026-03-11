package application;

/**
 * Main class to launch the Hangman game.
 */
public class App {

    public static void main(String[] args) {
        // Create an instance of the Hangman game
        Hangman game = new Hangman();

        // Run the game loop
        game.run();

        // Close resources (scanner)
        game.close();
    }
}