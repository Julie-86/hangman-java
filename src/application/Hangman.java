package application;

import java.util.Scanner;

/**
 * Handles the Hangman game loop, user input, and game logic.
 */
public class Hangman {

    private boolean running = true;
    private RandomWord word = new RandomWord();
    private Scanner scanner = new Scanner(System.in);
    private int triesRemaining = 5;
    private char lastGuess;

    /**
     * Main game loop.
     */
    public void run() {
        do {
            displayWord();
            getUserInput();
            checkUserInput();
        } while (running);
    }

    /**
     * Checks the user's guess and updates the game state.
     */
    private void checkUserInput() {
        boolean isCorrect = word.addGuess(lastGuess);

        if (isCorrect) {
            if (word.isComplete()) {
                System.out.println("You have won!!!");
                System.out.println("The word is " + word);
                running = false;
            }
        } else {
            triesRemaining--;
            if (triesRemaining == 0) {
                System.out.println("You have lost!");
                running = false;
            }
        }
    }

    /**
     * Prompts the user to enter a character guess.
     */
    private void getUserInput() {
        System.out.print("Enter your guess: ");
        String guess = scanner.nextLine();
        lastGuess = guess.charAt(0); // still no validation for lowercase letters
    }

    /**
     * Displays the current word state with guessed letters and blanks.
     */
    void displayWord() {
        System.out.println("\nTries remaining: " + triesRemaining);
        System.out.println(word);
    }

    /**
     * Closes the game resources (scanner).
     */
    public void close() {
        scanner.close();
    }
}