package ch.zhaw.multichannel;
import ch.zhaw.multichannel.core.GUIHandler;
import ch.zhaw.multichannel.core.MessageScheduler;
import ch.zhaw.multichannel.core.MessageSender;
import ch.zhaw.multichannel.gui.MultiChannelGUI;
import ch.zhaw.multichannel.gui.MultiChannelLogMonitor;

public class MultiChannel {

	public static void main(String[] args) {
		
		MessageScheduler scheduler = new MessageScheduler();
		
		MessageSender provider = new MessageSender(scheduler);
		
		GUIHandler guiHandler = new GUIHandler(provider);
		
		MultiChannelLogMonitor.getInstance();
		
		new MultiChannelGUI(guiHandler);
	}

}
