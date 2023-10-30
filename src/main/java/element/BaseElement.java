package element;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;


public class BaseElement {
    private final By locator;
    private SelenideElement element;

    public BaseElement(By locator) {
        this.locator = locator;
    }
    public BaseElement scrollIntoView(){
        WebDriverRunner.driver().executeJavaScript("arguments[0].scrollIntoView(true);",$(locator));
        return this;
    }

    public void click() {
        try {
            element = $(locator);
            element.click();
        } catch (ElementClickInterceptedException e) {
           WebDriverRunner.driver().executeJavaScript("arguments[0].click()", element);
        }
    }
        public BaseElement input(String text){
            $(locator).val(text);
            return this;
        }
        public void pressEnter () {
            $(locator).pressEnter();
        }

        public void selectOptionByValue (String text){
            $(locator).selectOptionByValue(text);
        }


    }