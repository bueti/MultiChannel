package messageTypes;

import exceptions.EmptyRecipientException;
import exceptions.EmptySubjectAndMessageException;

public class Print extends Message {

	public void send() {
		System.out.println("\"" + this.getSubject() + "\" an Drucker \""
				+ this.getRecipient() + "\" geschickt.");
		System.out.println("Nachricht:");
		System.out.println(this.getText());
	}
	
	public void sendReminder() {
		System.out.println("\"Das ist der Reminder and die Message: " + this.getSubject() + "and den Empfänger" + this.getRecipient() + "\"");
	}

	public boolean validate()
			throws EmptyRecipientException, EmptySubjectAndMessageException {
		if (!this.getRecipient().equals("")) {
			if (this.getSubject().equals("") && this.getText().equals("")) {
				throw new EmptySubjectAndMessageException();
			}
//			System.out.println("Validated");
			return true;
		} else {
			throw new EmptyRecipientException();
		}
	}

}
