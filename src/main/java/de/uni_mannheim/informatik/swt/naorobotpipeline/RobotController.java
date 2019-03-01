package de.uni_mannheim.informatik.swt.naorobotpipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RobotController {

	@Autowired
	private RobotRepresentation rob;

	@GetMapping("/")
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
