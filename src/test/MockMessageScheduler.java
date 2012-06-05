package test;

import messageTypes.Message;
import core.IMessageScheduler;

public class MockMessageScheduler implements IMessageScheduler{

	@Override
	public boolean createMessageTimer(Message msg) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean createReminderTimer(Message msg) {
		// TODO Auto-generated method stub
		return true;
	}

}
