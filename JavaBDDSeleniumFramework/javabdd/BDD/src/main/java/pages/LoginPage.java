package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    By usernameXpath = By.xpath("//input[@id='input-email']");
    By passwordXpath = By.xpath("//input[@id='input-password']");
    By loginBtnXpath = By.xpath("//input[@value='Login']");

    By logOutXpath =  By.xpath("//a[@class='list-group-item' and contains(text(),'Logout')]");

    By forgotPasswordXpath = By.xpath("(//a[text()='Forgotten Password'])[1]");


    //Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Page action methods
    public void enterEmail(String email){
        WebElement emailInput = driver.findElement(usernameXpath);
        emailInput.sendKeys(email);

    }

    public void enterPassword(String password){
        WebElement passwordInput = driver.findElement(passwordXpath);
        passwordInput.sendKeys(password);

    }

    public void clickLoginBtn(){
        WebElement loginButton = driver.findElement(loginBtnXpath);
        loginButton.click();

    }
    public void clickForgotPasswordLink(){
        WebElement forgotPassLink = driver.findElement(forgotPasswordXpath);
        forgotPassLink.click();

    }
    public boolean checkForgotPasswordLink(){
        return driver.findElement(forgotPasswordXpath).isDisplayed();

    }

    public boolean checkLogoutLink(){
        return driver.findElement(logOutXpath).isDisplayed();

    }

    public String getForgotPasswordPageUrl(){
        String forgotPasswordPageUrl = driver.getCurrentUrl();
        return forgotPasswordPageUrl;
    }


}
