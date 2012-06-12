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
 * @author Benjamin Bütikofer
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
     * @throws Exception Throws an Exception if message failed to send
     */
	public abstract void send() throws Exception;
	
    /** 
     * Each typed message class must implement a send reminder method to send a reminder
     * of itself.
     *  @throws Exception Throws an Exception if reminder failed to send
     */
	public abstract void sendReminder() throws Exception;
	
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
	 * @param recipient recipient of the message
	 * @param subject subject of the message
	 * @param message message body
	 * @param sendTime time to sent the message later (optional)
	 * @param reminderTime time to send a reminder for the message (optional)
	 */
	//IMPROVMENT: Maybe split this into two constructors for the sendTime and the remindertime
	public Message(String recipient, String subject, String message,Date sendTime, Date reminderTime) {
		
		setRecipient(recipient);
		setSubject(subject);
		setText(message);

		setSendLater(false);
		setSendReminder(false);

		if (sendTime != null) {
			setSendTime(sendTime);
			setSendLater(true);
		}
		if (reminderTime != null) {
			setSendReminder(true);
			setReminderTime(reminderTime);
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
