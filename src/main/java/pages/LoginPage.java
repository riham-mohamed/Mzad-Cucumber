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

    private final By profileDDL = By.cssSelector(".all_action_dropdown");

    private final By loginLink =  By.xpath("(//a[@class='logreg'])[1]");

    public void clickOnProfileDDL()
    {
        click(profileDDL,5);

    }
    public void clickOnLoginLink()
    {
      click(loginLink,5);
    }


}
