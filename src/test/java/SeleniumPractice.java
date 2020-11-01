import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class SeleniumPractice {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public void CheckURL(){
        //Launch Website
        driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");
        Assert.assertTrue(driver.getCurrentUrl().contains("testandquiz"));

        //get the title of the page
        System.out.println(driver.getTitle());

        //navigate to Link
        driver.findElement(By.linkText("This is a link")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("javatpoint"));

        //check the TextBox
        driver.navigate().back();
        driver.findElement(By.name("firstName")).sendKeys("LEILA");

        //check the submit button
        driver.findElement(By.id("idOfButton")).click();
        WebElement submitButton= driver.findElement(By.id("idOfButton"));
        Assert.assertEquals(true,submitButton.isEnabled());
        System.out.println("submit button is enabled");
        //Clear the text written in text box;
        driver.findElement(By.name("firstName")).clear();

        //check the radio button
        WebElement gender=driver.findElement(By.id("female"));
        gender.click();
        Assert.assertEquals(true,gender.isSelected());
        System.out.println("Radio button is selected");

        //check the checkBox
        WebElement radio1= driver.findElement(By.className("Automation"));
        //radio button1 is selected
        radio1.click();
        if (radio1.isSelected()) {
            System.out.println("checkbox is toggled On");
        }
        else{
            System.out.println("checkbox is toggled off");
        }

        //check the dropDown:using the select class to select value from the dropdown
        WebElement testingDropdown= driver.findElement(By.id("testingDropdown"));
        Select dropdown=new Select(testingDropdown);
        dropdown.selectByVisibleText("Database Testing");


    }




}

