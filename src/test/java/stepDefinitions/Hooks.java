package stepDefinitions;

import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.io.IOException;

public class Hooks {
    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.get("https://newwebsite.mzadqatar.com/en");
    }
    @After
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            // Capture screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define screenshot file path with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String screenshotName = "FailedScenario_" + scenario.getName().replaceAll(" ", "_") + "_" + timestamp + ".png";
            File destinationPath = new File("screenshots/" + screenshotName);

            try {
                // Save screenshot to the specified location
                FileUtils.copyFile(screenshot, destinationPath);
                System.out.println("Screenshot saved: " + destinationPath.getAbsolutePath());

                // Attach screenshot to Cucumber report (if using ExtentReports or Cucumber Reports)
                byte[] screenshotBytes = FileUtils.readFileToByteArray(destinationPath);
                scenario.attach(screenshotBytes, "image/png", "Screenshot");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @AfterAll
    public static void tearDown()
    {
        driver.quit();
    }
}