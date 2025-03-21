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

    public void clickOnProfileDDL() throws InterruptedException
    {
        explicitWait(profileDDL,60);
        click(profileDDL);
   }

    public LoginPage clickOnLoginLink()
    {
      explicitWait(loginLink,60);
      click(loginLink);
      return new LoginPage(driver);
    }
}