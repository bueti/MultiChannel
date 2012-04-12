package messageTypes;


public class Email extends Message {

	public void send(String recipient, String subject, String message) {
		// TODO: Schöner Output
		System.out.println("Email abgeschickt!");
	}

	public boolean validate(String recipient, String subject, String message) {
		// TODO: Email Validierung:
		// Mehrere Empfänger?
		// Hat die Adresse ein @
		// Hat die Adresse eine gültige TLD
		System.out.println("Email validated!");
		return true;
	}
}
