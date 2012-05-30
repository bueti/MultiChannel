import gui.MultiChannelGUI;
import gui.MultiChannelLogMonitor;
import core.GUIHandler;

public class MultiChannel {

	public static void main(String[] args) {
		
		GUIHandler guiHandler = new GUIHandler();
		
		MultiChannelLogMonitor.getInstance();
		
		new MultiChannelGUI(guiHandler);
	}

}
