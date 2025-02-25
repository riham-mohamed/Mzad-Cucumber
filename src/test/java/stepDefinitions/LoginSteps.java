package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.URLPage;

import static org.testng.AssertJUnit.assertEquals;

public class LoginSteps
{
    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
    WebDriver driver = Hooks.driver;
    URLPage urlPage = new URLPage(driver);
    LoginPage loginPage;
    HomePage homePage;
// Check Login function with valid credentials Steps
    @Given("user open login page")
    public void user_open_login_page() throws InterruptedException {
        urlPage.clickOnProfileDDL();
        loginPage = urlPage.clickOnLoginLink();
    }

    @When("user enters mobile number")
    public void user_enters_mobile_number()
    {
        loginPage.insertMobile("14755555");
    }

    @And("press Next button")
    public void press_Next_button()
    {
        loginPage.clickOnNextButton();
    }

    @And("user enters OTP")
    public void user_enters_OTP()
    {
        loginPage.insertOTP("123456");
    }

    @And("press next button")
    public void press_next_button()
    {
        homePage = loginPage.Clickonnextbutton();
    }

    @Then("user is navigated to homepage")
    public void user_is_navigated_to_homepage() {
        String mainHeaderText = homePage.getMainHeadText();
        String expectedhomepagetext = "Bid now & win the auction";
        assertEquals(mainHeaderText,expectedhomepagetext);
    }

    // Check Login with empty mobile number

    @When("user leave mobile number empty")
    public void user_leave_mobile_number_empty()
    {
     loginPage.checkMobileFieldDisplay();
    }

    @Then("next button is disabled")
    public void next_button_is_disabled()
    {
     Assert.assertFalse(loginPage.nextButtonIsDisabled(),"Empty Mobile Number cannot login test case is Fail");
    }

    // Check Login with Wrong OTP
    @And("user enters wrong OTP")
    public void user_enters_Wrong_OTP()
    {
     loginPage.insertOTP("111111");
    }

    @Then("press next button and check Error message")
    public void press_next_button_and_check_Error_message() throws InterruptedException {
       loginPage.clickOnNextButton();
       Thread.sleep(500);
       String actualwrongOTP = loginPage.getWrongOTPMessage();
       assertEquals("The user credentials were incorrect.",actualwrongOTP);
    }
}
