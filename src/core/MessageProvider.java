package core;

import java.util.Timer;

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
    
    public String sendMessageNow(Message msg) {
    	// TODO: Übergabe Empfänger und Nachricht
    	// TODO: Try catch falls versenden failt
    	msg.send();
    	
    	//TODO: return wirklich nötig?
    	return null;
    }
}

