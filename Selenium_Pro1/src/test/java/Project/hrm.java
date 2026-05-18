package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class hrm {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    void setUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(" https://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void login(){
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.className("oxd-button")).click();
    }

    @Test(dependsOnMethods = "login")
    void urlCheck(){
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Test(dependsOnMethods = "login")
    void adminButton(){
        WebElement adminMenu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[normalize-space()='Admin']")));
        adminMenu.click();
    }

    @Test(dependsOnMethods = "adminButton")
    void jobTitles(){
        WebElement jobMenu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[normalize-space()='Job']")));
        jobMenu.click();


        WebElement jobTitles = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[normalize-space()='Job Titles']")));
        jobTitles.click();


        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.cssSelector(".oxd-table-body .oxd-table-row"), 0));

        List<WebElement> rows =
                driver.findElements(By.cssSelector(".oxd-table-body .oxd-table-row"));

        for (WebElement row : rows) {
            System.out.println(
                    row.findElement(By.cssSelector(".oxd-table-cell:nth-child(2)")).getText()
            );
        }

    }

    @Test
    void logout(){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a")).click();
    }


    @AfterClass
    void tearDown(){
        driver.quit();
    }
}

