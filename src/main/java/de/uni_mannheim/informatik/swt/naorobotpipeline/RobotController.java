package de.uni_mannheim.informatik.swt.naorobotpipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController {

	@Autowired
	private RobotRepresentation rob;

	@RequestMapping("/")
	public String getStr() {
		return "Hello";
	}

	@RequestMapping("/startRobot")
	public String startRobot() {

		rob.sayHello();

		return "<h1> Robot has started! </h1>";
	}

	@RequestMapping("/standUp")
	public String standUp() {

		rob.standUp();
		return "<h1> Robot stands </h1>";
	}

}
