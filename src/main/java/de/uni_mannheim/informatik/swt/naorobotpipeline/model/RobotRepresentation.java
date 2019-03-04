package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

import org.springframework.stereotype.Service;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

@Service
public class RobotRepresentation {

	private String robot = "tcp://192.168.1.143:9559";

	private Application app = new Application(new String[] {}, robot);

	private Session session;

	public void sayHello() {

		app.start();
		session = app.session();

		try {
			ALTextToSpeech tty = new ALTextToSpeech(session);
			tty.say("I am available for you!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session = null;
		}
	}

	public void standUp() {

		app.start();
		session = app.session();
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
			session = null;
		}
	}

	public boolean checkConnection() {
		try {
			app.start();
			session = app.session();
		} catch (Exception e) {

		}
		return session.isConnected();
	}

}
