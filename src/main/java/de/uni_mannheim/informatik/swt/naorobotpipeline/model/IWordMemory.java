package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

import java.util.List;

public interface IWordMemory {

	/**
	 * Sets the key value as a list to be iterable
	 */
	public void setWordList();

	/**
	 * determines the value for a given key
	 * 
	 * @param key
	 * @return returns the value as a string
	 */
	public String getString(String key);

	/**
	 * this method adds new words to the memory of nao
	 * 
	 * @param key
	 * @param value
	 * @return
	 */

	public boolean addString(String key, String value);

	/**
	 * this method removes a word for a given key
	 * 
	 * @param key
	 * @return
	 */
	public boolean removeString(String key);

	/**
	 * returns all memorized words as a lists
	 * 
	 * @return
	 */
	public List<Word> getWords();

}
