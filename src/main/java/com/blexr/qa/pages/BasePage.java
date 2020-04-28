package com.blexr.qa.pages;

import com.blexr.qa.pages.vegas.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageFactory
{
    private static final Logger log = LogManager.getLogger(LandingPage.class);
    private WebDriver currentDriver;

    protected void waitForLoad() {
        ExpectedCondition<Boolean> loaded = driver ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(currentDriver, 10);
        wait.until(loaded);
    }

    public BasePage(WebDriver driver)
    {
        currentDriver = driver;
    }

    public WebDriver getDriver()
    {
        return currentDriver;
    }

    public void scrollTo(WebElement elem) throws WebDriverException
    {
        ((JavascriptExecutor) currentDriver).executeScript("arguments[0].scrollIntoView();", elem);
    }



}
