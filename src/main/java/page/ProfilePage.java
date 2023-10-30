package page;

import element.BaseElement;
import element.BaseElements;
import element.WaitAlerts;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    String url = "/profile";
    BaseElements bookCards = new BaseElements(By.cssSelector(".mr-2 a"));
    BaseElement gotoStore = new BaseElement(By.cssSelector("#gotoStore"));
    BaseElement deleteAllBooks = new BaseElement(By.xpath("(//div[.='Delete All Books'])[1]"));
    BaseElement deleteOk = new BaseElement(By.cssSelector("#closeSmallModal-ok"));
    BaseElement countRows = new BaseElement(By.cssSelector("select[aria-label='rows per page']"));

    public ProfilePage(String base_url){ super(base_url);}
    @Step("Delete all books")
    public ProfilePage deleteAllBooks() {
        deleteAllBooks.scrollIntoView().click();
        deleteOk.click();
        WaitAlerts.acceptAlert(20);
        return this;
    }

    public ProfilePage openPage() {
        super.openPage(this.url);
        return this;
    }

    @Step("goto Book Store")
    public void gotoStore() {
        gotoStore.click();
    }

    @Step("get books count at profile collection")
    public int getBooksCount() {
        return bookCards.size();
    }

    @Step("set count rows per page")
    public ProfilePage setCountRowsPerPage(String count) {
        countRows.selectOptionByValue(count);
        return this;
    }
}