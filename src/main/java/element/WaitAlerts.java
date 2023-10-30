package element;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitAlerts {
    public static void acceptAlert(int seconds){
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(seconds));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}