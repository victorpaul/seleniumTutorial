package test;
import org.junit.Test;
import test.DriverSetUp;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

/**
 * here are tests for home page
 */
public class HomePageTest extends DriverSetUp {

    @Test
    public void success_google() {
        browser().get("http://google.com");
        assertEquals(browser().getCurrentUrl(), "https://www.google.com/?gws_rd=ssl");
    }

    @Test
    public void success_yahoo() {
        browser().get("http://yahoo.com");
        assertEquals(browser().getCurrentUrl(), "https://www.yahoo.com/");
    }

}