package tests.ui;

import framework.base.BaseTest;
import org.testng.annotations.Test;
import framework.pages.LoginPage;
import org.testng.Assert;
public class LoginPageRedirect extends BaseTest {

    @Test
    public void verifyLoginNavigation() {
        LoginPage loginPage = new LoginPage(driver);
        // Navigate to homepage
        loginPage.openHomePage();
        // Click on signup/login
        loginPage.clickSignupLogin();
        // Assert user is on logi page
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "User is not on login page!");
    }
}