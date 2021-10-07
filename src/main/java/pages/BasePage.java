package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driverManager.DriverManager.getDriver;

public class BasePage {

    public WebElement waitUntilVisible(WebElement element, int time) {
        return new WebDriverWait(getDriver(), time)
                .until(ExpectedConditions.visibilityOf(element));
    }

}