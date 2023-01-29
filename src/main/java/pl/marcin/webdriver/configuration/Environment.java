package pl.marcin.webdriver.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Environment {
    private String name;
    private String protocol;
    private String host;
    private String port;

    public String getUrl() {
        return String.format("%s://%s:%s", protocol, host, port);
    }

    public boolean isConfigurationCorrect() {
        return Stream.of(getClass().getDeclaredFields()).allMatch(Objects::nonNull);
    }
}
