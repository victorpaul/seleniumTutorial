package test.homepage;

import org.junit.Test;
import test.DriverSetUp;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

/**
 * here are tests for home page with particular browsers
 */

public class HomePageWIthParticularBrowsersTest extends DriverSetUp {

    @Test
    public void success_google() {
        chrome().get("http://google.com");
        assertEquals(chrome().getCurrentUrl(), "https://www.google.com/?gws_rd=ssl");
    }

    @Test
    public void success_yahoo() {
        firefox().get("http://yahoo.com");
        assertEquals(firefox().getCurrentUrl(), "https://www.yahoo.com/");
    }

}