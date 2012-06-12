/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package ch.zhaw.multichannel.core;

import ch.zhaw.multichannel.core.interfaces.IGUIHandler;
import ch.zhaw.multichannel.core.interfaces.IMessageSender;
import ch.zhaw.multichannel.exceptions.MessageSenderException;
import ch.zhaw.multichannel.exceptions.ValidationException;
import ch.zhaw.multichannel.gui.MultiChannelLogMonitor;
import ch.zhaw.multichannel.messages.Message;

/**
 * The GUIHandler class is used to encapsulate the businesslogic from the GUI.
 * It implements the interface <code>IGUIHandler</code> to make it easy
 * replaceable by another handler.
 * 
 * @author Yannik Kopp
 * @version 1.0
 * @see ch.zhaw.multichannel.core.interfaces.IGUIHandler
 */
public class GUIHandler implements IGUIHandler {

	/**
	 * Instance of <code>MessageSender</code> class, which is used to send the
	 * message immediately or at a specific time
	 * 
	 * @see MessageSender
	 */
	IMessageSender provider;

	/**
	 * Default constructor for <code>GUIHandler</code>.
	 * 
	 * @param provider Instance of a <code>IMessageSender</code> object
	 * @see MessageSender
	 * @see IMessageSender
	 */
	public GUIHandler(IMessageSender provider) {
		this.provider = provider;
	}
	
	@Override
	public void sendMessage(MessageInfo info) throws ValidationException,Exception {
		
		Message newMsg = null;
		
		try{
			newMsg = MessageFactory.createNewMessage(info);
		}catch(ValidationException validationError){
			MultiChannelLogMonitor.getInstance().logInformation("Validation error found for recipient: " + validationError.getRecipient() + " because of: " + validationError.getValidationError(),3);
			throw validationError;
		}
		
		try{
			this.provider.sendMessage(newMsg);
		}catch(MessageSenderException msgException){
			MultiChannelLogMonitor.getInstance().logInformation("The message " + msgException.getFailedMessage().getSubject() + " for recipient " + msgException.getFailedMessage().getRecipient() + " failed because: " +msgException.getMessage(),1);
			throw new Exception("Message sending failed, check log monitor for further information");
		}
	}

}
