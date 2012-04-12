package messageTypes;

import java.util.Date;

import exceptions.EmptyRecipientException;
import exceptions.EmptySubjectAndMessageException;

public abstract class Message {
	private Boolean sendReminder;
	private Date reminderTime;
	private Boolean sendLater;
	private Date sendTime;
	public abstract void send(String recipient, String subject, String message);
	public abstract boolean validate(String recipient, String subject, String message) throws EmptyRecipientException, EmptySubjectAndMessageException;
	
	public Boolean getSendReminder() {
		return sendReminder;
	}
	public void setSendReminder(Boolean sendReminder) {
		this.sendReminder = sendReminder;
	}
	public Date getReminderTime() {
		return reminderTime;
	}
	public void setReminderTime(Date reminderTime) {
		this.reminderTime = reminderTime;
	}
	public Boolean getSendLater() {
		return sendLater;
	}
	public void setSendLater(Boolean sendLater) {
		this.sendLater = sendLater;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
}
