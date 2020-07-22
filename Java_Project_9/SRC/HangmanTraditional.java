package hw9;

import java.util.List;

/**
 * This is the version of tradition Hangman game
 * @author kmabry (Kyle Mabry) and maianz (Maian Zhang)
 *
 */
public class HangmanTraditional extends Hangman{

    /**
     * constructor for the tradition Hangman
     * @param wordList list of clean words
     */
    public HangmanTraditional(List<String> wordList) {
	super(wordList);
    }

    /**
     * update the word in each round (keep the same for this version)
     */
    @Override
    public void updateTheWord() {

    }

}

