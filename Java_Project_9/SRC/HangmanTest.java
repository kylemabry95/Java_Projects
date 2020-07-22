package hw9;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class HangmanTest {
	
	Hangman hangman;
	
	@BeforeEach
	void setUp() throws Exception {
		
		fileReader myReader = new fileReader("src/hw9/words_clean.txt");
		
		List<String> wordList = myReader.readFileIn();
		
		hangman = new HangmanTraditional(wordList);
	}

	@Test
	void testRandomChooseWord() {
		
		// since it's a random method, just repeat test
		assertTrue(hangman.wordList.contains(hangman.randomChooseWord()));
		
		assertTrue(hangman.wordList.contains(hangman.randomChooseWord()));
		
		assertTrue(hangman.wordList.contains(hangman.randomChooseWord()));
		
	}

	@Test
	void testIsGameOver() {
		
		assertFalse(hangman.isGameOver());
		
		hangman.correctGuess.add("x".charAt(0));
		assertFalse(hangman.isGameOver());
		
		for(int i=0; i<hangman.theWord.length(); i++) {
			hangman.correctGuess.add(hangman.theWord.charAt(i));
		}
		assertTrue(hangman.isGameOver());
		
		hangman.correctGuess.remove(1);	
		assertFalse(hangman.isGameOver());
	}


}
