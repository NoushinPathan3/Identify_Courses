package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class ShadowDomDemo {

    public static void main(String[] args) {

        WebDriver driver = null;

        try {
            //  Launch Browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("file:///C:/Users/2487760/Downloads/shadow.html");

            // -------------------------------------------------------------
            //  ATTEMPT 1: Access Shadow DOM element using By.id (FAILS)
            // -------------------------------------------------------------
            try {
                System.out.println("Trying to locate Shadow DOM element using By.id...");
                driver.findElement(By.id("shadowUser")).sendKeys("FAIL_CASE");
            } catch (NoSuchElementException e) {
                System.out.println("FAILED: By.id cannot access Shadow DOM elements");
            }

            // -------------------------------------------------------------
            //  ATTEMPT 2: Access Shadow DOM element using CSS Selector (FAILS)
            // -------------------------------------------------------------
            try {
                System.out.println("Trying to locate Shadow DOM element using CSS selector...");
                driver.findElement(By.cssSelector("#shadowBtn")).click();
            } catch (NoSuchElementException e) {
                System.out.println(" FAILED: CSS selector cannot access Shadow DOM elements");
            }

            // -------------------------------------------------------------
            // ATTEMPT 3: Access Shadow DOM element using XPath (FAILS)
            // -------------------------------------------------------------
      /*      try {
                System.out.println("Trying to locate Shadow DOM element using XPath...");
                driver.findElement(By.xpath("//input[@id='shadowUser']")).sendKeys("FAIL");
            } catch (NoSuchElementException e) {
                System.out.println("FAILED: XPath cannot penetrate Shadow DOM");
            }*/

            // -------------------------------------------------------------
            // CORRECT WAY: Handle Shadow DOM using Selenium 4
            // -------------------------------------------------------------

            System.out.println("Accessing Shadow DOM using getShadowRoot()...");

            // Step 1: Locate Shadow Host (custom element)
            //custom-login is the host element
            //The Shadow DOM is attached to it
//<div><span><custom-tag> can be shadowHost; <input><button> etc cant be shadowHost
            WebElement shadowHost = driver.findElement(By.cssSelector("custom-login"));
            Thread.sleep(1000);
            // Step 2: Get ShadowRoot (Selenium 4)
            SearchContext shadowRoot = shadowHost.getShadowRoot();

            // Step 3: Interact with elements inside Shadow DOM
            shadowRoot.findElement(By.cssSelector("#shadowUser"))
                    .sendKeys("Arya");
            Thread.sleep(1000);
            shadowRoot.findElement(By.cssSelector("#shadowBtn"))
                    .click();
            Thread.sleep(1000);
            System.out.println(" Shadow DOM interaction successful");

        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        } finally {
            // Always close browser
            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed");
            }
        }
    }
}

/*
Note
 Open Shadow DOM
this.attachShadow({ mode: "open" });
 Can be accessed using JavaScript\
 Selenium can interact (via JS)

 Closed Shadow DOM
this.attachShadow({ mode: "closed" });
 Cannot be accessed even via JavaScript\
 Selenium CANNOT automate it


 Step‑by‑Step Concept (No code first)

1.  Locate the Shadow Host
2.  Open the Shadow Root
3.  Then find elements inside
*/
