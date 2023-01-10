package stepdefinitions;


import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import pagesElements.HooksElements;


public class LoginDefinitions extends HooksDefinitions {


    HooksElements login;

//   @Before
//    public void before(){
//
//       driver.manage().window().maximize();
//
//
//    }


    @Given("user Navigate to the app and click login")
    public void user_open_browser() throws InterruptedException {

//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        login = new HooksElements(driver);
        driver.navigate().to("https://demo.nopcommerce.com/");

        driver.findElement(By.xpath("//div[@class='header-links']/ul/li/a[@class='ico-login']")).click();

    }


    @When("user enter email and password")
    public void user_enter_email_and_password() throws InterruptedException {

        login.HooksStepsUsername();
        Thread.sleep(1000);
        login.HooksStepsPassword();
        Thread.sleep(1000);



    }


    @And("user click login button")
    public void user_click_login() throws InterruptedException {
        driver.findElement(By.xpath("//div/button[@type='submit']")).click();
        Thread.sleep(1000);

    }

    @Then("user login successfully")
    public void user_login_successfully() throws InterruptedException {

        String expectedResult = "My account";
        String actualResult = driver.findElement(By.xpath("//div/ul/li/a[@class='ico-account']")).getText();
        Assert.assertEquals(actualResult.contains(expectedResult), true);
        Thread.sleep(2000);

    }



    @And("user logout and close browser")
    public void user_logout_and_close_browser() throws InterruptedException {
        driver.findElement(By.xpath("//div/ul/li/a[@class='ico-logout']")).click();
        Thread.sleep(1000);
        driver.quit();



    }
//    @After
//    public void afterScenario(){
//        driver.quit();
//    }


}


