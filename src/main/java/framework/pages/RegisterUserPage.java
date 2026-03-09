package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class RegisterUserPage {

    private WebDriver driver;

    // Constructor
    public RegisterUserPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Locators
    private By regnameInput = By.cssSelector("input[data-qa='signup-name']");
    private By regemailInput = By.cssSelector("input[data-qa='signup-email']");
    private By signUpButton = By.cssSelector("button[data-qa='signup-button']");
    private By titleMr = By.id("id_gender1");
    private By titleMrs = By.id("id_gender2");
    private By nameInput = By.id("name");
    private By passwordInput = By.id("password");
    private By daySelect = By.id("days");
    private By monthSelect = By.id("months");
    private By yearSelect = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By optinCheckbox = By.id("optin");
    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By companyInput = By.id("company");
    private By address1Input = By.id("address1");
    private By address2Input = By.id("address2");
    private By countrySelect = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipcodeInput = By.id("zipcode");
    private By mobileInput = By.id("mobile_number");
    private By createAccountBtn = By.cssSelector("button[data-qa='create-account']");

    // Actions

    public void registerUser(String email, String name) {
        driver.findElement(regnameInput).sendKeys(name);
        driver.findElement(regemailInput).sendKeys(email);
        driver.findElement(signUpButton).click();
    }
    public void selectTitle(String title) {
        if(title.equalsIgnoreCase("Mr")) {
            driver.findElement(titleMr).click();
        } else if(title.equalsIgnoreCase("Mrs")) {
            driver.findElement(titleMrs).click();
        }
    }

    public void enterName(String name) {
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void selectDOB(String day, String month, String year) {
        new Select(driver.findElement(daySelect)).selectByValue(day);
        new Select(driver.findElement(monthSelect)).selectByValue(month);
        new Select(driver.findElement(yearSelect)).selectByValue(year);
    }

    public void toggleNewsletter(boolean subscribe) {
        WebElement checkbox = driver.findElement(newsletterCheckbox);
        if(subscribe != checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void toggleOptin(boolean subscribe) {
        WebElement checkbox = driver.findElement(optinCheckbox);
        if(subscribe != checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void enterAddress(String firstName, String lastName, String company,
                             String address1, String address2, String country,
                             String state, String city, String zipcode, String mobile) {

        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(companyInput).sendKeys(company);
        driver.findElement(address1Input).sendKeys(address1);
        driver.findElement(address2Input).sendKeys(address2);
        new Select(driver.findElement(countrySelect)).selectByVisibleText(country);
        driver.findElement(stateInput).sendKeys(state);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(zipcodeInput).sendKeys(zipcode);
        driver.findElement(mobileInput).sendKeys(mobile);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountBtn).click();
    }
}