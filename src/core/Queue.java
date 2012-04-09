package core;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import messageTypes.Message;

public class Queue {
	
	private static Queue instance = null;
	private Message nextMsg;
	private Map<Date,Message> messageList;
	
	private Queue(){
		 messageList = new HashMap<Date,Message>();
	}
	
    public static Queue getInstance() {
        if (instance == null) {
            instance = new Queue();
        }
        return instance;
    }
	
	public void addMessageToList(Message msg){
		
		if(this.nextMsg == null){
			this.nextMsg = msg;
		}
		if(msg.getSendTime().before(this.nextMsg.getSendTime())){
			this.nextMsg = msg;
		}
		
		messageList.put(msg.getSendTime(),msg);
	}
	
	public Message getNextMsg() {
		return nextMsg;
	}
	
	public void refreshNextMessage(){
		for (Entry<Date, Message> entry : messageList.entrySet()) {
		    Date key = entry.getKey();
		    Message msg = entry.getValue();
		    
		    if(nextMsg.getSendTime().after(key)){
		    	nextMsg = msg;
		    }
		}
	}
	
	
	
}
