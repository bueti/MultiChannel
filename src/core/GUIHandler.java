/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package core;

import java.util.ArrayList;
import messageTypes.Message;

/**
 * The GUIHandler class is used to encapsulate the businesslogic from the GUI.
 * It implements the interface <code>IGUIHandler</code> to make it easy
 * replaceable by another handler.
 * 
 * @author Yannik Kopp
 * @version 1.0
 * @see core.IGUIHandler
 */
public class GUIHandler implements IGUIHandler {

	/**
	 * Instance of <code>MessageProvider</code> class, which is used to send the
	 * message immediately or at a specific time
	 * 
	 * @see MessageProvider
	 */
	IMessageProvider provider;

	/**
	 * Default constructor for <code>GUIHandler</code>.
	 * 
	 * @param pProvider Instance of a <code>IMessageProvider</code> object
	 * @See MessageProvider
	 * @see IMessageProvider
	 */
	public GUIHandler(IMessageProvider pProvider) {
		this.provider = pProvider;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<String> sendMessage(MessageInfo info) throws Exception {
		// TODO ANALYZE THIS!!
		ArrayList<String> errorList = new ArrayList<String>();

		for (String recipient : info.getRecipients()) {
			Message newMsg = null;
			String errorMsg = "";

			newMsg = MessageFactory.createNewMessage(recipient, info);
			if (newMsg == null) {
				errorMsg = "Ungültiger MessageType gewählt!";
			} else {
				try {
					newMsg.validate();
				} catch (Exception ex) {
					errorMsg = ex.getMessage();
				}
			}

			if (errorMsg.isEmpty()) {
				if (!this.provider.sendMessage(newMsg)) {
					errorMsg = "Message versenden fehlgeschlagen!";
				}
			}
			if (!errorMsg.isEmpty()) {
				errorList.add(errorMsg);
			}
		}
		return errorList;
	}

}
