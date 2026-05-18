package TestingDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationDemo {
    @BeforeSuite
    public void beforesuite(){
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void beforetest(){
        System.out.println("Before Test");
    }
    @BeforeClass
    public void beforeclass(){
        System.out.println("Before Class");
    }
    @BeforeMethod
    public void beforemethod(){
        System.out.println("Before Method");
    }
    @Test(priority=0)
    public void test1(){
        System.out.println("test1 executed");
    }
    @Test(priority=1)
    public void test2(){
        System.out.println("test2 executed");
    }
    @AfterMethod
    public void aftermethod(){
        System.out.println("After Method");
    }
    @AfterClass
    public void afterclass(){
        System.out.println("After Class");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("After Test");
    }
    @AfterSuite
    public void aftersuite(){
        System.out.println("After Suite");
    }
}
