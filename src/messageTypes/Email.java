package messageTypes;

import exceptions.EmptyRecipientException;
import exceptions.EmptySubjectAndMessageException;
import exceptions.IllegalEmailAddressException;


public class Email extends Message implements IValidator{

	public void send() {
		System.out.println("\"" + this.getSubject() + "\" an \"" + this.getRecipient() + "\" geschickt.");
		System.out.println("Nachricht:");
		System.out.println(this.getText());
	}

	public boolean validate()
			throws EmptyRecipientException, EmptySubjectAndMessageException, IllegalEmailAddressException {
		// TODO: Email Address Verification: http://leshazlewood.com/2006/11/06/emailaddress-java-class/ 
		if (!this.getRecipient().equals("")) {
			if(this.getRecipient().contains("@")) {
				if (this.getSubject().equals("") && this.getText().equals("")) {
					throw new EmptySubjectAndMessageException();
				}
			} else {
				throw new IllegalEmailAddressException();
			}
			return true;
		} else {
			throw new EmptyRecipientException();
		}
		
		//RegEx für Email addresse
		/*#  public boolean isValidEmailAddress(String emailAddress){  
			#    String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";  
			#    CharSequence inputStr = emailAddress;  
			#    Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);  
			#    Matcher matcher = pattern.matcher(inputStr);  
			#    return matcher.matches();  
			#   
			#  }*/
	}

	public void sendReminder() {
		System.out.println("\"Das ist der Reminder and die Message: " + this.getSubject() + "and den Empfänger" + this.getRecipient() + "\"");
	}
}
