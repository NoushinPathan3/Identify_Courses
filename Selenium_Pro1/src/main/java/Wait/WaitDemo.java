package Wait;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;

public class WaitDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com/");

        driver.findElement(By.linkText("Create new account")).click();

        driver.findElement(By.id("_R_1cl2p4jikacppb6amH1_")).sendKeys("Noushin");
        driver.findElement(By.id("_R_1kl2p4jikacppb6amH1_")).sendKeys("Pathan");

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/label[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();
        driver.findElement(By.xpath("//div[@class='x1lliihq x1plvlek xryxfnj x1n2onr6 xyejjpt x15dsfln x193iq5w xeuugli x1fj9vlw x13faqbe x1vvkbs x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x1sfkdl8 xurcqga x3vd66c xhqx0jl xzsf02u x1yc453h xudqn12 x3x7a5m xjpr12u x1nn3v0j'][normalize-space()='2']")).click();

//        Select day = new Select(driver.findElement(By.id("day")));
//        day.selectByVisibleText("3");
//
//        Select month = new Select(driver.findElement(By.id("month")));
//        month.selectByVisibleText("Apr");
//
//        Select year = new Select(driver.findElement(By.id("year")));
//        year.selectByVisibleText("2005");
//
//        driver.findElement(By.xpath("//input[@name='sex' and @value='1']")).click();
//
//        driver.findElement(By.id("_R_6ad8p4jikacppb6amH1_")).sendKeys("noushinpathan@example.com");
//
////        driver.findElement(By.xpath("//*[@id='mount_0_0_2Y']/div/div[1]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div[2]/div/div/div/div/div/div/div/div[9]/div/div/div[1]/div/div/div/div[2]")).click();
////
////        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
////        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'password')]"));
////        System.out.println("Error message displayed: " + errorMessage.getText());
//
//        driver.close();



//        // Wait for signup modal
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//        // Fill First Name
//        WebElement firstName = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
//        firstName.sendKeys("John");
//
//        // Fill Surname
//        driver.findElement(By.name("lastname")).sendKeys("Doe");
//
//        // Fill Email
//        driver.findElement(By.name("reg_email__")).sendKeys("johndoe123@gmail.com");
//
//        // Confirm Email (appears dynamically)
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reg_email_confirmation__")))
//                .sendKeys("johndoe123@gmail.com");
//
//        // Select DOB
//        Select day = new Select(driver.findElement(By.id("day")));
//        day.selectByVisibleText("10");
//
//        Select month = new Select(driver.findElement(By.id("month")));
//        month.selectByVisibleText("May");
//
//        Select year = new Select(driver.findElement(By.id("year")));
//        year.selectByVisibleText("2000");
//
//        // Select Gender (Male)
//        driver.findElement(By.xpath("//input[@value='2']")).click();
//
//        // DO NOT enter password
//
//        // Click Sign Up
//        driver.findElement(By.name("websubmit")).click();
//
//        // Wait for error message related to password
//        WebElement errorMsg = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                        By.xpath("//div[contains(text(),'Enter a combination of')]")));
//
//        // Print error message
//        System.out.println("Error Message: " + errorMsg.getText());

        // Close browser
//        driver.quit();





    }
}
