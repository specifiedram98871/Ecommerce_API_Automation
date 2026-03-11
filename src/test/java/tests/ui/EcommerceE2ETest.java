package tests.ui;

import framework.base.BaseTest;
import framework.pages.CheckoutPage;
import framework.pages.CartPage;
import framework.pages.LoginPage;
import framework.pages.ProductPage;
import framework.pages.PaymentPage;
import framework.utils.TestData;
import framework.utils.PaymentTestData;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;



public class EcommerceE2ETest extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    @BeforeClass
    public void setUpPages() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);
        loginPage.openHomePage();
        loginPage.clickSignupLogin();
    }
    
    @Test(description="Verify valid login redirects user to [Home] page")
    public void testValidLogin() {
        loginPage.loginUser(TestData.validEmail, TestData.PASSWORD);
        productPage.clickViewProduct();
    }
    
    @Test(description = "Verify click on [Product] redirects user to [Product] page",dependsOnMethods = "testValidLogin")
    public void testViewProduct() {
        // productPage.clickProductLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("product_details"), "URL should contain 'product_details'");
    }
    @Test(description="Verify [Add to cart] button redirects user to cart page from product page", dependsOnMethods = "testViewProduct")
    public void testAddToCartButton() {
        productPage.addToCart();
        Assert.assertTrue( productPage.isAddToCartModalVisible(),"Confirmation modal should be visible");
    }
    @Test(description="Verify [View Cart] redirects user to [cart] page", dependsOnMethods = "testAddToCartButton")
    public void testViewCartButton() {
        productPage.clickViewCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "URL should contain 'view_cart'");
        Assert.assertTrue(cartPage.isProductVisibleInCart(),
                "Product is not visible in the cart");
    }
    @Test(description ="Verify checkout button redirects user to checkout page from cart page", dependsOnMethods = "testViewCartButton")
    public void testCheckoutButton() {
        checkoutPage.clickCheckout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"), "URL should contain 'checkout'");
        Assert.assertEquals(checkoutPage.getDelName().trim(), "Mr. John Doe", "Address text should match");
    }
    @Test(description="Verify [Place Order] button redirects user to [payment] page", dependsOnMethods = "testCheckoutButton")
    public void testPlaceOrderButton() {
        checkoutPage.clickPlaceOrder();
        Assert.assertTrue(driver.getCurrentUrl().contains("payment"), "URL should contain 'payment'");
        Assert.assertEquals(checkoutPage.getHeading().trim(), "Payment", "Payment text shhould exist");
    }
    @Test(description=" Verify successfull payment redirects user to order page", dependsOnMethods = "testPlaceOrderButton")
    public void testSuccessfullPayment() {
        paymentPage.fillPaymentDetails(
                PaymentTestData.NAME_ON_CARD,
                PaymentTestData.CARD_NUMBER,
                PaymentTestData.CVC_CODE,
                PaymentTestData.EXPIRY_MONTH,
                PaymentTestData.EXPIRY_YEAR
        );

        paymentPage.clickPayButton();
    Assert.assertTrue(driver.getCurrentUrl().contains("payment_done"), "Url should contain 'payment_done'");
    Assert.assertEquals(paymentPage.sucessMessage().trim(), 
    "Congratulations! Your order has been confirmed!", 
    "Success message should match");
    }
}
