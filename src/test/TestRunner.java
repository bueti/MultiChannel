package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MessageSchedulerTest.class, MessageTypesValidationTest.class, MessageFactoryTest.class })
public class TestRunner {

}
