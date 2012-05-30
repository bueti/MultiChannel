package messageTypes;

import java.util.Date;

public abstract class Message {
	private Boolean sendReminder;
	private Date reminderTime;
	private Boolean sendLater;
	private Date sendTime;
	private String recipient;
	private String subject;
	private String text;
	
	public abstract void send();
	public abstract void sendReminder();
	public abstract boolean validate() throws Exception;
	
	public Message(String pRecipient,String pSubject, String pMessage, Date pSendTime, Date pReminderTime){
		this.setRecipient(pRecipient);
		this.setSubject(pSubject);
		this.setText(pMessage);
		
		this.setSendLater(false);
		this.setSendReminder(false);
		
		if(pSendTime!=null){
			this.setSendTime(pSendTime);
			this.setSendLater(true);
		}
		if(pReminderTime!=null){
			this.setSendReminder(true);
			this.setReminderTime(pReminderTime);
		}
	}
	
	public boolean getSendReminder() {
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
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
