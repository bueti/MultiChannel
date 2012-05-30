package core;

import java.util.Date;

import messageTypes.AllMessageTypes;
import messageTypes.Email;
import messageTypes.Message;
import messageTypes.Mms;
import messageTypes.Print;
import messageTypes.Sms;

public class MessageFactory {
	
	public static Message createNewMessage(String recipient, String subject, String message, String type, Date sendTime, Date reminderTime, String attachment)
	{
		Message msg = null;
		try{
			switch (AllMessageTypes.valueOf(type)){
				case Email:
					msg = new Email(recipient, subject, message, sendTime, reminderTime, attachment);
					break;
				case Sms:
					msg = new Sms(recipient, subject, message, sendTime, reminderTime);
					break;
				case Mms:
					msg = new Mms(recipient, subject,message, sendTime, reminderTime, attachment);
					break;
				case Print:
					msg = new Print(recipient, subject, message, sendTime, reminderTime);
					break;
			}
		}catch(IllegalArgumentException ex){
			//TODO: Log to Logger
			return null;
		}
		
		return msg;
		
	}

}
