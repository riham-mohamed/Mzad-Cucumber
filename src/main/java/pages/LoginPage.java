package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    private final By mobileField = By.id("phone");

    private final By nextButton = By.xpath("//button[@class='button']");

    public void checkMobileFieldDisplay()
    {
     explicitWait(mobileField,10);
    }

    public boolean nextButtonIsDisabled()
    {
     webElement(nextButton);
     return webElement(nextButton).isEnabled();
    }

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

    public void insertOTP(String OTPFieldValue)
    {
        explicitWait(otpField,10);
        sendKeys(otpField,OTPFieldValue);
    }

    public HomePage Clickonnextbutton()
    {
        explicitWait(nextButton,5);
        click(nextButton);
        return new HomePage(driver);
    }
}
