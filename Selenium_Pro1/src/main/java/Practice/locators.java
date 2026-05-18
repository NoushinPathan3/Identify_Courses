package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class locators {
    public static void main(String[] args) {
        WebDriver driver=new EdgeDriver();
        driver.get("https://www.demoblaze.com/index.html");

        //name
        driver.findElement(By.name("viewport"));
    }
}
