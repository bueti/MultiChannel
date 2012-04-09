package messageTypes;

public class Mms extends Message{

	@Override
	public void send() {
		System.out.println("I am an mms");
	}

	@Override
	public boolean validate() {
		System.out.println("Im a fine mms");
		return false;
	}


}
