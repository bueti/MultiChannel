/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package ch.zhaw.multichannel.core.interfaces;

import ch.zhaw.multichannel.core.MessageInfo;
import ch.zhaw.multichannel.exceptions.ValidationException;

/**
 * Interface which represent all the message functionality provided for the GUI.
 * 
 * @author  Yannik Kopp
 * @version 1.0
 * @see GUIHandler
 */
public interface IGUIHandler {
	
	/**
	 * Send message method provided to GUI. After the send button is clicked all inputs
	 * will be packed into a <code>MessageInfo</code> object and used as parameter for this
	 * method.
	 * 
	 * @param info all inputs from the gui packed in a <code>MessageInfo</code> object
	 * @throws Exception thrown if message sending failed
	 * @throws ValidationException if any input is wrong a <code>ValidationException is thrown</code>
	 */
	void sendMessage(MessageInfo info) throws Exception, ValidationException; 
}
