/**
 * This package contains all the available messagetypes and also the superclass <Message>
 */
package messageTypes;

import java.util.Date;

import exceptions.ValidationException;

public class Print extends Message implements IValidator{
	
	public Print(String pRecipient,String pSubject, String pMessage, Date pSendTime, Date pReminderTime) throws Exception{
		super(pRecipient, pSubject, pMessage, pSendTime, pReminderTime);
		
		try{
			this.validate();
		}
		catch(ValidationException validationException){
			throw validationException;
		}
	}
	//TODO: no inheritDOc!
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void send() {
		System.out.println("\"" + this.getSubject() + "\" an Drucker \""
				+ this.getRecipient() + "\" geschickt.");
		System.out.println("Nachricht:");
		System.out.println(this.getText());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void sendReminder() {
		System.out.println("\"Das ist der Reminder an die Message: " + this.getSubject() + " an den Empfänger " + this.getRecipient() + "\"");
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validate() throws ValidationException{
		if (!this.getRecipient().equals("")) {
			if (this.getSubject().equals("") || this.getText().equals("")) {
				throw new ValidationException(this.getRecipient(),"Subject or Text is empty!");
			}
			return true;
		} else {
			throw new ValidationException(this.getRecipient(),"Printer address is invalid");
		}
	}

}
