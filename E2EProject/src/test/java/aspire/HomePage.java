package aspire;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.ManufacturingPage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

public class HomePage extends Base {
    private WebDriver driver;
    private String baseUrl;
    private String productName;
    private String quantity;
    private LandingPage landingPage;
    private LoginPage loginPage;
    private ManufacturingPage manufacturingPage;

    @BeforeTest
    public void initialize() throws IOException, URISyntaxException {
        driver = initializeDriver();
        baseUrl = "https://aspireapp.odoo.com";
        productName = "DummyProduct";
        quantity = "15";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String Username, String Password, String text) throws InterruptedException {

        driver.get(baseUrl);
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        manufacturingPage = new ManufacturingPage(driver);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        loginPage.getEmail().sendKeys(Username);
        loginPage.getPassword().sendKeys(Password);
        loginPage.getLogin().click();

        landingPage.getInventory().click();
        landingPage.getProduct().click();
        landingPage.getProductInList().click();
        landingPage.getCreateProduct().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Print Labels')]")));
        landingPage.getProductName().sendKeys(productName);
        landingPage.getUpdateQuantity().click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your stock is currently empty')]")));

        landingPage.getCreateUpdateQuantity().click();
        landingPage.getCountedQuantity().clear();
        landingPage.getCountedQuantity().sendKeys(quantity);
        landingPage.getSaveQuantity().click();
        landingPage.getApplicationIcon().click();

        manufacturingPage.getManufacturingTab().click();
        manufacturingPage.getCreateOrder().click();
        manufacturingPage.insertName().click();
        manufacturingPage.insertName().sendKeys(productName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Create and Edit...")));
        manufacturingPage.insertName().sendKeys(Keys.ENTER);
        manufacturingPage.getConfirmButton().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[4]/span[1]")));
        manufacturingPage.getMarkAsDone().click();

        manufacturingPage.getFirstAlert().click();
        manufacturingPage.getSecondAlert().click();

        Assert.assertEquals(manufacturingPage.getProductName(), productName);
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[1][3];
        //0th row
        data[0][0] = "user@aspireapp.com";
        data[0][1] = "@sp1r3app";
        data[0][2] = " User";

        return data;


    }

}
