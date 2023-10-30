package ext.prop;
public enum Environment {
    TEST("test.properties");

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    Environment(String fileName) {
        this.fileName = fileName;
    }
}