package core;

import messageTypes.Email;
import messageTypes.Message;

public class GUIHandler implements IGUIHandler{

	@Override
	
	
	
	public void sendMessage(String Recipient,String Text, String Type) {
		DataHandler handler = DataHandler.getInstance();
		
		try {
			Class c = Class.forName("messageTypes." + Type);
			Message msg = (Message) c.newInstance();
			msg.validate();
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
