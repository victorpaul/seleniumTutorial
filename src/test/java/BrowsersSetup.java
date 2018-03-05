import org.junit.After;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * here is code that setup chrome and firefox for our tests
 */
@RunWith(BlockJUnit4ClassRunner.class)
abstract public class BrowsersSetup {
    private static String driverFirefox = BrowsersSetup.class.getResource("/web-driver/chromedriver.exe").getPath();
    private static WebDriver firefox;

    private static String driverChrome = BrowsersSetup.class.getResource("/web-driver/geckodriver.exe").getPath();
    private static WebDriver chrome;

    static {
        System.setProperty("webdriver.gecko.driver", driverChrome);
        System.setProperty("webdriver.chrome.driver", driverFirefox);
    }

    public static WebDriver chrome() {
        if (chrome == null) {
            chrome = new ChromeDriver();
        }
        return chrome;
    }

    public static WebDriver firefox() {
        if (firefox == null) {
            firefox = new FirefoxDriver();
        }
        return firefox;
    }

    @AfterClass
    public static void methodAfterClass() {
        System.out.println("FireFoxTest afterClass");

        if (firefox != null) {
            firefox.quit();
        }
        if (chrome != null) {
            chrome.quit();
        }
    }

    @After
    public void waitABit() throws InterruptedException {
        //Thread.sleep(1000);
    }

}