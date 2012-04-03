package messageTypes;

public class Print extends Message{

	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println("I am a print");
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		System.out.println("Im a fine print");
		return false;
	}

}
