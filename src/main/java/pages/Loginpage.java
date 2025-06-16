package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
     WebDriver driver;

     private By continueButton = By.xpath("//a[contains(text(),'Continue')]");

     public Loginpage(WebDriver driver) {

         this.driver = driver;
     }

        public void clickOnContinueButton() {

         driver.findElement(continueButton).click();
        }


}
