package core;

import java.util.Date;

import exceptions.EmptyRecipientException;
import exceptions.EmptySubjectAndMessageException;
import exceptions.IllegalEmailAddressException;

public interface IGUIHandler {
	void sendMessage(String recipient, String subject, String message, String type) throws ClassNotFoundException, InstantiationException, IllegalAccessException, EmptyRecipientException, EmptySubjectAndMessageException, IllegalEmailAddressException;
	void sendMessage(String recipient, String subject, String message, String type, Date sendTime);
	String[] getAllMessageTypes();
}
