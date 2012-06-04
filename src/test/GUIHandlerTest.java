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
		ArrayList receipientList = new ArrayList<String>();
		testInfo = new MessageInfo(receipientList,"test","test",null,null,null,null);
		testHandler = new GUIHandler(provider);
	}

	/**
	 * Test method for {@link core.GUIHandler#sendMessage(core.MessageInfo)}.
	 */
	@Test
	public void testSendMessage() {
		fail("Not yet implemented");
	}

}
