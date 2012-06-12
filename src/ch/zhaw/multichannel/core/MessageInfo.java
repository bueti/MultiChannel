/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package ch.zhaw.multichannel.core;

import java.io.File;
import java.util.Date;

public class MessageInfo {
	private String recipient;
	private String subject;
	private String message;
	private String type;
	private Date sendTime;
	private Date reminderTime;
	private File attachment;
	
	//TODO javadoc
	/**
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
	
	public MessageInfo(){
		
	}
	
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Date getReminderTime() {
		return reminderTime;
	}
	public void setReminderTime(Date reminderTime) {
		this.reminderTime = reminderTime;
	}
	public File getAttachment() {
		return attachment;
	}
	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

}
