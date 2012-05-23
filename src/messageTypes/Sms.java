package messageTypes;

public class Sms extends Message {

	@Override
	public void send() {
		// TODO: Schöner Output
		System.out.println("SMS abgeschickt!");
	}
	
	public void sendReminder() {
		System.out.println("\"Das ist der Reminder an die Message: " + this.getSubject() + " an den Empfänger: " + this.getRecipient() + " \"");
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
