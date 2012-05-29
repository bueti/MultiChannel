package messageTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email extends Message implements IValidator {

	public void send() {
		System.out.println("\"" + this.getSubject() + "\" an \""
				+ this.getRecipient() + "\" geschickt.");
		System.out.println("Nachricht:");
		System.out.println(this.getText());
	}

	public boolean validate() throws Exception{
		if (isValidEmailAddress(this.getRecipient())) {
			if (this.getSubject().equals("") || this.getText().equals("")) {
				throw new Exception("Subject or Text is empty!");
			}
		} else {
			throw new Exception("Email address is invalid");
		}
		return true;
	}
	
	// TODO maybe use this vor Validation
	// RegEx für Email addresse
	public boolean isValidEmailAddress(String emailAddress) {
		//String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		String expression = "^[\\w\\-]([\\.\\w])+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputStr = emailAddress;
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		return matcher.matches();

	}

	public void sendReminder() {
		System.out.println("\"Das ist der Reminder an die Message: "
				+ this.getSubject() + "an den Empfänger" + this.getRecipient()
				+ "\"");
	}
}
