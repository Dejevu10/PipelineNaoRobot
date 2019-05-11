package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

/**
 * @author Selcuk, Murat Ugur This class is a representation of a singe key-pair value
 */
public class Word {

	private String key;

	private String value;

	public void setKey(String key) {
		this.key = key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getKey() {
		return this.key;
	}

	public String getValue() {
		return this.value;
	}
}
