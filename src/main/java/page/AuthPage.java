package page;

import element.BaseElement;
import org.openqa.selenium.By;
import io.qameta.allure.Step;

public class AuthPage extends BasePage {
    String url = "/login";
    BaseElement username = new BaseElement(By.id("userName"));
    BaseElement password = new BaseElement(By.cssSelector("#password-wrapper input"));
    BaseElement loginButton = new BaseElement(By.cssSelector(".text-right button"));

    public AuthPage(String base_url) {
        super(base_url);
    }

    @Override
    public AuthPage openPage() {
        super.openPage(this.url);
        return this;
    }

    @Step("auth")
    public void login(String username, String password) {
        this.username.input(username);
        this.password.input(password).pressEnter();
    }
}