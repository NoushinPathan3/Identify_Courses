package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorDemo {

    public static void main(String[] args) {

        WebDriver driver = null;   //  declare outside try

        try {
            // 1. Launch Browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // 2. Open index.html
            driver.get("file:///C:/Users/2487760/Downloads/index.html");
            // Find Element by ID
            driver.findElement(By.id("username")).sendKeys("admin");
            Thread.sleep(1000);
            driver.findElement(By.id("password")).sendKeys("password123");
            Thread.sleep(1000);
            driver.findElement(By.id("loginBtn")).click();
            Thread.sleep(1000);
//by name
            driver.findElement(By.name("userName")).clear();
            driver.findElement(By.name("pass")).clear();
            Thread.sleep(1000);
            //byclass
            List<WebElement> inputFields =
                    driver.findElements(By.className("input-field"));
            System.out.println("Number of input fields -classname: " + inputFields.size());
            Thread.sleep(2000);
//by tag name
            List<WebElement> allInputs =
                    driver.findElements(By.tagName("input"));
            System.out.println("Total input tags: " + allInputs.size());
            Thread.sleep(1000);
            //by link text
            driver.findElement(By.linkText("Mouse Actions")).click();
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(1000);
            /* =====================================================
               Find Element by PARTIAL LINK TEXT
               ===================================================== */
            driver.findElement(By.partialLinkText("Frames")).click();
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(1000);
            /* =====================================================
               CSS SELECTORS when you cant locate using text or if
               ===================================================== */
            driver.findElement(By.cssSelector("h1")).isDisplayed(); // by tagname
            driver.findElement(By.cssSelector("#mainTitle")); // id
            driver.findElements(By.cssSelector(".input-field")); // class
            driver.findElement(By.cssSelector("input[type='text'][name='userName']")); //mul attribute
            driver.findElements(By.cssSelector("#cityList li")); //id p  & decendant
            driver.findElement(By.cssSelector("input[type='password']"));
            List<WebElement> citylist = driver.findElements(By.cssSelector("#cityList li"));
            System.out.println("City list count: " + citylist.size());


// Locate radio buttons
            WebElement maleRadio = driver.findElement(By.id("male"));
            WebElement femaleRadio = driver.findElement(By.id("female"));

// Select Male radio button
            if (!maleRadio.isSelected()) {
                maleRadio.click();
            }

// Verify selection
            System.out.println("Male selected: " + maleRadio.isSelected());
            System.out.println("Female selected: " + femaleRadio.isSelected());

// check box terms

            WebElement terms = driver.findElement(By.id("terms"));
            if (!terms.isSelected()) {
                terms.click();
            }

            /* =====================================================
               SELECT tag dropdown (without Select class)
               ===================================================== */
            List<WebElement> dropdownOptions =
                    driver.findElements(By.cssSelector("#cityDropdown option"));

            for (WebElement option : dropdownOptions) {
                if (option.getText().equalsIgnoreCase("Chennai")) {
                    option.click();
                    break;
                }
            }

            Thread.sleep(2000);

            /* =====================================================
               Custom UL-LI Dropdown
               ===================================================== */
            driver.findElement(By.id("selectedCity")).click();
            Thread.sleep(1000);
            List<WebElement> cities =
                    driver.findElements(By.cssSelector("#cityList li")); //desc

            for (WebElement city : cities) {
                if (city.getText().equals("Bangalore")) {
                    city.click();
                    break;
                }
            }
            Thread.sleep(1000);
            /* =====================================================
               findElement VS findElements
               ===================================================== */
            WebElement loginButton =
                    driver.findElement(By.id("loginBtn"));
            System.out.println("Login button displayed: "
                    + loginButton.isDisplayed());
            Thread.sleep(1000);
            List<WebElement> links =
                    driver.findElements(By.tagName("a"));
            System.out.println("Total links: " + links.size());

        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            // Always executed
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
