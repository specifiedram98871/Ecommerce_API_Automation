package framework.utils;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {

    public static JSONObject getJsonFromFile(String path) {

        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            return new JSONObject(content);

        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file: " + path);
        }
    }
}