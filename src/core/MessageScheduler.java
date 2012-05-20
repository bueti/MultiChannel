package core;

import java.util.Timer;
import java.util.TimerTask;

import messageTypes.Message;


public class MessageScheduler implements IMessageScheduler{
	
	Timer timer;
	
	public MessageScheduler(){

		timer = new Timer();
	}

	//TODO: Maybe change to Calendar type
	public void createMessageTimer(Message msg) {
        timer.schedule(new SenderTask(msg), msg.getSendTime());
	}
	
	//TODO: Maybe change to Calendar type
	public void createReminderTimer(Message msg) {
        timer.schedule(new ReminderTask(msg), msg.getReminderTime());
	}
	
	class SenderTask extends TimerTask {
		
		private Message msg;
		
		public SenderTask(Message pmsg)
		{
			this.msg = pmsg;
		}
		
	    public void run() {
	        this.msg.send();
	    }
	}
	
	class ReminderTask extends TimerTask {
		
		private Message msg;
		
		public ReminderTask(Message pmsg)
		{
			this.msg = pmsg;	
		}
		
	    public void run() {
	        this.msg.sendReminder();
	    }
	}
	
	

}



