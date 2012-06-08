/**
 * This package contains all the available messagetypes and also the superclass <Message>
 */
package messageTypes;

import java.io.File;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Email Class
 * Manages email specific options
 *
 */
public class Email extends Message implements IValidator {
	
	private File attachment;
	
	public Email(String pRecipient,String pSubject, String pMessage, Date pSendTime, Date pReminderTime, File pAttachment) {
		super(pRecipient, pSubject, pMessage, pSendTime, pReminderTime);
		
		if(pAttachment!=null){
			this.setAttachment(pAttachment);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void send() {
		System.out.println("\"" + this.getSubject() + "\" an \""
				+ this.getRecipient() + "\" geschickt.");
		System.out.println("Nachricht:");
		System.out.println(this.getText());
		if(this.getAttachment()!=null) {
			System.out.println("Attachment: " + this.getAttachment().getAbsolutePath());
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validate() throws Exception{
		if (isValidEmailAddress(this.getRecipient())) {
			if (this.getSubject().equals("") || this.getText().equals("")) {
				throw new Exception("Subject or Text is empty!");
			}
		} else {
			throw new Exception("Email address is invalid");
		}
		return true;
	}
	
	// RegEx für Email addresse
	public boolean isValidEmailAddress(String emailAddress) {
		//String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		String expression = "^[\\w\\-]([\\.\\w])+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputStr = emailAddress;
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		return matcher.matches();

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void sendReminder() {
		System.out.println("\"Das ist der Reminder an die Message: "
				+ this.getSubject() + " an den Empfänger " + this.getRecipient()
				+ "\"");
	}

	public File getAttachment() {
		return attachment;
	}

	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}
}
