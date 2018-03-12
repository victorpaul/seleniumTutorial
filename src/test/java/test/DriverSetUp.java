package test;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * here is code that setup chrome and firefox drivers
 */

abstract public class DriverSetUp {
    private static String
            defaultBrpwser = "chrome",
            driverFirefox = DriverSetUp.class.getResource("/web-driver/chromedriver.exe").getPath(),
            driverChrome = DriverSetUp.class.getResource("/web-driver/geckodriver.exe").getPath();

    private static WebDriver browser, chrome, firefox;

    static {
        System.setProperty("webdriver.gecko.driver", driverChrome);
        System.setProperty("webdriver.chrome.driver", driverFirefox);
    }

    public static WebDriver firefox() {
        if (firefox == null) {
            firefox = new FirefoxDriver();
        }
        return firefox;
    }

    public static WebDriver chrome() {
        if (chrome == null) {
            chrome = new ChromeDriver();
        }
        return chrome;
    }

    public static void set(String defBro) {
        defaultBrpwser = defBro;
    }

    public static WebDriver browser() {
        if (browser == null) {
            switch (defaultBrpwser) {
                case "firefox":
                    browser = firefox();
                    break;
                case "chrome":
                default:
                    browser = chrome();
                    break;
            }
        }
        return browser;
    }

    @AfterClass
    public static void finishBrowsers() {
        if (browser != null) browser.quit();
        if (chrome != null) chrome.quit();
        if (firefox != null) firefox.quit();
        browser = null;
        chrome = null;
        firefox = null;

    }
}