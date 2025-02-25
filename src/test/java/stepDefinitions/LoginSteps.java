package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.URLPage;

public class LoginSteps
{
    WebDriver driver = Hooks.driver;
    URLPage urlPage = new URLPage(driver);
    LoginPage loginPage;
    HomePage homePage;

    @Given("user open login page")
    public void user_open_login_page()
    {
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
        System.out.println("Main Header Text: " + mainHeaderText);
    }
}
