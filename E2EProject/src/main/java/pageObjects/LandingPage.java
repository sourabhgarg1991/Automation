package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    WebDriver driver;

    By inventory = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/a[2]/div[1]");
    By products = By.xpath("//span[contains(text(),'Products')]");
    By productInList = By.xpath("//a[contains(text(),'Products')]");
    By createProduct = By.xpath("//button[contains(text(),'Create')]");
    By productName = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]/h1[1]/div[1]/input[1]");
    By updateQuantity = By.xpath("//span[contains(text(),'Update Quantity')]");
    By createUpdateQuantity = By.xpath("//button[contains(text(),'Create')]");
    By countedQuantity = By.xpath("//tbody/tr[1]/td[6]/input[1]");
    By saveQuantity = By.xpath("//button[contains(text(),'Save')]");
    By applicationIcon = By.xpath("//header/nav[1]/a[1]");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getInventory() {
        return driver.findElement(inventory);
    }

    public WebElement getProduct() {
        return driver.findElement(products);
    }

    public WebElement getProductInList() {
        return driver.findElement(productInList);
    }

    public WebElement getCreateProduct() {
        return driver.findElement(createProduct);
    }

    public WebElement getProductName() {
        return driver.findElement(productName);
    }

    public WebElement getUpdateQuantity() {
        return driver.findElement(updateQuantity);
    }

    public WebElement getCreateUpdateQuantity() {
        return driver.findElement(createUpdateQuantity);
    }

    public WebElement getCountedQuantity() {
        return driver.findElement(countedQuantity);
    }

    public WebElement getSaveQuantity() {
        return driver.findElement(saveQuantity);
    }

    public WebElement getApplicationIcon() {
        return driver.findElement(applicationIcon);
    }

}
