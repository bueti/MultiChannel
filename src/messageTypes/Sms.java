package messageTypes;

public class Sms extends Message {

	@Override
	public void send() {
		// TODO: Schöner Output
		System.out.println("SMS abgeschickt!");
	}
	
	public void sendReminder() {
<<<<<<< OURS
		System.out.println("\"Das ist der Reminder an die Message: " + this.getSubject() + " an den Empfänger: " + this.getRecipient() + " \"");
=======
		System.out.println("\"Das ist der Reminder and die Message: " + this.getSubject() + " an den Empfänger: " + this.getRecipient() + " \"");
>>>>>>> THEIRS
	}
	

	@Override
	public boolean validate() {
		// TODO: SMS Validierung:
		// Mehrere Empfänger?
		// Format Handling: +417uxxxyyzz, 07uxxxyyyzz, 07u'xxx'yy'zz,
		// +41'7u'xxx'yy'zz, 07u xxx yy zz
		return true;
	}

}
