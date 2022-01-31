package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    WebDriver driver;

    By inventory = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/a[2]/div[1]");
    By products = By.xpath("//span[contains(text(),'Products')]");
    By productInList=By.xpath("//a[contains(text(),'Products')]");
    By createProduct = By.xpath("//button[contains(text(),'Create')]");
    By productName = By.xpath("//input[@id='o_field_input_601']");
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

//    public LoginPage getLogin() {
//        driver.findElement(signin).click();
//        LoginPage lp = new LoginPage(driver);
//        return lp;
//    }


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

}
