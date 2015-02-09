package Den;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConnectionConfig {

    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    private static String pathToConnectConfigFile = "src/main/java/Den/config";

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUrl() {
        return url;
    }

    public static String getDriver() {
        return driver;
    }

    static {
        FileInputStream fileInputStream;
        Properties property = new Properties();

        try {

            fileInputStream = new FileInputStream(pathToConnectConfigFile);
            property.load(fileInputStream);

            user = property.getProperty("db.user");
            password = property.getProperty("db.password");
            url = property.getProperty("db.url");
            driver = property.getProperty("db.driver");


        } catch (IOException e) {
            System.out.println("Ошибка чтения файла config");
        }
    }
}
