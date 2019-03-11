package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

import java.util.Map;

public interface IWordMemory {

	public Map<String, String> getWordList();

	public String getString(String key);

	public boolean addString(String key, String value);

}
