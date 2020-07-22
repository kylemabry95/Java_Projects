package hw9;

import java.util.List;
import java.util.Random;

/**
 * Main class for the Hangman game. 
 * @author kmabry (Kyle Mabry) and maianz (Maian Zhang)
 *
 */
public class HangmanGame {


    /**
     * This is the main method that runs our game. 
     * @param args
     */
    public static void main(String[] args) {

	// read in the file (This should work regardless of who's computer we run on). 
	fileReader myReader = new fileReader("src/hw9/words.txt");

	// store all the words in a list
	List<String> wordList = myReader.readFileIn();

	// randomly choose game version
	String versionOfGame = HangmanGame.randomChooseVersion();
	// create Hangman instance
	Hangman hangman;
	if(versionOfGame.equals("traditional hangman")) {
	    hangman = new HangmanTraditional(wordList);
	}else {
	    hangman = new HangmanEvil(wordList);
	}

	// provide initial information
	System.out.println("Welcome to the game of Hangman!");
	System.out.println();

	// While the game is not over
	while (hangman.isGameOver() == false) {

	    // print correct game status
	    hangman.printHangman();

	    // have the user take a turn. 
	    hangman.haveUserTakeTurn();

	}

	// print final game information
	System.out.println("Congratulations, you have guessed the correct word \"" + hangman.theWord + "\"!");
	System.out.println();
	System.out.println("Version: " + versionOfGame);
	System.out.println("You total guesses: " + (hangman.correctGuess.size() + hangman.incorrectGuess.size()));
	System.out.println("You total mistakes: " + hangman.incorrectGuess.size());

	// close scanner
	Hangman.scanner.close();

    }


    /**
     * Determines which version of the game we're playing. 
     * @return true for normal false for evil Hangman. 
     */
    public static String randomChooseVersion() {

	// Import random. 
	Random random = new Random();
	// use the random boolean method in random to determine which version of the 
	// game the computer is going to play. 
	Boolean WhichVersion = random.nextBoolean();	

	// Return which version of the game we're playing. 
	if(WhichVersion) {
	    return "traditional hangman"; 
	}else {
	    return "evil hangman";
	}	
    }   

}

