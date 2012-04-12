package core;

import java.util.Date;
import java.util.List;

import messageTypes.Message;
import exceptions.EmptyRecipientException;
import exceptions.EmptySubjectAndMessageException;

public class GUIHandler implements IGUIHandler {

	MessageProvider handler;

	public GUIHandler() {
		this.handler = MessageProvider.getInstance();
	}

	// Ohne Reminder
	public void sendMessage(String recipient, String subject, String message, String type) 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, EmptyRecipientException, EmptySubjectAndMessageException {

		Class<?> messageType = Class.forName("messageTypes." + type);
		Message msg = (Message) messageType.newInstance();

		// String recipient, String subject, String message
		if (msg.validate(recipient, subject, message)) {
			this.handler.sendMessageNow(msg, recipient, subject, message);
		}
	}

	// TODO: Mit Reminder
	public void sendMessage(String recipient, String subject, String message, String type, Date sendTime) {

	}

	public List<String> getAllMessageTypes() {

		return null;
	}

}
