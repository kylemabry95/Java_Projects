package hw9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Reads and parses the dictionary file, removes unacceptable words, and keeps track 
 * of the number of guesses and mistakes. The computer will need access to some of 
 * the methods in this class. 
 * @author kmabry (Kyle Mabry) and maianz (Maian Zhang)
 */
public class fileReader {

    // Instance variables.

    // We eventually want all of the words in the given dictionary to be stored to this string list
    // and in alphabetical order for convenience. 
    private List<String> wordList; 

    //The text file that we're using as the dictionary. 
    private File myFile; 

    /**
     * Constructor for DictionaryCleanup
     */
    public fileReader(String pathToFile) {

	this.myFile = new File(pathToFile);

	// Initialize this dictionary to be an array list of strings. 
	wordList = new ArrayList<String>();
    }


    /**
     * This method gets the file and reads in each line of the file. 
     * It also cleans up the dictionary by deleting any whitespace and eliminating illegal words.  
     * Uses BufferedReader and readLine until all lines have been read. 
     */
    public List<String> readFileIn() {

	// Create a new file reader and buffered reader and set it to null initially. (This will help if we 
	// get an error later on). 
	FileReader fileReader = null;
	try {
	    fileReader = new FileReader(this.myFile);
	} catch (FileNotFoundException e1) {
	    // Auto-generated catch block
	    e1.printStackTrace();
	}

	BufferedReader bufferedReader = new BufferedReader(fileReader);

	// create a string to hold each line that's read by the buffered reader. 
	String string; 
	// While there are still lines to be read.
	try {
	    while ((string = bufferedReader.readLine()) != null) {

		// remove any whitespace from before and after the "word". 
		String wordStripped = string.strip();			
		// if the word is clean (ie doesn't contain illegal characters)
		if (isWordClean(wordStripped)) {
		    // add it to the dictionary. 
		    wordList.add(wordStripped); 
		}
	    }
	} catch (IOException e) {
	    // Auto-generated catch block
	    e.printStackTrace();
	}

	try {
	    bufferedReader.close();
	} catch (IOException e) {
	    // Auto-generated catch block
	    e.printStackTrace();
	}

	return this.wordList;
    }

    /**
     * Determines if the input word is clean. Aka doesn't have upper case letters, abbreviations,
     * and apostrophe, a hyphen, compound words, or digits. 
     * @param word that we're checking
     * @return true if clean, false if not. 
     */
    public static boolean isWordClean(String word) {

	// Unacceptable characters for our word. If one or more is found reject the word. 
	String regexUnacceptable = "[A-Z0-9.'\\s-]+";

	// compile the regex and initialize matcher. 
	Pattern p = Pattern.compile(regexUnacceptable);
	Matcher m = p.matcher(word);

	// If we find any illegal characters return false. 
	return !m.find();
    }
}




