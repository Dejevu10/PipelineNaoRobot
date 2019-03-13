package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

import com.aldebaran.qi.Session;

public interface IRobotWalking {

	public void moveForward(Float way, Session session);

	public void moveBackward(Float way, Session session);

	public void moveRight(Float way, Session session);

	public void moveLeft(Float way, Session session);

	public void turnRight(Float way, Session session);

	public void turnLeft(Float way, Session session);
}
