/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package ch.zhaw.multichannel.core;

import java.util.Timer;
import java.util.TimerTask;

import ch.zhaw.multichannel.core.interfaces.IMessageScheduler;
import ch.zhaw.multichannel.core.interfaces.IMessageSender;
import ch.zhaw.multichannel.gui.MultiChannelLogMonitor;
import ch.zhaw.multichannel.messages.Message;


/**
 * Class representing the scheduler for all sent messages with a specified send time
 * or a remindertime. To schedule the messages and reminders the <code>java.util.Timer</code>
 * is used, it provides an easy access to the needed scheduling classes. To keep the abstraction 
 * it implements the <code>IMessageScheduler</code> Interface. So if at some point a more powerfull
 * scheduling class is used it just needs to implement this interface
 * 
 * @author  Yannik Kopp
 * @version 1.0
 * @see IMessageScheduler
 * @see IMessageSender
 */
public class MessageScheduler implements IMessageScheduler{
	
	/**
	 * is used to schedule the messages and reminders
	 */
	private Timer timer;
	
    /** 	
    * Default constructor for the </code>MessageScheduler</code> class, it just creates
    * a instance of the java.util.Timer to schedule the reminder and messages
    * 
    * @see java.util.Timer
    */
	public MessageScheduler(){

		timer = new Timer();
	}
	
	@Override
	public void createMessageTimer(Message msg) throws Exception {
		try{
			timer.schedule(new SenderTask(msg), msg.getSendTime());
		}
		catch(IllegalArgumentException ex){
			throw new Exception(ex.getMessage());
		}
		catch(IllegalStateException ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	@Override
	public void createReminderTimer(Message msg) throws Exception {
		try{
			timer.schedule(new ReminderTask(msg), msg.getReminderTime());
		}
		catch(IllegalArgumentException ex){
			throw new Exception(ex.getMessage());
		}
		catch(IllegalStateException ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	/**
	 * Represents a task for the timer to send a message at a specific time
	 * 
	 * @author  Yannik Kopp
	 * @version 1.0
	 * @see java.util.TimerTask
	 */
	private class SenderTask extends TimerTask {
		
		/**
		 * Message to send when the timer schedules the task
		 */
		private Message msg;
		
		/**
		 * Constructor to set the message to send
		 * 
		 * @param msg message to send
		 */
		public SenderTask(Message msg)
		{
			this.msg = msg;
		}
		
	    @Override
		public void run() {
	    	try{
	    		msg.send();
	    	}catch(Exception ex) {
	    		MultiChannelLogMonitor.getInstance().logInformation("Message sending failed because: "+ ex.getMessage(),3);
	    	}
	    }
	}
	
	/**
	 * Represents a task for the timer to send a reminder of a message at a specific time
	 * 
	 * @author  Yannik Kopp
	 * @version 1.0
	 * @see java.util.TimerTask
	 */
	private class ReminderTask extends TimerTask {
		
		/**
		 * Message to send the reminder for when the timer schedules the task
		 */
		private Message msg;
		
		/**
		 * Constructor to set the message to send
		 * 
		 * @param msg message to take the reminder from
		 */
		public ReminderTask(Message msg)
		{
			this.msg = msg;	
		}
		
		@Override
		public void run(){
			try {
				msg.sendReminder();
			} catch (Exception ex) {
				MultiChannelLogMonitor.getInstance().logInformation("Message sending failed because: "+ ex.getMessage(),3);
			}
	    }
	}
	
	

}



