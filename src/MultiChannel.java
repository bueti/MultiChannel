import gui.MultiChannelGUI;
import gui.MultiChannelLogMonitor;
import core.GUIHandler;
import core.MessageProvider;
import core.MessageScheduler;

public class MultiChannel {

	public static void main(String[] args) {
		
		MessageScheduler scheduler = new MessageScheduler();
		
		MessageProvider provider = new MessageProvider(scheduler);
		
		GUIHandler guiHandler = new GUIHandler(provider);
		
		MultiChannelLogMonitor.getInstance();
		
		new MultiChannelGUI(guiHandler);
	}

}
