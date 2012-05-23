package core;

import java.util.Date;
import java.util.List;

import exceptions.EmptyRecipientException;
import exceptions.EmptySubjectAndMessageException;
import exceptions.IllegalEmailAddressException;

public interface IGUIHandler {
	//OBSOLETE
	void sendMessage(List<String> recipient, String subject, String message, String type) throws ClassNotFoundException, InstantiationException, IllegalAccessException, EmptyRecipientException, EmptySubjectAndMessageException, IllegalEmailAddressException;
	//OBSOLETE
	void sendMessage(List<String> recipient, String subject, String message, String type, Date sendTime) throws ClassNotFoundException, InstantiationException, IllegalAccessException, EmptyRecipientException, EmptySubjectAndMessageException, IllegalEmailAddressException;
	//ONLY USE THIS MESSAGE TO SEND
	boolean sendMessage(List<String> recipient, String subject, String message, String type, Date sendTime,Date reminderTime);
	String[] getAllMessageTypes();
}
