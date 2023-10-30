package ext;

import com.codeborne.selenide.WebDriverRunner;
import ext.prop.PropertyProvider;
import io.qameta.allure.Step;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import page.AuthPage;

import java.util.Properties;

public class AuthExt implements BeforeEachCallback, AfterEachCallback {
    @Override
    @Step("Authorization")
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        Properties props = PropertyProvider.getInstance().getProps();
        AuthPage authPage = new AuthPage(props.getProperty("test.url"));
        authPage
                .openPage()
                .login(props.getProperty("test.user"),
                        props.getProperty("test.password"));

    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        WebDriverRunner.getWebDriver().close();
    }
}