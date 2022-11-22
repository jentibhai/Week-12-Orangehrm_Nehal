package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseURL = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find username and enter into the  field element
        driver.findElement(By.name("username")).sendKeys("Admin");

        //Find password and enter into the field element
        driver.findElement(By.name("password")).sendKeys("admin123");

        //Find login button and click it.
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();

        //Verify dashboard text after   login
        String expectedMessage = "Dashboard";

        //Find Log out text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String actualMessage = actualTextMessageElement.getText();

        //Validate actual and expected
        Assert.assertEquals("Text message not found", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
