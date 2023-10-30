package ext;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ChromeDriverExt implements BeforeAllCallback, AfterAllCallback {
    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
//        WebDriver driver = new  ChromeDriver();
//        WebDriverRunner.setWebDriver(driver);
        Configuration.timeout = 20000;
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        WebDriverRunner.getWebDriver().quit();
    }
}