package actions;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.*;

public class Action {

    private static final Logger logger = LogManager.getLogger(Action.class);
    HomePage homePage;
    LoginPage loginPage;
    SignupFormPage signupFormPage;
    CartPage cartPage;
    ProductDetailsPage productDetailsPage;
    ProductsPage productsPage;


    public Action(WebDriver driver) {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signupFormPage = new SignupFormPage(driver);
        cartPage = new CartPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        productsPage = new ProductsPage(driver);

    }

     public boolean register() {
        logger.info("Clicking Signup / Login button");
        homePage.clickSignupLoginButton();
        logger.info("Verifying login page loaded");
        loginPage.verifyPageLoaded();
        logger.info("Filling out initial signup form");
        loginPage.typeNewUsername();
        loginPage.typeNewUserEmailAddress();
        loginPage.clickNewUserSignUpButton();
        logger.info("Verifying registration form page loaded");
        signupFormPage.verifyPageLoaded();
        logger.info("Filling out registration form");
        signupFormPage.clickTitleButton();
        signupFormPage.typePassword("Test");
        signupFormPage.selectBirthDay("42");
        signupFormPage.selectBirthMonth("December");
        signupFormPage.selectBirthYear("1982");
        signupFormPage.clickSignupNewsletterCheckbox();
        signupFormPage.clickSpecialOffersCheckbox();
        signupFormPage.typeFirstName("Cabri");
        signupFormPage.typeLastNameField("Asher");
        signupFormPage.typeAddress1("Rishon Lezion");
        signupFormPage.typeAddress2("Haifa");
        signupFormPage.selectCountry("Israel");
        signupFormPage.typeState("Israel");
        signupFormPage.typeCity("Tel-Aviv");
        signupFormPage.typeZipCode("000000");
        signupFormPage.typeMobileNumber("000000");
        logger.info("Clicking create account button");
        signupFormPage.clickCreateAccountButton();
        logger.info("Verifying success message was displayed");

         //}

        // public boolean deleteAccount() {
        boolean successMessage = false;

        logger.info("Deleting account");
        homePage.clickDeleteAccount();
        logger.info("Verifying account was deleted successfully");

        return successMessage;
    }

   /* public String getLoggedInUser() {
        logger.info("Verifying new registered user appears as logged in");
        return homePage.getLoggedInUser();
    }*/

    public boolean verifyHomePageLoaded() {
        logger.info("Verifying homepage loaded successfully");
        return homePage.verifyPageLoaded();
    }

    public boolean loginWithWrongCredentials() {
        logger.info("Clicking Signup / Login button");
        homePage.clickSignupLoginButton();
        logger.info("Verifying login page loaded");
        boolean pageLoaded = loginPage.verifyPageLoaded();
        if (!pageLoaded) {
            return false;
        }
        logger.info("Filling out login info");
        loginPage.typeExistingUserEmail("incorrectemail@incorrect.com");
        loginPage.typeExistingUserPassword("incorrectPassword");
        logger.info("Clicking login button");
        loginPage.clickExistingUserLoginButton();
        return loginPage.verifyLoginErrorMessage();
    }

    public boolean logout() throws InterruptedException {
        logger.info("Clicking Signup / Login button");
        homePage.clickSignupLoginButton();
        logger.info("Verifying login page loaded");
        boolean pageLoaded;
        if (loginPage.verifyPageLoaded()) pageLoaded = true;
        else pageLoaded = false;

        logger.info("Filling out login info");
        loginPage.typeExistingUserEmail("cabri.asher@qualitestgroup.com");
        loginPage.typeExistingUserPassword("cabri1982");
        logger.info("Clicking login button");
        loginPage.clickExistingUserLoginButton();
        homePage.verifyPageLoaded();
        homePage.clicklogoutButton();
        return true;
    }

   /* public void addItemAndCheckout() {
        logger.info("Adding product to cart");
        homePage.clickAddCartButton();
        if (!homePage.verifyCheckoutMessageLoaded()) {
            return;
        }
        homePage.clickViewCartButton();
        if (!cartPage.verifyCheckoutPageLoaded()) {
            return;
        }
        logger.info("Clicking proceed to checkout button");
        cartPage.clickProceedToCheckoutButton();
    }*/


   /* public boolean registerFromCartPage() {
        logger.info("Clicking Register/Login button from checkout");
        cartPage.clickRegisterLoginButton();
        return register();
    }*/

   /* public boolean addReviewToProduct(String name, String email, String review) {
        logger.info("Clicking product details");
        productsPage.clickViewProductButton();
        logger.info("Adding review to product");
        productDetailsPage.addReview(name, email, review);
        logger.info("Verifying review was added successfully");
        return productDetailsPage.verifyReviewAdded();
    }*/

    public boolean goToProductsPage() {
        logger.info("clicking on Products button");
        homePage.clickproductsButton();
        logger.info("Verifying Products page loaded successfully");
        productsPage.AddToCart();
        productsPage.ViewCart();
        logger.info("verify Cart Page Is Displayed");
        cartPage.RemoveProduct();
        return cartPage.VerifyProductIsRemovedFromTheCart();
    }


    public boolean SubscriptionButton() {
        logger.info("Scroll down to footer");
        HomePage.scrollToFooter();
        logger.info("Verify text 'SUBSCRIPTION'");
        boolean isSubscriptionTextVisible = HomePage.isSubscriptionTextVisible();
        if (!isSubscriptionTextVisible) {
            logger.error("Text 'SUBSCRIPTION' is not visible");
            return false;
        }
        logger.info("Fill in email for subscription");
        HomePage.InsertSubscribeEmail("cabri.asher@qualitestgroup.com");
        logger.info("Click subscription button");
        HomePage.ClickSubscriptionButton();
        boolean isSubscriptionSuccessful = HomePage.YouHaveBeenSuccessfullySubscribed();
        if (isSubscriptionSuccessful) {
            logger.info("Successfully subscribed!");
        } else {
            logger.error("Subscription failed!");
        }
        return isSubscriptionSuccessful;
    }

    public boolean verifyPageLoaded() {
        return false;
    }
}


