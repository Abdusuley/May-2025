package stepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitlyWait {


    public static void main(String[] args) {



        // Opening Browser
        WebDriverManager.chromedriver().setup();
        WebDriver  driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(10));


//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        //Open the URL
        driver.get("https://seleniumautomationpractice.blogspot.com/2021/05/test-page-2.html");





        //Click on the element
        driver.findElement(By.xpath("//div[@id='mybutton']")).click();

    }

}
