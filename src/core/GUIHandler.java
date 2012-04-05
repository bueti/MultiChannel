package core;

import messageTypes.Message;

public class GUIHandler implements IGUIHandler{

	@Override
	
	public void sendMessage(String recipient, String subject, String message, String type) {
		DataHandler handler = DataHandler.getInstance();
		
		try {
			Class c = Class.forName("messageTypes." + type);
			Message msg = (Message) c.newInstance();
			System.out.println("Empfänger: " + recipient);
			System.out.println("Betrefft: " + subject);
			System.out.println("Nachricht: " + message);

			// Send Message
			handler.handleMessage(msg);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}
