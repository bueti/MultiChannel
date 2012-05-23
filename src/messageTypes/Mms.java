package messageTypes;

public class Mms extends Message {

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
<<<<<<< OURS
		System.out.println("\"Das ist der Reminder an die Message: " + this.getSubject() + " an den Empfänger " + this.getRecipient() + "\"");
=======
		System.out.println("\"Das ist der Reminder and die Message: " + this.getSubject() + "and den Empfänger" + this.getRecipient() + "\"");
>>>>>>> THEIRS
	}

}
