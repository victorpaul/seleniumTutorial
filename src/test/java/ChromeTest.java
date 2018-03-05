import org.junit.Test;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

/**
 * here are tests for chrome
 */
public class ChromeTest extends BrowsersSetup {

    @Test
    public void success_test_1() {
        chrome().get("http://google.com");
        assertEquals(chrome().getCurrentUrl(), "https://www.google.com/?gws_rd=ssl");
    }

    @Test
    public void success_test_2() {
        chrome().get("http://yahoo.com");
        assertEquals(chrome().getCurrentUrl(), "https://www.yahoo.com/");
    }

}