package application;

import java.util.Random;

/**
 * Handles a random word for the Hangman game.
 * Tracks guessed letters and blanks.
 */
public class RandomWord {
	private String[] words = {
		    "adventure", "mountain", "journey", "discovery", "whisper",
		    "treasure", "mystery", "horizon", "sunlight", "echoes",
		    "labyrinth", "wanderlust", "starlight", "voyager", "compass"
		};

    private String chosenWord;
    private Random random = new Random();
    private char[] characters;

    public RandomWord() {
        // Select a random word and initialize the character array
        chosenWord = words[random.nextInt(words.length)];
        characters = new char[chosenWord.length()];
    }

    /**
     * Returns the current state of the word, using "_" for unknown letters.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char c : characters) {
            sb.append(c == '\u0000' ? "_" : c);
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * Checks if all letters have been guessed.
     * @return true if the word is fully guessed, false otherwise
     */
    public boolean isComplete() {
        for (char c : characters) {
            if (c == '\u0000') {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds a guessed letter to the character array if it exists in the word.
     * @param c the guessed letter
     * @return true if the letter exists in the word, false otherwise
     */
    public boolean addGuess(char c) {
        boolean correct = false;
        for (int i = 0; i < chosenWord.length(); i++) {
            if (c == chosenWord.charAt(i)) {
                characters[i] = c;
                correct = true;
            }
        }
        return correct;
    }
}