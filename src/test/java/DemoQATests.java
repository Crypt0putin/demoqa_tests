import ext.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import page.BooksPage;
import page.ProfilePage;

@ExtendWith({
        ChromeDriverExt.class,
        AuthExt.class,
        BookPageResolver.class,
        ProfilePageResolver.class})
public class DemoQATests {

    @Test
    @DisplayName("Сценарий 1")
    @Description("Тест авторизации и проверки пустого профиля.")
    @Story("Как пользователь, я могу авторизоваться и проверить пустой профиль")
    @Feature("Авторизация")
    @Tags({@Tag("Authorization"), @Tag("Profile")})  //Теги для JUnit и Allure
    @Severity(SeverityLevel.BLOCKER)    //Важность теста для Allure
    @Owner("Matveev")
    @Tag("Positive")
    public void testEmptyProfileCollection(ProfilePage profilePage) {
        assert profilePage
                .getBooksCount() == 0;
    }

    @Test
    @DisplayName("Сценарий 2")
    @Description("Тест добавления 2 книг в профиль.")
    @Story("Как пользователь, я могу авторизоваться и добавлять книги в профиль")
    @Feature("Добавление книг в профиль")
    @Tags({@Tag("Profile"), @Tag("BookStore")})  //Теги для JUnit и Allure
    @Severity(SeverityLevel.BLOCKER)    //Важность теста для Allure
    @Owner("Matveev")
    @Tag("Positive")
    public void testCheckDeleteBooks(ProfilePage profilePage, BooksPage booksPage) {
        int[] booksN = new int[]{1, 2};
        profilePage.gotoStore();
        booksPage.addBooks(booksN);
        int booksInProfile = profilePage
                .openPage()
                .getBooksCount();
        assert profilePage
                .deleteAllBooks()
                .getBooksCount() == 0;
        assert booksN.length == booksInProfile;
    }

    @Test
    @DisplayName("Сценарий 3")
    @Description("Тест добавления книг в профиль и удаления всех книг из профиля.")
    @Story("Как пользователь, я могу авторизоваться, добавлять и удалять книги в профиль")
    @Feature("Удаление книг из профиля")
    @Tags({@Tag("Profile"), @Tag("BookStore"), @Tag("Delete")})  //Теги для JUnit и Allure
    @Severity(SeverityLevel.BLOCKER)    //Важность теста для Allure
    @Owner("Matveev")
    @Tag("Positive")
    @ExtendWith(ClearProfileCollectionExt.class)
    public void testCheckCountBooks(ProfilePage profilePage, BooksPage booksPage) {
        // Сценарий 3. (добавить 6 книг и проверить их количество в профиле)
        int[] booksN = new int[]{0, 1, 2, 3, 4, 5};
        profilePage.gotoStore();
        booksPage.openPage().addBooks(booksN);
        int booksInProfile = profilePage
                .openPage()
                .setCountRowsPerPage("10")
                .getBooksCount();
        assert booksN.length == booksInProfile;
    }

}