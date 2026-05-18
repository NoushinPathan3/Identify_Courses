package Practice;

import org.openqa.selenium.By;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonList {
    public static void main(String[] args) {
        WebDriver driver=new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.amazon.in/s?k=footwear&crid=3VFXC3SO6HLZX&sprefix=footwear%2Caps%2C561&ref=nb_sb_noss_2");
        List<WebElement> myList=driver.findElements(By.xpath("//span[contains(text(),'Footwear') or contains(text(),'footwear')]"));
        System.out.println("List : "+myList.size());
        driver.close();
    }
}
