package messageTypes;

public class Sms extends Message {

	@Override
	public void send() {
		System.out.println("I am an sms");
	}

	@Override
	public boolean validate() {
		System.out.println("Im a fine sms");
		return false;
	}



}
