package core;

import java.util.Date;
import messageTypes.Message;

public class MessageFactory {
	public static Message createNewMessage(String subject,String recipient, String message, String type, Date sendTime, Date reminderTime) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		Class<?> messageType = Class.forName("messageTypes." + type);
		
		Message msg = (Message) messageType.newInstance();
		msg.setText(message);
		msg.setSubject(subject);
		msg.setRecipient(recipient);
		
		msg.setSendLater(false);
		msg.setSendReminder(false);
		
		// TODO: Maybe check for right time
		if(sendTime!=null){
			msg.setSendTime(sendTime);
			msg.setSendLater(true);
		}if(reminderTime!=null){
			msg.setSendReminder(true);
			msg.setReminderTime(reminderTime);
		}
		
		return msg;
	}

}
