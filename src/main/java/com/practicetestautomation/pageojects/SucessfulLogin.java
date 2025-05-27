package com.practicetestautomation.pageojects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SucessfulLogin extends BasePage {
    private By logOutBtn = By.linkText("Log out");

    public SucessfulLogin(WebDriver driver){
        super(driver);
    }

    public boolean islogOutbtnDisplayed(){
        return islogDisplayed(logOutBtn);
        }

        public void load(){
        waitforElement(logOutBtn);
        }
    }

