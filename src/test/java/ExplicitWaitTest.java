import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Maximize browser window and set timeouts
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Initialize explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void loginToGmail() {
        // Navigate to Gmail login page
        driver.get("https://accounts.google.com/signin");

        // Enter email and proceed
        WebElement emailField = driver.findElement(By.id("identifierId"));
        emailField.sendKeys("seleniumwebtraining@gmail.com");
        driver.findElement(By.id("identifierNext")).click();

        // Wait for password field to be visible and enter password
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));
        passwordField.sendKeys("SPractice456");
        driver.findElement(By.id("passwordNext")).click();

        //Validate test by getting the page title
        String pageTitle = driver.getTitle();
//       System.out.println(pageTitle);
        if (pageTitle.contains("Inbox")) {

            System.out.println("Login Successful");
        } else {
            System.out.println("Failed to Log in");
        }

        // Additional assertions can be added here to verify successful login
    }

    @AfterMethod
    public void tearDown() throws IOException {
        // Capture screenshot after test execution
        takeScreenshot();

        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    private void takeScreenshot() throws IOException {
        // Capture screenshot and save it to the specified location
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("target/screenshots/screenshot_" + System.currentTimeMillis() + ".png"));
    }
}
