package ch.zhaw.multichannel.test;

import ch.zhaw.multichannel.core.interfaces.IMessageScheduler;
import ch.zhaw.multichannel.messages.Message;

public class MockMessageScheduler implements IMessageScheduler{

	@Override
	public void createMessageTimer(Message msg) {

	}

	@Override
	public void createReminderTimer(Message msg) {

	}

}
