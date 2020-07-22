package hw9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HangmanGameTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testRandomChooseVersion() {
		
		// this is a random method so just test for several times
		String version = HangmanGame.randomChooseVersion();
		
		assertTrue(version.equals("traditional hangman") || version.equals("evil hangman"));
		
		assertTrue(version.equals("traditional hangman") || version.equals("evil hangman"));
		
		assertTrue(version.equals("traditional hangman") || version.equals("evil hangman"));
		
	}

}
