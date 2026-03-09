package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openHomePage(String url){
        driver.get(url);
    }

    // Wait for element to be visible
    protected WebElement waitForElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Reusable actions
    protected void click(By locator){
        waitForElement(locator).click();
    }

    protected void type(By locator, String text){
        waitForElement(locator).sendKeys(text);
    }

    protected String getText(By locator){
        return waitForElement(locator).getText();
    }
}