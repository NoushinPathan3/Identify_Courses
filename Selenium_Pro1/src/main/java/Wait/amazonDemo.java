    package Wait;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;
    public class amazonDemo {
        public static void main(String[] args) {
            try {

                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();


                driver.get("https://www.amazon.com/ap/register");
                driver.findElement(By.id("a-autoid-0-announce")).click();

                driver.findElement(By.xpath("//*[@id=\'nav-link-accountList\']/a/span")).click();


                driver.findElement(By.id("ap_email_login")).sendKeys("gsrohan7080@gmail.com");


                driver.findElement(By.id("continue")).click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                try {
                    WebElement alertClose = wait.until(
                            ExpectedConditions.elementToBeClickable(By.id("alert-close")) // adjust locator
                    );
                    alertClose.click();
                } catch (Exception e) {
                    System.out.println("No alert popup appeared.");
                }
                WebElement passwordField = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.id("ap_password"))
                );
                passwordField.sendKeys("rohan");
                passwordField.sendKeys(Keys.ENTER);


                driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/div/form/div/span/span/input")).click();
                driver.findElement(By.cssSelector(".'a-spinner a-spinner-small aok-hidden'")).click();

//            WebDriverWait swait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement errorMsg = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='auth-password-missing-alert']//div"))
                );
                WebDriverWait swait = new WebDriverWait(driver, Duration.ofSeconds(10));

                System.out.println("Error message: " + errorMsg.getText());

                driver.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }




