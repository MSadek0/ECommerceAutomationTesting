package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pagesElements.HooksElements;

public class ColorDefinitions extends HooksDefinitions{

    HooksElements login;



    @Given("user login to the app4")
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

    @When("user select a category with multiple colors")
    public void user_select_a_category_with_multiple_colors() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='header-menu']/ul/li/a[@href='/apparel']")).click();
        driver.findElement(By.xpath("//div[@class='sub-category-item']/h2/a")).click();


    }
    @And("user select filter with color")
    public void user_select_filter_with_color() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='filter-content']/ul/li/input" +
                "[@id='attribute-option-16']")).click();
        Thread.sleep(1000);
    }
    @Then("user can filter products with color")
    public void user_can_filter_products_with_color() throws InterruptedException {

        Assert.assertEquals("https://demo.nopcommerce.com/shoes?viewmode=grid&orderby=0&pagesize=6&specs=16",driver.getCurrentUrl());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/ul/li/a[@class='ico-logout']")).click();
        Thread.sleep(1000);
        driver.quit();


    }

}
