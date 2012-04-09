package core;

import messageTypes.Message;

public interface IQueueHandler {
	public void addMessageToQueue(Message msg);
	public Message getNextMessage();
	public void refreshNextMessage();
}
