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
 * @see MessageScheduler
 * @author  Yannik Kopp
 * @version 1.0
 */
public interface IMessageScheduler {
	public boolean createMessageTimer(Message msg);
	public boolean createReminderTimer(Message msg);
}
