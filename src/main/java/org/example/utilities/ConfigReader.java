package org.example.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static String URL;
    private static String CHROME_DRIVER;
    private static String RETRY_COUNT;

    public ConfigReader() {
        FileInputStream fis;
        Properties properties = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to read the config.properties file...");
            return;
        }

        URL = properties.getProperty("URL");
        CHROME_DRIVER = properties.getProperty("CHROME_DRIVER");
        RETRY_COUNT = properties.getProperty("RETRY_COUNT");
    }

    public static String getURL() {
        return URL;
    }

    public static String getChromeDriver() {
        return CHROME_DRIVER;
    }

    public static String getRetryCount() {
        return RETRY_COUNT;
    }
}
