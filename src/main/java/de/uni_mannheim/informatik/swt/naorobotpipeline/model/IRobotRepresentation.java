package de.uni_mannheim.informatik.swt.naorobotpipeline.model;

public interface IRobotRepresentation {
	
	public void naoMove(Movement move);
	
	public void naoTalk(String text);
	
	public void setConnection(String ip, String port);
}
