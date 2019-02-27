package de.uni_mannheim.informatik.swt.naorobotpipeline;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.Session;


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
		RobotRepresentation rob = new RobotRepresentation();

		rob.sayHello();

		return "<h1> Robot has started! </h1>";
	}

	@RequestMapping("/standUp")
	public String standUp() {

		RobotRepresentation rob = new RobotRepresentation();

		rob.standUp();
		return "<h1> Robot stands </h1>";
	}

}
