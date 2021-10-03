package Components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Product {

    private static WebDriver webDriver;
    private WebElement imageProduct;
    private String nameProduct;
    private double priceProduct;
    private String availabilityProduct;
    private WebElement productAddToBasket;

    public Product(WebDriver driver){
        webDriver = driver;
    }

    public Product(WebElement imageProduct, String nameProduct, double priceProduct, String availabilityProduct, WebElement productAddToBasket){
        this.imageProduct = imageProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.availabilityProduct = availabilityProduct;
        this.productAddToBasket = productAddToBasket;
    }

    public List<Product> getAllItems(By boxcontainer){
        List<Product> products = new ArrayList<>();
        List<WebElement> boxElements = webDriver.findElements(boxcontainer);
        for(WebElement element : boxElements){
            WebElement imageProduct = element.findElement(By.xpath(".//div[contains(@class, 'image_container')]"));
            String nameProduct = element.findElement(By.xpath(".//h3[@class='mt-3']")).getText();
            double priceProduct = Double.parseDouble(element.findElement(By.xpath(".//p[@class='price_color']")).getText().substring(1));
            String availabilityProduct = element.findElement(By.xpath(".//p[contains(@class,'instock')]")).getText();
            WebElement productAddToBasket = element.findElement(By.xpath(".//form[contains(@action,'add')]"));
            Product product = new Product(imageProduct, nameProduct, priceProduct, availabilityProduct, productAddToBasket);
            products.add(product);
        }
        return products;
    }
}
