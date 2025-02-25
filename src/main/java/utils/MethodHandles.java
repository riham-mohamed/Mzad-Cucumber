package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles
{
    protected WebDriver driver;

    protected WebDriverWait wait;

    public MethodHandles(WebDriver driver)
    {
        this.driver=driver;
    }

    protected WebElement webElement(By locator)
    {
        return driver.findElement(locator);
    }

    protected void explicitWait(By locator, int time)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(driver -> {
        WebElement element = webElement(locator);
        return element.isDisplayed() && element.isEnabled();
        });
    }

    protected void click(By locator)
    {
        webElement(locator).click();
    }

    protected void sendKeys(By locator, String text)
    {
       webElement(locator).sendKeys(text);
    }

    protected String getText(By locator)
    {
        webElement(locator).getText();
        return null;
    }
}
