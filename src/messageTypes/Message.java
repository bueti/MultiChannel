/**
 * This package contains all the available messagetypes and also the superclass <Message>
 */
package messageTypes;

import java.util.Date;

/**
 * This class represent the basic message type which is used for all the sub message classes, every
 * typed message class needs to extend this abstract class. In the whole sending mechanism only this
 * superclass is used.
 * 
 * @author ben
 * @version 1.0
 */
public abstract class Message {
	
	/**
	 * These member variables define the standard fields of a message which must be set
	 * except <code>sendTime</code> and <reminderTime>
	 */
	private boolean sendReminder;
	private Date reminderTime;
	private boolean sendLater;
	private Date sendTime;
	private String recipient;
	private String subject;
	private String text;
	
    /** 
     * Each typed message class must implement a send method to send itself
     */
	public abstract void send();
	
    /** 
     * Each typed message class must implement a send reminder method to send a reminder
     * of itself
     */
	public abstract void sendReminder();
	
    /** 
     * Each typed message class must implement a validation method to validate itself.
     * @throws Exception whats wrong with the message
     * @return boolean if its validated right
     */
	public abstract boolean validate() throws Exception;

	/**
	 * Default constructor for the <code>Message</code> class, which is called
	 * by the subclasses to create a basic message
	 * 
	 * @param pRecipient recipient of the message
	 * @param pSubject subject of the message
	 * @param pMessage message body
	 * @param pSendTime time to sent the message later (optional)
	 * @param pReminderTime time to send a reminder for the message (optional)
	 */
	//TODO: Improvment: Maybe split this into two constructors for the sendTime and the remindertime
	public Message(String pRecipient, String pSubject, String pMessage,
			Date pSendTime, Date pReminderTime) {
		setRecipient(pRecipient);
		setSubject(pSubject);
		setText(pMessage);

		setSendLater(false);
		setSendReminder(false);

		if (pSendTime != null) {
			setSendTime(pSendTime);
			setSendLater(true);
		}
		if (pReminderTime != null) {
			setSendReminder(true);
			setReminderTime(pReminderTime);
		}
	}

	/**
	 * @return boolean if the message needs to send a reminder
	 */
	public boolean getSendReminder() {
		return sendReminder;
	}

	/**
	 * @param sendReminder indicator if the message needs to send a reminder
	 */
	public void setSendReminder(boolean sendReminder) {
		this.sendReminder = sendReminder;
	}

	/**
	 * @return Date time when the reminder needs to be sent
	 */
	public Date getReminderTime() {
		return reminderTime;
	}

	/**
	 * @param reminderTime time when the reminder needs to be sent
	 */
	public void setReminderTime(Date reminderTime) {
		this.reminderTime = reminderTime;
	}

	/**
	 * @return boolean if the message needs to be sent at a specific time
	 */
	public boolean getSendLater() {
		return sendLater;
	}

	/**
	 * @param sendLater if the message needs to be sent at a specific time
	 */
	public void setSendLater(boolean sendLater) {
		this.sendLater = sendLater;
	}

	/**
	 * @return Date time when to send the message
	 */
	public Date getSendTime() {
		return sendTime;
	}

	/**
	 * @param sendTime time when the message needs to be sent
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * @return String recipient of the message
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * @param recipient recipient of the message
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	/**
	 * @return String body text of the message
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text body text of the message
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return String subject of the message
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param String subject of the message
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
