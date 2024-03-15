package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;

public class LoginStepDef {
    public WebDriver driver;
    LoginPage loginPage;

        //Hooks in cucumber
    @Before
    public void setup(){
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
        driver.quit();
    }


    @Given("User is already on login page")
    public void user_Is_OnLoginPage() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/logout");
        loginPage = new LoginPage(driver);
    }

    @When("User enters (.+) and (.+)")
    public void user_enters_username_and_password(String username,String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }
    @When("User enters invalid (.+) and (.+)")
    public void user_enters_invalid_username_and_password(String username,String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @When("Click on login button")
    public void click_on_login_button() {
        throw new io.cucumber.java.PendingException();
    }

    @Then("Login is successful")
    public void login_is_successful() {
        Assert.assertTrue(loginPage.checkLogoutLink());
    }

    @Then("I should see an error message indicating {string}")
    public void error_message_displayed(String arg0, String arg1) {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
    }


    @Then("user is redirected to the password reset page")
    public void userIsRedirectedToThePasswordResetPage() {
        Assert.assertTrue(loginPage.getForgotPasswordPageUrl().contains("account/forgotten"));

    }

    @When("User clicks on forgot password link")
    public void userClicksOnForgotPasswordLink() {
        loginPage.clickForgotPasswordLink();
    }
}
