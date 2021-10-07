package stepDefs;

import pages.LoginPage;
import io.cucumber.java.en.*;

public class loginPageStepDefs {

    LoginPage loginPage = new LoginPage();

    @When("User login with {string} and {string}")
    public void user_login_with_and(String email, String password) {
        loginPage.fillInFormsAndLogin(email, password);
    }

}