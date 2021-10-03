package stepDefs;

import Pages.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;


public class MainPageStepDefs {

    MainPage mainPage = new MainPage();

    @Given("User is on Home page")
    public void user_is_on_home_page() {
        System.out.println("IT'S GIVEn");
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
        System.out.println(mainPage.getAllProductNamesWithLowerPrice(price));
    }

    @Then("User sees {string} contains categories")
    public void user_sees_books_contains_categories(String categoryName, DataTable dataTable) {


    }
}
