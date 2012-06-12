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
     * @see MessageScheduler
     */
    private IMessageScheduler messageScheduler;
    
    /** 	
    * Default constructor for <code>MessageSender</code>
    * Creates <code>MessageScheduler</code> instance with the implemented interface
    * @param scheduler Instance of a class which implements the IMessageScheduler interface to schedule the messages 	
    */
    public MessageSender(IMessageScheduler scheduler){
    	this.messageScheduler = scheduler;
    }
    
    @Override
	public void sendMessage(Message msg) throws Exception {
    	if(msg==null){
    		throw new Exception("no message found");
    	}
    	
    	if(!msg.getSendLater()){
    		/*At the moment there is no need for exception handling here because
    		 * there is no real provider behind the send mechanism
    		 */
    		msg.send();
    		
    	} else {
    		try{
    			MultiChannelLogMonitor.getInstance().logInformation("Create timer task for msg: " + msg.getSubject() + " at " + msg.getSendTime().toString(), 2);
    			this.messageScheduler.createMessageTimer(msg);
    		}
    		catch(Exception timerException) {
    			throw new MessageSenderException(msg,timerException.getMessage());
    		}
    		
    		if(msg.getSendReminder()){
        		try{
        			MultiChannelLogMonitor.getInstance().logInformation("Create reminder task for msg: " + msg.getSubject() + " at " + msg.getSendTime().toString(), 2);
        			this.messageScheduler.createReminderTimer(msg);
        		}
        		catch(Exception timerException) {
        			throw new MessageSenderException(msg,timerException.getMessage());
        		}
    		}
    	}
    } 
}

