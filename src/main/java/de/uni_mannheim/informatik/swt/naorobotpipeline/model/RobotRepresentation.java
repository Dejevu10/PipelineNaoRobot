package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

import org.springframework.stereotype.Component;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

@Component
public class RobotRepresentation {

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

	public void saySomething(String say) {

		try {
			ALTextToSpeech tty = new ALTextToSpeech(session);
			tty.say(say);
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

}
