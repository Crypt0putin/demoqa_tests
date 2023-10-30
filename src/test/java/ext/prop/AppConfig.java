package ext.prop;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface AppConfig extends Config {

    @Key("test.url")
    String testUrl();

    @Key("test.user")
    String testUser();

    @Key("test.pass")
    String testPass();
}