/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package ch.zhaw.multichannel.core;

import java.io.File;
import java.util.Date;

/**
 * This class is just a container for the fields of the gui to reduce
 * the parameters in the GUIHandler, it also makes the message creation
 * more dynamically 
 *
 * @author  Roland Hofer
 * @version 1.0
 */
public class MessageInfo {
	private String recipient;
	private String subject;
	private String message;
	private String type;
	private Date sendTime;
	private Date reminderTime;
	private File attachment;
	
	/**
	 * Constructor of the class <code>MessageInfo</code>
	 * 
	 * @param recipient
	 * @param subject
	 * @param message
	 * @param type
	 * @param sendTime
	 * @param reminderTime
	 * @param attachment
	 */
	public MessageInfo(String recipient, String subject, String message,
			String type, Date sendTime, Date reminderTime, File attachment) {
		this.recipient = recipient;
		this.subject = subject;
		this.message = message;
		this.type = type;
		this.sendTime = sendTime;
		this.reminderTime = reminderTime;
		this.attachment = attachment;
	}
	
	/**
	 * Creates an empty <code>MessageInfo</code> object
	 */
	public MessageInfo(){
		
	}

	/**
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * @param recipient the recipient to set
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the sendTime
	 */
	public Date getSendTime() {
		return sendTime;
	}

	/**
	 * @param sendTime the sendTime to set
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * @return the reminderTime
	 */
	public Date getReminderTime() {
		return reminderTime;
	}

	/**
	 * @param reminderTime the reminderTime to set
	 */
	public void setReminderTime(Date reminderTime) {
		this.reminderTime = reminderTime;
	}

	/**
	 * @return the attachment
	 */
	public File getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

}
