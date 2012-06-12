/**
 * This package contains all the available messagetypes and also the superclass <Message>
 */
package messageTypes;

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
public class Sms extends Message implements IValidator{
	
	
	/**
	 * @param recipient
	 * @param subject
	 * @param message
	 * @param sendTime
	 * @param reminderTime
	 * @throws Exception
	 */
	public Sms(String recipient,String subject, String message, Date sendTime, Date reminderTime) throws ValidationException{
		super(recipient, subject, message, sendTime, reminderTime);
		
		try{
			this.validate();
		}
		catch(ValidationException validationException){
			throw validationException;
		}
	}
	
	@Override
	public void send() throws Exception{
		// TODO: Schöner Output
		System.out.println("SMS abgeschickt!");
		System.out.println(getRecipient());
		System.out.println(getText());
	}
	
	@Override
	public void sendReminder() {
		System.out.println("\"Das ist der Reminder an die Message: " + this.getSubject() + " an den Empfänger: " + this.getRecipient() + " \"");
	}
	
	//TODO: translate
	/**
	 * Prüfung ob SMS-Nummer gültig ist oder nicht.
	 * Falls Nummer ungültig, wird Benutzer Meldung angezeigt
	 *
	 * {@inheritDoc}
	 */
	@Override
	public boolean validate() throws ValidationException{
		if (isValidPhoneNumber(this.getRecipient())) {
			if (this.getSubject().equals("") || this.getText().equals("")) {
				throw new ValidationException(this.getRecipient(),"Subject or Text is empty!");
			}
		} else {
			throw new ValidationException(this.getRecipient(),"Telephone-Number is invalid");
		}

		return true;
	}
	
	
	// RegEx für SMS-Number
	// Format Handling: +lluuxxxyyzz, 0uuxxxyyyzz, 0uu / xxx yy zz,
	// +ll uu xxx yy zz, 0uu xxx yy zz, 0uu/xxx yy zz
		public boolean isValidPhoneNumber(String smsNumber) {
			//Vorgängig alle Leerschläge entfernen in smsNumber
			String smsNumberStripSpaces = smsNumber.replaceAll("\\s","");
			//String expression = (\+|0)?\d([/ -]?\d)+;
			String expression = "(\\+|0)?\\d([/ -]?\\d)+";
			CharSequence inputStr = smsNumberStripSpaces;
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(inputStr);
			return matcher.matches();
		}

}
