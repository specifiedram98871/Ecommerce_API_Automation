package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import framework.utils.ConfigReader;;
public class LoginPage extends BasePage {
    By regnameInput = By.cssSelector("input[data-qa='signup-name']");
    By regemailInput = By.cssSelector("input[data-qa='signup-email']");
    By signUpButton = By.cssSelector("button[data-qa='signup-button']");
    By loginEmail = By.cssSelector("input[data-qa='login-email']");
    By loginPassword = By.cssSelector("input[data-qa='login-password']");
    By loginsubmitButton = By.cssSelector("button[data-qa='login-button']");
    By loggedInUser = By.xpath("//a[contains(text(),'Logged in as')]/b");

    // link
    By loginButton = By.cssSelector("a[href='/login']");
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void openHomePage(){
       openHomePage(ConfigReader.getProperty("baseUrl"));
    }
    public void clickSignupLogin(){
        driver.findElement(loginButton).click();
    }
     public void loginUser(String email, String password) {
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(loginPassword).sendKeys(password);
        driver.findElement(loginsubmitButton).click();
    }
    public void signUpUser(String email, String name) {
        driver.findElement(regnameInput).sendKeys(name);
        driver.findElement(regemailInput).sendKeys(email);
        driver.findElement(signUpButton).click();
    }
    public String getLoggedInUsername( ) {
    return getText(loggedInUser);
}
}