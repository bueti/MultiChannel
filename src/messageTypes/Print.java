package messageTypes;

import exceptions.EmptyRecipientException;
import exceptions.EmptySubjectAndMessageException;

public class Print extends Message {

	public void send(String printer, String subject, String message) {
		System.out.println("\"" + subject + "\" an Drucker \""
				+ printer + "\" geschickt.");
		System.out.println("Nachricht:");
		System.out.println(message);
	}

	public boolean validate(String printer, String subject, String message)
			throws EmptyRecipientException, EmptySubjectAndMessageException {
		if (!printer.equals("")) {
			if (subject.equals("") && message.equals("")) {
				throw new EmptySubjectAndMessageException();
			}
//			System.out.println("Validated");
			return true;
		} else {
			throw new EmptyRecipientException();
		}
	}

}
