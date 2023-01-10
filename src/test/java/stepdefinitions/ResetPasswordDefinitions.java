package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagesElements.HooksElements;

public class ResetPasswordDefinitions extends HooksDefinitions {

    HooksElements login;

//   @Before
//    public void setup(){
//
//       driver.manage().window().maximize();
//    }

    @Given("user Navigate to the app and click login to reset password")
    public void user_open_browser() throws InterruptedException {
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        login = new HooksElements(driver);

        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//div[@class='header-links']/ul/li/a[@class='ico-login']")).click();
        Thread.sleep(1000);

    }
    @When("user click on forgot password")
    public void user_click_on_forgot_password() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='inputs reversed']/span/a")).click();
        Thread.sleep(1000);


    }
    @And("user enter email")
    public void user_enter_email() throws InterruptedException {

        login.HooksStepsUsername();
        Thread.sleep(1000);

    }

    @And("user click recover")
    public void user_click_recover() throws InterruptedException {
        driver.findElement(By.xpath("//div/button[@type='submit']")).click();
        Thread.sleep(1000);
    }

    @Then("user recover successfully")
    public void user_recover_successfully() throws InterruptedException {

        String expectedResult = "Email with instructions has been sent to you.";
        String actualResult = driver.findElement(By.xpath("//div[@class='bar-notification success']/p")).getText();
        Assert.assertEquals(actualResult.contains(expectedResult), true);
        Thread.sleep(2000);
        driver.quit();

    }

//    @After
//    public void after_scenario(){
//        driver.quit();
//    }


}
