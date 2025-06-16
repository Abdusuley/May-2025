package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
     WebDriver driver;

     private By myAccount = By.xpath("(//span[contains(text(),'My account')])[2]");

     public Homepage (WebDriver driver) {
         this.driver = driver;
     }

        public void clickMyAccount() {
            driver.findElement(myAccount).click();
        }


}
