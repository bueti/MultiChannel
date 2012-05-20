package core;

import java.util.Timer;

import messageTypes.Message;

public class MessageProvider {
    private static MessageProvider _instance = null;
    private IMessageScheduler messageScheduler;
 
    private MessageProvider() {
		MessageScheduler scheduler = new MessageScheduler();
		this.messageScheduler = (IMessageScheduler)scheduler;
    }
    
    /**
     * Returns always the same insance of the MessageProvider object, this is
     * used to make sure only one object of this class is used.
     * This pattern is called singleton. 
     * <p>
     * If no object is existing a new one will be created
     *
     * @return      An instace of and object of the MessageProvider class
     * @see         MessageProvider
     */
    public static MessageProvider getInstance() {
        if (_instance == null) {
            _instance = new MessageProvider();
        }
        return _instance;
    }
    
    /**
     * Method to send a message right after the send button is clicked.
     * The type of the message doesn't matter because this method only
     * calls the send method of the superclass
     * <p>
     *
     * @param		msg Message to send
     * @return      tbd
     * @see         MessageProvider
     */
    public String sendMessageNow(Message msg) {
    	// TODO: Übergabe Empfänger und Nachricht
    	// TODO: Try catch falls versenden failt
    	msg.send();
    	
    	//TODO: return wirklich nötig?
    	return null;
    }
    
    /**
     * This method creates a timer task if a message needs to be send
     * at a specific time. It also checks if a reminder should be sent
     * before the original message.
     * <p>
     *
     * @param		msg Message to send
     * @return      tbd
     * @see         MessageProvider
     */
    public String sendMessageLater(Message msg){
    	if(msg.getSendLater()){
    		this.messageScheduler.createMessageTimer(msg);
    		
    		if(msg.getSendReminder()){
    			this.messageScheduler.createReminderTimer(msg);
    		}
    	}
    	
    	return null;
    }
    
    
}

