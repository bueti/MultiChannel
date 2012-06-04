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
		this.testScheduler = new MessageScheduler();
		this.testEmail = new Email("test@test.com","Test","This is a test email",new Date(System.currentTimeMillis() + 1000),new Date(System.currentTimeMillis() + 1000),null);
	}
	
	@After
	public void tearDown(){
		this.testEmail = null;
		this.testScheduler = null;
	}
	
	/**
	 * Test method for {@link core.MessageScheduler#createMessageTimer(messageTypes.Message)}.
	 */
	@Test
	public void testCreateMessageTimer() {
		assertTrue(this.testScheduler.createMessageTimer(this.testEmail));
		//fail("Message scheduler failed to create a new TimerTask");
	}
	
	/**
	 * Test method for {@link core.MessageScheduler#createMessageTimer(messageTypes.Message)}.
	 */
	@Test (expected = Exception.class)
	public void testNullTimeCreateMessageTimer(){
		this.testEmail.setSendTime(null);
		this.testScheduler.createMessageTimer(this.testEmail);
	}
	
	/**
	 * Test method for {@link core.MessageScheduler#createMessageTimer(messageTypes.Message)}.
	 */
	@Test (expected = Exception.class)
	public void testNullMessageCreateMessageTimer(){
		this.testEmail = null;
		this.testScheduler.createMessageTimer(this.testEmail);
	}
	
	/**
	 * Test method for {@link core.MessageScheduler#createReminderTimer(messageTypes.Message)}.
	 */
	@Test
	public void testCreateReminderTimer() {
		assertTrue(this.testScheduler.createReminderTimer(this.testEmail));
	}
	
	/**
	 * Test method for {@link core.MessageScheduler#createReminderTimer(messageTypes.Message)}.
	 */
	@Test (expected = Exception.class)
	public void testNullTimeCreateReminderTimer(){
		this.testEmail.setReminderTime(null);
		this.testScheduler.createReminderTimer(this.testEmail);
	}
	
	/**
	 * Test method for {@link core.MessageScheduler#createReminderTimer(messageTypes.Message)}.
	 */
	@Test (expected = Exception.class)
	public void testNullMessageCreateReminderTimer(){
		this.testEmail = null;
		this.testScheduler.createReminderTimer(this.testEmail);
	}

}
