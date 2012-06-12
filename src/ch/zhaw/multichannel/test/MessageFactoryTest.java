package ch.zhaw.multichannel.test;

import junit.framework.TestCase;


import org.junit.Test;

import ch.zhaw.multichannel.core.MessageFactory;
import ch.zhaw.multichannel.core.MessageInfo;
import ch.zhaw.multichannel.exceptions.ValidationException;
import ch.zhaw.multichannel.messages.Email;
import ch.zhaw.multichannel.messages.Mms;
import ch.zhaw.multichannel.messages.Print;
import ch.zhaw.multichannel.messages.Sms;


public class MessageFactoryTest extends TestCase
{
	private Email testEmail;
	private Sms testSms;
	private Mms testMms;
	private Print testPrint;
	private MessageInfo testInfo;
	
	@Override
	public void setUp(){
		try {
			testEmail = new Email("test@test.com","test","test",null,null,null);
			testSms = new Sms("0791234567","test","test",null,null);
			testMms = new Mms("0791234567","test","test",null,null,null);
			testPrint = new Print("PRT 21","test","test",null,null);
			testInfo = new MessageInfo(null,"test","test",null,null,null,null);
		} catch (Exception e) {
			fail("setup failed");
		}

	}
	
	/**
	 * Test method for {@link ch.zhaw.multichannel.core.MessageFactory#createNewMessage(string,ch.zhaw.multichannel.core.MessageInfo)}.
	 */
	@Test
	public void testCreateNewEmail() {
		testInfo.setType("Email");
		testInfo.setRecipient("test@test.com");
		Object testObj = null;
		try {
			testObj = MessageFactory.createNewMessage(this.testInfo);
		} catch (Exception e) {
			fail("Message creation failed");
		}
		if(testObj instanceof Email){
			Email newEmail = (Email)testObj;
			if(!newEmail.getRecipient().equals(testEmail.getRecipient())){
				fail("The receipients are not the same");
			}
			if(!newEmail.getSubject().equals(testEmail.getSubject())){
				fail("The subjects are not the same");
			}
			if(!newEmail.getText().equals(testEmail.getText())){
				fail("The subjects are not the same");
			}
		}else{
			fail("The created Object is wrong");
		}
	}
	
	/**
	 * Test method for {@link ch.zhaw.multichannel.core.MessageFactory#createNewMessage(string,ch.zhaw.multichannel.core.MessageInfo)}.
	 */
	@Test
	public void testCreateNewSms() {
		testInfo.setType("Sms");
		testInfo.setRecipient("0791234567");
		Object testObj = null;
		try {
			testObj = MessageFactory.createNewMessage(testInfo);
		} catch (Exception e) {
			fail("Message creation failed");
		}
		if(testObj instanceof Sms){
			Sms newSms = (Sms)testObj;
			if(!newSms.getRecipient().equals(testSms.getRecipient())){
				fail("The receipients are not the same");
			}
			if(!newSms.getSubject().equals(testSms.getSubject())){
				fail("The subjects are not the same");
			}
			if(!newSms.getText().equals(testSms.getText())){
				fail("The subjects are not the same");
			}
		}else{
			fail("The created Object is wrong");
		}
	}
	
	/**
	 * Test method for {@link ch.zhaw.multichannel.core.MessageFactory#createNewMessage(string,ch.zhaw.multichannel.core.MessageInfo)}.
	 */
	@Test
	public void testCreateNewMms() {
		testInfo.setType("Mms");
		testInfo.setRecipient("0791234567");
		Object testObj = null;
		try {
			testObj = MessageFactory.createNewMessage(testInfo);
		} catch (Exception e) {
			fail("Message creation failed");
		}
		if(testObj instanceof Mms){
			Mms newMms = (Mms)testObj;
			if(!newMms.getRecipient().equals(testMms.getRecipient())){
				fail("The receipients are not the same");
			}
			if(!newMms.getSubject().equals(testMms.getSubject())){
				fail("The subjects are not the same");
			}
			if(!newMms.getText().equals(testMms.getText())){
				fail("The subjects are not the same");
			}
		}else{
			fail("The created Object is wrong");
		}
	}
	
	/**
	 * Test method for {@link ch.zhaw.multichannel.core.MessageFactory#createNewMessage(string,ch.zhaw.multichannel.core.MessageInfo)}.
	 */
	@Test
	public void testCreateNewPrint() {
		testInfo.setRecipient("PRT 21");
		testInfo.setType("Print");
		Object testObj = null;
		try {
			testObj = MessageFactory.createNewMessage(testInfo);
		} catch (Exception e) {
			fail("Message creation failed");
		}
		if(testObj instanceof Print){
			Print newPrint = (Print)testObj;
			if(!newPrint.getRecipient().equals(testPrint.getRecipient())){
				fail("The receipients are not the same");
			}
			if(!newPrint.getSubject().equals(testPrint.getSubject())){
				fail("The subjects are not the same");
			}
			if(!newPrint.getText().equals(testPrint.getText())){
				fail("The subjects are not the same");
			}
		}else{
			fail("The created Object is wrong");
		}
	}
	
	/**
	 * Test method for {@link ch.zhaw.multichannel.core.MessageFactory#createNewMessage(string,ch.zhaw.multichannel.core.MessageInfo)}.
	 */
	@Test (expected=ValidationException.class)
	public void testInvalidValidation() {
		testInfo.setType("Email");
		testInfo.setRecipient("1234");
	}
}
