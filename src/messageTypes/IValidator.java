/**
 * This package contains all the available messagetypes and also the superclass <Message>
 */
package messageTypes;

import exceptions.ValidationException;

/**
 * Each specific message type needs to implement its own validation
 *
 * @author  Yannik Kopp
 * @version 1.0
 */
public interface IValidator {
	
    /** 
     * Validates the message object of the implementing class
     *
     * @throws 		ValidationException Exception which contains the validation error and the msg recipient
     * @see         IMessageScheduler
     */
	boolean validate() throws ValidationException;
}
