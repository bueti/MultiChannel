package ch.zhaw.multichannel.test;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.zhaw.multichannel.core.MessageScheduler;
import ch.zhaw.multichannel.core.interfaces.IMessageScheduler;
import ch.zhaw.multichannel.messages.Email;


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
	
	@Test
	public void testCreateMessageTimer() {
		try {
			testScheduler.createMessageTimer(testEmail);
		} catch (Exception e) {
			fail("failed to create timer task " + e.getMessage());
		}
	}
	
	@Test (expected = Exception.class)
	public void testNullTimeCreateMessageTimer() throws Exception{
		testEmail.setSendTime(null);
		testScheduler.createMessageTimer(testEmail);
	}
	
	@Test (expected = Exception.class)
	public void testNullMessageCreateMessageTimer() throws Exception{
		testEmail = null;
		testScheduler.createMessageTimer(testEmail);
	}
	
	@Test
	public void testCreateReminderTimer() {
		try {
			testScheduler.createReminderTimer(testEmail);
		} catch (Exception e) {
			fail("failed to create reminder task " + e.getMessage());
		}
	}

	@Test (expected = Exception.class)
	public void testNullTimeCreateReminderTimer() throws Exception{
		testEmail.setReminderTime(null);
		testScheduler.createReminderTimer(testEmail);
	}
	
	@Test (expected = Exception.class)
	public void testNullMessageCreateReminderTimer() throws Exception{
		this.testEmail = null;
		this.testScheduler.createReminderTimer(this.testEmail);
	}

}
