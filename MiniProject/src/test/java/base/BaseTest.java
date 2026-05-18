package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.io.FileHandler;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected int step = 1;

    @Parameters({"Browser"})
    public void launchBrowser(String br) {

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
                throw new IllegalArgumentException("Invalid browser value");
        }

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        takeScreenshot("Launch_Page");
    }

    protected void takeScreenshot(String stepName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(
                    src,
                    new File("screenshots/Step_" + step + "_" + stepName + ".png")
            );
            step++;
        } catch (IOException ignored) {}
    }
}

