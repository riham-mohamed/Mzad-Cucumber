package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MethodHandles;

import java.time.Duration;

public class LoginPage extends MethodHandles
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    private final By mobileField = By.id("phone");

    private final By nextButton = By.xpath("//button[@class='button']");

    public void insertMobile(String mobilenumber)
    {
        explicitWait(mobileField,5);
        sendKeys(mobileField,mobilenumber);
    }

    public void clickOnNextButton()
    {
       explicitWait(nextButton,5);
       click(nextButton);
    }

    private final By otpField = By.xpath("(//*[@class='phone_code'])[1]");

    public void insertOTP(String OTPfield)
    {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement otpElement = wait.until(ExpectedConditions.presenceOfElementLocated(otpField));
                otpElement.sendKeys(OTPfield);
                return;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        throw new RuntimeException("Failed to click on Profile Dropdown after multiple attempts");
    }
}
