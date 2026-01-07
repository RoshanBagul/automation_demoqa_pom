package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties prop;
    public static Properties getProperties () throws IOException {
        prop = new Properties();
        FileInputStream objfile = new FileInputStream("src/test/resources/config.properties");
        prop.load(objfile);
        return prop;
    }

    public static String get(String key) throws IOException {
        return getProperties().getProperty(key);
    }
}
