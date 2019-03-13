package de.uni_mannheim.informatik.swt.naorobotpipeline.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import de.uni_mannheim.informatik.swt.naorobotpipeline.model.Movement;
import de.uni_mannheim.informatik.swt.naorobotpipeline.model.RobotRepresentation;

@Service
public class RobotControllerTest {

	@Autowired
	private RobotRepresentation rob;

	public String letNaoWalkF() {

		rob.naoMove(Movement.FORWARD);

		return "walkingNao";
	}

	public String letNaoWalkB() {

		rob.naoMove(Movement.BACKWARD);

		return "walkingNao";
	}

	public String letNaoWalkL() {

		rob.naoMove(Movement.LEFT);

		return "walkingNao";
	}

	public String letNaoWalkR() {

		rob.naoMove(Movement.RIGHT);

		return "walkingNao";
	}

	public String letNaoTurnRight() {

		rob.naoMove(Movement.TURNRIGHT);

		return "walkingNao";
	}

	public String startRobot(String naoIP, String naoPort) {

		rob.setConnection(naoIP, naoPort);

		return "naomainpage";
	}

	public String robotSaySomething(String textToSay) {
		rob.naoTalk(textToSay);
		return "manageWords";
	}

	public String getTextTeaching() {
		return "textTeaching";
	}

}
