package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstTestCase {
    public static void main(String[] args) {
         /*
    Test Case
    1.Launch a browser
    2.open the url of opencart
    3.Validate the title is "OpenCart - Open Source Shopping Cart Solution" or not
    4.close the browser
     */

        /*//1.Launch a browser
        WebDriver driver=new EdgeDriver();

        //2.open the url of opencart
        driver.get("https://www.opencart.com/");

        //3.Validate the title is "your store" or not
        //String tit=driver.getTitle();
        if((driver.getTitle()).equals("OpenCart - Open Source Shopping Cart Solution")){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase failed");
        }
        //4.close the browser
        driver.close();
         */

        /*
        1.Launch browser(chrome)
        2.open url "https://demo.nopcommerce.com"
        3.Validate title "nopCommerce demo store. Home page title"
        4.Close the browser
         */

//        WebDriver driver=new ChromeDriver();
//        driver.get("https://demo.nopcommerce.com");
//        if(driver.getTitle().equals("nopCommerce demo store. Home page title")){
//            System.out.println("Passed");
//        }else{
//            System.out.println("Failed");
//        }
//        driver.close();

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.opencart.com/");
        driver.findElement(By.linkText("Demo")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Laptop");
    }

}
