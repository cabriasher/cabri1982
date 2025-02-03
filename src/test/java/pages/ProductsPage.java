package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {


    private final By allProductsHeader = By.xpath("//h2[text()='All Products']");
    private final By ViewProduct = By.cssSelector("a[href='/product_details/1']");
    private By AddToCart = By.xpath("(//a[@data-product-id='1'])[1]");
    private static By ViewCart = By.xpath ("//*[text()=' Cart']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyPageLoaded() {
        return validateElementExist(allProductsHeader);
    }

    public void clickViewProductButton() {
        scrollDown(200);
        click(ViewProduct);
    }

    public void AddToCart() {
        scrollToElementByXPath("//a[@data-product-id='1']");
        click(AddToCart);
    }

    public void ViewCart() {
        click(ViewCart);
    }

}
