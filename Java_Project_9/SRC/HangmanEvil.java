package hw9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Inherits all methods from the evil regular version of this game and creates the 
 * scenario where the computer keeps changing the word in order to make the user's 
 * task harder. 
 * @author kmabry (Kyle Mabry) and maianz (Maian Zhang)
 */
public class HangmanEvil extends Hangman{

    // map to store word families
    Map<String, List<String>> wordFamily =  new HashMap<String, List<String>>();

    /**
     * Constructor of the evil version of the Hangman game.
     * @param wordList
     */
    public HangmanEvil(List<String> wordList) {
	super(wordList);
    }

    /**
     * Update the word in each round.
     */
    @Override
    protected void updateTheWord() {

	// reset word family
	wordFamily.clear();

	// get iterator object from list 
	Iterator<String> it = this.wordList.iterator();

	// use the iterator while traversing the list
	while(it.hasNext()) {
	    // get the word in the word list
	    String word = it.next();

	    // this is the mark to record whether we should skip this round
	    boolean mark = false;

	    // check if the word has the same length as original word, skip this iteration if not
	    if(word.length() != this.theWord.length()) {
		continue;		
	    }

	    // this word should not contain any letter in incorrect guesses, skip this iteration if not
	    for(int i=0; i<this.incorrectGuess.size(); i++) {
		if(word.contains(this.incorrectGuess.get(i).toString())) {
		    mark = true;
		}
	    }

	    // this word should have the same correct guess position as before, skip this iteration if not
	    for(int i=0; i<this.theWord.length(); i++) {
		// capture the letter at ith position of the word
		char letter = this.theWord.charAt(i);
		// if this is a visible position
		if(this.correctGuess.contains(letter)) {
		    if(word.charAt(i) != letter) {
			mark = true;
		    }
		    // if this is not a visible position
		}else {
		    if(this.correctGuess.contains(word.charAt(i))) {
			mark = true;
		    }
		}
	    }

	    if(mark) {
		continue;
	    }

	    // find the pattern of the word
	    String pattern = word.replaceAll("[^" + this.userResponse + "]", "_");

	    if(!this.wordFamily.containsKey(pattern)) {
		// create new key if this pattern do not exist			
		List<String> family = new ArrayList<String>();;
		family.add(word);
		this.wordFamily.put(pattern, family);

	    }else {
		// add the word to the pattern key
		List<String> family = wordFamily.get(pattern);
		family.add(word);		
		this.wordFamily.put(pattern, family);
	    }	
	}

	// initialize max length and corresponding word
	int maxLength = 0;
	String evilWord = "";

	// loop through the keys of word family
	for (String key : wordFamily.keySet()) {

	    // update max length
	    if(wordFamily.get(key).size()>maxLength) {
		maxLength = wordFamily.get(key).size();
		evilWord = wordFamily.get(key).get(0);
	    }
	}

	// update the word
	this.theWord = evilWord;
    }

}

