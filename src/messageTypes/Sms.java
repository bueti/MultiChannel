package messageTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sms extends Message implements IValidator{

	@Override
	public void send() {
		// TODO: Schöner Output
		System.out.println("SMS abgeschickt!");
		System.out.println(getRecipient());
		System.out.println(getText());
	}
	
	public void sendReminder() {
		System.out.println("\"Das ist der Reminder an die Message: " + this.getSubject() + " an den Empfänger: " + this.getRecipient() + " \"");
	}
	

	@Override
	/** Prüfung ob SMS-Nummer gültig ist oder nicht.
	 * Falls Nummer ungültig, wird Benutzer Meldung angezeigt
	 */
	public boolean validate() throws Exception {
		if (isValidPhoneNumber(this.getRecipient())) {
			if (this.getSubject().equals("") && this.getText().equals("")) {
				throw new Exception("Subject or Text is empty!");
			}
		} else {
			throw new Exception("Telephone-Number is invalid");
		}

		return true;
	}
	
	
	// RegEx für SMS-Number
	// Format Handling: +lluuxxxyyzz, 07uxxxyyyzz, 0uu / xxx yy zz,
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
