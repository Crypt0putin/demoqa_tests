package ext;

import ext.prop.PropertyProvider;

import org.junit.jupiter.api.extension.*;
import page.BooksPage;

public class BookPageResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(BooksPage.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
       return new BooksPage(PropertyProvider.getInstance().getProps().getProperty("test.url"));
    }
}