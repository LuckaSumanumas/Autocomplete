package org.danske.autocomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	KeyboardMap keyboardMap = new KeyboardMap();
    	String line;

    	System.out.println(String.format("Enter digits to search words:"));
    	
    	try {
			while((line = br.readLine()) != null) {
			    String[] digits = line.split(",");
			    List<String> enteredChars = new ArrayList<>();
			    
			    enteredChars.addAll(Arrays.asList(digits));
			    System.out.println(String.format("The input is: %s", line));
			    
			    try {
			    	List<String> words = DictionaryHelper.searchInDictionary(
				    		keyboardMap.getMap(), 
				    		keyboardMap.getDictionary(), 
				    		enteredChars);
			    	System.out.println(String.format("The output is: %s", words.toString()));
			    } catch (Exception e) {
					System.out.println(e.getMessage());
				}
			    
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
    	
    }
}
