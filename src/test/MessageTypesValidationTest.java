package test;

import static org.junit.Assert.*;

import java.util.Date;

import messageTypes.Email;
import messageTypes.Print;
import messageTypes.Sms;

import org.junit.Before;
import org.junit.Test;

import core.MessageScheduler;

public class MessageTypesValidationTest {
	private Email testEmail;
	private Sms testSms;
	private Print testPrint;
	@Before
	public void setUp() throws Exception {
		this.testEmail = new Email();
		this.testEmail.setRecipient("test@test.com");
		this.testEmail.setSubject("Test");
		this.testEmail.setText("This is a test email");
		
		this.testSms = new Sms();
		this.testSms.setRecipient("0791234567");
		this.testSms.setSubject("Test");
		this.testSms.setText("This is a test sms");
		
		this.testPrint = new Print();
		this.testPrint.setRecipient("PRT 123");
		this.testPrint.setSubject("Test");
		this.testPrint.setText("This is a test print");
	}

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
	
	@Test (expected = Exception.class)
	public void testInvalidTextEmailValidation() throws Exception {
		this.testEmail.setText("");
		this.testEmail.validate();
	}
	
	@Test (expected = Exception.class)
	public void testInvalidSubjectEmailValidation() throws Exception {
		this.testEmail.setSubject("");
		this.testEmail.validate();
	}
	
	@Test (expected = Exception.class)
	public void testInvalidTextSMSValidation() throws Exception {
		this.testSms.setText("");
		this.testSms.validate();
	}
	
	@Test (expected = Exception.class)
	public void testInvalidSubjectSMSValidation() throws Exception {
		this.testSms.setSubject("");
		this.testSms.validate();
	}
	
	@Test (expected = Exception.class)
	public void testInvalidTextPrintValidation() throws Exception {
		this.testPrint.setText("");
		this.testPrint.validate();
	}
	
	@Test (expected = Exception.class)
	public void testInvalidSubjectvValidation() throws Exception {
		this.testPrint.setSubject("");
		this.testPrint.validate();
	}
	
	@Test (expected = Exception.class)
	public void testInvalidEmailAdressValidation() throws Exception{
		this.testEmail.setRecipient("13245");
		this.testEmail.validate();
	}
	
	@Test (expected = Exception.class)
	public void testInvalidSmsAdressValidation() throws Exception{
		this.testSms.setRecipient("abdc");
		this.testSms.validate();
	}
	
	@Test (expected = Exception.class)
	public void testInvalidPrintAdressValidation() throws Exception{
		this.testPrint.setRecipient("");
		this.testPrint.validate();
	}
	
	//TODO Maybe some more special testcases

}
