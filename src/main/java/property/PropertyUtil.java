package property;

import constants.TestConstants;
import customExceptions.PropertyFileUsageException;
import enums.ConfigProperties;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtil {

    private PropertyUtil() {
    }

    private static final Properties property = new Properties();

    static void loadProperties(String propertyFilePath) {
        try (FileInputStream input = new FileInputStream(propertyFilePath)) {
            property.load(input);
        } catch (IOException e) {
            throw new PropertyFileUsageException("IOException occurred while loading Property file in the specified path");
        }
    }

    public static String getPropertyValue(ConfigProperties key) {
        loadProperties(TestConstants.CONFIG_PROPERTIES_PATH);
        if (Objects.isNull(property.getProperty(key.name().toLowerCase())) || Objects.isNull(key.name().toLowerCase())) {
            throw new PropertyFileUsageException("Property name - " + key + " is not found. Please check the config.properties");
        }
        return property.getProperty(key.name().toLowerCase());
    }

    public static String getPropertyValue(String key) {
        loadProperties(TestConstants.CONFIG_PROPERTIES_PATH);
        if (Objects.isNull(property.getProperty(key.toLowerCase())) || Objects.isNull(key.toLowerCase())) {
            throw new PropertyFileUsageException("Property name - " + key + " is not found. Please check the config.properties");
        }
        return property.getProperty(key.toLowerCase());
    }
}