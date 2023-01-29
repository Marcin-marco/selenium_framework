package pl.marcin.webdriver.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FileReader {

    public static String readResourceFile(String pathToFile) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            InputStream inputStream = classLoader.getResourceAsStream(pathToFile);
            if (inputStream == null) {
                throw new RuntimeException("File cannot be read or not found. File path: " + pathToFile
                        + " See console output!");
            }
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
