package json;

import constants.TestConstants;
import customExceptions.InvalidPathException;
import customExceptions.JsonFileUsageException;
import enums.ConfigJson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class JsonUtils {

    private static Map<String, String> map;

    public static String getValue(String key) {
        try {
            return JsonPath.read(new File(TestConstants.CONFIG_JSON_PATH), key);
        } catch (IOException e) {
            throw new InvalidPathException("Check the config.json");
        }
    }

    static void readJson(String jsonPath) {
        try {
            map = new ObjectMapper().readValue(new File(jsonPath),
                    new TypeReference<HashMap<String, String>>() {
                    });
        } catch (IOException e) {
            throw new JsonFileUsageException("IOException occurred while reading Json file in the specified path");
        }
    }

    public static String getConfig(ConfigJson key) {
        readJson(TestConstants.CONFIG_JSON_PATH);
        if (Objects.isNull(map.get(key.name().toLowerCase()))) {
            throw new JsonFileUsageException("Property name - " + key + " is not found. Please check the config.json");
        }
        //MyLogger.INFO("returing property : " + key.name().toLowerCase());
        return map.get(key.name().toLowerCase());
    }

    public static String getConfig(String key) {
        readJson(TestConstants.CONFIG_JSON_PATH);
        if (Objects.isNull(map.get(key))) {
            throw new JsonFileUsageException("Property name - " + key + " is not found. Please check the config.json");
        }
        return map.get(key.toLowerCase());
    }
}
