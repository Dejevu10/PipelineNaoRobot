package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

import org.springframework.stereotype.Component;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

@Component
public class RobotRepresentation implements IRobotRepresentation {

	private Application app;

	private Session session;

	private RobotRepresentation() {

	}

	public void setConnection(String ip, String port) {

		String robot = "tcp://" + ip + ":" + port;

		app = new Application(new String[] {}, robot);

		app.start();

		session = app.session();
		sayHello();

	}

	private void sayHello() {

		try {
			ALTextToSpeech tty = new ALTextToSpeech(session);
			tty.say("I am available for you!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void standUp() {

		Session session = app.session();

		try {
//			ALMotion alm = new ALMotion(session);

			ALRobotPosture alp = new ALRobotPosture(session);

			alp.applyPosture("Sit", new Float(0));

			Thread.sleep(5000);

			alp.applyPosture("StandInit", new Float(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
			session = null;
		}
	}

	public boolean checkConnection() {

		app.start();

		Session session = app.session();

		boolean connected = false;
		try {

			session = app.session();
		} catch (Exception e) {
			connected = session.isConnected();
		} finally {
			session.close();
			session = null;
		}
		return connected;
	}

	@Override
	public void naoMove(Movement move) {
		IRobotWalking robotWalk = new RobotWalking();

		Float xWalk = new Float(0.5);

		Float yWalk = new Float(0.5);

		if (move == Movement.FORWARD) {
			robotWalk.moveForward(xWalk, session);
		} else if (move == Movement.BACKWARD) {
			robotWalk.moveBackward(-xWalk, session);
		} else if (move == Movement.LEFT) {
			robotWalk.moveLeft(yWalk, session);
		} else if (move == Movement.RIGHT) {
			robotWalk.moveRight(-yWalk, session);
		}else if (move == Movement.TURNRIGHT) {
			robotWalk.turnRight(xWalk, session);
		}

	}

	@Override
	public void naoTalk(String text) {
		IRobotTalking robotTalk = new RobotTalking();

		robotTalk.sayText(text, this.session);

	}

}
