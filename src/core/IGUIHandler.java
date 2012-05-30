package core;

import java.io.File;
import java.util.Date;
import java.util.List;

public interface IGUIHandler {
	boolean sendMessage(List<String> recipient, String subject, String message, String type, Date sendTime, Date reminderTime, File attachment) throws Exception; 
	String[] getAllMessageTypes();
}
