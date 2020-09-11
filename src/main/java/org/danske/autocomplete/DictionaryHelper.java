package org.danske.autocomplete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class DictionaryHelper {

	public static List<String> searchInDictionary(
			HashMap<Integer, List<Character>> keyboardMap,
			List<String> dictionary,
			List<String> enteredStrings) throws Exception {
		
		List<Character> wordChars = new ArrayList<>();
		
		List<String> words = new ArrayList<>();
		
		
		for(String enteredString : enteredStrings) {
			char[] enteredChars = enteredString.toCharArray();
			List<Integer> enterDigits = retrieveEnteredDigits(enteredChars);
			isAllDigitsEquals(enterDigits);
			List<Character> foundChars = retrieveFoundChars(keyboardMap, enterDigits);
			Character wordCharacter = retrieveWordChar(enterDigits, foundChars);
			wordChars.add(wordCharacter);
		}
		
		words = selectWords(dictionary, wordChars);
		
		return words;
	}
	
	
	private static Character retrieveWordChar(
			List<Integer> enteredDigits, 
			List<Character> foundChars) throws Exception {
		
		if(foundChars.size()<enteredDigits.size()) 
			throw new Exception("The number of digits entered in " 
					+ enteredDigits.toString() + " exceeds number of character available in " 
					+ foundChars.toString());
		
		return foundChars.get(enteredDigits.size()-1);
	}


	private static List<Integer> retrieveEnteredDigits(char[] enteredChars) throws Exception {
		List<Integer> digits = new ArrayList<>();
		
		for(char enteredChar : enteredChars) {
			if (Character.isDigit(enteredChar)) {
				Integer enteredInt = Character.getNumericValue(enteredChar);
				digits.add(enteredInt);
			} else {
				throw new Exception("Entered character '" + enteredChar + "' is not digit");
			}
			
		}
		
		return digits;
	}
	
	
	private static List<Character> retrieveFoundChars(
			HashMap<Integer, List<Character>> keyboardMap,
			List<Integer> enterDigits
			) {
		List<Character> foundChars = keyboardMap.entrySet().stream()
				.filter(entry -> entry.getKey().equals(enterDigits.get(0)))
		        .map(entry -> entry.getValue())
		        .flatMap(List::stream) 
		        .collect(Collectors.toList());
		
		return foundChars;
	}
	
	private static void isAllDigitsEquals(List<Integer> foundChars) throws Exception {
		
		for(Integer character : foundChars) {
			if(!character.equals(foundChars.get(0))) {
				throw new Exception("The digits are not equal in " + foundChars.toString());
			}
		}
		
	}
	
	private static List<String> selectWords(
			List<String> dictionary, 
			List<Character> wordChars) {
		List<String> selectedWords = dictionary.stream()
				  .collect(Collectors.toList());;
		
		for(int i=0; i<wordChars.size(); i++) {
			
			for(String dictionaryItem : dictionary) {
				if(!Character.valueOf(dictionaryItem.charAt(i)).equals(wordChars.get(i))) {
					selectedWords.remove(dictionaryItem);
				}
			}
		}

		return selectedWords;
	}
	
}
