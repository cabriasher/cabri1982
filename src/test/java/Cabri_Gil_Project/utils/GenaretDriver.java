import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import sun.net.www.protocol.http.HttpCallerInfo;

public static void initDriver(String browserType, URL url) {
    HttpCallerInfo GenaretDriver;
    GenaretDriver = null;
    GenaretDriver.url = url;
    WebDriver driver = switch (browserType.toLowerCase()) {
        case "chrome" -> {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("--headless");
            yield new ChromeDriver(chromeOptions);
        }
        default -> throw new IllegalStateException("Unexpected value: " + browserType.toLowerCase());
    };

}

public void main() {
}



