/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package core;

import gui.MultiChannelLogMonitor;
import messageTypes.Message;

/**
 * Class representing the handler for all sent messages, each message composed in
 * the gui will be handled by the <code>MessageProvider</code> class. If a message should be sent
 * immediately the providers calls the send method of the message superclass, it
 * doesn't care which message type it is. If a message should be sent on a specific
 * time the <code>MessageProvider</code> hands the message over to the <code>MessageScheduler</code>.
 * 
 * @author  Yannik Kopp
 * @version 1.0
 * @see core.MessageScheduler
 */
public class MessageProvider {
    /**
     * Instance of <code>MessageProvider</code> class, is used to implement the singleton pattern
     *
     * @see #getInstance()
     */
    private static MessageProvider _instance = null;
    
    /**
     *  <code>MessageScheduler<code> to send a message at a specific time
     *
     * @see #getInstance()
     */
    private IMessageScheduler messageScheduler;
    
    /** 	
    * Default constructor for <code>MessageProvider</code>
    * Creates <code>MessageScheduler</code> instance with the implemented interface 	
    */
    private MessageProvider(IMessageScheduler pScheduler){
    	this.messageScheduler = pScheduler;
    }
    
    
    /**
     * Method to send a message right after the send button is clicked.
     * Returns always the same insance of the <code>MessageProvider</code> object, this is
     * used to make sure only one object of this class is used.
     * This pattern is called singleton. 
     * <p>
     * If no object is existing a new one will be created
     *
     * @return      An instance of and object of the <code>MessageProvider</code> class
     * @see         MessageProvider
     */
    public static MessageProvider getInstance(IMessageScheduler scheduler) {
        if (_instance == null) {
            _instance = new MessageProvider(scheduler);
        }
        return _instance;
    }
    
    /** This method is used to send a message, if it needs to be send right now
     * it just calls the send method of the super class, if it should be sent at a specific
     * time the <code>MessageProvider</code> creates a new TimerTask with the <code>MessageScheduler</code>
     *
     * @param		msg Message to send
     * @return      tbd
     * @see         MessageProvider
     */
    public boolean sendMessage(Message msg) {
    	
    	if(!msg.getSendLater()){
    		try {
    			msg.send();
    			//TODO use logger to say that message is sent successfully
    			MultiChannelLogMonitor.getInstance().logInformation("Message send Successfully",1);
    		} catch(Exception e){
    			//TODO Use Logger to log error
    			return false;
    		}
    	} else {
    		if(!this.messageScheduler.createMessageTimer(msg)) {
    			return false;
    		}
    		
    		if(msg.getSendReminder()){
    			if(!this.messageScheduler.createReminderTimer(msg)) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    } 
}

