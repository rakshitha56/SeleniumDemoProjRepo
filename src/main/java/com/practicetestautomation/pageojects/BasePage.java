package com.practicetestautomation.pageojects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    protected void visit(String url){
        driver.get(url);
    }

    public String getCurrentUrl(){    // this method and below method are not specific for a single method
        return driver.getCurrentUrl();
    }

    public String getPageSorce(){
        return driver.getPageSource();
    }

    protected WebElement waitforElement(By locator){
      return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    protected boolean islogDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

        protected boolean waitforIsDisplayed(By locator){
            try{
                waitforElement(locator);
                return true;
            }
            catch (TimeoutException e){
                return false;
            }
    }

    protected boolean waitforHiddenMsg(By locator){
        try{
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }


}
