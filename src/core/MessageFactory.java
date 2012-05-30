package core;

import java.io.File;
import java.util.Date;

import messageTypes.AllMessageTypes;
import messageTypes.Email;
import messageTypes.Message;
import messageTypes.Mms;
import messageTypes.Print;
import messageTypes.Sms;

public class MessageFactory {
	
	//TODO OBSOLETE!
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
	
	public static Message createNewMessage(String recipient,String subject, String message, String type, Date sendTime, Date reminderTime, File attachment)
	{
		Message msg = null;
		switch (AllMessageTypes.valueOf(type)){
			case Email:
				msg = new Email(recipient,subject,message,sendTime,reminderTime,attachment);
				break;
			case Sms:
				msg = new Sms(recipient,subject,message,sendTime,reminderTime);
				break;
			case Mms:
				msg = new Mms(recipient,subject,message,sendTime,reminderTime,attachment);
				break;
			case Print:
				msg = new Print(recipient,subject,message,sendTime,reminderTime);
				break;
			default: 
				//TODO Log to error log!
				return null;
		}
		
		return msg;
		
	}

}
