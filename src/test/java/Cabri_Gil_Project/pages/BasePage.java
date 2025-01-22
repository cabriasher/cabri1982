package Cabri_Gil_Project.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class BasePage {

    private static final Logger logger = LogManager.getLogger(BasePage.class);
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    /**
     * Constructor to initialize the WebDriver and WebDriverWait.
     */
    public BasePage(WebDriver driver, int timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        actions = new Actions(driver);
    }

    /**
     * Clicks on the element located by the given locator.
     *
     * @param locator the By locator of the element to be clicked
     */
    public void click(By locator) {
        logger.info("Going to click WebElement: {}", locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = driver.findElement(locator);
        element.click();
    }
}

