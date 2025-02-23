package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;


public class URLPage extends MethodHandles
{
    public URLPage(WebDriver driver)
    {
        super(driver);
    }

    private final By profileDDL = By.cssSelector(".all_action_dropdown");

    private final By loginLink =  By.cssSelector("a.logreg");

    public void clickOnProfileDDL() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                explicitWait(profileDDL,10);
                click(profileDDL);
                return;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        throw new RuntimeException("Failed to click on Profile Dropdown after multiple attempts");
    }

    public LoginPage clickOnLoginLink()
    {
      explicitWait(loginLink,5);
      click(loginLink);
      return new LoginPage(driver);
    }
}