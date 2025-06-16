package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.Homepage;
import pages.Loginpage;
import pages.Registerpage;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;



public class MyStepdefs {
    WebDriver driver;

    @Before
    public void initDriver(){
        // 1st : Creating driver instance for Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() throws IOException, InterruptedException {
        takeScreenshot();

        Thread.sleep(5000);
        driver.quit();

    }

    @Given("I am on the Lambdatest home page {string}")
    public void iAmOnTheLambdatestHomePage(String lambdaUrl) {
        ////1st : Creating driver instance for Chrome
//        driver.get(lambdaUrl);
        driver.navigate().to(lambdaUrl);

//

    }

    @When("I click on MyAccount Menu")
    public void iClickOnMyAccountMenu() {

//        Xpath
//        driver.findElements(By.xpath("//a[@class='icon-left both nav-link dropdown-toggle']")).get(2).click();
//        CSS
//        driver.findElements(By.cssSelector("a[class='icon-left both nav-link dropdown-toggle']")).get(2).click();
        driver.findElements(By.cssSelector(".icon-left.both.nav-link.dropdown-toggle")).get(2).click();

    }

    @And("I click on Continue under the New Customer")
    public void iClickOnContinueUnderTheNewCustomer() {
//        driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
//        driver.findElement(By.linkText("Continue")).click();
        driver.findElement(By.partialLinkText("Conti")).click();


    }

    @Then("the Register Account page should be displayed")
    public void theRegisterAccountPageShouldBeDisplayed() {
      String pageTitle = driver.getTitle();
      assertThat(pageTitle, is(equalTo("Register Account")));
    }


    @When("I enter First Name as {string}, Last Name as {string}, email as {string}, telephone as {string} and password as {string}")
    public void enter_first_name_as_last_name_as_email_as_telephone_as_and_password_as(String fName, String lastname, String email, String telephoneNum, String password) {
        driver.findElement(By.id("input-firstname")).sendKeys(fName);
        driver.findElement(By.id("input-lastname")).sendKeys(lastname);
        driver.findElement(By.id("input-email")).sendKeys(randomNumber() + email);
        driver.findElement(By.id("input-telephone")).sendKeys(telephoneNum);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(password);
        // Write code here that turns the phrase above into concrete actions

    }
    @When("I click on the privacy policy")
    public void i_click_on_the_privacy_policy() {
        driver.findElement(By.xpath("//label[@for='input-agree']")).click();

        // Using css Selector
//        driver.findElement(By.cssSelector("label[for='input-agree']")).click();
        // Write code here that turns the phrase above into concrete actions

    }
    @When("I click on Continue button on the register account page")
    public void i_click_on_continue_button_on_the_register_account_page() {

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Write code here that turns the phrase above into concrete actions

    }
    
    @Then("{string} is displayed")
    public void is_displayed(String ourPageTitle) {
        // Write code here that turns the phrase above into concrete actions
        String pageTitle = driver.getTitle();
        assertThat(pageTitle, is(equalTo(ourPageTitle)));
    }




    @When("I click on Register link from the MyAccount Menu")
    public void iClickOnRegisterLinkFromTheMyAccountMenu() {
        driver.findElements(By.xpath("//a[@class='icon-left both nav-link dropdown-toggle']")).get(2).click();
    }
    public void takeScreenshot() throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("target/screenshots" + System.currentTimeMillis() + ".png"));
// Code to take screenshot
    }
    private int randomNumber() {
        // Generate a random number between 0 and 999
        Random random = new Random();
        return random.nextInt(1000);}

    @When("I enter  {string},  {string}, {string}, {string} and  {string}")
    public void iEnterAnd(String fName, String lName, String eMail, String phoneNumber, String pWord) {
        driver.findElement(By.id("input-firstname")).sendKeys(fName);
        driver.findElement(By.id("input-lastname")).sendKeys(lName);
        driver.findElement(By.id("input-email")).sendKeys(randomNumber() + eMail);
        driver.findElement(By.id("input-telephone")).sendKeys(phoneNumber);
        driver.findElement(By.id("input-password")).sendKeys(pWord);
        driver.findElement(By.id("input-confirm")).sendKeys(pWord);
    }

    @When("I enter details as follows")
    public void i_enter_details_as_follows(Map<String, String> dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        driver.findElement(By.id("input-firstname")).sendKeys(dataTable.get("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataTable.get("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(randomNumber() +dataTable.get("email"));
        driver.findElement(By.id("input-telephone")).sendKeys(dataTable.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(dataTable.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataTable.get("password"));

    }


    @When("I hover on My account menu")
    public void iHoverOnMyAccountMenu() {
        WebElement myAccountMenu = driver.findElement(By.xpath("(//span[contains(text(),'My account')])[2]"));
        // Perform mouse hover action on the My Account menu
        new Actions(driver).moveToElement(myAccountMenu).perform();
    }

    @Then("I click on Register")
    public void IclickonRegister() {
        WebElement registerAccountLink = driver.findElement(By.xpath("//span[contains(text(),'Register')]"));
        registerAccountLink.click();


    }

    @When("I click on my account link")
    public void i_click_on_my_account_link() {
        // Write code here that turns the phrase above into concrete actions
        Homepage homepage = new Homepage(driver);
        homepage.clickMyAccount();
    }
    @When("I click on Continue on the login page")
    public void i_click_on_continue_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        Loginpage loginpage = new Loginpage(driver);
        loginpage.clickOnContinueButton();
    }
    @When("enter {string}, {string}, {string}, {string} and {string} using page object")
    public void enter_and_using_page_object(String fName, String lName, String eMail, String tPhone, String pWord) {
        // Write code here that turns the phrase above into concrete actions
        Registerpage registerpage = new Registerpage(driver);
        registerpage.enterFirstName(fName);
        registerpage.enterLastName(lName);
        registerpage.enterEmail(randomNumber() + eMail);
        registerpage.enterTelephone(tPhone);
        registerpage.enterPassword(pWord);
        registerpage.enterConfirmPassword(pWord);
    }
    @When("I click on the privacy policy using page object")
    public void i_click_on_the_privacy_policy_using_page_object() {
        // Write code here that turns the phrase above into concrete actions
        Registerpage registerpage = new Registerpage(driver);
        registerpage.clickOnPrivacy();
    }
    @When("I click on Continue button on the register account page using page object")
    public void i_click_on_continue_button_on_the_register_account_page_using_page_object() {
        // Write code here that turns the phrase above into concrete actions
        Registerpage registerpage = new Registerpage(driver);
        registerpage.clickOnContinueButton();
    }
}



