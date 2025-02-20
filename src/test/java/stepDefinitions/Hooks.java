package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks
{
    public static WebDriver driver;

    @Before
    public static void setUp()
    {
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
      driver.get("https://newwebsite.mzadqatar.com/en");
    }

    @After
    public static void tearDown()
    {
        driver.quit();
    }
}
