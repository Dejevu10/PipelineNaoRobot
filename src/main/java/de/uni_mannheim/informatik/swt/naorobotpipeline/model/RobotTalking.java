package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

public class RobotTalking implements IRobotTalking {

	@Override
	public void sayText(String text, Session session) {

		try {
			ALTextToSpeech tty = new ALTextToSpeech(session);
			tty.say(text);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
