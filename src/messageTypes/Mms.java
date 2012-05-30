package messageTypes;

import java.io.File;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mms extends Message implements IValidator {
	
	private File attachment;
	
	public Mms(String pRecipient,String pSubject, String pMessage, Date pSendTime, Date pReminderTime, File pAttachment){
		super(pRecipient, pSubject, pMessage, pSendTime, pReminderTime);
		if(attachment != null){
			this.setAttachment(pAttachment);
		}
	}

	@Override
	public void send() {
		System.out.println("\"" + this.getSubject() + "\" an \"" + this.getRecipient() + "\" geschickt.");
		System.out.println("Nachricht:");
		System.out.println(this.getText());
	}

	@Override
	/** Prüfung ob MMS-Nummer gültig ist oder nicht.
	 * Falls Nummer ungültig, wird Benutzer Meldung angezeigt.
	 * Prüfung der MMS-Nummer kontrolliert, ob es sich um eine 
	 * Schweizer Mobile-Nummer handelt (Falls Landesvorwahl,  
	 * muss +41 eingetragen sein. Anschliessend muss Ziffer 7 in Vorwahl 
	 * enthalten sein)
	 */
	public boolean validate() throws Exception {
		if (isValidPhoneNumber(this.getRecipient())) {
			if (this.getSubject().equals("") || this.getText().equals("")) {
				throw new Exception("Subject or Text is empty!");
			}
		} else {
			throw new Exception("Telephone-Number for MMS is invalid");
		}

		return true;
	}
		
	// RegEx für MMS-Number
	// Format Handling: +417uxxxyyzz, 07uxxxyyyzz, 07u / xxx yy zz,
	// +41 7u xxx yy zz, 07u xxx yy zz, 07u/xxx yy zz
		public boolean isValidPhoneNumber(String mmsNumber) {
			//Vorgängig alle Leerschläge und '/' entfernen in mmsNumber
			String mmsNumberStripSpaces = mmsNumber.replaceAll("[\\s[/]]","");
			//String expression = (\+|0)?(41)?[7]{1}\d([/ -]?\d)+;
			String expression = "(\\+|0)?(41)?[7]{1}\\d([/ -]?\\d)+";
			CharSequence inputStr = mmsNumberStripSpaces;
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(inputStr);
			return matcher.matches();
		}

	
	public void sendReminder() {
		System.out.println("\"Das ist der Reminder an die Message: " + this.getSubject() + " an den Empfänger " + this.getRecipient() + "\"");
	}
	
	public File getAttachment() {
		return attachment;
	}

	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

}
