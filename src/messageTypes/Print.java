package messageTypes;

import exceptions.EmptyRecipientException;
import exceptions.EmptySubjectAndMessageException;

public class Print extends Message {

	public void send(String printer, String subject, String message) {
		// TODO: Schöner Output
		System.out.println("Nachricht \"" + subject + "\" an Drucker \""
				+ printer + "\" geschickt.");
	}

	public boolean validate(String printer, String subject, String message)
			throws EmptyRecipientException, EmptySubjectAndMessageException {
		if (!printer.equals("")) {
			if (subject.equals("") && message.equals("")) {
				throw new EmptySubjectAndMessageException();
			}
			System.out.println("Validated");
			return true;
		} else {
			throw new EmptyRecipientException();
		}
	}

}
