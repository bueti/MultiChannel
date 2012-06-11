import gui.MultiChannelGUI;
import gui.MultiChannelLogMonitor;
import core.GUIHandler;
import core.MessageSender;
import core.MessageScheduler;

public class MultiChannel {

	public static void main(String[] args) {
		
		MessageScheduler scheduler = new MessageScheduler();
		
		MessageSender provider = new MessageSender(scheduler);
		
		GUIHandler guiHandler = new GUIHandler(provider);
		
		MultiChannelLogMonitor.getInstance();
		
		new MultiChannelGUI(guiHandler);
	}

}
