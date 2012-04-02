package messageTypes;

public class Mms extends Message{

	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println("I am an mms");
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		System.out.println("Im a fine mms");
		return false;
	}


}
