package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MessageFactoryTest.class, MessageSchedulerTest.class, MessageTypesValidationTest.class })
public class TestRunner {

}
