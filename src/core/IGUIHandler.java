/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package core;

import exceptions.ValidationException;

//TODO javadoc yak
public interface IGUIHandler {
	void sendMessage(MessageInfo info) throws ValidationException,Exception; 
}
