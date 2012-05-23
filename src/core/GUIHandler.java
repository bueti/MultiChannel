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
	
	//ONLY USE THIS METHOD TO SEND
	public boolean sendMessage(List<String> recipientList, String subject, String message, String type, Date sendTime, Date reminderTime){
		try{
			for(String recipient: recipientList){
				
				Message newMsg = MessageFactory.createNewMessage(subject, recipient, message, type, sendTime, reminderTime);
				
				//TODO Add exception handling for message validation errors
				if (newMsg.validate()) {
					this.handler.sendMessage(newMsg);
				}else{
					//TODO return what was wrong through an exception
					return false;
				}
			}
		}catch(Exception e){
			//Log to logger
		}
		return true;
	}

	// OBSOLETE!!!
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
				//this.handler.sendMessageNow(msg);
			}
		}
	}
	
	// OBSOLETE
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
				//this.handler.sendMessageLater(msg);
			}
		}
		
	}

	/*public void sendMessage(List<String> recipientList, String subject, String message, String type, Date sendTime, Date reminderTime)
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
		
	}*/
	
	//TODO: Do we want to delete this?
	public String[] getAllMessageTypes() {
		allMessageTypes = new String[] {"Email", "Sms", "Mms", "Print"};
		return allMessageTypes;
	}

}
