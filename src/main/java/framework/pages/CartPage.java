package framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By cartRow = By.id("product-1");
    private By cartProductName = By.cssSelector("#product-1 .cart_description h4 a");
    private By cartQuantityBtn = By.cssSelector(".cart_quantity");
    private By cartLink = By.cssSelector("a[href='/view_cart']");
    private By cartMessage = By.cssSelector("p.text-center");
    private By linktoProduct = By.xpath("//a[@href='/products']/u[text()='here']");
    private By removeProductBtn = By.cssSelector(".cart_delete .cart_quantity_delete i.fa-times");
    private By productRow = By.cssSelector("tr#product-1");
    private By homeLink = By.cssSelector("a[href='/']");

    public boolean isProductVisibleInCart(String productName) {
        List<WebElement> products = driver.findElements(cartRow);
        if (products.isEmpty())
            return false;

        String name = driver.findElement(cartProductName).getText();
        return name.equalsIgnoreCase(productName);
    }

    public int getProductQuantityInCart() {
        String qtyText = driver.findElement(cartQuantityBtn).getText();
        return Integer.parseInt(qtyText);
    }

    public int getInitialCartQuantity() {
        driver.findElement(cartLink).click();
        // locate the "Cart is empty!" message
        List<WebElement> emptyCartMsg = driver.findElements(cartMessage);
        if (!emptyCartMsg.isEmpty() && emptyCartMsg.get(0).getText().contains("Cart is empty")) {
            return 0; // Cart is empty
        } else {
            // If message not present, get the cart quantity element
            String crtMessage = driver.findElement(cartQuantityBtn).getText();
            return Integer.parseInt(crtMessage);
        }
    }

    public void gotoProductPage() {
        driver.findElement(linktoProduct).click();
    }

    public boolean isremoveProductFromCart() {
        List<WebElement> deleteIcons = driver.findElements(removeProductBtn);
        click(removeProductBtn);
        if (!deleteIcons.isEmpty()) {
            WebElement icon = deleteIcons.get(0);
            if (icon.isDisplayed() && icon.isEnabled()) {
                icon.click();
                return true;
            }
        }
        return false;
    }

    public void clickViewCartLink() {
        click(cartLink);
    }

    public boolean isProductVisibleInCart() {
        List<WebElement> products = driver.findElements(productRow);
        return !products.isEmpty();
    }

    public void removeProduct() {
        click(removeProductBtn);
    }

    public void gotoHomePage() {
        click(homeLink);
    }
}
