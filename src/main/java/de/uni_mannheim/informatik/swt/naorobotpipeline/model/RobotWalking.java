package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;

public class RobotWalking implements IRobotWalking {

	@Override
	public void moveForward(Float way, Session session) {

		try {
			ALMotion robotMove = new ALMotion(session);

			robotMove.setStiffnesses("Body", new Float(1.0));

			this.standInit(session);

			robotMove.setMoveArmsEnabled(true, true);

			Float x = way;
			Float y = new Float(0.0);
			Float theta = new Float(0.0);
			Float speed = new Float(0.5);

			robotMove.setWalkTargetVelocity(x, y, theta, speed);

			this.stopWalking(3000, session);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void moveBackward(Float way, Session session) {

		try {
			ALMotion robotMove = new ALMotion(session);

			robotMove.setStiffnesses("Body", new Float(1.0));

			this.standInit(session);

			robotMove.setMoveArmsEnabled(true, true);

			Float x = way;
			Float y = new Float(0.0);
			Float theta = new Float(0.0);
			Float speed = new Float(0.5);

			robotMove.setWalkTargetVelocity(x, y, theta, speed);

			this.stopWalking(3000, session);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void moveRight(Float way, Session session) {

		try {
			ALMotion robotMove = new ALMotion(session);

			robotMove.setStiffnesses("Body", new Float(1.0));

			this.standInit(session);

			robotMove.setMoveArmsEnabled(true, true);

			Float x = new Float(0.0);
			Float y = way;
			Float theta = new Float(0.0);
			Float speed = new Float(0.5);

			robotMove.setWalkTargetVelocity(x, y, theta, speed);

			this.stopWalking(3000, session);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void moveLeft(Float way, Session session) {

		try {
			ALMotion robotMove = new ALMotion(session);

			robotMove.setStiffnesses("Body", new Float(1.0));

			this.standInit(session);

			robotMove.setMoveArmsEnabled(true, true);

			Float x = new Float(0.0);
			Float y = way;
			Float theta = new Float(0.0);
			Float speed = new Float(0.5);

			robotMove.setWalkTargetVelocity(x, y, theta, speed);

			this.stopWalking(3000, session);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void turnRight(Float way, Session session) {

		try {
			ALMotion robotMove = new ALMotion(session);

			robotMove.setStiffnesses("Body", new Float(1.0));

			this.standInit(session);

			robotMove.setMoveArmsEnabled(true, true);

			Float x = new Float(0.1);
			Float y = new Float(0.5);
			Float theta = new Float(-0.9);
			Float speed = new Float(0.5);

			robotMove.setWalkTargetVelocity(x, y, theta, speed);

			this.stopWalking(4500, session);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void turnLeft(Float way, Session session) {
		// TODO Auto-generated method stub

	}

	private void standInit(Session session) {

		try {
			ALRobotPosture alPosture = new ALRobotPosture(session);

			alPosture.goToPosture("StandInit", new Float(0.5));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void stopWalking(long sleeptime, Session session) {
		try {
			Thread.sleep(sleeptime);
			ALMotion robotMove = new ALMotion(session);

			Float x = new Float(0.0);
			Float y = new Float(0.0);
			Float theta = new Float(0.0);
			Float speed = new Float(0.0);

			robotMove.setWalkTargetVelocity(x, y, theta, speed);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
