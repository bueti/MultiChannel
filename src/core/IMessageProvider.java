/**
 * 
 */
package core;

import messageTypes.Message;

/**
 * @author yannik
 *
 */
public interface IMessageProvider {
	public boolean sendMessage(Message msg);
}
