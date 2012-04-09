package messageTypes;

public class Print extends Message{

	public void send() {
		System.out.println("I am a print");
	}

	public boolean validate() {
		System.out.println("Im a fine print");
		return false;
	}

}
