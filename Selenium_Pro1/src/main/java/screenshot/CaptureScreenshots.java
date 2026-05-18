package screenshot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshots {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //1) full page screenshot
       /*TakesScreenshot ts=(TakesScreenshot)driver;

       //capture in random memory location - cant track
       File sourcefile=ts.getScreenshotAs(OutputType.FILE);

       // own location - know the path
       File targetfile=new File(System.getProperty("user.dir")+"\\Screenshots\\fullpage.png");
       sourcefile.renameTo(targetfile); // copy sourcefile to target file
       */
// intro from selenium4 --> part of a page

        //2) capture the screenshot of specific section
        ////#main > div > section > div > div > section.product-grid.home-page-product-grid
       /*WebElement featuredProducts=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));

       File sourcefile=featuredProducts.getScreenshotAs(OutputType.FILE);
       File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\featredproducts.png");
       sourcefile.renameTo(targetfile); // copy sourcefile to target file
       */

        //3) capture the screenshot of webelement
        //body > div.master-wrapper-page > header > div.header-lower > div.header-logo > a > img
        WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File sourcefile=logo.getScreenshotAs(OutputType.FILE);
        File targetfile=new File(System.getProperty("user.dir")+"\\Screenshots\\logo.png");
        sourcefile.renameTo(targetfile); // copy sourcefile to target file

        driver.quit();



    }

}
