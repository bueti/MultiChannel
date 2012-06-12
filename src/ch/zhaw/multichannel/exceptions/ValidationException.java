/**
 * This package contains the custom exceptions for the core
 */
package ch.zhaw.multichannel.exceptions;

/**
 * Custom exception to represent a validation exception. If a message is invalid this
 * exception can be thrown with the specific error in it and the original recipient who
 * should have received the message.
 * 
 * @author  Yannik Kopp
 * @version 1.0
 * @see Exception
 */
public class ValidationException extends Exception {

	private static final long serialVersionUID = -5571552368355227193L;
	
	/**
	 * Original recipient of the invalid message
	 */
	private String recipient;
	
	/**
	 * Error message of the validation
	 */
	private String validationError;
	
	/**
	 * Calls constructor of the superclass and sets the recipient and the error
	 * message of the validation
	 * @param recipient
	 * @param validationError
	 */
	public ValidationException(String recipient,String validationError){
		super();
		this.recipient = recipient;
		this.validationError = validationError;
	}

	/**
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * @return the validationError
	 */
	public String getValidationError() {
		return validationError;
	}

}
