package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pagesElements.HooksElements;

public class SearchDefinition extends HooksDefinitions{
    HooksElements login;

    @Given("user login to the app1")
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

    @When("user enter a keyword in the search box")
    public void user_search_box() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='search-box store-search-box']/form/" +
                "input[@name='q']")).sendKeys("shoes");
        Thread.sleep(1000);

    }
    @And("user click on search button")
    public void user_click_on_search_button() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='search-box store-search-box']/form/" +
                "button[@type='submit']")).click();
        Thread.sleep(1000);

    }

    @Then("user can find a product after search")
    public void user_can_find_a_product_after_search() throws InterruptedException {
        String expectedResult = "Nike Floral Roshe Customized Running Shoes";
        String actualResult = driver.findElement(By.xpath("//div[@data-productid='24']/div/h2/a")).getText();
        Assert.assertEquals(actualResult.contains(expectedResult),true);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/ul/li/a[@class='ico-logout']")).click();
        Thread.sleep(1000);
        driver.quit();


    }

}
