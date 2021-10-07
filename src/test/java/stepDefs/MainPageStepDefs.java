package stepDefs;

import pages.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class MainPageStepDefs {

    MainPage mainPage = new MainPage();

    @Given("User is on Home page")
    public void user_is_on_home_page() {
        mainPage.openMainPage();
    }

    @Then("User see {int} products")
    public void user_see_products(Integer amountOfProducts) {
        assertEquals(mainPage.getProductsAmount(), amountOfProducts);
    }

    @Then("User see each product have picture, price, availability and Add to basket button")
    public void user_see_each_product_have_picture_price_availability_and_add_to_basket_button() {
        mainPage.getAllProducts();
    }

    @Then("User see each price is higher than {double}")
    public void user_see_each_price_is_higher(double price) {
        assertEquals(0, mainPage.getAllProductNamesWithLowerPrice(price).size());
    }

    @Then("User sees {string} contains subcategories")
    public void user_sees_category_contains_subcategories(String categoryName, DataTable dataTable) {
        List<String> subcategories = dataTable.asList();
        assertEquals(subcategories, mainPage.getSubcategories(categoryName));
    }

    @When("User click on Login button")
    public void user_click_on_login_button() {
        mainPage.goToLoginPage();
    }

    @Then("User can see Login message")
    public void user_can_see_login_message() {
        mainPage.checkIfSuccessfulLoginMessageIsPresent();
    }
}
