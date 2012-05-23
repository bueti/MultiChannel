package core;

import java.util.Timer;
import java.util.TimerTask;

import messageTypes.Message;


public class MessageScheduler implements IMessageScheduler{
	
	//TODO: WHAT HAPPENS IF TWO TIMERS ARE CREATED RIGHT AT THE SAME TIME??
	//REALY IMPORTANT TO CHECK THIS -> checked it one was no error, more tests required
	
	Timer timer;
	
	public MessageScheduler(){

		timer = new Timer();
	}

	public void createMessageTimer(Message msg) {
        timer.schedule(new SenderTask(msg), msg.getSendTime());
	}
	
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



