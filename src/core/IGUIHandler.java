/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package core;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IGUIHandler {
	ArrayList<String> sendMessage(MessageInfo info) throws Exception; 
}
