package ch.zhaw.multichannel.exception;

public class ValidationException extends Exception {

	private static final long serialVersionUID = -5571552368355227193L;
	private String recipient;
	private String validationError;
	
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
