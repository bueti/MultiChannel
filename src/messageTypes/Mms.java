package messageTypes;


//TODO: Implement Validator Interface to make it replacable
public class Mms extends Message implements IValidator {

	@Override
	public void send() {
		System.out.println("\"" + this.getSubject() + "\" an \"" + this.getRecipient() + "\" geschickt.");
		System.out.println("Nachricht:");
		System.out.println(this.getText());
	}

	@Override
	public boolean validate() {
		// TODO: MMS Validierung:
		// Mehrere Empfänger?
		// Format Handling: +417uxxxyyzz, 07uxxxyyyzz, 07u'xxx'yy'zz, +41'7u'xxx'yy'zz, 07u xxx yy zz
		return true;
	}
	
	public void sendReminder() {
		System.out.println("\"Das ist der Reminder an die Message: " + this.getSubject() + " an den Empfänger " + this.getRecipient() + "\"");
	}

}
