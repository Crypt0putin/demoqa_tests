package ext;

import ext.prop.PropertyProvider;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import page.ProfilePage;

public class ProfilePageResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(ProfilePage.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        ProfilePage profilePage = new ProfilePage( PropertyProvider.getInstance().getProps().getProperty("test.url"));
        extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).put("profilePage", profilePage);
        return profilePage;
    }
}