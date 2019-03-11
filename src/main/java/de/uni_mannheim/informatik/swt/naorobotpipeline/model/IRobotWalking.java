package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

public interface IRobotWalking {

	public void moveForward(Float way);

	public void moveBackward(Float way);

	public void moveRight(Float way);

	public void moveLeft(Float way);

	public void turnRight(Float way);

	public void turnLeft(Float way);
}
