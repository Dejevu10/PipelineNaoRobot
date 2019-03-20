package de.uni_mannheim.informatik.swt.naorobotpipeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.uni_mannheim.informatik.swt.naorobotpipeline.model.IWordMemory;

@Controller
public class MainController {

	@Autowired
	private RobotControllerTest robController;

	@Autowired
	WordController wordContr;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage(Model model) {

		String message = "Hello, you can connect to me!";

		model.addAttribute("connection", message);

		return "index";
	}

//--------------------------Robotcontroller part-----------------------------------

	@RequestMapping(value = "/walkingNao", method = RequestMethod.GET)
	public String walkingNao() {
		return "walkingNao";
	}

	@RequestMapping(value = "/letNaoWalkF", method = RequestMethod.GET)
	public String letNaoWalkF() {

		return robController.letNaoWalkF();
	}

	@RequestMapping(value = "/letNaoWalkB", method = RequestMethod.GET)
	public String letNaoWalkB() {

		return robController.letNaoWalkB();
	}

	@RequestMapping(value = "/letNaoWalkL", method = RequestMethod.GET)
	public String letNaoWalkL() {

		return robController.letNaoWalkL();
	}

	@RequestMapping(value = "/letNaoWalkR", method = RequestMethod.GET)
	public String letNaoWalkR() {

		return robController.letNaoWalkR();
	}

	@RequestMapping(value = "/letNaoTurnRight", method = RequestMethod.GET)
	public String letNaoTurnRight() {

		return robController.letNaoTurnRight();
	}

	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String startRobot(@RequestParam(name = "naoIP", required = false, defaultValue = "nao.local") String naoIP,
			@RequestParam(name = "naoPort", required = false, defaultValue = "9559") String naoPort, Model model) {

		model.addAttribute("naoIP", naoIP);
		model.addAttribute("naoPort", naoPort);

		return robController.startRobot(naoIP, naoPort);
	}

	@RequestMapping(value = "/actions", method = RequestMethod.GET)
	public String mainPage(@RequestParam(name = "naoIP", required = false, defaultValue = "192.168.1.143") String naoIP,
			@RequestParam(name = "naoPort", required = false, defaultValue = "9559") String naoPort, Model model) {

		return "naomainpage";
	}

	// ------------------------ WordContoller------------------------
	@RequestMapping(value = "/manageWords", method = RequestMethod.GET)
	public ModelAndView getManageWords() {

		IWordMemory memory = wordContr.getMemory();

		return new ModelAndView("manageWords", "wordMemory", memory);

	}

	@RequestMapping(value = "/addNewWord", method = RequestMethod.POST)
	public ModelAndView addNewWord(@RequestParam(name = "key", required = true, defaultValue = "NoKey") String key,
			@RequestParam(name = "value", required = true, defaultValue = "NoValue") String value) {

		this.wordContr.addWord(key.trim(), value.trim());

		return this.getManageWords();
	}

	@RequestMapping(value = "/robotSaySomething", method = RequestMethod.POST, params = "speak")
	public ModelAndView robotSaySomething(
			@RequestParam(name = "value", required = false, defaultValue = "Murat") String textToSay) {

		robController.robotSaySomething(textToSay);

		return this.getManageWords();
	}

	@RequestMapping(value = "/robotSaySomething", method = RequestMethod.POST, params = "remove")
	public ModelAndView robotRemoveWord(
			@RequestParam(name = "key", required = false, defaultValue = "Murat") String key) {

		System.out.println(key);
		System.out.println(this.wordContr.removeString(key.trim()));

		return this.getManageWords();
	}

	@RequestMapping(value = "/textToSay", method = RequestMethod.POST)
	public String robotTextToSay(
			@RequestParam(name = "naoText", required = true, defaultValue = "Nothing to say") String textToSay) {

		String resolvedText = wordContr.determineTextToSay(textToSay.trim());

		System.out.println(resolvedText.trim());

		robController.robotSaySomething(resolvedText.trim());

		return "walkingNao";
	}

	@RequestMapping(value = "/textTeaching", method = RequestMethod.GET)
	public String getTextTeaching() {
		return "textTeaching";
	}

}