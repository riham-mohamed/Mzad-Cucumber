package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MethodHandles;

public class HomePage extends MethodHandles
{
    public HomePage(WebDriver driver)
    {
    super(driver);
    }

    private final By homeMainHeadFieldtext = By.xpath("//p[@class='mainshopmenuinfo']");

    public String getMainHeadText()
    {
        explicitWait(homeMainHeadFieldtext,10);
        WebElement element = webElement(homeMainHeadFieldtext);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].textContent;", element);
    }
}
