package gui;

import core.GUIHandler;
import core.IGUIHandler;


public class GUI {
	
	private IGUIHandler guiHandler;
	
	
	public GUI(){
		GUIHandler handler = new GUIHandler();
		guiHandler = (IGUIHandler)handler;
		
		this.sendMessage();
	}
	
	public void sendMessage(){
		//guiHandler.sendMessage("bla", "bla");
		
	}

}
