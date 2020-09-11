package org.danske.autocomplete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class AutocompleteTest {
	
	KeyboardMap keyboardMap;
	
	@Before
	public void init() {
		keyboardMap = new KeyboardMap();
	}
	
	@Test
	public void autocompleteSuccessTest() throws Exception {
		
		List<String> enteredString = new ArrayList<>();
		String[] eneteredChars = {"555","2","222"};
		enteredString.addAll(Arrays.asList(eneteredChars));
		
		List<String> words = DictionaryHelper.searchInDictionary(
				keyboardMap.getMap(), keyboardMap.getDictionary(), enteredString);
		
		Assert.assertEquals(words.get(0), "labas");
	}
}
