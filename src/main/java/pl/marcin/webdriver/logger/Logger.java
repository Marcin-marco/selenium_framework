package pl.marcin.webdriver.logger;

import pl.marcin.webdriver.configuration.Configuration;
import pl.marcin.webdriver.utils.TimeUtil;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static final ThreadLocal<List<String>> logTable = ThreadLocal.withInitial(ArrayList::new);
    private static int testCounter = 1;

    public static void addTestHeader(String testMethod) {
        String header = String.format("%d-[%s]-[%s]-[%s]",
                testCounter++, testMethod, Configuration.BROWSER.get(), Configuration.ENVIRONMENT);
        logTable.get().add(header);
    }

    public static String getLog() {
        StringBuilder log = new StringBuilder();
        for (String row : logTable.get()) {
            log.append(row).append("\n");
        }
        return log.toString();
    }

    public static void log(LogType logType, String message) {
        String line = String.format("%s - [%s]-[%s] - %s",
                TimeUtil.getCurrentTime(), logType.getName(), getClassName(), message);
        logTable.get().add(line);
    }

    private static String getClassName() {
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        String[] array = className.split("\\.");
        return array[array.length - 1];
    }

    public static void clearLogTable() {
        logTable.get().clear();
    }

    public static void printLogs() {
        System.out.println(getLog());
    }
}
