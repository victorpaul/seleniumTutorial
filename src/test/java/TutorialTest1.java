import org.junit.After;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TutorialTest1 extends BaseTest {

    @Test
    public void success_test_1() {
        firefox().get("http://google.com");
        System.out.println("TutorialTest1 success_test_1");
        assertTrue(true);
    }

    @Test
    public void success_test_2() {
        firefox().get("http://yahoo.com");
        System.out.println("TutorialTest1 success_test_2");
        assertTrue(true);
    }

    @Test
    public void fail_test_1() {
        chrome().get("http://bing.com");
        System.out.println("TutorialTest1 fail_test_1");
        assertFalse(false);
        chrome().quit();
    }

    @After
    public void waitABit() throws InterruptedException {
        Thread.sleep(1000);
    }
}
