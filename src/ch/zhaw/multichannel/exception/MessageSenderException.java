package ch.zhaw.multichannel.exception;

import ch.zhaw.multichannel.messages.Message;

public class MessageSenderException extends Exception {
	
	private static final long serialVersionUID = -6624873749429160999L;
	private Message failedMsg;
	
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
