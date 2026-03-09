package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import framework.utils.ConfigReader;;
public class LoginPage extends BasePage {
    
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
}