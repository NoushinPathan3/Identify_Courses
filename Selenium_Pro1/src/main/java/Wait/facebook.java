package Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class facebook {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/div/div[1]/div/div[5]/div/a/div")).click();

        driver.findElement(By.xpath("//input[@id='_R_1cl2p4jikacppb6amH1_']")).sendKeys("Noushin");

        driver.findElement(By.xpath("//input[@id='_R_1kl2p4jikacppb6amH1_']")).sendKeys("Pathan");

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/label[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();
        driver.findElement(By.xpath("//div[@id='_r_1___3']//div[@class='html-div xdj266r x14z9mp xat24cr x1lziwak x1qjc9v5 x9f619 x78zum5 xdt5ytf xl56j7k xeuugli xdl72j9 x1iyjqo2 x2lah0s x1mq37bv xdqstbe x7oumki xv54qhq xf7dkkf x1exlly7 x1e7cf47 x44cjkt x1dygckn']")).click();

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/label[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'April')]")).click();

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/label[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]")).click();
        driver.findElement(By.xpath("//div[@id='_r_d___21']//div[@class='html-div xdj266r x14z9mp xat24cr x1lziwak x1qjc9v5 x9f619 x78zum5 xdt5ytf xl56j7k xeuugli xdl72j9 x1iyjqo2 x2lah0s x1mq37bv xdqstbe x7oumki xv54qhq xf7dkkf x1exlly7 x1e7cf47 x44cjkt x1dygckn']")).click();

        driver.findElement(By.xpath("//div[@id='_R_mad6p4jikacppb6amH2_']//div[@class='xwoeoq x1s9qjmn x71vvrb x7gj0x1 x167l43f x11lwdb5 xfxe0gy x1szzd0g xh2argp x13fuv20 x18b5jzi x1q0q8m5 x1t7ytsu x178xt8z x1lun4ml xso031l xpilrb4 x9f619 x78zum5 xozqiw3 xcvrjo4 x1qughib x6ikm8r x10wlt62 xz9dl7a xsag5q8 xf7dkkf xv54qhq x1n2onr6 xh8yej3 x1ja2u2z xggcdpo xzxmhi2 x1bhcc0k x1poa18a']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Female')]")).click();

        driver.findElement(By.xpath("//input[@id='_R_6ad8p4jikacppb6amH1_']")).sendKeys("9550456824");

        WebElement input1 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='x1ja2u2z x78zum5 x2lah0s x1n2onr6 xl56j7k x6s0dn4 xozqiw3 x1q0g3np x972fbf x10w94by x1qhh985 x14e42zd x9f619 xtvsq51 xqbgfmv xbe3n85 x7a1id4 x1d9i5bo x1xila8y x1bumbmr xc8cyl1']//div[@class='html-div xdj266r xat24cr xexx8yu xyri2b x18d9i69 x1c1uobl x6s0dn4 x78zum5 xl56j7k x1e0frkt xf0ucvx xx2axb6']"))));
        input1.click();
        String error=driver.findElement(By.xpath("//*[@id=\"_R_clap4jikacppb6am_\"]/div/div[2]/span")).getText();
        System.out.println(error);

    }

}