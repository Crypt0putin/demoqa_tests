package element;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class BaseElements {

    private final By locator;

    public BaseElements(By locator) {
        this.locator = locator;
            }

    public void clickOn(int idx) {
        $$(locator).get(idx).click();
    }

    public int size() {
        return $$(locator).size();
    }


}