package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pagesElements.HooksElements;

public class CreateOrderDefinitions extends HooksDefinitions{

    HooksElements login;



    @Given("user login to the app9")
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

    @When("user add product to purchase")
    public void user_add_product_to_purchase() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='search-box store-search-box']" +
                "/form/input[@name='q']")).sendKeys("shoes");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='search-box store-search-box']" +
                "/form/button[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div/button[@onclick='return " +
                "AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/26/1/1\"),!1']")).click();
        Thread.sleep(5500);

    }
    @And("navigate to shopping cart")
    public void navigate_to_shopping_cart() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='header-links']/ul/li/a[@href='/cart']")).click();
        Thread.sleep(3000);
    }
    @And("user checkout and place the order")
    public void user_checkout_and_place_the_order() throws InterruptedException {
        //accept terms of conditions
        driver.findElement(By.xpath("//div[@class='terms-of-service']/input")).click();
        //click checkout
        driver.findElement(By.xpath("//div[@class='checkout-buttons']/button")).click();
        Thread.sleep(1500);
        //select country usa
        driver.findElement(By.xpath("//div[@class='inputs']/select[@id='BillingNewAddress_CountryId']/" +
                "option[@value='1']")).click();
        Thread.sleep(500);
        //select state
        driver.findElement(By.xpath("//div[@class='inputs']/select" +
                "[@id='BillingNewAddress_StateProvinceId']/option[@value='16']")).click();
        Thread.sleep(500);
        //enter city
        driver.findElement(By.xpath("//div[@class='inputs']/input[@id" +
                "='BillingNewAddress_City']")).sendKeys("New York");
        Thread.sleep(500);
        //enter address
        driver.findElement(By.xpath("//div[@class='inputs']/" +
                "input[@id='BillingNewAddress_Address1']")).sendKeys("downtown");
        Thread.sleep(500);
        //enter postal code
        driver.findElement(By.xpath("//div[@class='inputs']/" +
                "input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("10001");
        Thread.sleep(500);
        //enter phone no.
        driver.findElement(By.xpath("//div[@class='inputs']/" +
                "input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("01234567890");
        Thread.sleep(500);
        //click continue
        driver.findElement(By.xpath("//div[@class='buttons']/button[@name='save']")).click();
        Thread.sleep(1500);
        //click continue to save shipping method
        driver.findElement(By.xpath("//div[@class='buttons']/" +
                "button[@onclick='ShippingMethod.save()']")).click();
        Thread.sleep(1500);
        //click continue to confirm payment method
        driver.findElement(By.xpath("//div[@class='buttons']/" +
                "button[@onclick='PaymentMethod.save()']")).click();
        Thread.sleep(1500);
        //click continue to checkout
        driver.findElement(By.xpath("//div[@class='buttons']/button" +
                "[@onclick='PaymentInfo.save()']")).click();
        Thread.sleep(1500);
        //click continue to confirm order
        driver.findElement(By.xpath("//div[@class='buttons']/button" +
                "[@onclick='ConfirmOrder.save()']")).click();
        Thread.sleep(3000);
    }
    @Then("user can Create successful Order")
    public void user_can_create_successfull_order() throws InterruptedException {

        String expectedResult = "Your order has been successfully processed!";
        String actualResult = driver.findElement(By.xpath("//div[@class='section order-completed']" +
                "/div/strong")).getText();
        Assert.assertEquals(actualResult.contains(expectedResult),true);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/ul/li/a[@class='ico-logout']")).click();
        Thread.sleep(1000);
        driver.quit();



    }

}
