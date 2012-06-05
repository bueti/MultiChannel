/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import core.GUIHandler;
import core.MessageInfo;

/**
 * @author yannik
 *
 */
public class GUIHandlerTest {
	
	private GUIHandler testHandler;
	private MessageInfo testInfo;
	private ArrayList receipientList;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockMessageProvider provider = new MockMessageProvider();
		receipientList = new ArrayList<String>();
		testInfo = new MessageInfo(receipientList,"test","test",null,null,null,null);
		testHandler = new GUIHandler(provider);
	}

	/**
	 * Test method for {@link core.GUIHandler#sendMessage(core.MessageInfo)}.
	 */
	@Test
	public void testSendEmailSingleMessage() {
		this.receipientList.add("test@test.com");
		testInfo.setRecipients(receipientList);
		testInfo.setType("Email");
		try {
			if(!this.testHandler.sendMessage(testInfo).isEmpty()){
				fail("Could not send test message");
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link core.GUIHandler#sendMessage(core.MessageInfo)}.
	 */
	@Test
	public void testSendEmailMultipleMessage() {
		this.receipientList.add("test@test.com");
		this.receipientList.add("test2@test.com");
		this.receipientList.add("test3@test.com");
		testInfo.setRecipients(receipientList);
		testInfo.setType("Email");
		try {
			if(!this.testHandler.sendMessage(testInfo).isEmpty()){
				fail("Could not send test message");
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	//TODO: Add fail tests

}
