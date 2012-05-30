/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package core;

import java.io.File;
import java.util.Date;
import java.util.List;

import messageTypes.Message;

/**
 * The GUIHandler class is used to encapsulate the businesslogic from the GUI.
 * It implements the interface <code>IGUIHandler</code> to make it easy replaceable
 * by another handler.
 *
 * @author  Yannik Kopp
 * @version 1.0
 * @see core.IGUIHandler
 */
public class GUIHandler implements IGUIHandler {
	
    /**
     * Instance of <code>MessageProvider</code> class, which is used to
     * send the message immediately or at a specific time
     *
     * @see MessageProvider
     */
	MessageProvider provider;
	
    /**
     * Represents all available message types
     *
     */
	String[] allMessageTypes;
	
    /** 	
    * Default constructor for <code>GUIHandler</code>. 
    * Creates a <code>MessageScheduler</code> instance to initiate <code>MessageProvider</code>,
    * after it gets a <code>MessageProvider</code> instance through the singleton.
    * 
    * @See MessageScheduler
    * @See MessageProvider
    */
	public GUIHandler() {
		IMessageScheduler scheduler = new MessageScheduler();
		this.provider = MessageProvider.getInstance(scheduler);
	}
	
	//TODO: Maybe us Dictionary for all these parameters
	@Override
	public boolean sendMessage(List<String> recipientList, String subject, String message, String type, Date sendTime, Date reminderTime, File attachment) throws Exception {
		
		for (String recipient : recipientList) {
			Message newMsg;

			try {
				newMsg = MessageFactory.createNewMessage(recipient,subject,message, type, sendTime, reminderTime, attachment);
				if(newMsg == null){
					return false;
				}
				newMsg.validate();
			} catch (Exception ex) {
				throw new Exception(ex.getMessage());
			}
			
			if(!this.provider.sendMessage(newMsg)){
				return false;
			}
		}
		return true;
	}
	
	//TODO: OBSOLETE!!
	@Override
	public String[] getAllMessageTypes() {
		allMessageTypes = new String[] {"Email", "Sms", "Mms", "Print"};
		return allMessageTypes;
	}

}
