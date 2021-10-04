package Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    public static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setDriver(WebDriver webDriver) {
        DRIVER_THREAD_LOCAL.set(webDriver);
    }

    public static WebDriver getDriver() {
        return DRIVER_THREAD_LOCAL.get();
    }


}
