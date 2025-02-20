package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps
{
    WebDriver driver = Hooks.driver;

    @Given("user open login page")
    public void user_open_login_page()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnProfileDDL();
        loginPage.clickOnLoginLink();
    }

    @When("select country code from DDL")
    public void select_country_code_from_DDL()
    {
        System.out.println("select country code from DDL");
    }

    @And("user enters mobile number")
    public void user_enters_mobile_number()
    {
        System.out.println("user enters mobile number");
    }

    @And("press next button")
    public void press_next_button()
    {
        System.out.println("press next button");
    }

    @And("user enters OTP")
    public void user_enters_OTP()
    {
        System.out.println("user enters OTP");
    }

    @And("press Next button")
    public void press_Next_button()
    {
        System.out.println("press Next button");
    }

    @Then("user is navigated to homepage")
    public void user_is_navigated_to_homepage() {
        System.out.println("user is navigated to homepage");
    }
}
