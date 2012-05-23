/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package core;

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
    private MessageProvider(){
    	MessageScheduler scheduler = new MessageScheduler();
    	this.messageScheduler = (IMessageScheduler)scheduler;
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
    public static MessageProvider getInstance() {
        if (_instance == null) {
            _instance = new MessageProvider();
        }
        return _instance;
    }
    
    
    //TODO: Merge these two comments
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
  //TODO: Merge these two comments
    /**
     * Send a message after the send button is clicked.
     * The type of the message doesn't matter because this method only
     * calls the send method of the superclass
     * <p>
     *
     * @param		msg Message to send
     * @return      tbd
     * @see         MessageProvider
     */
    public boolean sendMessage(Message msg) {
    	
    	if(!msg.getSendLater()){
    		try{
    			msg.send();
    		}catch(Exception e){
    			//TODO Use Logger to log error
    			return false;
    		}
    	}else{
    		//TODO: ADD Exception handling
    		this.messageScheduler.createMessageTimer(msg);
    		
    		if(msg.getSendReminder()){
    			this.messageScheduler.createReminderTimer(msg);
    		}
    	}
    	
    	return true;
    } 
}

