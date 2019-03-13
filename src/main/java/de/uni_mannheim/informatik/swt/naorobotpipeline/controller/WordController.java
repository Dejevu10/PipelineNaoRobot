package de.uni_mannheim.informatik.swt.naorobotpipeline.controller;

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

}
