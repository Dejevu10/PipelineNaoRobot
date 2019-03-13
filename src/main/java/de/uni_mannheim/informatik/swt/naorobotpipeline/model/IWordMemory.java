package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

import java.util.List;

public interface IWordMemory {

	public void setWordList();

	public String getString(String key);

	public boolean addString(String key, String value);

	public List<Word> getWords();

}
