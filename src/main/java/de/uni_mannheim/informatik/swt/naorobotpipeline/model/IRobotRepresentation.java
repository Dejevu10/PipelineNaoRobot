package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

/**
 * @author Selcuk, Murat Ugur This class is a general representation of a Nao Robot
 */
public interface IRobotRepresentation {

	/**
	 * this method lets the naorobot move
	 * 
	 * @param move -> enumeration to determine the direction of move
	 */

	public void naoMove(Movement move);

	/**
	 * this method lets nao talk
	 * 
	 * @param text -> this is the text which nao speaks
	 */

	public void naoTalk(String text);

	/**
	 * this method establishes the connection to nao
	 * 
	 * @param ip   -> ip from nao
	 * @param port -> port from nao default: 9559
	 */
	public void setConnection(String ip, String port);
}
