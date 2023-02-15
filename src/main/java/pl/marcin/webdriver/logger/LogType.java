package pl.marcin.webdriver.logger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LogType {
    INFO("INFO"),
    ERROR("ERROR"),
    WARNING("WARNING"),
    TEST_SUCCESS("TEST SUCCESS"),
    TEST_FAILED("TEST_FAILED"),
    TEST_SKIPPED("TEST SKIPPED");

    private String name;
}
