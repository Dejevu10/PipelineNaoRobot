package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class WordMemory implements IWordMemory {

	private Map<String, String> wordList;

	private List<Word> words;

	@Override
	public void setWordList() {

		// For test
		this.addString("Master", "Murat Ugur Selcuk");
		this.addString("Owner", "Chair of Software Engineering in University of Mannheim");

		Map<String, String> mapList = this.wordList;

		this.words = new ArrayList<Word>();

		Set<String> keys = mapList.keySet();

		Iterator<String> iterator = keys.iterator();

		while (iterator.hasNext()) {
			String key = iterator.next();

			String value = mapList.get(key);

			Word word = new Word();

			word.setKey(key);
			word.setValue(value);

			words.add(word);

		}
	}

	public List<Word> getWords() {
		return this.words;
	}

	@Override
	public String getString(String key) {
		String value = (this.wordList.get(key) != null) ? this.wordList.get(key) : "Key is not known";
		return value;
	}

	@Override
	public boolean addString(String key, String value) {
		if (this.wordList == null) {
			this.wordList = new HashMap<String, String>();
		}

		this.wordList.put(key, value);

		return (this.wordList.get(key) != null);
	}

}
