package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By RegisterLogin = By.xpath("//u[text()='Register / Login']");
    private final By ProceedToCheckout = By.xpath("//a[text()='Proceed To Checkout']");

    private final By RemoveProduct = By.xpath("//a[text()='cart_quantity_delete']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyCheckoutPageLoaded() {
        return validateElementExist(ProceedToCheckout);
    }

    public void clickProceedToCheckoutButton() {
        click(ProceedToCheckout);
    }

    public void clickRegisterLoginButton() {
        click(RegisterLogin);
    }


    public void RemoveProduct() {
        click(RemoveProduct);
    }

    public boolean VerifyProductIsRemovedFromTheCart() {
        return false;
    }
}