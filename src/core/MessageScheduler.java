package core;

import java.util.Timer;
import java.util.TimerTask;

import messageTypes.Message;


public class MessageScheduler implements IMessageScheduler{
	
	Timer timer;
	
	public MessageScheduler(){

		timer = new Timer();
	}

	@Override
	public boolean createMessageTimer(Message msg) {
		try{
			timer.schedule(new SenderTask(msg), msg.getSendTime());
		}
		catch(IllegalArgumentException ex){
			//TODO Log to logger
			return false;
		}
		catch(IllegalStateException ex){
			//TODO Log to logger
			return false;
		}
		return true;
	}
	
	@Override
	public boolean createReminderTimer(Message msg) {
		try{
			timer.schedule(new ReminderTask(msg), msg.getReminderTime());
		}
		catch(IllegalArgumentException ex) {
			//TODO Log to logger
			return false;
		}
		catch(IllegalStateException ex) {
			//TODO Log to logger
			return false;
		}
		return true;
	}
	
	class SenderTask extends TimerTask {
		
		private Message msg;
		
		public SenderTask(Message pmsg)
		{
			this.msg = pmsg;
		}
		
	    @Override
		public void run() {
	    	try{
	    		this.msg.send();
	    	}catch(Exception ex) {
	    		//MultiChannelLogMonitor.getInstance().writeLogEntry(, status)
	    	}
	    }
	}
	
	class ReminderTask extends TimerTask {
		
		private Message msg;
		
		public ReminderTask(Message pmsg)
		{
			this.msg = pmsg;	
		}
		
		@Override
		public void run() {
			try {
				this.msg.sendReminder();
			} catch (Exception ex) {
				// TODO Log to error console
			}
	    }
	}
	
	

}



