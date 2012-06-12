/**
 * Provides the classes to handle the sending and scheduling mechanisms for the
 * messages in the MultiChannel project 
 */
package core;

import java.util.Timer;
import java.util.TimerTask;

import messageTypes.Message;

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
	
	/**
	 * Uses the <code>java.util.Timer</code> to schedule the message
	 * @throws Exception 
	 * @see java.util.Timer
	 * {@inheritDoc}
	 */
	@Override
	public void createMessageTimer(Message msg) throws Exception {
		try{
			timer.schedule(new SenderTask(msg), msg.getSendTime());
		}
		catch(IllegalArgumentException ex){
			//TODO Log to logger
			throw new Exception(ex.getMessage());
		}
		catch(IllegalStateException ex){
			//TODO Log to logger
			throw new Exception(ex.getMessage());
		}
	}
	
	/**
	 * Uses the <code>java.util.Timer</code> to schedule the reminder
	 * @throws Exception 
	 * @see java.util.Timer
	 * {@inheritDoc}
	 */
	@Override
	public void createReminderTimer(Message msg) throws Exception {
		try{
			timer.schedule(new ReminderTask(msg), msg.getReminderTime());
		}
		catch(IllegalArgumentException ex){
			//TODO Log to logger
			throw new Exception(ex.getMessage());
		}
		catch(IllegalStateException ex){
			//TODO Log to logger
			throw new Exception(ex.getMessage());
		}
	}
	
	//TODO: messagescheduler javadoc
	private class SenderTask extends TimerTask {
		
		private Message msg;
		
		public SenderTask(Message pmsg)
		{
			this.msg = pmsg;
		}
		
	    @Override
		public void run() {
	    	try{
	    		msg.send();
	    	}catch(Exception ex) {
	    		//TODO log to logger
	    		//MultiChannelLogMonitor.getInstance().writeLogEntry(, status)
	    	}
	    }
	}
	
	private class ReminderTask extends TimerTask {
		
		private Message msg;
		
		public ReminderTask(Message msg)
		{
			this.msg = msg;	
		}
		
		@Override
		public void run() {
			try {
				msg.sendReminder();
			} catch (Exception ex) {
				// TODO Log to error console
			}
	    }
	}
	
	

}



