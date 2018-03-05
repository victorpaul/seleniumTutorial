import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TutorialTest2 extends BaseTest {

    @Test
    public void success_test_1() {
        System.out.println("TutorialTest2 success_test_1");
        assertTrue(true);
    }

    @Test
    public void success_test_2() {
        System.out.println("TutorialTest2 success_test_2");
        assertTrue(true);
    }

    @Test
    public void fail_test_1() {
        System.out.println("TutorialTest2 fail_test_1");
        assertFalse(false);
    }
}