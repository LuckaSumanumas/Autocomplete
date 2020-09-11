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
		
		List<String> words = new ArrayList<>();
		
		//enteredChars.stream().filter(predicate)
		
		for(String enteredString : enteredStrings) {
			
			char[] enteredChars = enteredString.toCharArray();
			List<Integer> integers = retrieveEnteredIntegers(enteredChars);
			
			List<Character> foundMap = keyboardMap.entrySet().stream()
					.filter(entry -> entry.getKey().equals(integers.get(0)))
			        .map(entry -> entry.getValue())
			        .flatMap(List::stream) 
			        .collect(Collectors.toList());
			
			System.out.println("Entered chars: " + foundMap.toString());
		}
		
		
		return words;
	}
	
	
	private static List<Integer> retrieveEnteredIntegers(char[] enteredChars) throws Exception {
		List<Integer> integers = new ArrayList<>();
		
		for(char enteredChar : enteredChars) {
			if (Character.isDigit(enteredChar)) {
				Integer enteredInt = Character.getNumericValue(enteredChar);
				integers.add(enteredInt);
			} else {
				throw new Exception("Entered character '" + enteredChar + "' is not digit");
			}
			
		}
		
		return integers;
	}
}
