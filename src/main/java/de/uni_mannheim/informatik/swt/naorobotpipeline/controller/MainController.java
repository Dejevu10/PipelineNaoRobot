package de.uni_mannheim.informatik.swt.naorobotpipeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.uni_mannheim.informatik.swt.naorobotpipeline.model.IWordMemory;

/**
 * @author Selcuk, Murat Ugur This class to orchestrate all individual
 *         controllers within the application
 */

@Controller
public class MainController {

	@Autowired
	private RobotController robController;

	@Autowired
	WordController wordContr;

	/**
	 * It is the starting point after loggin.
	 * 
	 * @param model
	 * @return
	 */
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

	/**
	 * 
	 * @param naoIP   -> We have tested the 192.168.1.143 robot, therefore it is a
	 *                default value
	 * @param naoPort -> the standard port of 9559 according to Aldebaran if not
	 *                configured otherwise
	 * @param model   -> represents individual values
	 * @return
	 */
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String startRobot(
			@RequestParam(name = "naoIP", required = false, defaultValue = "192.168.1.143") String naoIP,
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

	/**
	 * the method to open the page manageWords
	 * 
	 * @return individual page with the memorized words
	 */
	@RequestMapping(value = "/manageWords", method = RequestMethod.GET)
	public ModelAndView getManageWords() {

		IWordMemory memory = wordContr.getMemory();

		return new ModelAndView("manageWords", "wordMemory", memory);

	}

	/**
	 * This method handles the new key-values which were added to Nao
	 * 
	 * @param key   -> The key which corresponds to the value and is safed in nao's
	 *              memory
	 * @param value -> The value which is safed in nao's memory with the key
	 * @return
	 */
	@RequestMapping(value = "/addNewWord", method = RequestMethod.POST)
	public ModelAndView addNewWord(@RequestParam(name = "key", required = true, defaultValue = "NoKey") String key,
			@RequestParam(name = "value", required = true, defaultValue = "NoValue") String value) {

		this.wordContr.addWord(key.trim(), value.trim());

		return this.getManageWords();
	}

	/**
	 * forwards to the robotcontroller to say value of textToSay
	 * 
	 * @param textToSay
	 * @return
	 */
	@RequestMapping(value = "/robotSaySomething", method = RequestMethod.POST, params = "speak")
	public ModelAndView robotSaySomething(
			@RequestParam(name = "value", required = false, defaultValue = "Murat") String textToSay) {

		robController.robotSaySomething(textToSay);

		return this.getManageWords();
	}

	/**
	 * forwards to the robotcontroller to delete
	 * 
	 * @param key
	 * @return
	 */

	@RequestMapping(value = "/robotSaySomething", method = RequestMethod.POST, params = "remove")
	public ModelAndView robotRemoveWord(
			@RequestParam(name = "key", required = false, defaultValue = "Murat") String key) {

		System.out.println(key);
		System.out.println(this.wordContr.removeString(key.trim()));

		return this.getManageWords();
	}

	/**
	 * This is the most sophisticated method for the nao to say something. It
	 * forwards textToSay to the robotcontoller
	 * 
	 * @param textToSay
	 * @return
	 */

	@RequestMapping(value = "/textToSay", method = RequestMethod.POST)
	public String robotTextToSay(
			@RequestParam(name = "naoText", required = true, defaultValue = "Nothing to say") String textToSay) {

		String resolvedText = wordContr.determineTextToSay(textToSay.trim());

		robController.robotSaySomething(resolvedText.trim());

		return "walkingNao";
	}
	
	
	/**
	 * it is only the method to open the view for textTeaching
	 * @return
	 */
	@RequestMapping(value = "/textTeaching", method = RequestMethod.GET)
	public String getTextTeaching() {
		return "textTeaching";
	}

}
