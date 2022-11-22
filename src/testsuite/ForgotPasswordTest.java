package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {

        //Click  Forgot Pass word Button
        driver.findElement(By.xpath("//p[text()='Forgot your password? ']")).click();

        //Verify Reset Password
        String expectedMessage = "Reset Password";
        WebElement actualTextMessage = driver.findElement(By.xpath("//h6[text()='Reset Password']"));
        String actualMessage = actualTextMessage.getText();

        Assert.assertEquals("Not on Reset Password Page", expectedMessage, actualMessage);

    }
}
