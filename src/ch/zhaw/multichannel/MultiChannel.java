/**
 * Contains the main class and method for the MultiChannel application 
 */
package ch.zhaw.multichannel;

import ch.zhaw.multichannel.core.GUIHandler;
import ch.zhaw.multichannel.core.MessageScheduler;
import ch.zhaw.multichannel.core.MessageSender;
import ch.zhaw.multichannel.gui.MultiChannelGUI;
import ch.zhaw.multichannel.gui.MultiChannelLogMonitor;

/**
 * Main class for the application MultiChannel creates GUI, GUIHandler, MessageScheduler,
 * and MessageSender
 * 
 * @author yannik
 * @version 1.0
 */
public class MultiChannel {
	
	/**
	 * Main method, creates all needed objects to run the application
	 * inclusive GUI
	 *
	 *@see MessageScheduler
	 *@see MessageSender
	 *@see GUIHandler
	 *@see MultiChannelLogMonitor
	 */
	public static void main(String[] args) {
		
		MessageScheduler scheduler = new MessageScheduler();
		
		MessageSender provider = new MessageSender(scheduler);
		
		GUIHandler guiHandler = new GUIHandler(provider);
		
		new MultiChannelGUI(guiHandler);
	}

}
