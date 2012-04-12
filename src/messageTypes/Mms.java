package messageTypes;

public class Mms extends Message {

	@Override
	public void send(String recipient, String subject, String message) {
		// TODO: Schöner Output
		System.out.println("MMS abgeschickt!");
	}

	@Override
	public boolean validate(String recipient, String subject, String message) {
		// TODO: MMS Validierung:
		// Mehrere Empfänger?
		// Format Handling: +417uxxxyyzz, 07uxxxyyyzz, 07u'xxx'yy'zz, +41'7u'xxx'yy'zz, 07u xxx yy zz
		System.out.println("Validated");
		return true;
	}

}
