/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package ch.zhaw.multichannel.core;

import ch.zhaw.multichannel.core.interfaces.IMessageScheduler;
import ch.zhaw.multichannel.core.interfaces.IMessageSender;
import ch.zhaw.multichannel.exceptions.MessageSenderException;
import ch.zhaw.multichannel.gui.MultiChannelLogMonitor;
import ch.zhaw.multichannel.messages.Message;

/**
 * Class representing the handler for all sent messages, each message composed in
 * the gui will be handled by the <code>MessageSender</code> class. If a message should be sent
 * immediately the providers calls the send method of the message superclass, it
 * doesn't care which message type it is. If a message should be sent on a specific
 * time the <code>MessageSender</code> hands the message over to the <code>MessageScheduler</code>.
 * To keep the abstraction it implements the <code>IMessageSender</code> Interface.
 * 
 * @author  Yannik Kopp
 * @version 1.0
 * @see MessageScheduler
 * @see IMessageSender
 */
public class MessageSender implements IMessageSender{

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
    * Default constructor for <code>MessageSender</code>
    * Creates <code>MessageScheduler</code> instance with the implemented interface
    * @param pScheduler Instance of a class which implements the IMessageScheduler interface to schedule the messages 	
    */
    public MessageSender(IMessageScheduler pScheduler){
    	this.messageScheduler = pScheduler;
    	this.logMonitor = MultiChannelLogMonitor.getInstance();
    }
    
    //TODO document in interface
    /** 
     * This method is used to send a message, if it needs to be send right now
     * it just calls the send method of the super class, if it should be sent at a specific
     * time the <code>MessageSender</code> creates a new TimerTask with the <code>MessageScheduler</code>
     *
     * @param		msg Message to send
     * @return      boolean if message sending was successfully
     * @throws 		Exception 
     * @see         MessageSender
     */
    @Override
	public void sendMessage(Message msg) throws Exception {
    	if(msg==null){
    		throw new Exception("no message found");
    	}
    	
    	if(!msg.getSendLater()){
    		//TODO: Kann send() überhaupt fehlschlagen??
    		try {
    			msg.send();
    			//logMonitor.logInformation("Message send Successfully",1);
    		} catch(Exception senderException){
    			//logMonitor.logException(senderException);
    			throw new MessageSenderException(msg,senderException.getMessage());
    		}
    	} else {
    		try{
    			this.messageScheduler.createMessageTimer(msg);
    		}
    		catch(Exception timerException) {
    			throw new MessageSenderException(msg,timerException.getMessage());
    		}
    		
    		if(msg.getSendReminder()){
        		try{
        			this.messageScheduler.createReminderTimer(msg);
        		}
        		catch(Exception timerException) {
        			throw new MessageSenderException(msg,timerException.getMessage());
        		}
    		}
    	}
    } 
}

