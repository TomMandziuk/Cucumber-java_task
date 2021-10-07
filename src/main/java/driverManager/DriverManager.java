package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    private DriverManager(){}

    public static WebDriver getDriver() {
        if (DRIVER_THREAD_LOCAL.get() == null) {
            init();
        }
        return DRIVER_THREAD_LOCAL.get();
    }

    public static synchronized void killDriver() {
        if (DRIVER_THREAD_LOCAL.get() != null) {
            DRIVER_THREAD_LOCAL.get().quit();
            DRIVER_THREAD_LOCAL.remove();
        }
    }

    private static void init() {
        String browser = System.getProperty("browser", "chrome");

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                DRIVER_THREAD_LOCAL.set(new ChromeDriver());
                DRIVER_THREAD_LOCAL.get().manage().window().maximize();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                DRIVER_THREAD_LOCAL.set(new FirefoxDriver());
                DRIVER_THREAD_LOCAL.get().manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException(String.format("Browser %s not found", browser));
        }
    }
}
