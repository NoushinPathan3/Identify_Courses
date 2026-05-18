package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class JobTitlesPage {

    WebDriver driver;
    WebDriverWait wait;

    public JobTitlesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openJobTitles() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Job']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Job Titles']"))).click();
    }


    public void displayJobTitles() {

        System.out.println("------ EXISTING JOB TITLES ------");

        try {

            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(Exception.class);

            List<WebElement> rows = fluentWait.until(d -> {
                List<WebElement> r =
                        d.findElements(By.cssSelector(".oxd-table-body .oxd-table-row"));
                return r.isEmpty() ? null : r;
            });

            for (WebElement row : rows) {
                System.out.println(
                        row.findElement(
                                By.cssSelector(".oxd-table-cell:nth-child(2)")
                        ).getText()
                );
            }

        } catch (Exception e) {
            System.out.println("⚠ Job titles not visible yet, continuing test");
        }

        System.out.println("--------------------------------");
    }

    public void addJobTitle(String jobTitle) {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".oxd-icon.bi-plus"))).click();

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[text()='Job Title']/../following-sibling::div/input")
                ));

        input.sendKeys(jobTitle);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[text()='Successfully Saved']")));
    }
}