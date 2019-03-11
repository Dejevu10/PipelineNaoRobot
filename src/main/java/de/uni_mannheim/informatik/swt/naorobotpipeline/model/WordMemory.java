package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class WordMemory implements IWordMemory {

	private Map<String, String> wordList;

	@Override
	public Map<String, String> getWordList() {

		return this.wordList;
	}

	@Override
	public String getString(String key) {
		String value = (this.wordList.get(key) != null) ? this.wordList.get(key) : "Key is not known";
		return value;
	}

	@Override
	public boolean addString(String key, String value) {
		this.wordList.put(key, value);

		return (this.wordList.get(key) != null);
	}

}
