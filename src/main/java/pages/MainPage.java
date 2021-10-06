package pages;
import components.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static driverManager.DriverManager.getDriver;

public class MainPage extends BasePage {

    Product products = new Product(getDriver());
    protected By productList = By.xpath("//article[contains(@class, 'product_pod')]");

    @FindBy(xpath ="//div[contains(@class, 'side_categories')]")
    private WebElement sideCategoriesBar;

    public MainPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public void openMainPage() {
        getDriver().get("https://zshop.pp.ua/en-gb/catalogue/");
        waitUntilVisible(sideCategoriesBar, 10);
    }


    public List<Product> getAllProducts() {
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
        }
        return productsWithLowerPrice;
    }

    public List<String> getSubcategories(String category) {
        List<String> subcategories = new ArrayList<>();
        WebElement categoryElement = getDriver().findElement(By.xpath("//li[@class='mt-2']/a[text()[contains(., '" + category + "')]]"));
        List<WebElement> categories = categoryElement.findElements(By.xpath("./following-sibling::ul/li/a"));
        for (WebElement elem : categories) {
            subcategories.add(elem.getText());
        }
        return subcategories;
    }
}