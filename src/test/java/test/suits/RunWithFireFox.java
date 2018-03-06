package test.suits;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.DriverSetUp;
import test.homepage.HomePageTest;
import test.homepage.HomePageWIthParticularBrowsersTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HomePageTest.class,
        HomePageWIthParticularBrowsersTest.class
})
public class RunWithFireFox {

    @BeforeClass
    public static void methodBeforeClass() {
        DriverSetUp.set("firefox");
    }

}