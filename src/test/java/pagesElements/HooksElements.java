package pagesElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HooksElements {

    WebDriver driver;

    public HooksElements(WebDriver driver) {
        this.driver = driver;


    }

    public WebElement usernameElement()
    {
        return driver.findElement(By.xpath("//div/input[@id='Email']"));

    }
    public WebElement passwordElement()
    {
        return driver.findElement(By.id("Password"));

    }
    public WebElement confirmPasswordElement()
    {
        return driver.findElement(By.id("ConfirmPassword"));

    }

    public void HooksStepsUsername()
    {

        usernameElement().sendKeys("arab.gold04@gmail.com");



    }
    public void HooksStepsPassword()
    {


        passwordElement().sendKeys("123456");

    }
    public void HooksStepsConfirmPassword()
    {


        confirmPasswordElement().sendKeys("123456");

    }






}
