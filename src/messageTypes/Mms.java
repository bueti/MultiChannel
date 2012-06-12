/**
 * This package contains all the available messagetypes and also the superclass <Message>
 */
package messageTypes;

import java.io.File;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class Mms extends Message implements IValidator {
	
	/**
	 * The email class got the specific type member attachment
	 */
	private File attachment;

	/**
	 * Default constructor for the <code>Mms</code> class, which is called
	 * to create a new mms. After creation of the mms it is validated and if
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
	public Mms(String recipient, String subject, String message,
			Date sendTime, Date reminderTime, File attachment) throws ValidationException {
		super(recipient, subject, message, sendTime, reminderTime);
		if (attachment != null) {
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
		System.out.println("\"" + getSubject() + "\" an \""
				+ getRecipient() + "\" geschickt.");
		System.out.println("Nachricht:");
		System.out.println(getText());
		if (getAttachment() != null) {
			System.out.println("Attachment: "
					+ getAttachment().getAbsolutePath());
		}
	}
	
	/**
	 * Check if the mobile number is valid. If the number is invalid and
	 * <code>ValidationException</code> is thrown. This validation checks
	 * if its a correct swiss mobile phone number. (with country code +41,
	 * number has to start with a 7, without it has to start with a 0)
	 */
	@Override
	public boolean validate() throws ValidationException {
		if (isValidPhoneNumber(getRecipient())) {
			if (getSubject().equals("") || getText().equals("")) {
				throw new ValidationException(getRecipient(),"Subject or Text is empty!");
			}
		} else {
			throw new ValidationException(getRecipient(),"Telephone-Number for MMS is invalid");
		}

		return true;
	}

	/**
	 * Regex to check mobile phone number:
	 * Format Handling: +417uxxxyyzz, 07uxxxyyyzz, 07u / xxx yy zz,
	 * +41 7u xxx yy zz, 07u xxx yy zz, 07u/xxx yy zz
	 * 
	 * @param mmsNumber number to check
	 * @return boolean if number is valid or not
	 */
	public boolean isValidPhoneNumber(String mmsNumber) {
		
		// strip all spaces and slashes in phone number
		String mmsNumberStripSpaces = mmsNumber.replaceAll("[\\s[/]]", "");
		String expression = "(\\+|0)?(41)?[7]{1}\\d([/ -]?\\d)+";
		CharSequence inputStr = mmsNumberStripSpaces;
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		return matcher.matches();
	}
	
	@Override
	public void sendReminder() {
		System.out.println("\"Das ist der Reminder an die Message: "
				+ getSubject() + " an den Empfänger "
				+ getRecipient() + "\"");
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
