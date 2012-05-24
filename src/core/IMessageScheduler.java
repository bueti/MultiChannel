package core;

import messageTypes.Message;

public interface IMessageScheduler {
	public void createMessageTimer(Message msg);
	public void createReminderTimer(Message msg);
}
