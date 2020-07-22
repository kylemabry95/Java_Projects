package hw9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Handles all aspects of the Hangman game. Evil Hangman and traditional Hangman will extend this class. 
 * The computer will decide if the user is correct with their guess or not. 
 * @author kmabry (Kyle Mabry) and maianz (Maian Zhang)
 *
 */
public abstract class Hangman {

    //Instance variables

    // Store all of the correct guesses.
    protected List<Character> correctGuess = new ArrayList<>();

    // Store all of the correct guesses.
    protected List<Character> incorrectGuess = new ArrayList<>();

    // The word that the computer chose from the word list as a string. 
    protected String theWord;

    // list to store all clean words
    protected List<String> wordList;

    // running update of user response for each round
    protected String userResponse;

    // create global scanner instance
    public static Scanner scanner = new Scanner(System.in);


    /**
     * Constructor for Hangman.
     */
    public Hangman(List<String> wordList) {

	// initialize text word list
	this.wordList = wordList;
	// have the computer choose a word for the game. 
	this.theWord = randomChooseWord();

    }


    /**
     * This method is what the computer uses to choose the word that the player will have to guess. 
     * @return a single word, as a string that the computer will use for the game. 
     */
    public String randomChooseWord() {

	// Initialize random. 
	Random random = new Random(); 
	// Get the length of the word list. 
	int lengthOfwordList = this.wordList.size();
	// choose a random integer within the range of the word list to index the word that we want. 
	int whichIndexOfwordList = random.nextInt(lengthOfwordList);
	// update the game word. 
	return this.wordList.get(whichIndexOfwordList);

    }


    /**
     * Has the user take a turn aka. guess a letter or the word. 
     * Updates the number of incorrect guesses the user has taken so far. 
     */
    public void haveUserTakeTurn() {

	while (true) {	    
	    // get user input
	    System.out.print("Please guess a letter: ");

	    // capture user input
	    this.userResponse = scanner.next();

	    // check user input
	    this.updateTheWord();

	    // convert string to char, take first char by default
	    char userResponseChar = userResponse.charAt(0);

	    // check whether the user's guess is repeated
	    if(!this.correctGuess.contains(userResponseChar) && !this.incorrectGuess.contains(userResponseChar)) {		    	
		// update guess history
		if(this.theWord.contains(userResponse)) {
		    this.correctGuess.add(userResponseChar);
		}else {
		    this.incorrectGuess.add(userResponseChar);
		}				
		// break the loop if guess is not repeated
		break;
	    }else {
		System.out.println("The letter \"" + userResponseChar + "\" has already been guessed, "
			+ "please try another letter.");
		System.out.println();
	    }   	    
	}	
    }


    /**
     * This method print out the current game status and list of wrong guess
     */
    public void printHangman() {

	// print current game status
	for (int i = 0; i < this.theWord.length(); i++) {
	    // display character that has been guessed
	    if(this.correctGuess.contains(this.theWord.charAt(i))) {   			
		System.out.print(" " + this.theWord.charAt(i) + " ");    			
	    }
	    // display character that hasn't been guessed
	    else {
		System.out.print(" _ ");
	    }
	}
	System.out.println();

	// print wrong guess list
	System.out.println("Incorrect Guess: " + this.incorrectGuess);
	System.out.println();

    }

    /**
     * Decide whether the game is over.
     * @return true if game is over otherwise false.
     */
    public boolean isGameOver() {

	// iterate through each character in the word
	for (int i = 0; i < this.theWord.length(); i++) {
	    // return false if at least one character has not been guessed
	    if(!this.correctGuess.contains(this.theWord.charAt(i))) {    			
		return false;    			
	    } 		
	}
	// return true if all characters have been guessed correctly
	return true;
    }

    /**
     * This method update the word in each round
     */
    protected abstract void updateTheWord();

}






