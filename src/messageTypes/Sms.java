package messageTypes;

public class Sms extends Message {

	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println("I am an sms");
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		System.out.println("Im a fine sms");
		return false;
	}



}
