package pl.marcin.webdriver.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.marcin.webdriver.utils.FileReader;

import java.util.List;

public class EnvironmentsManager {
    private static final String PATH_TO_CONFIG_FILE = "\\config\\environments.json";
    private static String environmentUrl = null;

    public static String getUrlForEnvironment() {
        if (environmentUrl == null) {
            parseConfigurationFile();
        }
        return environmentUrl;
    }

    private static void parseConfigurationFile() {
        List<Environment> environments = getEnvironmentsFromConfigFile();
        Environment environment = getEnvironmentFromList(environments);
        checkEnvironmentConfiguration(environment);
        environmentUrl = environment.getUrl();
    }

    private static List<Environment> getEnvironmentsFromConfigFile() {
        String environmentsData = FileReader.readResourceFile(PATH_TO_CONFIG_FILE);
        Environments environments;

        try {
            environments = new ObjectMapper().readValue(environmentsData, Environments.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return environments.getEnvironments();
    }

    private static Environment getEnvironmentFromList(List<Environment> environments) {
        return environments.stream()
                .filter((environment) -> Configuration.ENVIRONMENT.equalsIgnoreCase(environment.getName()))
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalStateException("Environment config file doesn't contain environment: \""
                            + Configuration.ENVIRONMENT + "\". Please check config file!");
                });
    }

    private static void checkEnvironmentConfiguration(Environment environment) {
        if (!environment.isConfigurationCorrect()) {
            throw new IllegalStateException("Environment config for environment: \""
                    + Configuration.ENVIRONMENT + "\" doesn't contain required fields! Please check config file!");
        }
    }
}