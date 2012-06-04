package test;

import messageTypes.Message;
import core.IMessageProvider;

public class MockMessageProvider implements IMessageProvider {

	@Override
	public boolean sendMessage(Message msg) {
		// TODO Auto-generated method stub
		return true;
	}

}
