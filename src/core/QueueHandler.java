package core;

import messageTypes.Message;

public class QueueHandler implements IQueueHandler{
	
	private Queue messageQueue;
	
	public QueueHandler(){
		this.messageQueue = Queue.getInstance();
	}

	public void addMessageToQueue(Message msg) {
		this.messageQueue.addMessageToList(msg);
	}

	public Message getNextMessage() {
		return null;
		
		
	}

	public void refreshNextMessage() {
		
		
	}
	

}
