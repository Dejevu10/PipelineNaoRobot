package de.uni_mannheim.informatik.swt.naorobotpipeline.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String startRobot(
			@RequestParam(name = "naoIP", required = false, defaultValue = "192.168.1.143") String naoIP,
			@RequestParam(name = "naoPort", required = false, defaultValue = "9559") String naoPort, Model model) {

		model.addAttribute("naoIP", naoIP);
		model.addAttribute("naoPort", naoPort);

		rob.setConnection(naoIP, naoPort);

		return "naomainpage";
	}

	@RequestMapping(value = "/actions", method = RequestMethod.GET)
	public String mainPage(
			@RequestParam(name = "naoIP", required = false, defaultValue = "192.168.1.143") String naoIP,
			@RequestParam(name = "naoPort", required = false, defaultValue = "9559") String naoPort, Model model) {

		return "naomainpage";
	}

	@RequestMapping(value = "/manageWords", method = RequestMethod.GET)
	public String getManageWords() {

		return "manageWords";
	}

	@RequestMapping(value = "/robotSaySomething", method = RequestMethod.POST)
	public String robotSaySomething(
			@RequestParam(name = "value", required = false, defaultValue = "Murat") String wordToSay) {
		rob.saySomething(wordToSay);
		return "manageWords";
	}

	@RequestMapping(value = "/textTeaching", method = RequestMethod.GET)
	public String getTextTeaching() {
		return "textTeaching";
	}

}
