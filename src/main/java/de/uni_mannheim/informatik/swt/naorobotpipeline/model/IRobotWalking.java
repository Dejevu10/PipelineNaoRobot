package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

import com.aldebaran.qi.Session;

/**
 * @author Selcuk, Murat Ugur
 * This class represents the ability to move for nao
 */

public interface IRobotWalking {

	/**
	 * All these methods are necessary to let the connected nao move
	 * 
	 * @param way
	 * @param session
	 */

	public void moveForward(Float way, Session session);

	public void moveBackward(Float way, Session session);

	public void moveRight(Float way, Session session);

	public void moveLeft(Float way, Session session);

	public void turnRight(Float way, Session session);

	public void turnLeft(Float way, Session session);
}
