package core;

import messageTypes.Message;

public interface IMessageScheduler {
	public boolean createMessageTimer(Message msg);
	public boolean createReminderTimer(Message msg);
}
