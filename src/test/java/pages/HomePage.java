package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage<by> extends BasePage {


    private static WebDriver driver;
    private By homeButton = By.cssSelector("a[href='/'][style='color: orange;']");
    private By signupLoginButton = By.cssSelector("a[href='/login']");
    private By testCasesButton = By.cssSelector("a[href='/test_cases']");
    private By deleteAccountButton = By.cssSelector("a[href='/delete_account']");
    private By loggedInAs = By.cssSelector("i.fa-user ~ b");
    private By AddToCartButton = By.xpath("(//a[text()='Add to cart'])[1]");
    private By CheckoutMessage = By.xpath("//p[text()='Your product has been added to cart.']");
    private By ViewCart = By.xpath("//u[text()='View Cart']");
    private By productsButton = By.xpath("//a[@href='/products']");
    private By loguotButton = By.cssSelector("a[href='/logout']");
    private static By SubscriptionButton = By.xpath("//button[@id='subscribe']");
    private static By SubscribeEmail = By.xpath("//input[@id='susbcribe_email']");




    public HomePage(WebDriver driver, By existingExistingEmail) {
        super(driver);
      //  this.existingExistingEmail = existingExistingEmail;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static void typeExistingUserEmail(String mail) {
    }


    public static void scrollToFooter() {

    }

    public boolean verifyPageLoaded() {
        return validateElementExist(homeButton);
    }

    public void clickSignupLoginButton() {
        click(signupLoginButton);
    }

    public void clickTestCasesButton() {
        click(testCasesButton);
    }

    public String getLoggedInUser() {
        return elementText(loggedInAs);
    }

    public void clickDeleteAccount() {
        click(deleteAccountButton);
    }

    public void clickAddCartButton() {
        click(AddToCartButton);
    }

    public boolean verifyCheckoutMessageLoaded() {
        return validateElementExist(CheckoutMessage);
    }

    public void clickViewCartButton() {
        click(ViewCart);
    }

    public <by> void clickProductsButton() {
        by productsButton = null;
        click((By) productsButton);
    }

    public void clicklogout() {
        By clicklogout = null;
        click(clicklogout);}

    public By getLoguotButton() {
        return loguotButton;
    }

    public void setLoguotButton(By loguotButton) {
        this.loguotButton = loguotButton;
    }

    public void clicklogoutButton() {
        click(loguotButton);
    }

    public void clickproductsButton() {
        click(productsButton);
    }

    public static boolean ClickSubscriptionButton() {
        click(SubscriptionButton);
        return false;
    }

    public static void InsertSubscribeEmail(String email) {
        typeText(SubscribeEmail, email);
    }

    public static boolean isSubscriptionTextVisible() {
        return false;
    }

    public static boolean YouHaveBeenSuccessfullySubscribed() {
        return false;
    }
}