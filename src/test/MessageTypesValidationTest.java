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
		testEmail = new Email("test@test.com","Test","This is a test email",null,null,null);
		
		testSms = new Sms("0791234567","Test","This is a test sms",null,null);
		
		testPrint = new Print("PRT 123","Test","This is a test print",null,null);
	}
	
	/**
	 * Test method for {@link messageTypes.Email#validate()}.
	 * Test method for {@link messageTypes.Sms#validate()}.
	 * Test method for {@link messageTypes.Print#validate()}.
	 */
	@Test
	public void testCorrectValidation(){
		try {
			assertTrue(testEmail.validate());
			assertTrue(testSms.validate());
			assertTrue(testPrint.validate());
		} catch (Exception e) {
			fail("This testCorrectValidation failed");
		}
	}
	
	/**
	 * Test method for {@link messageTypes.Email#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidTextEmailValidation() throws Exception {
		testEmail.setText("");
		testEmail.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Email#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidSubjectEmailValidation() throws Exception {
		testEmail.setSubject("");
		testEmail.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Sms#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidTextSMSValidation() throws Exception {
		testSms.setText("");
		testSms.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Sms#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidSubjectSMSValidation() throws Exception {
		testSms.setSubject("");
		testSms.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Print#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidTextPrintValidation() throws Exception {
		testPrint.setText("");
		testPrint.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Print#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidSubjectvValidation() throws Exception {
		testPrint.setSubject("");
		testPrint.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Email#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidEmailAdressValidation() throws Exception{
		testEmail.setRecipient("13245");
		testEmail.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Sms#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidSmsAdressValidation() throws Exception{
		testSms.setRecipient("abdc");
		testSms.validate();
	}
	
	/**
	 * Test method for {@link messageTypes.Print#validate()}.
	 */
	@Test (expected = Exception.class)
	public void testInvalidPrintAdressValidation() throws Exception{
		testPrint.setRecipient("");
		testPrint.validate();
	}
	
	//TODO Improvment: Maybe some more special testcases

}
