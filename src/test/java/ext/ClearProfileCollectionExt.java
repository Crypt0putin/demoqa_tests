package ext;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import page.ProfilePage;

public class ClearProfileCollectionExt implements AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        ProfilePage profilePage = extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).get("profilePage", ProfilePage.class);
        profilePage.openPage().
                setCountRowsPerPage("5").
                deleteAllBooks();
    }
}