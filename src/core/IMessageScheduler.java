/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package core;

import messageTypes.Message;

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
     * @return      boolean if the scheduling was succesfully
     * @see         IMessageScheduler
     */
	public boolean createMessageTimer(Message msg);
	
    /** 
     * Creates a new ReminderTask to send a reminder of a message at a specific time
     *
     * @param		msg Message to send
     * @return      boolean if the scheduling was succesfully
     * @see         IMessageScheduler
     */
	public boolean createReminderTimer(Message msg);
}
