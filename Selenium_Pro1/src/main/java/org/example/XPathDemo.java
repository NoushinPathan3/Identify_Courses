package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = null;
        try {
            //  Launch Browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("file:///C:/Users/2487760/Downloads/index.html");
            driver.manage().window().maximize();
            Thread.sleep(1000);


            // 1. Absolute XPath using Single Slash (/)
            driver.findElement(By.xpath("/html/body/div/input[1]"))
                    .sendKeys("AbsoluteUser");
            Thread.sleep(1000);

            // 2️. Relative XPath using Double Slash (//)
            driver.findElement(By.xpath("//input[@id='password']"))
                    .sendKeys("RelativePwd");
            Thread.sleep(1000);

            // 3. contains() – Partial attribute value
            driver.findElement(By.xpath("//input[contains(@placeholder,'User')]"))
                    .clear();
            driver.findElement(By.xpath("//input[contains(@placeholder,'User')]"))
                    .sendKeys("ContainsUser");
            Thread.sleep(1000);

            // 4️. starts-with() – Attribute starts with value
            driver.findElement(By.xpath("//input[starts-with(@id,'pass')]"))
                    .clear();
            driver.findElement(By.xpath("//input[starts-with(@id,'pass')]"))
                    .sendKeys("StartsWithPwd");
            Thread.sleep(1000);

            // 5️. text() – Visible text matching
            driver.findElement(By.xpath("//button[text()='Login']")).click();
            Thread.sleep(1000);

            // 6. last() – Select last matching element
            // Clicking last city in the list (Coimbatore)
            driver.findElement(By.xpath("(//ul[@id='cityList']/li)[last()]")).click();
            Thread.sleep(1000);

            // Clicking last link on the page (Broken Link)
            driver.findElement(By.xpath("(//a)[last()]")).click();
            Thread.sleep(2000);}catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }  finally {
            // Always close browser
            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed");
            }
        }
    }
}

