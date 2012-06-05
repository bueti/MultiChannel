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
 * To keep the abstraction it implements the <code>IMessageProvider</code> Interface.
 * 
 * @author  Yannik Kopp
 * @version 1.0
 * @see core.MessageScheduler
 * @see core.IMessageProvider
 */
public class MessageProvider implements IMessageProvider{

    /**
     *  <code>MessageScheduler<code> to send a message at a specific time
     *
     * @see #MessageScheduler()
     */
    private IMessageScheduler messageScheduler;
    
    /**
     *  <code>MultiChannelLogMonitor<code> to log different status messages and exceptions
     *
     * @see MultiChannelLogMonitor
     */
    private MultiChannelLogMonitor logMonitor;
    
    /** 	
    * Default constructor for <code>MessageProvider</code>
    * Creates <code>MessageScheduler</code> instance with the implemented interface
    * @param pScheduler Instance of a class which implements the IMessageScheduler interface to schedule the messages 	
    */
    public MessageProvider(IMessageScheduler pScheduler){
    	this.messageScheduler = pScheduler;
    	this.logMonitor = MultiChannelLogMonitor.getInstance();
    }
    
    /** 
     * This method is used to send a message, if it needs to be send right now
     * it just calls the send method of the super class, if it should be sent at a specific
     * time the <code>MessageProvider</code> creates a new TimerTask with the <code>MessageScheduler</code>
     *
     * @param		msg Message to send
     * @return      boolean if message sending was successfully
     * @see         MessageProvider
     */
    @Override
	public boolean sendMessage(Message msg) {
    	
    	if(msg==null){
    		//TODO: Log to logger
    		return false;
    	}
    	
    	if(!msg.getSendLater()){
    		try {
    			msg.send();
    			this.logMonitor.logInformation("Message send Successfully",1);
    		} catch(Exception e){
    			this.logMonitor.logException(e);
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

