package core;

import java.util.Date;
import java.util.List;

import messageTypes.Message;
import exceptions.EmptyRecipientException;
import exceptions.EmptySubjectAndMessageException;
import exceptions.IllegalEmailAddressException;

public class GUIHandler implements IGUIHandler {

	MessageProvider handler;
	String[] allMessageTypes;

	public GUIHandler() {
		this.handler = MessageProvider.getInstance();
	}

	// Sofort senden
	public void sendMessage(List<String> recipientList, String subject, String message, String type) 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, EmptyRecipientException, EmptySubjectAndMessageException, IllegalEmailAddressException {
		
		Class<?> messageType = Class.forName("messageTypes." + type);
		
		for(String recipient: recipientList){
			Message msg = (Message) messageType.newInstance();
			msg.setText(message);
			msg.setSubject(subject);
			msg.setRecipient(recipient);
			if (msg.validate()) {
				this.handler.sendMessageNow(msg);
			}
		}
	}
	
	// TODO: Später senden
	// TODO: Maybe change Date type to Calendar
	public void sendMessage(List<String> recipientList, String subject, String message, String type, Date sendTime) 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, EmptyRecipientException, EmptySubjectAndMessageException, IllegalEmailAddressException {
		
		Class<?> messageType = Class.forName("messageTypes." + type);
		
		for(String recipient: recipientList){
			Message msg = (Message) messageType.newInstance();
			msg.setText(message);
			msg.setSubject(subject);
			msg.setRecipient(recipient);
			// TODO: Maybe check for right time
			msg.setSendTime(sendTime);
			msg.setSendLater(true);
			msg.setSendReminder(false);
			if (msg.validate()) {
				this.handler.sendMessageLater(msg);
			}
		}
		
	}
	
	// TODO: Später senden mit reminder
	// TODO: Reminder und send Later methode vieleicht zusammen führen?
	public void sendMessage(List<String> recipientList, String subject, String message, String type, Date sendTime, Date reminderTime)
		throws ClassNotFoundException, InstantiationException, IllegalAccessException, EmptyRecipientException, EmptySubjectAndMessageException, IllegalEmailAddressException {
		
		Class<?> messageType = Class.forName("messageTypes." + type);
		
		for(String recipient: recipientList){
			Message msg = (Message) messageType.newInstance();
			msg.setText(message);
			msg.setSubject(subject);
			msg.setRecipient(recipient);
			// TODO: Maybe check for right time
			msg.setSendTime(sendTime);
			msg.setSendLater(true);
			msg.setReminderTime(reminderTime);
			msg.setSendReminder(true);
			if (msg.validate()) {
				this.handler.sendMessageLater(msg);
			}
		}
		
	}

	public String[] getAllMessageTypes() {
		allMessageTypes = new String[] {"Email", "Sms", "Mms", "Print"};
		return allMessageTypes;
	}

}
