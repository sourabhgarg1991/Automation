package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManufacturingPage {
    public WebDriver driver;

    By manufacturingTab = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/a[3]/div[1]");
    By createOrder = By.xpath("//button[contains(text(),'Create')]");
    By insertProdName = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[5]/td[2]/div[1]/div[1]/div[1]/input[1]");
    //By sendMeInstructions = By.cssSelector("[type='submit']");
    By confirmButton = By.xpath("//span[contains(text(),'Confirm')]");
    By markAsDone = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[4]/span[1]");
    By firstAlert = By.xpath("//span[contains(text(),'Ok')]");
    By secondAlert = By.xpath("//span[contains(text(),'Apply')]");

    public ManufacturingPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
    }

    public WebElement getManufacturingTab() {
        return driver.findElement(manufacturingTab);
    }

    public WebElement getCreateOrder() {
        return driver.findElement(createOrder);
    }

    public WebElement insertName() {
        return driver.findElement(insertProdName);
    }

    public WebElement getConfirmButton() {
        return driver.findElement(confirmButton);
    }

    public WebElement getMarkAsDone() {
        return driver.findElement(markAsDone);
    }

    public WebElement getFirstAlert() {
        return driver.findElement(firstAlert);
    }

    public WebElement getSecondAlert() {
        return driver.findElement(secondAlert);
    }

    public String getProductName() {
        return driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[5]/td[2]")).getText();
    }
}
