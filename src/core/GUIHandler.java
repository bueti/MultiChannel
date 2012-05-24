/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package core;

import java.util.Date;
import java.util.List;

import messageTypes.Message;

public class GUIHandler implements IGUIHandler {

	MessageProvider handler;
	String[] allMessageTypes;

	public GUIHandler() {
		MessageScheduler scheduler = new MessageScheduler();
		this.handler = MessageProvider.getInstance(scheduler);
	}
	
	public boolean sendMessage(List<String> recipientList, String subject, String message, String type, Date sendTime, Date reminderTime) throws Exception{
		
		for (String recipient : recipientList) {
			Message newMsg;

			try {
				newMsg = MessageFactory.createNewMessage(subject, recipient,message, type, sendTime, reminderTime);
				newMsg.validate();
			} catch (ClassNotFoundException e) {
				//TODO: Log error
				return false;
			} catch (InstantiationException e) {
				//TODO: Log error
				return false;
			} catch (IllegalAccessException e) {
				//TODO: Log error
				return false;
			} catch (Exception ex) {
				throw new Exception(ex.getMessage());
			}
			
			//TODO: Exception Handling für send message
			this.handler.sendMessage(newMsg);
		}
		return true;
	}
	
	//TODO: Do we want to delete this?
	public String[] getAllMessageTypes() {
		allMessageTypes = new String[] {"Email", "Sms", "Mms", "Print"};
		return allMessageTypes;
	}

}
