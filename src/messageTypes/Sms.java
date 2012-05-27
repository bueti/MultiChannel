package messageTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sms extends Message implements IValidator{

	@Override
	public void send() {
		// TODO: Schöner Output
		System.out.println("SMS abgeschickt!");
	}
	
	public void sendReminder() {
		System.out.println("\"Das ist der Reminder an die Message: " + this.getSubject() + " an den Empfänger: " + this.getRecipient() + " \"");
	}
	

	@Override
	// TODO: Leezeichen für Stringprüfung eliminieren
	// Aktuell wird pro String-Gruppe 1 SMS geschickt 
	// also 079 555 55 55 = 4 sms...   :-o
	public boolean validate() throws Exception {
		if (isValidPhoneNumber(this.getRecipient())) {
			if (this.getSubject().equals("") && this.getText().equals("")) {
				throw new Exception("Subject or Text is empty!");
			}
		} else {
			throw new Exception("Telephone-Number is invalid");
		}
		// Format Handling: +417uxxxyyzz, 07uxxxyyyzz, 07u'xxx'yy'zz,
		// +41'7u'xxx'yy'zz, 07u xxx yy zz
		return true;
	}
	
	
	// RegEx für SMS-Number
		public boolean isValidPhoneNumber(String smsNumber) {
			String smsNumberStripSpaces = smsNumber.replaceAll("\\s","");
			//String expression = (\+|0)?\d([/ -]?\d)+;
			String expression = "(\\+|0)?\\d([/ -]?\\d)+";
			CharSequence inputStr = smsNumberStripSpaces;
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(inputStr);
			return matcher.matches();
		}

}
