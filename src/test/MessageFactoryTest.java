package test;

import junit.framework.TestCase;

import messageTypes.Email;
import messageTypes.Mms;
import messageTypes.Print;
import messageTypes.Sms;

import org.junit.Test;

import core.MessageFactory;

public class MessageFactoryTest extends TestCase
{
	private Email testEmail;
	private Sms testSms;
	private Mms testMms;
	private Print testPrint;
	
	@Override
	public void setUp(){
		this.testEmail = new Email("test@test.com","test","test",null,null,null);
		this.testSms = new Sms("0791234567","test","test",null,null);
		this.testMms = new Mms("0791234567","test","test",null,null,null);
		this.testPrint = new Print("PRT 21","test","test",null,null);
	}
	
	@Test
	public void testCreateNewEmail() {
		Object testObj = MessageFactory.createNewMessage("test@test.com", "test", "test", "Email", null, null, null);
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
	
	@Test
	public void testCreateNewSms() {
		Object testObj = MessageFactory.createNewMessage("0791234567","test","test","Sms",null,null, null);
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
	
	@Test
	public void testCreateNewMms() {
		Object testObj = MessageFactory.createNewMessage("0791234567","test","test","Mms",null,null,null);
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
	
	@Test
	public void testCreateNewPrint() {
		Object testObj = MessageFactory.createNewMessage("PRT 21","test","test","Print",null,null,null);
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
	
	@Test
	public void testInvalidMessageType(){
		assertEquals(null, MessageFactory.createNewMessage("invalid", "invalid", "invalid", "Picture", null, null, null));
	}
}
