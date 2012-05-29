package messageTypes;

public class Print extends Message implements IValidator{

	public void send() {
		System.out.println("\"" + this.getSubject() + "\" an Drucker \""
				+ this.getRecipient() + "\" geschickt.");
		System.out.println("Nachricht:");
		System.out.println(this.getText());
	}
	
	public void sendReminder() {
		System.out.println("\"Das ist der Reminder an die Message: " + this.getSubject() + " an den Empfänger " + this.getRecipient() + "\"");
	}

	public boolean validate() throws Exception{
		if (!this.getRecipient().equals("")) {
			if (this.getSubject().equals("") || this.getText().equals("")) {
				throw new Exception("Subject or Text is empty!");
			}
			return true;
		} else {
			throw new Exception("Printer address is invalid");
		}
	}

}
