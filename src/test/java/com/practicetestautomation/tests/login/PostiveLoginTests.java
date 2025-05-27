package com.practicetestautomation.tests.login;

import com.practicetestautomation.pageojects.LoginPage;
import com.practicetestautomation.pageojects.SucessfulLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.logging.Level;
import java.util.logging.Logger;


public class PostiveLoginTests {
    private WebDriver driver;
    private Logger log; //used to get the log

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser){
        log = Logger.getLogger(PostiveLoginTests.class.getName());
        log.setLevel(Level.INFO);
        log.info("Running test in" +browser);
        switch (browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }



    @Test(groups ={"positive","regression","smoke"})
    public void testLoginFunctionality(){

        //Open page
       /* System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();*/
       // Type username student into Username field
        log.info("Positive login functional test");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();
        SucessfulLogin sucessfulLogin = loginPage.execution("student","Password123");
        sucessfulLogin.load();
        String expectedUrl ="https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = sucessfulLogin.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        String expectedtext = "Congratulations student. You successfully logged in!";
        String pasgesorce = sucessfulLogin.getPageSorce(); //used to page that the text is there in this page
        Assert.assertTrue(pasgesorce.contains(expectedtext));
        Assert.assertTrue(sucessfulLogin.islogOutbtnDisplayed());

     /*   WebElement usernameinput = driver.findElement(By.id("username"));
        usernameinput.sendKeys("student");
      //  Type password Password123 into Password field
        WebElement passwordinput = driver.findElement(By.id("password"));
        passwordinput.sendKeys("Password123");
       // Push Submit button
        WebElement subbtn = driver.findElement(By.className("btn"));
        subbtn.click();*/

       /* try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        //  Verify new page URL contains practicetestautomation.com/logged-in-successfully/
       /* String expectedUrl ="https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);*/
       // Verify new page contains expected text ('Congratulations' or 'successfully logged in')
      /*  String .expectedtext = "Congratulations student. You successfully logged in!";
        String pasgesorce = driver.getPageSource(); //used to page that the text is there in this page
        Assert.assertTrue(pasgesorce.contains(expectedtext));*/
      //  Verify button Log out is displayed on the new page
      /*  WebElement logout = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logout.isDisplayed());*/
    }

    @Parameters({"username","password","errorMsg"})
    @Test(groups ={"negative","regression"})
    public void negativeLoginSTest(String username, String password, String errorMsg){
        log.info("Negaative secinario");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();
        loginPage.execution(username, password);
     //   loginPage.errorMsg();
        Assert.assertEquals(loginPage.errorMsg(),errorMsg);


        //Open page
        /*System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();*/
      /*  WebDriver driver = new FirefoxDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameinput = driver.findElement(By.id("username"));
        usernameinput.sendKeys(username); //hardcoded passing from fullRgressionSite.xml file

        //  Type password Password123 into Password field
        WebElement passwordinput = driver.findElement(By.id("password"));
        passwordinput.sendKeys(password);

        WebElement subbtn = driver.findElement(By.className("btn"));
        subbtn.click();

        WebElement errormsg = driver.findElement(By.id("error"));
        Assert.assertTrue(errormsg.isDisplayed());

       // String errorMsg = "Your username is invalid!";
        String actualText = errormsg.getText();
        Assert.assertEquals(actualText, errorMsg);*/

    }

  /*  @Test(groups ={"positive","regression"})
    public void inncorrectpasswordTest() {

        //Open page
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Type username student into Username field
        WebElement usernameinput = driver.findElement(By.id("username"));
        usernameinput.sendKeys("student");

        //  Type password Password123 into Password field
        WebElement passwordinput = driver.findElement(By.id("password"));
        passwordinput.sendKeys("password123");

        WebElement subbtn = driver.findElement(By.className("btn"));
        subbtn.click();

        WebElement errormsg = driver.findElement(By.id("error"));
        Assert.assertTrue(errormsg.isDisplayed());

        String verifyText = "Your password is invalid!";
        String actualText = errormsg.getText();
        Assert.assertEquals(actualText, verifyText);
        driver.quit();*/
}
