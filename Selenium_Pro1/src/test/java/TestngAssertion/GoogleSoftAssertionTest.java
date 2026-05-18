package TestngAssertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class GoogleSoftAssertionTest {
    WebDriver driver;
    SoftAssert softAssert;
    @BeforeClass
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        softAssert=new SoftAssert();
    }
    @Test
    public void verifyGoogleHomePage(){
        System.out.println("Title validation");
        softAssert.assertEquals(driver.getTitle(),"Google123","Title mismatch");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            System.out.println("Logo validation");
            WebElement logo=wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("img[alt='Google']")
                    )
            );
            softAssert.assertTrue(logo.isDisplayed(),"Google logo not displayed");
        }catch(Exception e){
            softAssert.fail("Logo validation failed due to exception");
        }
        try{
            System.out.println("Box validation");
            WebElement searchBox=wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.name("q")
                    )
            );
            softAssert.assertTrue(searchBox.isEnabled(),
                    "search box not enabled");
        } catch (Exception e) {
            softAssert.fail("Search box validation failed due to exception");
        }
        System.out.println("assertAll called");
        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
