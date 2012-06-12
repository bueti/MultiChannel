/**
 * 
 */
package ch.zhaw.multichannel.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ch.zhaw.multichannel.core.GUIHandler;
import ch.zhaw.multichannel.core.MessageInfo;


/**
 * @author yannik
 *
 */
public class GUIHandlerTest {
	
	private GUIHandler testHandler;
	private MessageInfo testInfo;
	private ArrayList<String> receipientList;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockMessageSender provider = new MockMessageSender();
		receipientList = new ArrayList<String>();
		testInfo = new MessageInfo("","test","test",null,null,null,null);
		testHandler = new GUIHandler(provider);
	}

	/**
	 * Test method for {@link ch.zhaw.multichannel.core.GUIHandler#sendMessage(ch.zhaw.multichannel.core.MessageInfo)}.
	 */
	@Test
	public void testSendEmailSingleMessage() {
		this.testInfo.setRecipient("test@test.com");
		testInfo.setType("Email");
		try {
			this.testHandler.sendMessage(testInfo);			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link ch.zhaw.multichannel.core.GUIHandler#sendMessage(ch.zhaw.multichannel.core.MessageInfo)}.
	 */
	@Test
	public void testSendEmailMultipleMessage() {
		this.receipientList.add("test@test.com");
		this.receipientList.add("test2@test.com");
		this.receipientList.add("test3@test.com");
		testInfo.setType("Email");
		for(String recipient : this.receipientList){
			testInfo.setRecipient(recipient);
			try{
				this.testHandler.sendMessage(testInfo);
			}catch(Exception e){
				fail(e.getMessage());
			}
		}
	}
	
	//TODO: Add fail tests

}
