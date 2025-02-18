package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks
{
    public WebDriver driver;

    @Before
    public void setUp()
    {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       System.out.println("Browser opened before scenario");
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
