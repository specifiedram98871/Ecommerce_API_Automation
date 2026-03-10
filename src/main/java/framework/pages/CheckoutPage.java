package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    private By checoutBtn = By.cssSelector("a.check_out");
    private By delName = By.cssSelector("li.address_firstname.address_lastname");
    private By placeOrderBtn =By.cssSelector("a.btn.btn-default.check_out");
    private By heading = By.cssSelector(".step-one .heading");
    public void clickCheckout(){
        click(checoutBtn);
    }
    public String getDelName(){
        return getText(delName);
    }
    public void clickPlaceOrder(){
        click(placeOrderBtn);
    }
    public String getHeading(){
        return getText(heading);
    }
}
