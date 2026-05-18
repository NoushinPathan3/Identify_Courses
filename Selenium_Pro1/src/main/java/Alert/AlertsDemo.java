package Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertsDemo {

    public static void main(String[] args) {

        WebDriver driver = null;   //  declare outside try

        try {
            // 1. Launch Browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // Load local HTML file
            driver.get("C:/Users/2487760/Downloads/alerts.html");

            /***************** SIMPLE ALERT *****************/
            driver.findElement(By.xpath("//button[text()='Alert']")).click();

            Alert simpleAlert = driver.switchTo().alert();
            System.out.println("Simple Alert Text: " + simpleAlert.getText());
            simpleAlert.accept();
            // Thread.sleep(3000);
            /***************** CONFIRM ALERT *****************/
            driver.findElement(By.xpath("//button[text()='Confirm']")).click();

            Alert confirmAlert = driver.switchTo().alert();
            System.out.println("Confirm Alert Text: " + confirmAlert.getText());
            confirmAlert.dismiss();   // or confirmAlert.accept();
            // Thread.sleep(3000);
            /***************** PROMPT ALERT *****************/
            driver.findElement(By.xpath("//button[text()='Prompt']")).click();

            Alert promptAlert = driver.switchTo().alert();
            Thread.sleep(1000);
            System.out.println("Prompt Alert Text: " + promptAlert.getText());
            Thread.sleep(1000);

            promptAlert.sendKeys("testdata");
            promptAlert.accept();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // Always executed
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
