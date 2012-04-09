package messageTypes;


public class Email extends Message{

	public void send() {
		System.out.println("I am an email");
	}

	public boolean validate() {
		System.out.println("Email validated!");
		return true;
	}
}
