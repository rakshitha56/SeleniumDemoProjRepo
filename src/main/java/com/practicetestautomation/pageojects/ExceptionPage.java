package com.practicetestautomation.pageojects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExceptionPage extends BasePage {
    private By addbtnLocator = By.id("add_btn");
    private By editbtnLocator = By.xpath("//button[@id='edit_btn']");
    private By rowtwoInput = By.id("row1");
    private By save1Row = By.xpath("//div[@id='row1']/input");
    private By secrowInput = By.className("input-field");
    private By savebtnLocator = By.xpath("//div[@id='row2']/button[@name='Save']");
    private By successMsg = By.id("confirmation");
    private By instructionLocator = By.id("instructions");



    public ExceptionPage(WebDriver driver){
        super(driver);
    }

    public void visit(){
        super.visit("https://practicetestautomation.com/practice-test-exceptions/");
    }

    public void pushaddbtn(){
        driver.findElement(addbtnLocator).click();
    }

    public void editbtn(){
        driver.findElement(editbtnLocator).click();
    }

    public boolean isRowTwoDisplay(){
        return waitforIsDisplayed(rowtwoInput);
    }

    public void secondrowField(){
        driver.findElement(secrowInput).sendKeys("SecondInputField");
    }

    public void enterRow1(String name){
       WebElement row1input = driver.findElement(rowtwoInput);
       row1input.clear();
       row1input.sendKeys(name);
    }

    public void saveRow1(){
        driver.findElement(save1Row).click();
    }

    public void savedata2(){
        driver.findElement(savebtnLocator).click();
    }
    public String getSuccessMessage(){
        WebElement message = waitforElement(successMsg);
        return message.getText();
    }

    public boolean isHiddenInstruction(){
        return waitforHiddenMsg(instructionLocator);
    }
}
