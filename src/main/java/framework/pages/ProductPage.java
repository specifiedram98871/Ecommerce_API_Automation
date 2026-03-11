package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage{

    private By viewProduct = By.cssSelector("a[href='/product_details/1']");
    private By quantityInput  = By.id("quantity");
    private By addToCart = By.cssSelector("button.cart");
    private By modalConfirm = By.cssSelector(".modal-dialog.modal-confirm");
    private By continueShopping = By.xpath("//button[contains(text(),'Continue Shopping')]");
    private By cart = By.linkText("View Cart");
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickViewProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(viewProduct));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
         product.click();
    }
    public void setQuantity(String qty) {
        type(quantityInput,qty);
    }

    public void addToCart() {
        click(addToCart);
    }
    public boolean isAddToCartModalVisible() {
        try {
            WebElement modal = wait.until(
            ExpectedConditions.visibilityOfElementLocated(modalConfirm));
            return modal.isDisplayed();
            }
        catch (Exception e) {
            return false;
            }
}
    public void clickContinueShopping() {
        click(continueShopping);
    }
    public void clickViewCart() {
        click(cart);
    }
}
