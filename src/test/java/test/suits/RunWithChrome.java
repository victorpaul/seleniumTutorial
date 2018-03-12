package test.suits;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.DriverSetUp;
import test.HomePageTest;
import test.HomePageWIthParticularBrowsersTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HomePageTest.class,
        HomePageWIthParticularBrowsersTest.class
})
public class RunWithChrome {

    @BeforeClass
    public static void methodBeforeClass() {
        DriverSetUp.set("chrome");
    }

}
