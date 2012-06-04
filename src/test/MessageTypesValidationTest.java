package test;

import static org.junit.Assert.*;

import messageTypes.Email;
import messageTypes.Print;
import messageTypes.Sms;

import org.junit.Before;
import org.junit.Test;

public class MessageTypesValidationTest {
	private Email testEmail;
	private Sms testSms;
	private Print testPrint;
	@Before
	public void setUp() throws Exception {
		this.testEmail = new Email("test@test.com","Test","This is a test email",null,null,null);
		
		this.testSms = new Sms("0791234567","Test","This is a test sms",null,null);
		
		this.testPrint = new Print("PRT 123","Test","This is a test print",null,null);
	}
	
	/**
	 * Test method for {@link messageTypes.Email#validate()}.
	 * Test method for {@link messageTypes.Sms#validate()}.
	 * Test method for {@link messageTypes.Print#validate()}.
	 */
	@Test
	public void testCorrectValidation(){
		try {
			assertTrue(this.testEmail.validate());
			assertTrue(this.testSms.validate());
			assertTrue(this.testPrint.validate());
		} catch (Exception e) {
			fail("This testCorrectValidation failed");
		}
	}
	
	/**
	 * Test method for {@link messageTypes.Email#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidTextEmailValidation() throws Exception {
		this.testEmail.setText("");
		this.testEmail.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Email#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidSubjectEmailValidation() throws Exception {
		this.testEmail.setSubject("");
		this.testEmail.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Sms#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidTextSMSValidation() throws Exception {
		this.testSms.setText("");
		this.testSms.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Sms#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidSubjectSMSValidation() throws Exception {
		this.testSms.setSubject("");
		this.testSms.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Print#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidTextPrintValidation() throws Exception {
		this.testPrint.setText("");
		this.testPrint.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Print#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidSubjectvValidation() throws Exception {
		this.testPrint.setSubject("");
		this.testPrint.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Email#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidEmailAdressValidation() throws Exception{
		this.testEmail.setRecipient("13245");
		this.testEmail.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Sms#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidSmsAdressValidation() throws Exception{
		this.testSms.setRecipient("abdc");
		this.testSms.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Print#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidPrintAdressValidation() throws Exception{
		this.testPrint.setRecipient("");
		this.testPrint.validate();
	}
	
	//TODO Maybe some more special testcases

}
