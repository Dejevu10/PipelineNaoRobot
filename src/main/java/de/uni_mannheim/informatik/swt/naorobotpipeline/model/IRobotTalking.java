package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

import com.aldebaran.qi.Session;

/**
 * @author Selcuk, Murat Ugur
 * This class represents the ability to talk for nao robot
 */

public interface IRobotTalking {

	/**
	 * 
	 * @param text    -> the text nao should say
	 * @param session -> the session in which nao is
	 */
	public void sayText(String text, Session session);
}
