package core;

import java.util.Date;
import java.util.List;

import exceptions.EmptyRecipientException;
import exceptions.EmptySubjectAndMessageException;
import exceptions.IllegalEmailAddressException;

public interface IGUIHandler {
	void sendMessage(List<String> recipient, String subject, String message, String type) throws ClassNotFoundException, InstantiationException, IllegalAccessException, EmptyRecipientException, EmptySubjectAndMessageException, IllegalEmailAddressException;
	void sendMessage(List<String> recipient, String subject, String message, String type, Date sendTime) throws ClassNotFoundException, InstantiationException, IllegalAccessException, EmptyRecipientException, EmptySubjectAndMessageException, IllegalEmailAddressException;
	void sendMessage(List<String> recipient, String subject, String message, String type, Date sendTime,Date reminderTime) throws ClassNotFoundException, InstantiationException, IllegalAccessException, EmptyRecipientException, EmptySubjectAndMessageException, IllegalEmailAddressException;
	String[] getAllMessageTypes();
}
