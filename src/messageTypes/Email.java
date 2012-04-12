package messageTypes;

import exceptions.EmptyRecipientException;
import exceptions.EmptySubjectAndMessageException;
import exceptions.IllegalEmailAddressException;


public class Email extends Message {

	public void send(String recipient, String subject, String message) {
		System.out.println("\"" + subject + "\" an \"" + recipient + "\" geschickt.");
		System.out.println("Nachricht:");
		System.out.println(message);
	}

	public boolean validate(String recipient, String subject, String message)
			throws EmptyRecipientException, EmptySubjectAndMessageException, IllegalEmailAddressException {
		if (!recipient.equals("")) {
			if(recipient.contains("@")) {
				if (subject.equals("") && message.equals("")) {
					throw new EmptySubjectAndMessageException();
				}
			} else {
				throw new IllegalEmailAddressException();
			}
			return true;
		} else {
			throw new EmptyRecipientException();
		}
	}
}
