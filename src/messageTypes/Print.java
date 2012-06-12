/**
 * This package contains all the available messagetypes and also the superclass <Message>
 */
package messageTypes;

import java.util.Date;

import exceptions.ValidationException;

/**
 * This is a subclass of the superclass <code>Message</code> and represents a specific message type.
 * The Interface <code>IValidator</code> makes sure each specific message type implements a validation
 * for itself which is called in the constructor
 * 
 * @author Benjamin Bütikofer
 * @version 1.0
 * @see Message
 * @see IValidator
 *
 */
public class Print extends Message implements IValidator{
	
	/**
	 * Default constructor for the <code>Print</code> class, which is called
	 * to create a new print. After creation of the print it is validated and if
	 * it's invalid the <code>ValidationException</code> is thrown.
	 * 
	 * @param recipient recipient of the message
	 * @param subject subject of the message
	 * @param message message body
	 * @param sendTime time to sent the message later (optional)
	 * @param reminderTime time to send a reminder for the message (optional)
	 * @throws ValidationException exception thrown if the email is invalid contains the recipient and the error
	 */
	public Print(String recipient,String subject, String message, Date sendTime, Date reminderTime) throws ValidationException{
		super(recipient, subject, message, sendTime, reminderTime);
		
		try{
			this.validate();
		}
		catch(ValidationException validationException){
			throw validationException;
		}
	}

	@Override
	public void send() {
		System.out.println("\"" + getSubject() + "\" an Drucker \""
				+ getRecipient() + "\" geschickt.");
		System.out.println("Nachricht:");
		System.out.println(getText());
	}
	
	@Override
	public void sendReminder() {
		System.out.println("\"Das ist der Reminder an die Message: " + getSubject() + " an den Empfänger " + getRecipient() + "\"");
	}
	
	@Override
	public boolean validate() throws ValidationException{
		if (!getRecipient().equals("")) {
			if (getSubject().equals("") || getText().equals("")) {
				throw new ValidationException(getRecipient(),"Subject or Text is empty!");
			}
			return true;
		} else {
			throw new ValidationException(getRecipient(),"Printer address is invalid");
		}
	}

}
