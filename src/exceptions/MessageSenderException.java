package exceptions;

import messageTypes.Message;

public class MessageSenderException extends Exception {
	
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
