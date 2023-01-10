package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pagesElements.HooksElements;

public class CurrencyDefinition extends HooksDefinitions{

    HooksElements login;
    @Given("user login to the app2")
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

    @When("user select currency to euro")
    public void user_select_currency_to_euro() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='header-selectors-wrapper']/div/select/option" +
                "[@value='https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F']")).click();


    }
    @Then("user can change the currency to euro")
    public void user_can_change_the_currency_to_euro() throws InterruptedException {

        String expectedResult = "Euro";
        String actualResult = driver.findElement(By.xpath("//div[@class='header-selectors-wrapper']" +
                "/div/select/option[@value='https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F']")).getText();
        Assert.assertEquals(actualResult.contains(expectedResult),true);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/ul/li/a[@class='ico-logout']")).click();
        Thread.sleep(1000);
        driver.quit();


    }
}
