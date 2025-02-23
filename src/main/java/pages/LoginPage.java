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

}
