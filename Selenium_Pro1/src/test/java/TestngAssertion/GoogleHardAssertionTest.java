package TestngAssertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleHardAssertionTest {
    WebDriver driver=null;
    @BeforeClass
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }
    @Test
    public void verifyGoogleHomePage(){
        System.out.println("Title validation");
        String actualTitle=driver.getTitle();
        String expectedTitle="Google123";
        Assert.assertEquals(actualTitle,expectedTitle,"Page title does not match");
        System.out.println("Logo Validation");
        WebElement logo=driver.findElement(By.xpath("//img[@alt='Google']"));
        Assert.assertTrue(logo.isDisplayed(),"Google is not displayed!");
        System.out.println("Box validation");
        WebElement searchBox=driver.findElement(By.name("q"));
        Assert.assertTrue(searchBox.isEnabled(),"search box is not enabled!");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
