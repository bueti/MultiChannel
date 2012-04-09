package core;

import messageTypes.Message;

public class MessageProvider {
    private static MessageProvider instance = null;
    private IQueueHandler queueHandler;
 
    private MessageProvider() {
		QueueHandler handler = new QueueHandler();
		queueHandler = (IQueueHandler)handler;
    }
 
    public static MessageProvider getInstance() {
        if (instance == null) {
            instance = new MessageProvider();
        }
        return instance;
    }
    
    public String sendMessageNow(Message msg){
    	msg.send();
    	return null;
    }
    
    public String sendMessageLater(Message msg){
		queueHandler.addMessageToQueue(msg);
		
    	
    	return null;
    }
}

