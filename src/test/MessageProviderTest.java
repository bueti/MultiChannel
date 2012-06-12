/**
 * 
 */
package test;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.Date;

import messageTypes.Email;
import messageTypes.Mms;
import messageTypes.Print;
import messageTypes.Sms;

import org.junit.Before;
import org.junit.Test;

import core.MessageSender;
import exceptions.MessageSenderException;

/**
 * @author yannik
 *
 */
public class MessageProviderTest {
	
	private MessageSender testProvider;
	private Email testEmail;
	private Sms testSms;
	private Mms testMms;
	private Print testPrint;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testEmail = new Email("test@test.com","Test","This is a test email",null,null,null);
		testSms = new Sms("0791231212","Test sms","This is a test sms",null,null);
		testMms = new Mms("0791231212","Test Mms","This is a test Mms",null,null,new File(""));
		testPrint = new Print("PRT 123","Test print","This is a test print",null,null);
		testProvider = new MessageSender(new MockMessageScheduler());
	}

	/**
	 * Test method for {@link core.MessageSender#sendMessage(messageTypes.Message)}.
	 */
	@Test
	public void testSendMessage() {
		try {
			testProvider.sendMessage(testSms);
			testProvider.sendMessage(testMms);
			testProvider.sendMessage(testPrint);
			testProvider.sendMessage(testEmail);
		} catch (Exception e) {
			fail("message sending failed" + e.getMessage());
		}

	}
	
	/**
	 * Test method for {@link core.MessageSender#sendMessage(messageTypes.Message)}.
	 */
	@Test
	public void testSendLaterMessage() {
		this.testEmail.setSendTime(new Date(System.currentTimeMillis() + 1000));
		this.testMms.setSendTime(new Date(System.currentTimeMillis() + 1000));
		this.testPrint.setSendTime(new Date(System.currentTimeMillis() + 1000));
		this.testSms.setSendTime(new Date(System.currentTimeMillis() + 1000));
		try {
			testProvider.sendMessage(testSms);
			testProvider.sendMessage(testMms);
			testProvider.sendMessage(testPrint);
			testProvider.sendMessage(testEmail);
		} catch (Exception e) {
			fail("send message failed" + e.getMessage());
		}

	}
	
	@Test
	public void testSendReminderMessage() {
		this.testEmail.setSendTime(new Date(System.currentTimeMillis() + 1000));
		this.testMms.setSendTime(new Date(System.currentTimeMillis() + 1000));
		this.testPrint.setSendTime(new Date(System.currentTimeMillis() + 1000));
		this.testSms.setSendTime(new Date(System.currentTimeMillis() + 1000));
		this.testEmail.setReminderTime(new Date(System.currentTimeMillis() + 500));
		this.testMms.setReminderTime(new Date(System.currentTimeMillis() + 500));
		this.testPrint.setReminderTime(new Date(System.currentTimeMillis() + 500));
		this.testSms.setSendTime(new Date(System.currentTimeMillis() + 500));
		try {
			testProvider.sendMessage(testSms);
			testProvider.sendMessage(testMms);
			testProvider.sendMessage(testPrint);
			testProvider.sendMessage(testEmail);
		} catch (Exception e) {
			fail("send message failed" + e.getMessage());
		}
	}
	
	@Test (expected=Exception.class)
	public void testFailSend() throws MessageSenderException, Exception{
		testProvider.sendMessage(null);
	}
	

}
