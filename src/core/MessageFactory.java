/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package core;

import java.io.File;
import java.util.Date;

import messageTypes.AllMessageTypes;
import messageTypes.Email;
import messageTypes.Message;
import messageTypes.Mms;
import messageTypes.Print;
import messageTypes.Sms;

/**
 * The MessageFactory class is used to generate a business object out of parameters,
 * it is called by the <code>GUIHandler</code> to create the <code>Message</code> object.
 * The type of the message is decided by a parameter.
 *
 * @see GUIHandler
 * @see messageTypes.Message
 * @author  Yannik Kopp
 * @version 1.0
 */
public class MessageFactory {
	
	public static Message createNewMessage(String recipient, MessageInfo info)
	{
		Message msg = null;
		try{
			switch (AllMessageTypes.valueOf(info.getType())){
				case Email:
					msg = new Email(recipient, info.getSubject(), info.getMessage(), info.getSendTime(), info.getReminderTime(), info.getAttachment());
					break;
				case Sms:
					msg = new Sms(recipient, info.getSubject(), info.getMessage(), info.getSendTime(), info.getReminderTime());
					break;
				case Mms:
					msg = new Mms(recipient, info.getSubject(), info.getMessage(), info.getSendTime(), info.getReminderTime(), info.getAttachment());
					break;
				case Print:
					msg = new Print(recipient, info.getSubject(), info.getMessage(), info.getSendTime(), info.getReminderTime());
					break;
			}
		}catch(IllegalArgumentException ex){
			//TODO: Log to Logger
			return null;
		}
		
		return msg;
		
	}

}
