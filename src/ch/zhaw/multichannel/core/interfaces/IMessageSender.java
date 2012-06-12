/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package ch.zhaw.multichannel.core.interfaces;

import ch.zhaw.multichannel.core.MessageSender;
import ch.zhaw.multichannel.messages.Message;

/**
 * This Interface makes sure the <code>MessageSender</code> is easy replaceable. If there is a need
 * for another type of message providing the new provider only needs to implement this interface.
 * Its also very useful for the unit tests because it gives us the possibility to implement a MockObject
 *
 * @see MessageSender
 * @author  Yannik Kopp
 * @version 1.0
 */
public interface IMessageSender {
	
    /** 
     * This method is used to send a message, if it needs to be send right now
     * it just calls the send method of the super class, if it should be sent at a specific
     * time the <code>MessageSender</code> creates a new TimerTask with the <code>MessageScheduler</code>
     *
     * @param		msg Message to send
     * @throws 		Exception thrown if a exception happens during the message sending
     * @see         MessageSender
     */
	public void sendMessage(Message msg) throws Exception;
}
