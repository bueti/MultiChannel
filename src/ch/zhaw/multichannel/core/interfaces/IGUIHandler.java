/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package ch.zhaw.multichannel.core.interfaces;

import ch.zhaw.multichannel.core.MessageInfo;
import ch.zhaw.multichannel.exceptions.ValidationException;

//TODO javadoc yak
public interface IGUIHandler {
	void sendMessage(MessageInfo info) throws ValidationException,Exception; 
}
