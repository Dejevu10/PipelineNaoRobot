package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

import com.aldebaran.qi.Session;

public interface IRobotTalking {
	
	public void sayText(String text, Session session);
}
