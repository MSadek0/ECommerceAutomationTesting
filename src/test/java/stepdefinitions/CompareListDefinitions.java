package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pagesElements.HooksElements;

public class CompareListDefinitions extends HooksDefinitions{

    HooksElements login;



    @Given("user login to the app8")
    public void user_open_browser() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(2000);
        login = new HooksElements(driver);
        driver.navigate().to("https://demo.nopcommerce.com/");

        driver.findElement(By.xpath("//div[@class='header-links']/ul/li/a[@class='ico-login']")).click();
        login.HooksStepsUsername();
        Thread.sleep(500);
        login.HooksStepsPassword();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div/button[@type='submit']")).click();
        Thread.sleep(1000);
        String expectedResult = "My account";
        String actualResult = driver.findElement(By.xpath("//div/ul/li/a[@class='ico-account']")).getText();
        Assert.assertEquals(actualResult.contains(expectedResult), true);
        Thread.sleep(2000);

    }

    @When("user add first product to compare list")
    public void user_add_first_product_to_compare_list() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='search-box store-search-box']" +
                "/form/input[@name='q']")).sendKeys("shoes");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='search-box store-search-box']" +
                "/form/button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='buttons']/button[@onclick='return " +
                "AjaxCart.addproducttocomparelist(\"/compareproducts/add/26\"),!1']")).click();
        Thread.sleep(5000);

    }
    @And("user add second product to compare list")
    public void user_add_second_product_to_compare_ist() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='search-box store-search-box']" +
                "/form/input[@name='q']")).sendKeys("htc one");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='search-box store-search-box']" +
                "/form/button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='buttons']/button[@onclick='return " +
                "AjaxCart.addproducttocomparelist(\"/compareproducts/add/18\"),!1']")).click();
        Thread.sleep(5000);


    }

    @Then("user can add products to compare list")
    public void user_can_add_products_to_compare_list() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='footer-block customer-service']/ul/li/" +
                "a[@href='/compareproducts']")).click();
        Thread.sleep(3000);

        String expectedResult1 = "Nike SB Zoom Stefan Janoski \"Medium Mint\"";
        String actualResult1 = driver.findElement(By.xpath("//div[@class='table-wrapper']/table/tbody/" +
                "tr[@class='product-name']/td/a[@href='/nike-sb-zoom-stefan-janoski-medium-mint']")).getText();
        Assert.assertEquals(actualResult1.contains(expectedResult1),true);
        Thread.sleep(1000);

        String expectedResult2 = "HTC One M8 Android L 5.0 Lollipop";
        String actualResult2 = driver.findElement(By.xpath("//div[@class='table-wrapper']/table/tbody/" +
                "tr[@class='product-name']/td/a[@href='/htc-one-m8-android-l-50-lollipop']")).getText();
        Assert.assertEquals(actualResult2.contains(expectedResult2),true);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/ul/li/a[@class='ico-logout']")).click();
        Thread.sleep(1000);
        driver.quit();


    }

}
