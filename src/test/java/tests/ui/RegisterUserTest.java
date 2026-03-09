package tests.ui;

import framework.base.BaseTest;
import framework.pages.RegisterUserPage;
import framework.pages.LoginPage;
import org.testng.annotations.Test;
import framework.utils.TestData;
import org.testng.Assert;

public class RegisterUserTest extends BaseTest {

@Test(description = "Verify that a user can register successfully")
public void testUserRegistration() {

    LoginPage loginPage = new LoginPage(driver);
    loginPage.openHomePage();
    loginPage.clickSignupLogin();

    RegisterUserPage registerPage = new RegisterUserPage(driver);

    registerPage.registerUser(TestData.uniqueMail(), TestData.NAME);

    Assert.assertTrue(driver.getCurrentUrl().contains("signup"),
            "URL should contain 'signup'");

    registerPage.selectTitle(TestData.TITLE);
    registerPage.enterName(TestData.NAME);
    registerPage.enterPassword(TestData.PASSWORD);
    registerPage.selectDOB("1", "1", "2002");

    registerPage.toggleNewsletter(true);
    registerPage.toggleOptin(true);

    registerPage.enterAddress(
            TestData.FIRST_NAME,
            TestData.LAST_NAME,
            TestData.COMPANY,
            TestData.ADDRESS1,
            TestData.ADDRESS2,
            TestData.COUNTRY,
            TestData.STATE,
            TestData.CITY,
            TestData.ZIPCODE,
            TestData.PHONE
    );

    registerPage.clickCreateAccount();
}
}