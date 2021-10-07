package components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

@Getter
public class Product {

    private static WebDriver webDriver;
    private WebElement imageProduct;
    private String nameProduct;
    private double priceProduct;
    private String availabilityProduct;
    private WebElement productAddToBasket;

    By imageContainer = By.xpath(".//div[contains(@class, 'image_container')]");
    By nameContainer = By.xpath(".//h3[@class='mt-3']");
    By priceContainer = By.xpath(".//p[@class='price_color']");
    By availabilityContainer = By.xpath(".//p[contains(@class,'instock')]");
    By buttonContainer = By.xpath(".//form[contains(@action,'add')]");

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
        List<WebElement> boxElements = $(boxcontainer).findElements(boxcontainer);
        for(WebElement element : boxElements){
            WebElement image = $(element).findElement(imageContainer);
            String name = $(element).findElement(nameContainer).getText();
            double price = Double.parseDouble($(element).findElement(priceContainer).getText().substring(1));
            String availability = $(element).findElement(availabilityContainer).getText();
            WebElement addToBasketButton = $(element).findElement(buttonContainer);
            Product product = new Product(image, name, price, availability, addToBasketButton);
            products.add(product);
        }
        return products;
    }
}
