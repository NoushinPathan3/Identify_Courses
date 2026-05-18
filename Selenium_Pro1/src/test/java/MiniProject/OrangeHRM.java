//package MiniProject;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.*;
//import org.testng.Assert;
//import org.testng.annotations.*;
//import MiniProject.ExcelReader;
//
//import java.io.File;
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.io.FileHandler;
//
//public class OrangeHRM {
//
//    WebDriver driver;
//    WebDriverWait wait;
//    int step;
//
//    @BeforeMethod
//    @Parameters({"Browser"})
//    public void setUp(String br) {
//        switch (br.toLowerCase()){
//            case "chrome":
//                driver=new ChromeDriver();
//                break;
//            case "edge":
//                driver=new EdgeDriver();
//                break;
//            case "firefox":
//                driver=new FirefoxDriver();
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid browser value: " + br);
//
//        }
//        //driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.get("https://opensource-demo.orangehrmlive.com/");
//    }
//
//    @Test
//    public void addJobTitleTest() throws Exception {
//
//        String username = ExcelReader.getCellData(1, 0);
//        String password = ExcelReader.getCellData(1, 1);
//        String jobTitle = ExcelReader.getCellData(1, 5);
//
//        // Login
//        driver.findElement(By.name("username")).sendKeys(username);
//        driver.findElement(By.name("password")).sendKeys(password);
//        driver.findElement(By.className("oxd-button")).click();
//
//        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
//
//        // Click Admin menu
//        WebElement adminMenu = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        By.xpath("//span[normalize-space()='Admin']")));
//        adminMenu.click();
//
//// Click Job sub-menu (Admin must be expanded first)
//        WebElement jobMenu = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        By.xpath("//span[normalize-space()='Job']")));
//        jobMenu.click();
//
//// Click Job Titles
//        WebElement jobTitles = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        By.xpath("//a[normalize-space()='Job Titles']")));
//        jobTitles.click();
//
//        // Print Job Titles
//        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
//                By.cssSelector(".oxd-table-body .oxd-table-row"), 0));
//
//        List<WebElement> rows =
//                driver.findElements(By.cssSelector(".oxd-table-body .oxd-table-row"));
//
//        for (WebElement row : rows) {
//            System.out.println(
//                    row.findElement(By.cssSelector(".oxd-table-cell:nth-child(2)")).getText()
//            );
//        }
//
//        // Add Job Title
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.cssSelector(".oxd-icon.bi-plus.oxd-button-icon"))).click();
//
//        driver.findElement(
//                        By.cssSelector("input.oxd-input.oxd-input--active"))
//                .sendKeys(jobTitle);
//
//        // Screenshot
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        FileHandler.copy(ts.getScreenshotAs(OutputType.FILE),
//                new File("screenshots/addJob.png"));
//
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        System.out.println("Saved Successfully");
//    }
//     public void takeScreenshot(String stepName) {
//        try {
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            File src = ts.getScreenshotAs(OutputType.FILE);
//
//            File dest = new File("screenshots/Step_" + step + "_" + stepName + ".png");
//            FileHandler.copy(src, dest);
//
//            step++;
//        } catch (IOException e) {
//            System.out.println("Screenshot failed: " + e.getMessage());
//        }
//    }
//
//
//
//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//        System.out.println("Test finished");
//    }
//
//}
//
//
//
package MiniProject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.io.FileHandler;

public class OrangeHRM {

    WebDriver driver;
    WebDriverWait wait;
    int step = 1; // screenshot counter

    @BeforeMethod
    @Parameters({"Browser"})
    public void setUp(String br) {

        switch (br.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser value: " + br);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://opensource-demo.orangehrmlive.com/");
        takeScreenshot("Launch_Page");
    }

    @Test
    public void addJobTitleTest() {

        // Read data from Excel
        String username = ExcelReader.getCellData(1, 0);
        String password = ExcelReader.getCellData(1, 1);
        String jobTitle = ExcelReader.getCellData(1, 5);

        // Make job title UNIQUE to avoid duplicate rejection
        jobTitle = jobTitle + " " + System.currentTimeMillis();

        // Login
        driver.findElement(By.name("username")).sendKeys(username);
        takeScreenshot("Enter_Username");

        driver.findElement(By.name("password")).sendKeys(password);
        takeScreenshot("Enter_Password");

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        takeScreenshot("Click_Login");

        // Wait for Dashboard
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h6[text()='Dashboard']")
        ));
        takeScreenshot("Dashboard_Loaded");

        // Admin Menu
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Admin']"))).click();
        takeScreenshot("Click_Admin");

        // Job Menu
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Job']"))).click();
        takeScreenshot("Click_Job");

        // Job Titles
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Job Titles']"))).click();
        takeScreenshot("Job_Titles_Page");

        // Wait until table loads
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.cssSelector(".oxd-table-body .oxd-table-row"), 0));

        List<WebElement> rows =
                driver.findElements(By.cssSelector(".oxd-table-body .oxd-table-row"));

        for (WebElement row : rows) {
            System.out.println(
                    row.findElement(By.cssSelector(".oxd-table-cell:nth-child(2)"))
                            .getText()
            );
        }
        takeScreenshot("Existing_Job_Titles");

        // Click Add button
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".oxd-icon.bi-plus"))).click();
        takeScreenshot("Click_Add_Job");

        // Enter Job Title (stable locator)
        WebElement jobTitleInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[text()='Job Title']/../following-sibling::div/input")
                )
        );
        jobTitleInput.clear();
        jobTitleInput.sendKeys(jobTitle);
        takeScreenshot("Enter_New_Job_Title");

        // Click Save
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        takeScreenshot("Click_Save");

        // Confirm success
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[text()='Successfully Saved']")
        ));
        takeScreenshot("Job_Title_Saved");

        System.out.println("Job Title added successfully: " + jobTitle);
    }

    // Screenshot utility (no throws, safe)
    public void takeScreenshot(String stepName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            File dest = new File("screenshots/Step_" + step + "_" + stepName + ".png");
            FileHandler.copy(src, dest);

            step++;
        } catch (IOException e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Test finished");
    }
}

