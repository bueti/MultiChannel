/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Date;

import messageTypes.Email;
import messageTypes.Mms;
import messageTypes.Print;
import messageTypes.Sms;

import org.junit.Before;
import org.junit.Test;

import core.MessageProvider;

/**
 * @author yannik
 *
 */
public class MessageProviderTest {
	
	private MessageProvider testProvider;
	private Email testEmail;
	private Sms testSms;
	private Mms testMms;
	private Print testPrint;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.testEmail = new Email("test@test.com","Test","This is a test email",null,null,null);
		this.testSms = new Sms("0791231212","Test sms","This is a test sms",null,null);
		this.testMms = new Mms("0791231212","Test Mms","This is a test Mms",null,null,new File(""));
		this.testPrint = new Print("PRT 123","Test print","This is a test print",null,null);
		this.testProvider = new MessageProvider(new MockMessageScheduler());
	}

	/**
	 * Test method for {@link core.MessageProvider#sendMessage(messageTypes.Message)}.
	 */
	@Test
	public void testSendMessage() {
		assertTrue(this.testProvider.sendMessage(testSms));
		assertTrue(this.testProvider.sendMessage(testMms));
		assertTrue(this.testProvider.sendMessage(testPrint));
		assertTrue(this.testProvider.sendMessage(testEmail));
	}
	
	/**
	 * Test method for {@link core.MessageProvider#sendMessage(messageTypes.Message)}.
	 */
	@Test
	public void testSendLaterMessage() {
		this.testEmail.setSendTime(new Date(System.currentTimeMillis() + 1000));
		this.testMms.setSendTime(new Date(System.currentTimeMillis() + 1000));
		this.testPrint.setSendTime(new Date(System.currentTimeMillis() + 1000));
		this.testSms.setSendTime(new Date(System.currentTimeMillis() + 1000));
		assertTrue(this.testProvider.sendMessage(testSms));
		assertTrue(this.testProvider.sendMessage(testMms));
		assertTrue(this.testProvider.sendMessage(testPrint));
		assertTrue(this.testProvider.sendMessage(testEmail));
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
		assertTrue(this.testProvider.sendMessage(testSms));
		assertTrue(this.testProvider.sendMessage(testMms));
		assertTrue(this.testProvider.sendMessage(testPrint));
		assertTrue(this.testProvider.sendMessage(testEmail));
	}
	
	@Test
	public void testFailSend(){
		assertFalse(this.testProvider.sendMessage(null));
	}
	

}
