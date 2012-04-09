package core;

import java.util.Date;
import java.util.List;

public interface IGUIHandler {
	void sendMessage(String recipient, String subject, String message, String type) throws ClassNotFoundException, InstantiationException, IllegalAccessException;
	void sendMessage(String recipient, String subject, String message, String type, Date sendTime);
	List<String> getAllMessageTypes();
}
