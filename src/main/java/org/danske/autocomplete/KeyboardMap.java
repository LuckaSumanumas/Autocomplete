package org.danske.autocomplete;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class KeyboardMap {

	HashMap<Integer, List<Character>> map; 
	List<String> dictionary;
	
	public KeyboardMap() {
		map = constructKeyboardMap();
		dictionary = constructDictionary();
	}
	
	private HashMap<Integer, List<Character>> constructKeyboardMap() {
		HashMap<Integer, List<Character>> map = new HashMap<>(); 
		
		Character list1[] = {};
		Character list2[] = {'a', 'ą', 'b', 'c', 'č'};
		Character list3[] = {'d', 'e', 'ę', 'ė', 'f'};
		Character list4[] = {'g', 'h', 'i', 'į'};
		Character list5[] = {'j', 'k', 'l'};
		Character list6[] = {'m', 'n', 'o'};
		Character list7[] = {'p', 'q', 'r', 's', 'š'};
		Character list8[] = {'t', 'u', 'ų', 'ū', 'v'};
		Character list9[] = {'w', 'x', 'y', 'z', 'ž'};
		Character list0[] = {};
		
		
		map.put(1, Arrays.asList(list1));
		map.put(2, Arrays.asList(list2));
		map.put(3, Arrays.asList(list3));
		map.put(4, Arrays.asList(list4));
		map.put(5, Arrays.asList(list5));
		map.put(6, Arrays.asList(list6));
		map.put(7, Arrays.asList(list7));
		map.put(8, Arrays.asList(list8));
		map.put(9, Arrays.asList(list9));
		map.put(0, Arrays.asList(list0));
		
		return map;
		
	}
	
	private List<String> constructDictionary() {
		String[] dictionary = {
				"labas", 
				"rytas", 
				"kaip", 
				"sekasi", 
				"nieko", 
				"visai", 
				"labai", 
				"gerai", 
				"ačiū", 
				"viso"};
		
		return Arrays.asList(dictionary);
	}
	
	public HashMap<Integer, List<Character>> getMap() {
		return map;
	}

	public List<String> getDictionary() {
		return dictionary;
	}
}
