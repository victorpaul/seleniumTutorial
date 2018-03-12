package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BItBucketTests extends DriverSetUp {

    @Test
    public void open_home_page_and_find_login_button() {
        WebDriver webDriver = browser();
        browser().get("https://bitbucket.org");
        List<WebElement> login;

        //not find by text
        login = webDriver.findElements(By.linkText("not Log in"));
        assertEquals(0, login.size());

        // find by text
        login = webDriver.findElements(By.linkText("Log in"));
        assertEquals(1, login.size());

        // find mobile login by relative path by href
        login = webDriver.findElements(By.xpath("//nav[@class='header__branded-domains__nav-links--mobile']/ul/li/a[@href='/account/signin/']"));
        assertEquals(1, login.size());
        assertFalse(login.get(0).isDisplayed());

        // find desktop login by relative path by href
        login = webDriver.findElements(By.xpath("//nav[@class='header__branded-domains__nav-links']/ul/li/a[@href='/account/signin/']"));
        assertEquals(1, login.size());
        assertEquals("Log in", login.get(0).getText());
        assertTrue(login.get(0).isDisplayed());

        // find desktop login by relative path by href and class
        login = webDriver.findElements(By.xpath("//nav[@class='header__branded-domains__nav-links']/ul/li/a[@href='/account/signin/' and @class='cms-link cms-link--text']"));
        assertEquals(1, login.size());
        assertEquals("Log in", login.get(0).getText());
        assertTrue(login.get(0).isDisplayed());

        // find desktop login by relative path by href and class
        login = webDriver.findElements(By.xpath("//nav[@class='header__branded-domains__nav-links']/ul/li/a[@href='/account/signin/' and contains(@class,'cms-link')]"));
        assertEquals(1, login.size());
        assertEquals("Log in", login.get(0).getText());
        assertTrue(login.get(0).isDisplayed());

    }

    @Test
    public void try_to_login_with_empty_credentials_and_fail() {
        browser().get("https://bitbucket.org");
        browser().findElement(By.linkText("Log in")).click();

        assertEquals("https://bitbucket.org/account/signin/", browser().getCurrentUrl());

        browser().findElement(By.xpath("//input[contains(@class,'selenium-login-submit') and @type='submit' and @value='Log in']")).click();

        assertEquals(1, browser().findElements(By.xpath("//input[@id='js-email-field' and contains(@class,'invalid') and @data-validation-error='This field is required.']")).size());
        assertEquals(1, browser().findElements(By.xpath("//input[@id='js-password-field' and contains(@class,'invalid') and @data-validation-error='This field is required.']")).size());
    }

    @Test
    public void try_to_login_with_wrong_credentials_and_fail() {
        String homeUrl = "https://bitbucket.org",
                loginUrl = "https://bitbucket.org/account/signin/";
        By
                emailBy = By.xpath("//input[@id='js-email-field']"),
                passwordBy = By.xpath("//input[@id='js-password-field']"),
                errorDialogBy = By.xpath("//input[@id='js-global-login-error-container']"),
                submitBy = By.xpath("//input[contains(@class,'selenium-login-submit') and @type='submit' and @value='Log in']");

        browser().get(homeUrl);
        browser().findElement(By.linkText("Log in")).click();

        assertEquals(loginUrl, browser().getCurrentUrl());

        browser().findElement(emailBy).sendKeys("asd@asd.com");
        browser().findElement(passwordBy).sendKeys("qwerty");

        assertFalse(browser().findElement(errorDialogBy).isDisplayed());

        browser().findElement(submitBy).click();

        assertTrue(browser().findElement(errorDialogBy).isDisplayed());
    }
}
