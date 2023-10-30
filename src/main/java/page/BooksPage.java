package page;

import element.WaitAlerts;
import element.BaseElement;
import element.BaseElements;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

public class BooksPage extends BasePage {
    String url = "/books";
    Cookie token;
    BaseElements bookCards = new BaseElements(By.cssSelector(".mr-2 a"));
    BaseElement addBook = new BaseElement(By.cssSelector(".text-right button#addNewRecordButton"));
    BaseElement goBack = new BaseElement(By.cssSelector(".text-left button#addNewRecordButton"));

    public BooksPage(String base_url) {
        super(base_url);
    }

    @Step("open Book Store page")
    @Override
    public BooksPage openPage() {
        super.openPage(this.url);
        return this;
    }

    @Step("goto book card")
    public BooksPage gotoBook(int idx) {
        bookCards.clickOn(idx);
        return this;
    }

    @Step("click add book button")
    public BooksPage addBookClick() {
        addBook.click();
        WaitAlerts.acceptAlert(20);
        return this;
    }

    @Step("go back to book list ")
    public BooksPage goBack() {
        goBack.click();
        return this;
    }

    @Step("add book by index")
    public BooksPage addBook(int idx) {
        return gotoBook(idx).addBookClick().goBack();
    }

    @Step("add books from list indexes")
    public BooksPage addBooks(int[] idxs) {
        for (int idx : idxs) addBook(idx);
        return this;
    }
}