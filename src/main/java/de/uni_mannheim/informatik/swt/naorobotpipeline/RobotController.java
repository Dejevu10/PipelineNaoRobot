package de.uni_mannheim.informatik.swt.naorobotpipeline;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

@RestController
public class RobotController {

	String robot = "tcp://192.168.1.143:9559";

	Application app = new Application(new String[] {}, robot);

	Session session;

	@RequestMapping("/")
	public String getStr() {
		return "Hello";
	}

	@RequestMapping("/startRobot")
	public String startRobot() {
		app.start();
		session = app.session();

		try {
			ALTextToSpeech tty = new ALTextToSpeech(session);
			tty.say("I am available for you!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "<h1> Robot has started! </h1>";
	}
	
	@RequestMapping("/standUp")
	public String standUp() {
		app.start();
		session = app.session();
		try {
			ALMotion alm = new ALMotion(session);
			
			ALRobotPosture alp = new ALRobotPosture(session);
			
			alp.applyPosture("Sit", new Float(0));
			
			Thread.sleep(5000);
			
			alp.applyPosture("StandInit", new Float(0));
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "<h1> Robot stands </h1>";
	}

}
