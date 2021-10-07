package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{

    By emailField = By.xpath("//form[@id='login_form']//input[@type='email']");
    By passwordField = By.xpath("//form[@id='login_form']//input[@type='password']");
    By loginBtn = By.xpath("//button[@name='login_submit']");

    public void fillInFormsAndLogin(String email, String password){
        $(loginBtn).shouldBe(Condition.visible);
        $(emailField).sendKeys(email);
        $(passwordField).sendKeys(password);
        $(loginBtn).click();
    }
}
