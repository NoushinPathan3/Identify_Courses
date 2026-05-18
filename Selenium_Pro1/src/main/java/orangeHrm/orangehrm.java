package orangeHrm;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.time.Duration;
import java.util.List;

public class orangehrm {
    public static void main(String[] args) throws IOException{

        WebDriver driver=new ChromeDriver();
        //open website
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //login
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.className("oxd-button")).click();
        //check whether current browser url contains dashboard or not
        String url=driver.getCurrentUrl();
        if(url.contains("dashboard")){
            System.out.println("url contains string dashboard");
        }
        //click admin
        driver.findElement(By.className("oxd-text")).click();
        //click job
        driver.findElement(By.xpath("//span[normalize-space()='Job']")).click();
        //job titles
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-topbar-body-nav-tab-link"))).click();


        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.cssSelector(".oxd-table-body .oxd-table-row"), 0));

        //list job titles
        List<WebElement> rows = driver.findElements(
                By.cssSelector(".oxd-table-body .oxd-table-row"));


        for (WebElement row : rows) {
            String jobTitle = row
                    .findElement(By.cssSelector(".oxd-table-cell:nth-child(2)"))
                    .getText();
            System.out.println(jobTitle);
        }
        //Add job title
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".oxd-icon.bi-plus.oxd-button-icon")));
        addButton.click();
        driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")).sendKeys("Automation Tester");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[2]")).click();

        //Screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/page.png");

        FileUtils.copyFile(src, dest);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a")).click();
        driver.quit();
    }
}
