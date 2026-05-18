package example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.awt.SystemColor.window;

public class flipkartExample {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.flipkart.com");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement closeBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[5]/div/span")
                )
        );
        closeBtn.click();


        WebElement search1 = driver.findElement(By.name("q"));
        search1.sendKeys("mobiles under 15000");
        search1.sendKeys(Keys.ENTER);

        WebElement maxDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(text(),'₹')]")
                )
        );
        maxDropdown.click();


        WebElement el=driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div/div[1]/div/div[1]/div/section[14]/div[4]/div[3]/select"));
        Select select=new Select(el);
        select.selectByVisibleText("₹10000");

        System.out.println("Max price selected successfully");
        Set<String> name=driver.getWindowHandles();
        List<String> windowlist=new ArrayList<>(name);
        String parentId=windowlist.get(0);
        driver.switchTo().window(parentId);


        driver.findElement(By.xpath("//div[contains(text(),'Operating System Version Name')]")).click();
        WebElement an=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='Android Q']//div[@class='ybaCDx']")));
        Select s=new Select(an);
        s.selectByVisibleText("Android Q");
    }
}

