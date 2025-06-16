package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registerpage {
    WebDriver driver;

    private By firstname = By.id("input-firstname");
    private By lastname = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");
    private By privacy = By.xpath("//label[@for='input-agree']");
    private By continuButton = By.cssSelector("input[value='Continue']");

    public Registerpage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterFirstName(String fName) {
        driver.findElement(firstname).sendKeys(fName);
    }
    public void enterLastName(String lName) {
        driver.findElement(lastname).sendKeys(lName);
    }
    public void enterEmail(String emailAddress) {
        driver.findElement(email).sendKeys(emailAddress);
    }
    public void enterTelephone(String telephoneNum) {
        driver.findElement(telephone).sendKeys(telephoneNum);
    }
    public void enterPassword(String passwordText) {
        driver.findElement(password).sendKeys(passwordText);
    }
    public void enterConfirmPassword(String confirmPasswordText) {
        driver.findElement(confirmPassword).sendKeys(confirmPasswordText);
    }
    public void clickOnPrivacy() {
        driver.findElement(privacy).click();
    }
    public void clickOnContinueButton() {
        driver.findElement(continuButton).click();
    }
}


