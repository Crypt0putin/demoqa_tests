package page;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    String BASE_URL;
    protected BasePage(String base_url){
        BASE_URL=base_url;
    }

    protected BasePage openPage() {
        open(BASE_URL);
        return this;
    }
    protected void openPage(String url) {
        open(BASE_URL + url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

}