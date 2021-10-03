package Pages;
import Components.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage{

    Product product = new Product(getDriver());
    public By productList = By.xpath("//article[contains(@class, 'product_pod')]");

    @FindBy(xpath = ".//select[@name='language']")
    private WebElement languagesBar;

    @FindBy(xpath ="//div[contains(@class, 'side_categories')]")
    private WebElement sideBarCategories;

    public MainPage(){ PageFactory.initElements(getDriver(), this); }

    public void openMainPage() {getDriver().get("https://zshop.pp.ua/en-gb/catalogue/");}


    public List<Product> getAllProducts(){
        return product.getAllItems(productList);
    }

    public Integer getProductsAmount(){
        return getAllProducts().size();
    }

    public List<String> getAllProductNamesWithLowerPrice(double price){
        List<Product> allProducts = getAllProducts();
        List<String> productsWithLowerPrice = new ArrayList<>();
        for(Product product : allProducts){
            if(product.getPriceProduct()<=price){
                productsWithLowerPrice.add(product.getNameProduct());
            }
        }
        return productsWithLowerPrice;
    }


    public boolean ifSideBarCategoriesIsPresent() {
        return sideBarCategories.isDisplayed();
    }
}
