package Aspire;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;
import java.net.URISyntaxException;

public class HomePage extends base {
    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException, URISyntaxException {
        driver = initializeDriver();
    }

    @Test(dataProvider = "getData")

    public void basePageNavigation(String Username, String Password, String text) throws IOException, InterruptedException {

        //one is inheritance
        // creating object to that class and invoke methods of it
        driver.get("https://aspireapp.odoo.com");
        LandingPage l = new LandingPage(driver);
        LoginPage lp = new LoginPage(driver);
        lp.getEmail().sendKeys(Username);
        lp.getPassword().sendKeys(Password);
        lp.getLogin().click();
        Thread.sleep(5000);
        l.getInventory().click();
        Thread.sleep(5000);
        l.getProduct().click();
        Thread.sleep(5000);
        l.getProductInList().click();
        Thread.sleep(5000);
        l.getCreateProduct().click();
        Thread.sleep(5000);
        l.getProductName().sendKeys("New Project");
       
        Thread.sleep(5000);


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
