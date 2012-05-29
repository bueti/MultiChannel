package core;

import java.util.Timer;
import java.util.TimerTask;

import messageTypes.Message;


public class MessageScheduler implements IMessageScheduler{
	
	//TODO: WHAT HAPPENS IF TWO TIMERS ARE CREATED RIGHT AT THE SAME TIME??
	//REALY IMPORTANT TO CHECK THIS -> checked it once was no error, more tests required
	
	Timer timer;
	
	public MessageScheduler(){

		timer = new Timer();
	}

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
	
	public boolean createReminderTimer(Message msg) {
		try{
			timer.schedule(new ReminderTask(msg), msg.getReminderTime());
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
	
	class SenderTask extends TimerTask {
		
		private Message msg;
		
		public SenderTask(Message pmsg)
		{
			this.msg = pmsg;
		}
		
	    public void run() {
	    	try{
	    		this.msg.send();
	    	}catch(Exception ex){
	    		//TODO Log to error console
	    	}
	    }
	}
	
	class ReminderTask extends TimerTask {
		
		private Message msg;
		
		public ReminderTask(Message pmsg)
		{
			this.msg = pmsg;	
		}
		
	    public void run() {
	        try{
	        	this.msg.sendReminder();
	        }catch(Exception ex){
	        	//TODO Log to error console
	        }
	    }
	}
	
	

}



