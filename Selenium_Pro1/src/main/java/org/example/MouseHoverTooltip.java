package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverTooltip {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = null;   //  declare outside try

        try {
            // 1. Launch Browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // 2. Open index.html
            driver.get("file:///C:/Users/2487760/Downloads/actions.html");



            // Locate the hover element
            WebElement hoverBox = driver.findElement(By.id("hoverBox"));

            // Create Actions object
            Actions actions = new Actions(driver);

            // Perform mouse hover
            actions.moveToElement(hoverBox).perform();

            // Get tooltip text from title attribute
            String tooltipText = hoverBox.getAttribute("title");

            // Print tooltip text
            System.out.println("Tooltip text is: " + tooltipText);

            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            // Always executed
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
