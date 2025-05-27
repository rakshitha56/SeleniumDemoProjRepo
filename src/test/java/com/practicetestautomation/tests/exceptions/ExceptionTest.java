package com.practicetestautomation.tests.exceptions;

import com.practicetestautomation.pageojects.ExceptionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionTest {
    private WebDriver driver;
    private Logger log;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        log = Logger.getLogger(ExceptionTest.class.getName());
        log.setLevel(Level.INFO);
        log.info("Link will open in chrome browser");
        //Open page
        driver = new ChromeDriver();
        //Implicit Wait
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
      //  driver.get("https://practicetestautomation.com/practice-test-exceptions/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

   @Test
    public void firstMethod(){
        //Explicit Wait
       ExceptionPage exceptionPage = new ExceptionPage(driver);
       exceptionPage.visit();
       exceptionPage.pushaddbtn();
       Assert.assertTrue(exceptionPage.isRowTwoDisplay(),"row 2 input field is not displayed");



 /*      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addbtn = driver.findElement(By.id("add_btn"));
        log.info("click add button");
        addbtn.click();

       WebElement rowTwo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("row2")));*/
     /*  try {
           Thread.sleep(10000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }*/
      // WebElement rowTwo = driver.findElement(By.id("row2"));
      /*  log.info("Verifying Row 2 is Displayed");
       Assert.assertTrue(rowTwo.isDisplayed());*/

    }

    @Test
    public void secondTimeOutMethod(){

        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.pushaddbtn();
        Assert.assertTrue(exceptionPage.isRowTwoDisplay(),"Verifying 2nd input field is Displayed");

       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        WebElement addbtn = driver.findElement(By.id("add_btn"));
        log.info("click add button");
        addbtn.click();

        WebElement rowTwo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("row2")));*/

     /*  try {
           Thread.sleep(10000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }*/
     //   WebElement rowTwo = driver.findElement(By.id("row2"));
     /*   log.info("Verifying 2nd input field is Displayed");
        Assert.assertTrue(rowTwo.isDisplayed());*/

    }
    @Test
    public void thirdElementNotInteractableExceptionMethod(){

        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.pushaddbtn();
        exceptionPage.isRowTwoDisplay();
        exceptionPage.secondrowField();
        exceptionPage.savedata2();
        Assert.assertEquals(exceptionPage.getSuccessMessage(),"Row 2 was saved");

       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        WebElement addbtn = driver.findElement(By.id("add_btn"));
        log.info("click add button");
        addbtn.click();

        WebElement rowTwo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("row2")));*/

     /*  try {
           Thread.sleep(10000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }*/
        //   WebElement rowTwo = driver.findElement(By.id("row2"));
     /*   log.info("Verifying 2nd input field is Displayed");
        Assert.assertTrue(rowTwo.isDisplayed());*/

      /*  WebElement secinputFiled = driver.findElement(By.className("input-field"));
        secinputFiled.sendKeys("SecondInputField");

        WebElement savebtn = driver.findElement(By.xpath("//div[@id='row2']/button[@name='Save']"));
        savebtn.click();*/

     /*   WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation")));
        String actualmsg = success.getText();
        String expectmsg = "Row 2 was saved";
        Assert.assertEquals(actualmsg,expectmsg);*/

    }
    @Test
    public void fourInvalidElementStateException() {
        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.editbtn();
        exceptionPage.enterRow1("Sushi");
        exceptionPage.saveRow1();
        Assert.assertEquals(exceptionPage.getSuccessMessage(),"Row 1 was saved","Message is not excepted");



      /*  WebElement editBtn = driver.findElement(By.xpath("//button[@id='edit_btn']"));
        editBtn.click();

        WebElement rowone = driver.findElement(By.xpath("//div[@id='row1']/input"));
        rowone.clear();
        rowone.sendKeys("Sushi");*/

    }
    @Test
    public void fiveStaleElementReferenceException() {

        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.pushaddbtn();
       Assert.assertTrue( exceptionPage.isHiddenInstruction(),"Instruction test is still hidden");

     /*   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        WebElement editBtn = driver.findElement(By.id("instructions"));

        WebElement addbtn = driver.findElement(By.id("add_btn"));
        log.info("click add button");
        addbtn.click();

        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("instructions"))));*/



    }



    }
