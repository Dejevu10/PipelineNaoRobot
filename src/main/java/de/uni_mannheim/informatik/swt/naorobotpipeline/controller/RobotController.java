package de.uni_mannheim.informatik.swt.naorobotpipeline.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import de.uni_mannheim.informatik.swt.naorobotpipeline.model.Movement;
import de.uni_mannheim.informatik.swt.naorobotpipeline.model.RobotRepresentation;

/**
 * @author Selcuk, Murat Ugur
 * This class is the representation to control the roboters functionality.
 */

@Service
public class RobotController {

	@Autowired
	private RobotRepresentation rob;

	/**
	 * The nao moves forward
	 * @return Parameter which determines the wepbage as a HTTP response
	 */
	public String letNaoWalkF() {

		rob.naoMove(Movement.FORWARD);

		return "walkingNao";
	}

	/**
	 * The nao moves backward
	 * @return Parameter which determines the wepbage as a HTTP response
	 */
	
	public String letNaoWalkB() {

		rob.naoMove(Movement.BACKWARD);

		return "walkingNao";
	}

	/**
	 * The nao moves left
	 * @return Parameter which determines the wepbage as a HTTP response
	 */
	
	public String letNaoWalkL() {

		rob.naoMove(Movement.LEFT);

		return "walkingNao";
	}

	
	/**
	 * The nao moves right
	 * @return Parameter which determines the wepbage as a HTTP response
	 */
	
	public String letNaoWalkR() {

		rob.naoMove(Movement.RIGHT);

		return "walkingNao";
	}
	
	
	/**
	 * The nao turns right
	 * @return Parameter which determines the wepbage as a HTTP response
	 */
	
	public String letNaoTurnRight() {

		rob.naoMove(Movement.TURNRIGHT);

		return "walkingNao";
	}
	
	/**
	 * This method connects to the robot
	 * @return Parameter which determines the wepbage as a HTTP response
	 */

	public String startRobot(String naoIP, String naoPort) {

		rob.setConnection(naoIP, naoPort);

		return "naomainpage";
	}
	
	/**
	 * The method lets the nao speak a desired text
	 * @return Parameter which determines the wepbage as a HTTP response
	 */

	public String robotSaySomething(String textToSay) {
		rob.naoTalk(textToSay);
		return "manageWords";
	}

	public String getTextTeaching() {
		return "textTeaching";
	}

}
