/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
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
			throws EmptyRecipientException, EmptySubjectAndMessageException, IllegalEmailAddressException {
		
		Class<?> messageType = null;
		Message msg = null;
		try {
			messageType = Class.forName("messageTypes." + type);
			msg = (Message) messageType.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO: Program crashes, need to search a solution
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO: Program crashes, need to search a solution
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO: Program crashes, need to search a solution
			e.printStackTrace();
		}
		
		for(String recipient: recipientList){
			msg.setText(message);
			msg.setSubject(subject);
			msg.setRecipient(recipient);
			if (msg.validate()) {
				this.handler.sendMessageNow(msg);
			}
		}
	}
	

	// Send with schedule
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
	
	// send with schedule and reminder
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
