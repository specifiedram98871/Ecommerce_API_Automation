package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By nameOnCard = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    private By cvc = By.name("cvc");
    private By expiryMonth = By.name("expiry_month");
    private By expiryYear = By.name("expiry_year");
    private By payButton = By.id("submit");
    private By successMessage = By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");
    

    public void enterNameOnCard(String name) {
        driver.findElement(nameOnCard).sendKeys(name);
    }

    public void enterCardNumber(String number) {
        driver.findElement(cardNumber).sendKeys(number);
    }

    public void enterCVC(String cvcCode) {
        driver.findElement(cvc).sendKeys(cvcCode);
    }

    public void enterExpiryMonth(String month) {
        driver.findElement(expiryMonth).sendKeys(month);
    }

    public void enterExpiryYear(String year) {
        driver.findElement(expiryYear).sendKeys(year);
    }

    public void clickPayButton() {
        driver.findElement(payButton).click();
    }

    public boolean isPaymentSuccessful() {
       String  Message=  getText(successMessage);
        if (!Message.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public void fillPaymentDetails(String name, String card, String cvcCode, String month, String year) {
        enterNameOnCard(name);
        enterCardNumber(card);
        enterCVC(cvcCode);
        enterExpiryMonth(month);
        enterExpiryYear(year);
    }
    public String sucessMessage() {
        return getText(successMessage);
    }
}