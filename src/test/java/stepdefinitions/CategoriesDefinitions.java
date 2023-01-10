package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pagesElements.HooksElements;

public class CategoriesDefinitions extends HooksDefinitions{

    HooksElements login;

    @Given("user login to the app3")
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

    @When("user click on a category")
    public void user_click_on_a_category() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='header-menu']/ul/li/a")).click();


    }
    @And("user click on subcategory")
    public void user_click_on_subcategory() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='sub-category-item']/h2/" +
                "a[@title='Show products in category Notebooks']")).click();
        Thread.sleep(1000);
    }
    @Then("user can navigates categories on app")
    public void user_can_navigates_categories_on_app() throws InterruptedException {

        String expectedResult = "Notebooks";
        String actualResult = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        Assert.assertEquals(actualResult.contains(expectedResult),true);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/ul/li/a[@class='ico-logout']")).click();
        Thread.sleep(1000);
        driver.quit();


    }
}
