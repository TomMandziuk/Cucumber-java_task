package pages;
import com.codeborne.selenide.Condition;
import components.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Selenide.*;

import java.util.ArrayList;
import java.util.List;

import static driverManager.DriverManager.getDriver;

public class MainPage extends BasePage {

    protected By productList = By.xpath("//article[contains(@class, 'product_pod')]");
    protected By loginButton = By.xpath("//a[@id='login_link']");
    protected By successfulLoginMessage = By.xpath("//div[@class[contains(., 'alert-success')]]");
    protected By subCategories = By.xpath("./following-sibling::ul/li/a");

    String baseUrl = "https://zshop.pp.ua/en-gb/catalogue/";

    public void openMainPage() {
        open(baseUrl);
        $(productList).shouldBe(Condition.visible);
    }


    public List<Product> getAllProducts() {
        Product products = new Product(getDriver());
        return products.getAllItems(productList);
    }

    public Integer getProductsAmount() {
        return getAllProducts().size();
    }

    public List<String> getAllProductNamesWithLowerPrice(double price) {
        List<Product> allProducts = getAllProducts();
        List<String> productsWithLowerPrice = new ArrayList<>();
        for (Product prod : allProducts) {
            if (prod.getPriceProduct() <= price) {
                productsWithLowerPrice.add(prod.getNameProduct());
            }
            if(!productsWithLowerPrice.isEmpty()){
                System.out.println(productsWithLowerPrice);
            }
        }
        return productsWithLowerPrice;
    }

    public List<String> getSubcategories(String category) {
        List<String> subcategories = new ArrayList<>();
        WebElement categoryElement = $(By.xpath("//li[@class='mt-2']/a[text()[contains(., '" + category + "')]]"));
        List<WebElement> subCategoriesList = $(categoryElement).findElements(subCategories);
        for (WebElement subCategoryItem : subCategoriesList) {
            subcategories.add(subCategoryItem.getText());
        }
        return subcategories;
    }

    public void goToLoginPage(){
        $(loginButton).click();
    }

    public void checkIfSuccessfulLoginMessageIsPresent(){
        $(successfulLoginMessage).shouldBe(Condition.visible);
    }
}