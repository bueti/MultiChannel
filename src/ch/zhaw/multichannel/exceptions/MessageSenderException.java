/**
 * This package contains the custom exceptions for the core
 */
package ch.zhaw.multichannel.exceptions;

import ch.zhaw.multichannel.messages.Message;

/**
 * Custom exception to represent a sender exception. If a message couldn't be sent this
 * exception can be thrown with the specific error in it and the original message which couldn't
 * be sent
 * 
 * @author  Yannik Kopp
 * @version 1.0
 * @see Exception
 */
public class MessageSenderException extends Exception {
	
	private static final long serialVersionUID = -6624873749429160999L;
	
	/**
	 * Message which couldn't been sent
	 */
	private Message failedMsg;
	
	/**
	 * Call the constructor of the super class with the error message and writes
	 * the failed sent message to the member variable
	 * 
	 * @param failedMsg
	 * @param message
	 */
	public MessageSenderException(Message failedMsg,String message){
		super(message);
		this.failedMsg = failedMsg;
	}

	/**
	 * @return the failedMsg
	 */
	public Message getFailedMessage() {
		return failedMsg;
	}
	
	
	

}
