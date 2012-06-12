/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package ch.zhaw.multichannel.core.interfaces;

import ch.zhaw.multichannel.messages.Message;

/**
 * This Interface makes sure the <code>MessageScheduler</code> is easy replaceable. If there is a need
 * for another type of message scheduling the new scheduler only needs to implement this interface.
 *
 * @see IMessageScheduler
 * @author  Yannik Kopp
 * @version 1.0
 */
public interface IMessageScheduler {
	
    /** 
     * Creates a new TimerTask to send a message at a specific time
     *
     * @param		msg Message to send
     * @throws 		Exception 
     * @see         IMessageScheduler
     */
	public void createMessageTimer(Message msg) throws Exception;
	
    /** 
     * Creates a new ReminderTask to send a reminder of a message at a specific time
     *
     * @param		msg Message to send
     * @throws 		Exception 
     * @see         IMessageScheduler
     */
	public void createReminderTimer(Message msg) throws Exception;
}
