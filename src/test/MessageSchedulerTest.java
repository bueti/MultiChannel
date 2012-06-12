package test;

import static org.junit.Assert.*;

import java.util.Date;

import messageTypes.Email;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.IMessageScheduler;
import core.MessageScheduler;

public class MessageSchedulerTest {
	
	private IMessageScheduler testScheduler;
	private Email testEmail;

	@Before
	public void setUp() throws Exception {
		testScheduler = new MessageScheduler();
		testEmail = new Email("test@test.com","Test","This is a test email",new Date(System.currentTimeMillis() + 1000),new Date(System.currentTimeMillis() + 1000),null);
	}
	
	@After
	public void tearDown(){
		testEmail = null;
		testScheduler = null;
	}
	
	/**
	 * Test method for {@link core.MessageScheduler#createMessageTimer(messageTypes.Message)}.
	 */
	@Test
	public void testCreateMessageTimer() {
		try {
			testScheduler.createMessageTimer(testEmail);
		} catch (Exception e) {
			fail("failed to create timer task " + e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link core.MessageScheduler#createMessageTimer(messageTypes.Message)}.
	 */
	@Test (expected = Exception.class)
	public void testNullTimeCreateMessageTimer() throws Exception{
		testEmail.setSendTime(null);
		testScheduler.createMessageTimer(testEmail);
	}
	
	/**
	 * Test method for {@link core.MessageScheduler#createMessageTimer(messageTypes.Message)}.
	 */
	@Test (expected = Exception.class)
	public void testNullMessageCreateMessageTimer() throws Exception{
		testEmail = null;
		testScheduler.createMessageTimer(testEmail);
	}
	
	/**
	 * Test method for {@link core.MessageScheduler#createReminderTimer(messageTypes.Message)}.
	 */
	@Test
	public void testCreateReminderTimer() {
		try {
			testScheduler.createReminderTimer(testEmail);
		} catch (Exception e) {
			fail("failed to create reminder task " + e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link core.MessageScheduler#createReminderTimer(messageTypes.Message)}.
	 * @throws Exception 
	 */
	@Test (expected = Exception.class)
	public void testNullTimeCreateReminderTimer() throws Exception{
		testEmail.setReminderTime(null);
		testScheduler.createReminderTimer(testEmail);
	}
	
	/**
	 * Test method for {@link core.MessageScheduler#createReminderTimer(messageTypes.Message)}.
	 * @throws Exception 
	 */
	@Test (expected = Exception.class)
	public void testNullMessageCreateReminderTimer() throws Exception{
		this.testEmail = null;
		this.testScheduler.createReminderTimer(this.testEmail);
	}

}
