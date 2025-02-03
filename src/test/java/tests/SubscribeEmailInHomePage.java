package tests;

import actions.Action;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.GenerateDriver;
import utils.JsonUtils;
import utils.ScreenshotUtils;

import java.io.File;
import java.io.IOException;

public class SubscribeEmailInHomePage {

    WebDriver driver;
    Action actions;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        String browserType = JsonUtils.readJsonFromFile("browserType");
        String url = JsonUtils.readJsonFromFile("url");
        driver = GenerateDriver.initDriver(browserType, url);
        actions = new Action(driver);
    }
    @BeforeMethod
    public void navigateToDefaultPage() {GenerateDriver.navigateToDefaultPage(driver);}

    @Description("Verify the home page loaded successfully")
    @Test(groups = {"Regression", "HomePage"}, priority = 1)
    public void HomePage() {
        Assert.assertFalse(actions.verifyPageLoaded(), "Verify the home page loaded successfully");
    }

    @Description("Subscription Eamil In Home Page")
    @Test(groups = {"Regression", "HomePage"}, priority = 2)
    public void SubscriptionButton() {
        Assert.assertFalse(actions.SubscriptionButton(), "Verify If Subscribed Successfully");
    }

    @AfterMethod()
    public void captureScreenshot() throws IOException {
        String testName = this.getClass().getName();
        File screenshot = ScreenshotUtils.captureScreenshot(driver, testName);
        Allure.addAttachment("Test screenshot", FileUtils.openInputStream(screenshot));
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
