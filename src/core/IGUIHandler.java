/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package core;

import java.util.ArrayList;

public interface IGUIHandler {
	ArrayList<String> sendMessage(MessageInfo info) throws Exception; 
}
