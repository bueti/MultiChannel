package core;

import messageTypes.Email;
import messageTypes.Message;

public class GUIHandler implements IGUIHandler{

	@Override
	public void sendMessage(String text, String recipient) {
		DataHandler handler = DataHandler.getInstance();
		
		handler.handleMessage(new Email());
		
	}
	

}
