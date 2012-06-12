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

	private File attachment;

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
		System.out.println("\"" + this.getSubject() + "\" an \""
				+ this.getRecipient() + "\" geschickt.");
		System.out.println("Nachricht:");
		System.out.println(this.getText());
		if (this.getAttachment() != null) {
			System.out.println("Attachment: "
					+ this.getAttachment().getAbsolutePath());
		}
	}
	
	//TODO: Translate to english
	/**
	 * Prüfung ob MMS-Nummer gültig ist oder nicht. Falls Nummer ungültig, wird
	 * Benutzer Meldung angezeigt. Prüfung der MMS-Nummer kontrolliert, ob es
	 * sich um eine Schweizer Mobile-Nummer handelt (Falls Landesvorwahl, muss
	 * +41 eingetragen sein. Anschliessend muss Ziffer 7 in Vorwahl enthalten
	 * sein)
	 * 
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public boolean validate() throws ValidationException {
		//TODO: Check for empty recipient
		/*if(this.getRecipient()==null){
			throw new ValidationException("","Emailadress is empty");
		}*/
		if (isValidPhoneNumber(this.getRecipient())) {
			if (this.getSubject().equals("") || this.getText().equals("")) {
				throw new ValidationException(this.getRecipient(),"Subject or Text is empty!");
			}
		} else {
			throw new ValidationException(this.getRecipient(),"Telephone-Number for MMS is invalid");
		}

		return true;
	}

	// RegEx für MMS-Number
	// Format Handling: +417uxxxyyzz, 07uxxxyyyzz, 07u / xxx yy zz,
	// +41 7u xxx yy zz, 07u xxx yy zz, 07u/xxx yy zz
	public boolean isValidPhoneNumber(String mmsNumber) {
		// Vorgängig alle Leerschläge und '/' entfernen in mmsNumber
		String mmsNumberStripSpaces = mmsNumber.replaceAll("[\\s[/]]", "");
		// String expression = (\+|0)?(41)?[7]{1}\d([/ -]?\d)+;
		String expression = "(\\+|0)?(41)?[7]{1}\\d([/ -]?\\d)+";
		CharSequence inputStr = mmsNumberStripSpaces;
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		return matcher.matches();
	}
	
	@Override
	public void sendReminder() {
		System.out.println("\"Das ist der Reminder an die Message: "
				+ this.getSubject() + " an den Empfänger "
				+ this.getRecipient() + "\"");
	}

	public File getAttachment() {
		return attachment;
	}

	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

}
