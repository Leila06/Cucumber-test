import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }
    public void checkSearch(String Keywords){
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        WebElement SearchBox= driver.findElement(By.id("twotabsearchtextbox"));
        WebElement SearchButton= driver.findElement(By.xpath("//input[@type='submit']"));
        SearchBox.sendKeys(Keywords);
        SearchButton.click();
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains(Keywords));

}
    public void signUp(String username,String password) {
        WebElement accountButton=driver.findElement(By.xpath("//span[contains(text(),'Account & Lists')]"));
        accountButton.click();
        WebElement signUpUsername=driver.findElement(By.name("email"));
        signUpUsername.sendKeys(username);
        WebElement continueButton= driver.findElement(By.id("continue"));
        continueButton.click();
        WebElement signUpPassword= driver.findElement(By.id("ap_password"));
        signUpPassword.sendKeys(password);
        WebElement signInButton= driver.findElement(By.id("signInSubmit"));
        signInButton.click();

    }
@Test
    public void AmazonSearch(){
        Assert.assertTrue(driver.getTitle().contains("Amazon") );
        //Search
        checkSearch("halloween decorations");
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    //choose a category
driver.findElement(By.xpath("//a[contains(@href,\"Halloween\")]")).click();
    System.out.println(driver.getTitle());
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    //choose a product
    driver.findElement(By.xpath("//span[contains(text(),'Halloween Decorations')]")).click();
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    Assert.assertTrue(driver.findElement(By.id("landingImage")).isDisplayed());
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    //add to cart
    driver.findElement(By.id("add-to-cart-button")).click();

    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    driver.findElement(By.id("hlb-ptc-btn-native")).click();
    Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).isDisplayed());
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
@Test
     public void AmazonSignUp(){
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    signUp("lila.delil@hotmail.com","test2020");
       Assert.assertTrue(driver.findElement(By.xpath("//span[@class='a-list-item']")).isDisplayed());

     }
     @Test
     public void checkHome(){
        //check the home button
        WebElement homeButton=  driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']"));
      homeButton.click();
         try {
             Thread.sleep(3000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Hello, Sign in']")).isDisplayed());
         //select a category
         driver.findElement(By.xpath("//div[text()='Books']")).click();
         driver.findElement(By.linkText("Children's Books")).click();
         System.out.println(driver.getTitle());
         Assert.assertTrue(driver.getTitle().contains("Children's Books"));
         try {
             Thread.sleep(3000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         //Check the dropdown of the search
         WebElement dropdownMenu= driver.findElement(By.id("searchDropdownBox"));
         Select dropDown= new Select(dropdownMenu);
         dropDown.selectByVisibleText("Appliances");
         try {
             Thread.sleep(3000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         driver.findElement(By.xpath("//input[@type='submit']")).click();
         try {
             Thread.sleep(3000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         Assert.assertTrue(driver.findElement(By.xpath("//img[@alt=\"Appliances\"]")).isDisplayed());





     }
@After
    public void tearDown(){
        driver.close();
}





}
