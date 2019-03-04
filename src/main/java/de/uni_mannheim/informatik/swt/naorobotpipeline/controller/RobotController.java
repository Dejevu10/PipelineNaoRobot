package de.uni_mannheim.informatik.swt.naorobotpipeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.uni_mannheim.informatik.swt.naorobotpipeline.model.RobotRepresentation;

@Controller
public class RobotController {

	@Autowired
	private RobotRepresentation rob;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage(Model model) {

		String message = "Hello, you can connect to me!";

		model.addAttribute("connection", message);

		return "index";
	}

	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String startRobot(@RequestParam(name = "naoIP", required = false, defaultValue = "192.168.1.1") String naoIP,
			@RequestParam(name = "naoPort", required = false, defaultValue = "5997") int naoPort, Model model) {
		model.addAttribute("naoIP", naoIP);
		model.addAttribute("naoPort", naoPort);

		return "test.html";
	}

	@RequestMapping(value = "/standUp", method = RequestMethod.GET)
	public String standUp() {
		rob.standUp();
		return "<h1> Robot stands </h1>";
	}

}
