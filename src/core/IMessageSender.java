/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package core;

import messageTypes.Message;

/**
 * This Interface makes sure the <code>MessageSender</code> is easy replaceable. If there is a need
 * for another type of message providing the new provider only needs to implement this interface.
 * Its also very useful for the unittests because it gives us the possibility to implement a MockObject
 *
 * @see MessageSender
 * @author  Yannik Kopp
 * @version 1.0
 */
public interface IMessageSender {
	
    /** 
     * This method is used to send a message, if it needs to be send right now
     * it just calls the send method of the super class, if its supposed to be sent
     * later or with a reminder the decision what happens is made in this method
     *
     * @param		msg Message to send
     * @return      boolean if message sending was successfully
     * @throws		Exception Sender exception
     * @see         IMessageSender
     */
	public void sendMessage(Message msg) throws Exception;
}
