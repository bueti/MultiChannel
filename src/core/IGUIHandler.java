package core;

import java.util.Date;
import java.util.List;

import exceptions.EmptyRecipientException;
import exceptions.EmptySubjectAndMessageException;

public interface IGUIHandler {
	void sendMessage(String recipient, String subject, String message, String type) throws ClassNotFoundException, InstantiationException, IllegalAccessException, EmptyRecipientException, EmptySubjectAndMessageException;
	void sendMessage(String recipient, String subject, String message, String type, Date sendTime);
	List<String> getAllMessageTypes();
}
