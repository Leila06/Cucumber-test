import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest1 {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

  @Test
    public void checkFbk(){
        driver.get("https://www.facebook.com/");
      Assert.assertTrue(driver.getTitle().contains("Facebook"));
      driver.findElement(By.name("email")).sendKeys("lila.delil@hotmail.com");
      driver.findElement(By.name("pass")).sendKeys("test2020");
      try {
          Thread.sleep(300);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      driver.findElement(By.name("login")).click();
      try {
          Thread.sleep(3000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      Assert.assertTrue(driver.findElement(By.xpath("//div[text()='The password you’ve entered is incorrect. ']")).isDisplayed());

  }
}