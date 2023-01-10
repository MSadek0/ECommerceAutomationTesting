package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pagesElements.HooksElements;

public class TagsDefinitions extends HooksDefinitions{

    HooksElements login;



    @Given("user login to the app5")
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

    @When("user click on a category and select a tag of tags list")
    public void user_click_on_a_category_and_select_a_tag_of_tags_list() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='header-menu']/ul/li/a[@href='/apparel']")).click();
        driver.findElement(By.xpath("//div[@class='listbox']//div/ul/li/a[@href='/cool']")).click();
        Thread.sleep(1000);


    }
    @And("user click on another tag")
    public void user_click_on_another_tag() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='listbox']//div/ul/li/a[@href='/game']")).click();
        Thread.sleep(1000);
    }
    @Then("user can select different tags")
    public void user_can_select_different_tags() throws InterruptedException {

        String expectedResult = "Products tagged with 'game'";
        String actualResult = driver.findElement(By.xpath("//div[@class='page product-tag-page']" +
                "/div/h1")).getText();
        Assert.assertEquals(actualResult.contains(expectedResult),true);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/ul/li/a[@class='ico-logout']")).click();
        Thread.sleep(1000);
        driver.quit();


    }
}
