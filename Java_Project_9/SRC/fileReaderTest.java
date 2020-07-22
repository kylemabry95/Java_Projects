package hw9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class fileReaderTest {

	@BeforeEach
	void setUp() throws Exception {
	}


	@Test
	void testIsWordClean() {
		
		String string = "Zambia";
		assertFalse(fileReader.isWordClean(string));
		
		string = "mrs.";
		assertFalse(fileReader.isWordClean(string));
		
		string = "you're";
		assertFalse(fileReader.isWordClean(string));
		
		string = "mother-in-law";
		assertFalse(fileReader.isWordClean(string));
		
		string = "post office";
		assertFalse(fileReader.isWordClean(string));
		
		string = "2nd";
		assertFalse(fileReader.isWordClean(string));
		
		string = "happy";
		assertTrue(fileReader.isWordClean(string));
		
		
	}

}
