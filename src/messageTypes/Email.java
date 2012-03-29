package messageTypes;

public class Email extends Message{


	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println("I am an email");
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
