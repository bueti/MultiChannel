/**
 * This package contains all the available messagetypes and also the superclass <Message>
 */
package ch.zhaw.multichannel.messages;

import java.io.File;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.zhaw.multichannel.exceptions.ValidationException;
import ch.zhaw.multichannel.gui.MultiChannelLogMonitor;
import ch.zhaw.multichannel.messages.interfaces.IValidator;



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
public class Email extends Message implements IValidator {

	/**
	 * The email class got the specific type member attachment
	 */
	private File attachment;
	
	/**
	 * Default constructor for the <code>Email</code> class, which is called
	 * to create a new email. After creation of the email it is validated and if
	 * it's invalid the <code>ValidationException</code> is thrown.
	 * 
	 * @param recipient recipient of the message
	 * @param subject subject of the message
	 * @param message message body
	 * @param sendTime time to sent the message later (optional)
	 * @param reminderTime time to send a reminder for the message (optional)
	 * @param attachment attachment of the email
	 * @throws ValidationException exception thrown if the email is invalid contains the recipient and the error
	 */
	public Email(String recipient,String subject, String message, Date sendTime, Date reminderTime, File attachment) throws ValidationException {
		super(recipient, subject, message, sendTime, reminderTime);
		
		if(attachment!=null){
			this.setAttachment(attachment);
		}
		
		try{
			this.validate();
		}
		catch(ValidationException validationException){
			throw validationException;
		}
	}
	
	@Override
	public void send() {
		/*
		   At the moment there is no exception handling needed in the send method
		   but the possibility to implement it is given with the superclass
		 */
		String message = "\"" + getSubject() + "\" an \""+ getRecipient() + "\" geschickt." +"\n";
		message += "Nachricht: " + getText() +"\n";
		if(getAttachment()!=null) {
			message += "Attachment: " + getAttachment().getAbsolutePath();
		}
		MultiChannelLogMonitor.getInstance().logInformation(message, 1);
	}
	
	@Override
	public void sendReminder() {
		/*
		   At the moment there is no exception handling needed in the send method
		   but the possibility to implement it is given with the superclass
		 */

		String message = "\"Das ist der Reminder an die Message: " + getSubject() + " an den Empfänger " + getRecipient() + "\"";
		MultiChannelLogMonitor.getInstance().logInformation(message, 1);
	}
	
	@Override
	public boolean validate() throws ValidationException{
		if (isValidEmailAddress(getRecipient().trim())) {
			if (getSubject().equals("") || getText().equals("")) {
				throw new ValidationException(getRecipient(),"Subject or Text is empty!");
			}
		} else {
			throw new ValidationException(getRecipient(),"Email address is invalid");
		}
		return true;
	}
	
	/**
	 * Regex to check email addresses
	 * @param emailAddress address to check
	 * @return boolean is valid or not
	 */
	public boolean isValidEmailAddress(String emailAddress) {
		//String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		String expression = "^[\\w\\-]([\\.\\w])+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputStr = emailAddress;
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		return matcher.matches();

	}
	
	/**
	 * @return File attachment of the message
	 */
	public File getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment attachment of the message
	 */
	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}
}
