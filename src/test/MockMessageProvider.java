package test;

import messageTypes.Message;
import core.IMessageSender;

public class MockMessageProvider implements IMessageSender {

	@Override
	public boolean sendMessage(Message msg) {
		return true;
	}

}
