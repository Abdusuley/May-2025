package stepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWait {


    public static void main(String[] args) {



        // Opening Browser

        System.setProperty("webdriver.chrome.driver",
                "C:\\WorkStation\\May-2025\\lib\\chromedriver.exe"
        ); WebDriver driver = new ChromeDriver();

        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        //Open the URL
        driver.get("https://seleniumautomationpractice.blogspot.com/2021/05/test-page-2.html");





        //Click on the element
        driver.findElement(By.xpath("//div[@id='mybutton']")).click();

    }

}
