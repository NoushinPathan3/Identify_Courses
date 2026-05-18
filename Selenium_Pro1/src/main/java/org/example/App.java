package org.example;


//import com.sun.tools.javac.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
//import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //System.out.println( "Hello World!" );
        EdgeOptions options=new EdgeOptions();
        WebDriver driver=null;
        try {
            driver = new EdgeDriver(options);
            driver.get("https://www.opencart.com/");
            driver.manage().window().maximize();
            Thread.sleep(5000);
            System.out.println("Title: " + driver.getTitle());
            String act_title = driver.getTitle();
            String result = act_title.equals("Google") ? "Title is Google" : "Title is not Google";
            System.out.println(result);

            List<WebElement> allInputs=driver.findElements(By.tagName("input"));
            System.out.println("Total input tags: "+allInputs.size());
            Thread.sleep(1000);

            driver.findElement(By.linkText("Features")).click();
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(1000);

            driver.findElement(By.partialLinkText("Get Started")).click();
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(driver!=null){
                driver.quit();
            }
        }

    }
}
