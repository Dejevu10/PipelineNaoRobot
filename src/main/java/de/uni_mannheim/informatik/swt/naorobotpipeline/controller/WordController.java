package de.uni_mannheim.informatik.swt.naorobotpipeline.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.uni_mannheim.informatik.swt.naorobotpipeline.model.IWordMemory;

@Controller
public class WordController {

	@Autowired
	private IWordMemory wordMemory;

	public void addWord(String key, String value) {
		wordMemory.addString(key, value);
	}

	public IWordMemory getMemory() {
		wordMemory.setWordList();

		return this.wordMemory;
	}

	public boolean removeString(String key) {
//		try {

//			WordMemoryException.emptyKey(key);
//			WordMemoryException.badKey(key);

		return this.wordMemory.removeString(key);
//		} catch (WordMemoryException e) {
//			e.printStackTrace();
//		}

//		return false;
	}

	public String determineTextToSay(String textToSay) {

		// First split array into parts
		String[] words = textToSay.split(" ");

		System.out.println(words[0]);

		ArrayList<String> values;

		// Find matching keys with '$' & return values
		values = getValuesForKeys(words);

		return buildStringTogether(words, values);
	}

	private String buildStringTogether(String[] initialText, ArrayList<String> values) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < initialText.length; i++) {

			if (initialText[i].charAt(0) == '$') {
				// Replace key for value
				initialText[i] = values.get(0);

				// remove key
				values.remove(0);
			}
			// build string step by step together
			sb.append(initialText[i] + " ");
		}

		return sb.toString();
	}

	// toDo
	private String askMemoryTheWord(String key) {

		String value = this.wordMemory.getString(key);
		return value;
	}

	private ArrayList<String> getValuesForKeys(String[] words) {

		ArrayList<String> keys = new ArrayList<String>();

		// find keys
//		try {
		for (int i = 0; i < words.length; i++) {
			if (words[i].charAt(0) == '$') {

//					WordMemoryException.emptyKey(words[i]);
//					WordMemoryException.badKey(words[i]);

//				if (key.matches("$+\\w*(\\W)+\\w*")) {
//					throw new WordMemoryException();
//				}

				String key = words[i].substring(1);
				keys.add(key);
			}
		}

		ArrayList<String> values = new ArrayList<String>();

		Iterator<String> it = keys.iterator();

		// Get the values for keys
		// To do -> If not match, return exception
		while (it.hasNext()) {
			String key = it.next();

			String value = askMemoryTheWord(key);

			values.add(value);
		}
		return values;
//		} catch (WordMemoryException e) {
//			e.printStackTrace();
//		}
//
//		return keys;
	}

}
