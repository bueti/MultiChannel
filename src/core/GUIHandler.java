package core;

import java.util.Date;
import java.util.List;

import messageTypes.Message;

public class GUIHandler implements IGUIHandler {

	MessageProvider handler;

	public GUIHandler() {
		this.handler = MessageProvider.getInstance();
	}

	public void sendMessage(String recipient, String subject, String message, String type) 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		Class messageType = Class.forName("messageTypes." + type);
		Message msg = (Message) messageType.newInstance();

		if (msg.validate()) {
			this.handler.sendMessageNow(msg);
		}
	}

	public void sendMessage(String recipient, String subject, String message,
			String type, Date sendTime) {

	}

	public List<String> getAllMessageTypes() {

		return null;
	}

}
