package Pages;
import Components.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage{

    Product product = new Product(getDriver());
    public By productList = By.xpath("//article[contains(@class, 'product_pod')]");

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

    public List<String> getSubcategories(String category){
        List<String> subcategories = new ArrayList<>();
        WebElement categoryElement = getDriver().findElement(By.xpath("//li[@class='mt-2']/a[text()[contains(., '"+category+"')]]"));
        List<WebElement> categories = categoryElement.findElements(By.xpath("./following-sibling::ul/li/a"));
        for(WebElement elem : categories){
            subcategories.add(elem.getText());
        }
        return subcategories;
    }
}

