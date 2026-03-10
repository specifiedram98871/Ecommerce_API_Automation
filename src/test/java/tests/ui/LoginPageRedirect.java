package tests.ui;

import framework.base.BaseTest;
import org.testng.annotations.Test;
import framework.pages.LoginPage;
import org.testng.Assert;
import framework.utils.TestData;
public class LoginPageRedirect extends BaseTest {

    @Test(description = "Verify user is logged in after successful login")

    public void verifyLoginNavigation() {
        LoginPage loginPage = new LoginPage(driver);
        // Navigate to homepage
        loginPage.openHomePage();
        // Click on signup/login
        loginPage.clickSignupLogin();
        // Assert user is on login page
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "User is not on login page!");

        loginPage.loginUser(TestData.validEmail, TestData.PASSWORD);

        Assert.assertEquals(
        loginPage.getLoggedInUsername(),
        TestData.NAME,
        "Logged in username is incorrect!"
);
    }
}