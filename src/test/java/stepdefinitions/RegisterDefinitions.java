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

public class RegisterDefinitions extends HooksDefinitions{


    HooksElements login;


//    @Before
//    public void before_all(){
//        System.out.println("1111111111111111");
////        driver.manage().window().maximize();
//        System.out.println("22222222222222222");
////        driver.navigate().to("https://demo.nopcommerce.com/");
//    }


    @Given("user navigate to the app and click on register")
    public void user_open_browser() throws InterruptedException {
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        login = new HooksElements(driver);
//        System.out.println("33333333333333333");
        driver.navigate().to("https://demo.nopcommerce.com/");

        driver.findElement(By.xpath("//div[@class='header-links']/ul/li/a[@class='ico-register']")).click();

    }


    @When("user fill the form with valid data")
    public void user_fill_the_form_with_valid_data() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='gender']/span/input[@id='gender-male']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("FirstName")).sendKeys("Most");
        Thread.sleep(1000);
        driver.findElement(By.id("LastName")).sendKeys("Khat");
        Thread.sleep(1000);
        //div[@class='date-picker-wrapper']/select[@name='DateOfBirthDay']/option[@value='2']
        driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[@name='DateOfBirthDay']/option[@value='2']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[@name='DateOfBirthMonth']/option[@value='2']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[@name='DateOfBirthYear']/option[@value='1983']")).click();
        Thread.sleep(500);
        login.HooksStepsUsername();
        Thread.sleep(500);
        login.HooksStepsPassword();
        Thread.sleep(500);
        login.HooksStepsConfirmPassword();
        Thread.sleep(500);


    }

    @And("user submit the register form")
    public void user_submit_the_register_form() throws InterruptedException {
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);


    }

    @Then("user can register successfully")
    public void user_can_register_successfully() throws InterruptedException {
        String expectedResult = "Your registration completed";
        Thread.sleep(2000);
        String actualResult = driver.findElement(By.xpath("//div[@class='page-body']/div[@class='result']")).getText();
        Assert.assertEquals(actualResult.contains(expectedResult),true);
        Thread.sleep(2000);
        driver.quit();




    }

//    @After
//    public void after_scenario(){
//        driver.quit();
//    }

}
