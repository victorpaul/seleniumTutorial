import org.junit.Test;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

/**
 * here are tests for firefox
 */
public class FireFoxTest extends BrowsersSetup {

    @Test
    public void success_test_1() {
        firefox().get("http://google.com");
        assertEquals(firefox().getCurrentUrl(), "https://www.google.com/?gws_rd=ssl");
    }

    @Test
    public void success_test_2() {
        firefox().get("http://yahoo.com");
        assertEquals(firefox().getCurrentUrl(), "https://www.yahoo.com/");
    }
}
